package com.project.mdonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MdonlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdonlineApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(AppointmentRepository appointmentRepository){
//		return args -> {
//			Appointment appointment = new Appointment();
//			appointment.setPatientId(1);
//			appointment.setDoctorId(1);
//			appointment.setPaymentAmount(55.00);
//			appointmentRepository.save(appointment);
//		};
//	}

}
