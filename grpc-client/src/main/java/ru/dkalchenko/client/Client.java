package ru.dkalchenko.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import ru.dkalchenko.client.util.PerformanceUtils;
import ru.dkalchenko.server.InfoServiceGrpc;
import ru.dkalchenko.server.InfoServiceOuterClass;

import java.util.Iterator;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Long start = PerformanceUtils.startMeasuring();

        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();

        InfoServiceGrpc.InfoServiceBlockingStub stub = InfoServiceGrpc.newBlockingStub(channel);

        InfoServiceOuterClass.InfoRequest request = InfoServiceOuterClass.InfoRequest.newBuilder()
                .setFirstName("Denis")
                .setLastName("Kalchenko")
                .setMiddleName("Alexandrovich")
                .addAllLanguages(List.of("Java", "Kotlin", "SQL"))
                .addAllFrameworks(List.of("Spring", "Hibernate"))
                .build();

        Iterator<InfoServiceOuterClass.InfoResponse> response = stub.getCompactInfo(request);

        while (response.hasNext()) {
            System.out.println(response.next());
        }

        String time = PerformanceUtils.finishMeasuring(start);
        System.out.println("Spent " + time);

        channel.shutdownNow();
    }
}
