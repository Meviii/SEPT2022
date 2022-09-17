package com.mdonline.AppointmentBookingService.Event;
import java.util.Date;
import java.util.List;

public interface EventService {
    EventEntity saveEvent(EventEntity eventEntity);
    void deleteEvent(EventEntity eventEntity);
    void deleteEventById(Long id);
    EventEntity getEventById(Long id);
    List<EventEntity> getEventByUserId(Long id);
    EventEntity getEventByDoctorIdAndDate(Long id, Date date);
    List<EventEntity> getUpcomingEventByUserId(Long id);
    List<EventEntity> getPastEventByUserId(Long id);
}
