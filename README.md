# grpc-examples

# Описание
Реализация межсервисного взаимодействия по сетевому протоколу gRPC.

# Стек технологий
- Java 21
- Maven 3.8.2
- gRPC Netty 1.68.0
- gRPC Protobuf 1.68.0
- gRPC Stub 1.68.0

# Модуль grpc-server
Сервер, содержащий бизнес-логику удалённой процедуры.

# Модуль grpc-client
Клиент, совершаюший вызов удаленной процедуры на сервере.

# Инструкция по запуску

1) Выполнить `mvn package`
2) Запустить сервер `ru/dkalchenko/server/ApplicationServer`
3) Запустить клиент `ru/dkalchenko/client/Client`
4) Проверить, что в консоль клиента выводится результат выполнения удаленной процедуры
