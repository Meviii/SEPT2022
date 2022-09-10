package com.mdonline.AppointmentBookingService.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private EventRepository repository;

    @Override
    public EventEntity saveEvent(EventEntity eventEntity) { return repository.save(eventEntity); }

    @Override
    public void deleteEvent(EventEntity eventEntity) { repository.delete(eventEntity); }

    @Override
    public void deleteEventById(Long id) { repository.deleteById(id); }

    @Override
    public EventEntity getEventById(Long id) { return repository.findById(id).get(); }

    @Override
    public List<EventEntity> getEventByUserId(Long id) { return repository.findByDoctorIdOrderByDateAsc(id); }

    @Override
    public List<EventEntity> getUpcomingEventByUserId(Long id) {
        return repository.findUpcomingEventByDoctorIdOrderByDateAsc(id);
    }

    @Override
    public List<EventEntity> getPastEventByUserId(Long id) {
        return repository.findPastEventByDoctorIdOrderByDateDesc(id);
    }
}