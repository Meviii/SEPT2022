FROM maven:3.6.3-jdk-11-openj9

COPY target/MessageService-0.0.1-SNAPSHOT.jar messageservice.jar

ENTRYPOINT ["java", "-jar", "/messageservice.jar"]