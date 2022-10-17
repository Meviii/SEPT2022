package com.mdonline.AppointmentBookingService.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Business logic of Event URI endpoints and data handling.
 */
@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private EventRepository repository;

    /**
     * Creates a new Event and saves into datastore.
     *
     * @param eventEntity - Event object to save
     *
     * @Return - Event object if event has been created
     */
    @Override
    public EventEntity saveEvent(EventEntity eventEntity) { return repository.save(eventEntity); }

    /**
     * Deletes an Event if object id exists in datastore
     *
     * @param eventEntity - Event object
     *
     */
    @Override
    public void deleteEvent(EventEntity eventEntity) { repository.delete(eventEntity); }

    /**
     * Deletes an Event if id exists in datastore
     *
     * @param id - Event id to delete
     *
     */
    @Override
    public void deleteEventById(Long id) { repository.deleteById(id); }

    /**
     * Finds and returns Event list by Doctor id if it is found in the datastore.
     *
     * @param id - Doctor id
     * @Return - EventList OR EmptyList
     */
    @Override
    public List<EventEntity> getEventByUserId(Long id) { return repository.findByDoctorIdOrderByDateAsc(id); }

    /**
     * Finds and returns Event list by Doctor id and Date if it is found in the datastore.
     *
     * @param id - Doctor id
     * @param date - Date
     * @Return - EventList OR EmptyList
     */
    @Override
    public EventEntity getEventByDoctorIdAndDate(Long id, Date date) { return repository.findByDoctorIdAndDate(id, date); }

    /**
     * Finds and returns upcoming Event list by Doctor id if it is found in the datastore.
     *
     * @param id - Doctor id
     * @Return - EventList OR EmptyList
     */
    @Override
    public List<EventEntity> getUpcomingEventByUserId(Long id) {
        return repository.findUpcomingEventByDoctorIdOrderByDateAsc(id);
    }

    /**
     * Finds and returns past Event list by Doctor id if it is found in the datastore.
     *
     * @param id - Doctor id
     * @Return - EventList OR EmptyList
     */

    @Override
    public List<EventEntity> getPastEventByUserId(Long id) {
        return repository.findPastEventByDoctorIdOrderByDateDesc(id);
    }
}