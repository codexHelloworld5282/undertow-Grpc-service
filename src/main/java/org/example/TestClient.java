package org.example;


import com.example.brand.CreateBrandRequest;
import com.example.brand.CreateBrandResponse;
import com.example.brand.Brand;
import org.example.grpc.GrpcBrandClient;

public class TestClient {
    public static void main(String[] args) throws Exception {
        try (GrpcBrandClient client = new GrpcBrandClient("localhost", 50051)) {
            CreateBrandResponse resp = client.createBrand("Nike", "Sports brand");
            System.out.println("Response: " + resp.getMessage());
        }
    }
}
