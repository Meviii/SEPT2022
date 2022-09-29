package com.mdonline.AppointmentBookingService.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Date;

/**
 * This interface handles the Event related database queries via JPA and Hibernate
 */

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    @Query(value = "SELECT * FROM Events WHERE doctor_id = ?1 ORDER BY (date >= CURDATE()) ASC", nativeQuery = true)
    List<EventEntity> findByDoctorIdOrderByDateAsc(Long id);
    @Query(value = "SELECT * FROM Events WHERE doctor_id = ?1 AND date = ?2", nativeQuery = true)
    EventEntity findByDoctorIdAndDate(Long id, Date date);

    @Query(value = "SELECT * FROM Events WHERE doctor_id = ?1 AND date >= CURDATE() ORDER BY date ASC", nativeQuery = true)
    List<EventEntity> findUpcomingEventByDoctorIdOrderByDateAsc(Long id);

    @Query(value = "SELECT * FROM Events WHERE doctor_id = ?1 AND date < CURDATE() ORDER BY date DESC", nativeQuery = true)
    List<EventEntity> findPastEventByDoctorIdOrderByDateDesc(Long id);
}