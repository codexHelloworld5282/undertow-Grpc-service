package org.example;

import io.undertow.Undertow;
import io.undertow.Handlers;
import io.undertow.server.RoutingHandler;
import io.undertow.server.handlers.BlockingHandler;
import org.example.handlers.BrandHttpHandler;

public class AppServer {
    public static void main(String[] args) {
        String grpcHost = System.getenv().getOrDefault("GRPC_HOST", "localhost");
        int grpcPort = Integer.parseInt(System.getenv().getOrDefault("GRPC_PORT", "50051"));
        int httpPort = Integer.parseInt(System.getenv().getOrDefault("HTTP_PORT", "8080"));

        RoutingHandler routing = Handlers.routing()
                .post("/brands", new BlockingHandler(new BrandHttpHandler(grpcHost, grpcPort)));

        Undertow server = Undertow.builder()
                .addHttpListener(httpPort, "0.0.0.0")
                .setHandler(routing)
                .build();

        server.start();
        System.out.println("Undertow HTTP server listening on port " + httpPort);
    }
}
