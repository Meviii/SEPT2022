package com.mdonline.AppointmentBookingService.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * This interface handles the Appointment related database queries via JPA and Hibernate
 */

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long>{
    List<AppointmentEntity> findByPatientIdOrderByStartAsc(Long patientId);

    @Query(value = "SELECT * FROM Appointments WHERE patient_id = ?1 AND start >= NOW() ORDER BY start ASC",
            nativeQuery = true)
    List<AppointmentEntity> findUpcomingAppointmentByPatientIdOrderByDateAsc(Long patientId);

    @Query(value = "SELECT * FROM Appointments WHERE patient_id = ?1 AND start < NOW() ORDER BY start DESC",
            nativeQuery = true)
    List<AppointmentEntity> findCompletedAppointmentByPatientIdOrderByDateDesc(Long patientId);

    List<AppointmentEntity> findByDoctorIdOrderByStartAsc(Long doctorId);

    @Query(value = "SELECT * FROM Appointments WHERE doctor_id = ?1 AND start >= NOW() ORDER BY start ASC",
            nativeQuery = true)
    List<AppointmentEntity> findUpcomingAppointmentByDoctorIdOrderByDateAsc(Long doctorId);

    @Query(value = "SELECT * FROM Appointments WHERE doctor_id = ?1 AND start < NOW() ORDER BY start DESC",
            nativeQuery = true)
    List<AppointmentEntity> findCompletedAppointmentByDoctorIdOrderByDateDesc(Long doctorId);

    @Query(value = "SELECT * FROM Appointments WHERE start >= NOW() ORDER BY start ASC",
            nativeQuery = true)
    List<AppointmentEntity> findUpcomingAppointmentOrderByDateAsc();

    @Query(value = "SELECT * FROM Appointments WHERE start < NOW() ORDER BY start DESC",
            nativeQuery = true)
    List<AppointmentEntity> findCompletedAppointmentOrderByDateDesc();

    @Query(value = "SELECT start, 'end' FROM Appointments a WHERE doctor_id = ?1 AND CAST(start as DATE) = ?2 ORDER BY start ASC", nativeQuery = true)
    List<AppointmentTimeSlot> findAvailableTimeByDoctorIdAndDate(Long id, Date date);
}
