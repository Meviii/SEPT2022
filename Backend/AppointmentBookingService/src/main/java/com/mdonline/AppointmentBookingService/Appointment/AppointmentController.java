package com.mdonline.AppointmentBookingService.Appointment;
import com.mdonline.AppointmentBookingService.Event.EventDuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/api/v1/appointment")
@CrossOrigin(origins = "*")
public class AppointmentController {
    @Autowired
    AppointmentService service;

    @GetMapping(value = "/")
    public List<AppointmentEntity> getAllAppointments(){
        return service.getAllAppointments();
    }
    @GetMapping(value = "/upcoming")
    public List<AppointmentEntity> getAllUpcomingAppointments(){
        return service.getAllUpcomingAppointments();
    }

    @GetMapping(value = "/completed")
    public List<AppointmentEntity> getAllCompletedAppointments(){
        return service.getAllCompletedAppointments();
    }

    @GetMapping(value = "/patient/{id}")
    public List<AppointmentEntity> getAppointmentsByPatientId(@PathVariable Long id){
        return service.getAppointmentsByPatientId(id);
    }

    @GetMapping(value = "/upcoming/patient/{id}")
    public List<AppointmentEntity> getUpcomingAppointmentsByPatientId(@PathVariable Long id){
        return service.getUpcomingAppointmentByPatientId(id);
    }

    @GetMapping(value = "/completed/patient/{id}")
    public List<AppointmentEntity> getCompletedAppointmentsByPatientId(@PathVariable Long id){
        return service.getCompletedAppointmentByPatientId(id);
    }

    @GetMapping(value = "/doctor/{id}")
    public List<AppointmentEntity> getAppointmentsByDoctorId(@PathVariable Long id){
        return service.getAppointmentByDoctorId(id);
    }

    @GetMapping(value = "/upcoming/doctor/{id}")
    public List<AppointmentEntity> getUpcomingAppointmentsByDoctorId(@PathVariable Long id){
        return service.getUpcomingAppointmentByDoctorId(id);
    }

    @GetMapping(value = "/completed/doctor/{id}")
    public List<AppointmentEntity> getCompletedAppointmentsByDoctorId(@PathVariable Long id){
        return service.getCompletedAppointmentByDoctorId(id);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> saveAppointment(@Valid @RequestBody AppointmentEntity appointment){
        try {
            System.out.println("Test");
            System.out.println(appointment);
            AppointmentEntity appointmentEntity  = service.saveAppointment(appointment);
            return ResponseEntity.status(HttpStatus.CREATED).body(appointmentEntity);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PutMapping(value = "/")
    public ResponseEntity<?> updateAppointment(@Valid @RequestBody AppointmentEntity appointment){
        try {
            AppointmentEntity appointmentEntity  = service.updateAppointment(appointment);
            return ResponseEntity.status(HttpStatus.OK).body(appointmentEntity);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<?> deleteAppointment(@Valid @RequestBody AppointmentEntity appointment){
        try {
            service.deleteAppointment(appointment);
            return ResponseEntity.ok().body("APPOINTMENT DELETED.");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteAppointmentById(@Valid @PathVariable Long id){
        try {
            service.deleteAppointmentById(id);
            return ResponseEntity.ok().body("APPOINTMENT DELETED.");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
