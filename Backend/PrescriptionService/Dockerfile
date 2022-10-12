FROM maven:3.6.3-jdk-11-openj9

COPY target/PrescriptionService-0.0.1-SNAPSHOT.jar prescriptionservice.jar

ENTRYPOINT ["java", "-jar", "/prescriptionservice.jar"]