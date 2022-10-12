FROM maven:3.6.3-jdk-11-openj9

COPY target/DiscoveryServer-0.0.1-SNAPSHOT.jar discoveryserver.jar

ENTRYPOINT ["java", "-jar", "/discoveryserver.jar"]