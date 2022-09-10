package com.mdonline.AppointmentBookingService.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long>{
    List<AppointmentEntity> findByPatientIdOrderByStartAsc(Long patientId);

    @Query(value = "SELECT * FROM Appointment WHERE patient_id = ?1 AND appointment_start >= NOW() ORDER BY appointment_start ASC",
            nativeQuery = true)
    List<AppointmentEntity> findUpcomingAppointmentByPatientIdOrderByDateAsc(Long patientId);

    @Query(value = "SELECT * FROM Appointment WHERE patient_id = ?1 AND appointment_start < NOW() ORDER BY appointment_start DESC",
            nativeQuery = true)
    List<AppointmentEntity> findCompletedAppointmentByPatientIdOrderByDateDesc(Long patientId);

    List<AppointmentEntity> findByDoctorIdOrderByStartAsc(Long doctorId);

    @Query(value = "SELECT * FROM Appointment WHERE doctor_id = ?1 AND appointment_start >= NOW() ORDER BY appointment_start ASC",
            nativeQuery = true)
    List<AppointmentEntity> findUpcomingAppointmentByDoctorIdOrderByDateAsc(Long doctorId);

    @Query(value = "SELECT * FROM Appointment WHERE doctor_id = ?1 AND appointment_start < NOW() ORDER BY appointment_start DESC",
            nativeQuery = true)
    List<AppointmentEntity> findCompletedAppointmentByDoctorIdOrderByDateDesc(Long doctorId);

    @Query(value = "SELECT * FROM Appointment WHERE appointment_start >= NOW() ORDER BY appointment_start ASC",
            nativeQuery = true)
    List<AppointmentEntity> findUpcomingAppointmentOrderByDateAsc();

    @Query(value = "SELECT * FROM Appointment WHERE appointment_start < NOW() ORDER BY appointment_start DESC",
            nativeQuery = true)
    List<AppointmentEntity> findCompletedAppointmentOrderByDateDesc();

    @Query(value = "SELECT appointment_start as start, appointment_end as end FROM Appointment WHERE doctor_id = ?1 AND CAST(appointment_start as DATE) = ?2 ORDER BY appointment_start ASC", nativeQuery = true)
    List<AppointmentTimeSlot> findAvailableTimeByDoctorIdAndDate(Long id, Date date);
}
