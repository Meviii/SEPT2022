package com.mdonline.AppointmentBookingService.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1/appointment")
@CrossOrigin(origins = "*")
public class AppointmentController {
    @Autowired
    AppointmentService service;

    @GetMapping(value = "/")
    public List<AppointmentEntity> getAllAppointment(){
        return service.getAllAppointments();
    }
    @GetMapping(value = "/upcoming")
    public List<AppointmentEntity> getAllUpcomingAppointment(){
        return service.getAllUpcomingAppointments();
    }

    @GetMapping(value = "/completed")
    public List<AppointmentEntity> getAllCompletedAppointment(){
        return service.getAllCompletedAppointments();
    }

    @GetMapping(value = "/patient/{id}")
    public List<AppointmentEntity> getAppointmentByPatientId(@PathVariable Long id){
        return service.getAppointmentByPatientId(id);
    }

    @GetMapping(value = "/upcoming/patient/{id}")
    public List<AppointmentEntity> getUpcomingAppointmentByPatientId(@PathVariable Long id){
        return service.getUpcomingAppointmentByPatientId(id);
    }

    @GetMapping(value = "/completed/patient/{id}")
    public List<AppointmentEntity> getCompletedAppointmentByPatientId(@PathVariable Long id){
        return service.getCompletedAppointmentByPatientId(id);
    }

    @GetMapping(value = "/doctor/{id}")
    public List<AppointmentEntity> getAppointmentByDoctorId(@PathVariable Long id){
        return service.getAppointmentByDoctorId(id);
    }

    @GetMapping(value = "/upcoming/doctor/{id}")
    public List<AppointmentEntity> getUpcomingAppointmentByDoctorId(@PathVariable Long id){
        return service.getUpcomingAppointmentByDoctorId(id);
    }

    @GetMapping(value = "/completed/doctor/{id}")
    public List<AppointmentEntity> getCompletedAppointmentByDoctorId(@PathVariable Long id){
        return service.getCompletedAppointmentByDoctorId(id);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> saveAppointment(@Valid @RequestBody AppointmentEntity appointment){
        try {
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
    public ResponseEntity<?> deleteAppointment(@RequestBody AppointmentEntity appointment){
        try {
            service.deleteAppointment(appointment);
            return ResponseEntity.ok().body("APPOINTMENT DELETED.");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteAppointmentById(@PathVariable Long id){
        try {
            service.deleteAppointmentById(id);
            return ResponseEntity.ok().body("APPOINTMENT DELETED.");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
