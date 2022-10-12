FROM maven:3.6.3-jdk-11-openj9

COPY target/AppointmentBookingService-0.0.1-SNAPSHOT.jar appointmentservice.jar

ENTRYPOINT ["java", "-jar", "/appointmentservice.jar"]