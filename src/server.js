const path = require('path');
const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');
const { connect } = require('./db/mongo');
const { createBrand } = require('./handlers/brandHandler');

const PROTO_PATH = path.join(__dirname, '..', 'proto', 'brand.proto');

const packageDef = protoLoader.loadSync(PROTO_PATH, {
    keepCase: true,
    longs: String,
    enums: String,
    defaults: true,
    oneofs: true
});
const proto = grpc.loadPackageDefinition(packageDef).brand;

async function main() {
    await connect();
    const server = new grpc.Server();

    server.addService(proto.BrandService.service, {
        CreateBrand: createBrand
    });

    const addr = '0.0.0.0:50051';
    server.bindAsync(addr, grpc.ServerCredentials.createInsecure(), (err, port) => {
        if (err) {
            console.error('gRPC bind error', err);
            process.exit(1);
        }
        console.log(`gRPC server listening on ${addr}`);
        server.start();
    });
}

main().catch(err => {
    console.error('Fatal error starting gRPC server:', err);
    process.exit(1);
});
