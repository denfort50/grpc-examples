package ru.dkalchenko.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ApplicationServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        Server server = ServerBuilder.forPort(8080)
                .addService(new InfoService())
                .build();

        server.start();
        System.out.println("Server started");
        server.awaitTermination();
    }
}
