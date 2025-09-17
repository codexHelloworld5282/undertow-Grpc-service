package org.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.example.brand.BrandServiceGrpc;
import com.example.brand.CreateBrandRequest;
import com.example.brand.CreateBrandResponse;
import com.example.brand.Brand;


import java.util.concurrent.TimeUnit;

public class GrpcBrandClient implements AutoCloseable {
    private final ManagedChannel channel;
    private final BrandServiceGrpc.BrandServiceBlockingStub blockingStub;

    public GrpcBrandClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.blockingStub = BrandServiceGrpc.newBlockingStub(channel);
    }

    public CreateBrandResponse createBrand(String name, String description) {
        Brand brand = Brand.newBuilder()
                .setName(name)
                .setDescription(description)
                .build();

        CreateBrandRequest req = CreateBrandRequest.newBuilder()
                .setBrand(brand)
                .build();

        return blockingStub.createBrand(req);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    @Override
    public void close() throws Exception {
        shutdown();
    }
}
