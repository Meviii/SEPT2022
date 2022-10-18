FROM maven:3.6.3-jdk-11-openj9

COPY target/ChatService-0.0.1-SNAPSHOT.jar chatservice.jar

ENTRYPOINT ["java", "-jar", "/chatservice.jar"]