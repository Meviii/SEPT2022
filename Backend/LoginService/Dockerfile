FROM maven:3.6.3-jdk-11-openj9

COPY target/LoginService-0.0.1-SNAPSHOT.jar loginservice.jar

ENTRYPOINT ["java", "-jar", "/loginservice.jar"]