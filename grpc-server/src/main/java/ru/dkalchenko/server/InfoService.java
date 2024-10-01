package ru.dkalchenko.server;

import io.grpc.stub.StreamObserver;

public class InfoService extends InfoServiceGrpc.InfoServiceImplBase {

    @Override
    public void getCompactInfo(InfoServiceOuterClass.InfoRequest request,
                               StreamObserver<InfoServiceOuterClass.InfoResponse> responseObserver) {
        for (int i = 0; i < 1_000_000; i++) {

            InfoServiceOuterClass.InfoResponse response = InfoServiceOuterClass.InfoResponse.newBuilder()
                    .setFio(request.getLastName() + " " + request.getFirstName() + " " + request.getMiddleName())
                    .setLanguagesCount(request.getLanguagesCount())
                    .setFrameworksCount(request.getFrameworksCount())
                    .setQueueNumber(i)
                    .build();

            responseObserver.onNext(response);
        }

        responseObserver.onCompleted();
    }
}
