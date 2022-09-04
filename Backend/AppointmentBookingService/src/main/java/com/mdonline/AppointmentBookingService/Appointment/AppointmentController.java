package com.mdonline.AppointmentBookingService.Appointment;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1")
@CrossOrigin(origins = "*")
public class AppointmentController {
    @Autowired
    AppointmentService service;

    @GetMapping(value = "/appointments")
    public List<AppointmentEntity> getAllAppointments(){
        return service.getAllAppointments();
    }
    @GetMapping(value = "/appointments/upcoming")
    public List<AppointmentEntity> getAllUpcomingAppointments(){
        return service.getAllUpcomingAppointments();
    }

    @GetMapping(value = "/appointments/completed")
    public List<AppointmentEntity> getAllCompletedAppointments(){
        return service.getAllCompletedAppointments();
    }

    @GetMapping(value = "/appointments/patient/{id}")
    public List<AppointmentEntity> getAppointmentsByPatientId(@PathVariable int id){
        return service.getAppointmentsByPatientId(id);
    }

    @GetMapping(value = "/appointments/upcoming/patient/{id}")
    public List<AppointmentEntity> getUpcomingAppointmentsByPatientId(@PathVariable int id){
        return service.getUpcomingAppointmentsByPatientId(id);
    }

    @GetMapping(value = "/appointments/completed/patient/{id}")
    public List<AppointmentEntity> getCompletedAppointmentsByPatientId(@PathVariable int id){
        return service.getCompletedAppointmentsByPatientId(id);
    }

    @GetMapping(value = "/appointments/doctor/{id}")
    public List<AppointmentEntity> getAppointmentsByDoctorId(@PathVariable int id){
        return service.getAppointmentsByDoctorId(id);
    }

    @GetMapping(value = "/appointments/upcoming/doctor/{id}")
    public List<AppointmentEntity> getUpcomingAppointmentsByDoctorId(@PathVariable int id){
        return service.getUpcomingAppointmentsByDoctorId(id);
    }

    @GetMapping(value = "/appointments/completed/doctor/{id}")
    public List<AppointmentEntity> getCompletedAppointmentsByDoctorId(@PathVariable int id){
        return service.getCompletedAppointmentsByDoctorId(id);
    }

    @PostMapping(value = "/appointment/save")
    public ResponseEntity<?> saveAppointment(@Valid @RequestBody AppointmentEntity appointment){
        try {
            AppointmentEntity appointmentEntity  = service.saveAppointment(appointment);
            return ResponseEntity.status(HttpStatus.CREATED).body(appointmentEntity);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PutMapping(value = "/appointment/update")
    public ResponseEntity<?> updateAppointment(@Valid @RequestBody AppointmentEntity appointment){
        try {
            AppointmentEntity appointmentEntity  = service.updateAppointment(appointment);
            return ResponseEntity.status(HttpStatus.OK).body(appointmentEntity);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @DeleteMapping(value = "/appointment/delete")
    public ResponseEntity<?> deleteAppointment(@Valid @RequestBody AppointmentEntity appointment){
        try {
            service.deleteAppointment(appointment);
            return ResponseEntity.ok().body("APPOINTMENT DELETED.");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @DeleteMapping(value = "/appointment/delete/{id}")
    public ResponseEntity<?> deleteAppointmentById(@Valid @PathVariable int id){
        try {
            service.deleteAppointmentById(id);
            return ResponseEntity.ok().body("APPOINTMENT DELETED.");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
