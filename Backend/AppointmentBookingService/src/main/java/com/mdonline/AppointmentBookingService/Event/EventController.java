package com.mdonline.AppointmentBookingService.Event;

import com.mdonline.AppointmentBookingService.Appointment.AppointmentTimeSlotImpl;
import com.mdonline.AppointmentBookingService.Appointment.AppointmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * WEB Endpoint controller/ URI Controller
 */


@RestController
@RequestMapping(path="/api/v1/event")
@CrossOrigin(origins = "*")
public class EventController {
    @Autowired
    EventService service;

    private static final Logger LOGGER = LogManager.getLogger(EventController.class);

    @Autowired
    AppointmentService appointmentService;

    /**
     * Returns all the events(available days) by the doctor id
     * @param id - doctor id
     */
    @GetMapping(value = "/{id}")
    public List<EventEntity> getEventByUserId(@PathVariable Long id) { return service.getEventByUserId(id); }


    /**
     * Returns all the upcoming events(available days) by doctor id
     * @param id - doctor id
     */
    @GetMapping(value = "/upcoming/{id}")
    public List<EventEntity> getUpcomingEventByUserId(@PathVariable Long id) {
        return service.getUpcomingEventByUserId(id);
    }

    /**
     * Returns all the past events(available days) by doctor id
     * @param id - doctor id
     */
    @GetMapping(value = "/past/{id}")
    public List<EventEntity> getPastEventByUserId(@PathVariable Long id) {
        return service.getPastEventByUserId(id);
    }

    /**
     * Creates an event by a given valid payload
     *
     * @param event - Entity object of event
     */
    @PostMapping(value = "/")
    public ResponseEntity<?> saveEvent(@Valid @RequestBody EventEntity event){
        try{
            EventEntity saveEvent = service.saveEvent(event);
            LOGGER.info("EVENT CREATED.");
            return ResponseEntity.status(HttpStatus.CREATED).body(saveEvent);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    /**
     * Deletes an event by the given payload
     *
     * @param event - Entity object of event
     */
    @DeleteMapping(value = "/")
    public ResponseEntity<?> deleteEvent(@RequestBody EventEntity event){
        try{
            service.deleteEvent(event);
            LOGGER.info("EVENT DELETED.");
            return ResponseEntity.ok().body("EVENT DELETED.");
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    /**
     * Deletes an event by a given valid id
     *
     * @param id - id of event
     */

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteEventById(@PathVariable Long id){
        try{
            service.deleteEventById(id);
            LOGGER.info("EVENT DELETED.");
            return ResponseEntity.ok().body("EVENT DELETED.");
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    /**
     * Returns doctor's availability by the given payload
     *
     * @param payload - the payload contains Doctor id & Date
     */
    @PostMapping(value = "/availability")
    public List<AppointmentTimeSlotImpl> getAvailableTime(@RequestBody Map<String, String> payload) throws ParseException {
        long id = Long.parseLong(payload.get("id"));
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = (java.util.Date) dateFormatter.parse(payload.get("date"));
        EventEntity isAvailableOnDate = service.getEventByDoctorIdAndDate(id, date);
        if(isAvailableOnDate != null){
            return appointmentService.getAvailableTime(id, date);
        }
        return Collections.emptyList();
    }
}
