package com.mdonline.AppointmentBookingService.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Date;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    @Query(value = "SELECT * FROM Event WHERE doctor_id = ?1 ORDER BY (event_date >= CURDATE()) ASC", nativeQuery = true)
    List<EventEntity> findByDoctorIdOrderByDateAsc(Long id);

    @Query(value = "SELECT * FROM Event WHERE doctor_id = ?1 AND event_date >= CURDATE() ORDER BY event_date ASC", nativeQuery = true)
    List<EventEntity> findUpcomingEventByDoctorIdOrderByDateAsc(Long id);

    @Query(value = "SELECT * FROM Event WHERE doctor_id = ?1 AND event_date < CURDATE() ORDER BY event_date DESC", nativeQuery = true)
    List<EventEntity> findPastEventByDoctorIdOrderByDateDesc(Long id);
}