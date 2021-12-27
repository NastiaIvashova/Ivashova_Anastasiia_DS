FROM openjdk:17-alpine

WORKDIR /opt/server

COPY ./target/order-service-0.0.1-SNAPSHOT.jar orderService.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar","orderService.jar"]