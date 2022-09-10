package com.mdonline.AppointmentBookingService.Event;

import com.mdonline.AppointmentBookingService.Appointment.AppointmentTimeSlotImpl;
import com.mdonline.AppointmentBookingService.Appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/api/v1/event")
@CrossOrigin(origins = "*")
public class EventController {
    @Autowired
    EventService service;

    @Autowired
    AppointmentService appointmentService;

    @GetMapping(value = "/{id}")
    public List<EventEntity> getEventByUserId(@PathVariable Long id) { return service.getEventByUserId(id); }

    @GetMapping(value = "/upcoming/{id}")
    public List<EventEntity> getUpcomingEventByUserId(@PathVariable Long id) {
        return service.getUpcomingEventByUserId(id);
    }

    @GetMapping(value = "/past/{id}")
    public List<EventEntity> getPastEventByUserId(@PathVariable Long id) {
        return service.getPastEventByUserId(id);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> saveEvent(@Valid @RequestBody EventEntity event){
        try{
            EventEntity saveEvent = service.saveEvent(event);
            return ResponseEntity.status(HttpStatus.CREATED).body(saveEvent);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<?> deleteEvent(@RequestBody EventEntity event){
        try{
            service.deleteEvent(event);
            return ResponseEntity.ok().body("EVENT DELETED.");
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteEventById(@PathVariable Long id){
        try{
            service.deleteEventById(id);
            return ResponseEntity.ok().body("EVENT DELETED.");
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PostMapping(value = "/availability")
    public List<AppointmentTimeSlotImpl> getAvailableTime(@RequestBody Map<String, String> payload) throws ParseException {
        long id = Long.parseLong(payload.get("id"));
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = (java.util.Date) dateFormatter.parse(payload.get("date"));
        return appointmentService.getAvailableTime(id, date);
    }

}
