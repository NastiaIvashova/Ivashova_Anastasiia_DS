FROM openjdk:17-alpine

WORKDIR /opt/server

COPY ./target/pizza-delivery-0.0.1-SNAPSHOT.jar pizzaService.jar

EXPOSE 8084

ENTRYPOINT ["java", "-jar","pizzaService.jar"]