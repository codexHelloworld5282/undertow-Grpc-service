package org.example.handlers;

import com.example.brand.CreateBrandResponse;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.BlockingHandler;
import io.undertow.util.Headers;
import org.example.grpc.GrpcBrandClient;
import com.example.brand.CreateBrandRequest;
import org.example.utils.JsonUtil;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class BrandHttpHandler implements HttpHandler {

    private final String grpcHost;
    private final int grpcPort;

    public BrandHttpHandler(String grpcHost, int grpcPort) {
        this.grpcHost = grpcHost;
        this.grpcPort = grpcPort;
    }

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        // Use BlockingHandler to read body
        if (!exchange.getRequestMethod().equalToString("POST")) {
            exchange.setStatusCode(405);
            exchange.getResponseSender().send("Method Not Allowed");
            return;
        }

        exchange.getRequestReceiver().receiveFullBytes((ex, data) -> {
            try {
                String body = new String(data, StandardCharsets.UTF_8);
                // crude JSON parsing just for name + description
                var node = JsonUtil.toObjectNode(body);
                String name = node.has("name") ? node.get("name").asText() : "";
                String description = node.has("description") ? node.get("description").asText() : "";

                try (GrpcBrandClient client = new GrpcBrandClient(grpcHost, grpcPort)) {
                    CreateBrandResponse resp = client.createBrand(name, description);
                    ex.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
                    ex.setStatusCode(200);
                    ex.getResponseSender().send(JsonUtil.toJson(resp));
                }

            } catch (Exception e) {
                ex.setStatusCode(500);
                ex.getResponseSender().send("{\"error\":\"" + e.getMessage() + "\"}");
            }
        });
    }
}
