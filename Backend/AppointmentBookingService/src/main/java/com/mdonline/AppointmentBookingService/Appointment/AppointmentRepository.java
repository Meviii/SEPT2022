package com.mdonline.AppointmentBookingService.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer>{
    List<AppointmentEntity> findByPatientIdOrderByDateDesc(int patientId);

    @Query(value = "SELECT * FROM Appointment WHERE patient_id = ?1 AND appointment_date >= NOW() ORDER BY appointment_date ASC, appointment_time ASC",
            nativeQuery = true)
    List<AppointmentEntity> findUpcomingAppointmentsByPatientIdOrderByDateAsc(int patientId);

    @Query(value = "SELECT * FROM Appointment WHERE patient_id = ?1 AND appointment_date <= NOW() ORDER BY appointment_date DESC, appointment_time DESC",
            nativeQuery = true)
    List<AppointmentEntity> findCompletedAppointmentsByPatientIdOrderByDateDesc(int patientId);

    List<AppointmentEntity> findByDoctorIdOrderByDateDesc(int doctorId);

    @Query(value = "SELECT * FROM Appointment WHERE doctor_id = ?1 AND appointment_date >= NOW() ORDER BY appointment_date ASC, appointment_time ASC",
            nativeQuery = true)
    List<AppointmentEntity> findUpcomingAppointmentsByDoctorIdOrderByDateAsc(int doctorId);

    @Query(value = "SELECT * FROM Appointment WHERE doctor_id = ?1 AND appointment_date <= NOW() ORDER BY appointment_date DESC, appointment_time DESC",
            nativeQuery = true)
    List<AppointmentEntity> findCompletedAppointmentsByDoctorIdOrderByDateDesc(int doctorId);

    @Query(value = "SELECT * FROM Appointment WHERE appointment_date >= NOW() ORDER BY appointment_date ASC, appointment_time ASC",
            nativeQuery = true)
    List<AppointmentEntity> findUpcomingAppointmentsOrderByDateAsc();

    @Query(value = "SELECT * FROM Appointment WHERE appointment_date <= NOW() ORDER BY appointment_date DESC, appointment_time DESC",
            nativeQuery = true)
    List<AppointmentEntity> findCompletedAppointmentsOrderByDateDesc();

}
