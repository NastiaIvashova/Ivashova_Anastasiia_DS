FROM openjdk:17-alpine

WORKDIR /opt/server

COPY ./target/user-service-0.0.1-SNAPSHOT.jar userService.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar","userService.jar"]