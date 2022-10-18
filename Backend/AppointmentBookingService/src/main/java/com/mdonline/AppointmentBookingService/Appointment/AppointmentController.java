package com.mdonline.AppointmentBookingService.Appointment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


/**
 * WEB Endpoint controller/ URI Controller
 */

@RestController
@RequestMapping(path="/api/v1/appointment")
@CrossOrigin(origins = "*")
public class AppointmentController {
    @Autowired
    AppointmentService service;

    private static final Logger LOGGER = LogManager.getLogger(AppointmentController.class);

    /**
     * Returns all the appointments
     */
    @GetMapping(value = "/")
    public List<AppointmentEntity> getAllAppointment(){
        return service.getAllAppointments();
    }

    /**
     * Returns all the upcoming appointments
     */
    @GetMapping(value = "/upcoming")
    public List<AppointmentEntity> getAllUpcomingAppointment(){
        return service.getAllUpcomingAppointments();
    }

    /**
     * Returns all the completed appointments
     */
    @GetMapping(value = "/completed")
    public List<AppointmentEntity> getAllCompletedAppointment(){
        return service.getAllCompletedAppointments();
    }

    /**
     * Returns all the appointments by patient id
     * @param id - patient id
     */
    @GetMapping(value = "/patient/{id}")
    public List<AppointmentEntity> getAppointmentByPatientId(@PathVariable Long id){
        return service.getAppointmentByPatientId(id);
    }

    /**
     * Returns all the upcoming appointments by patient id
     * @param id - patient id
     */
    @GetMapping(value = "/upcoming/patient/{id}")
    public List<AppointmentEntity> getUpcomingAppointmentByPatientId(@PathVariable Long id){
        return service.getUpcomingAppointmentByPatientId(id);
    }

    /**
     * Returns all the completed appointments by patient id
     * @param id - patient id
     */
    @GetMapping(value = "/completed/patient/{id}")
    public List<AppointmentEntity> getCompletedAppointmentByPatientId(@PathVariable Long id){
        return service.getCompletedAppointmentByPatientId(id);
    }

    /**
     * Returns all the appointments by doctor id
     * @param id - doctor id
     */
    @GetMapping(value = "/doctor/{id}")
    public List<AppointmentEntity> getAppointmentByDoctorId(@PathVariable Long id){
        return service.getAppointmentByDoctorId(id);
    }

    /**
     * Returns all the upcoming appointments by doctor id
     * @param id - doctor id
     */
    @GetMapping(value = "/upcoming/doctor/{id}")
    public List<AppointmentEntity> getUpcomingAppointmentByDoctorId(@PathVariable Long id){
        return service.getUpcomingAppointmentByDoctorId(id);
    }

    /**
     * Returns all the completed appointments by doctor id
     * @param id - doctor id
     */
    @GetMapping(value = "/completed/doctor/{id}")
    public List<AppointmentEntity> getCompletedAppointmentByDoctorId(@PathVariable Long id){
        return service.getCompletedAppointmentByDoctorId(id);
    }

    /**
     * Creates an appointment by a given valid payload
     *
     * @param appointment - Entity object of appointment
     */
    @PostMapping(value = "/")
    public ResponseEntity<?> saveAppointment(@Valid @RequestBody AppointmentEntity appointment){
        try {
            AppointmentEntity appointmentEntity  = service.saveAppointment(appointment);
            LOGGER.info("APPOINTMENT CREATED.");
            return ResponseEntity.status(HttpStatus.CREATED).body(appointmentEntity);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    /**
     * Updates the appointment by the given payload
     *
     * @param appointment - Entity object of appointment
     */
    @PutMapping(value = "/")
    public ResponseEntity<?> updateAppointment(@Valid @RequestBody AppointmentEntity appointment){
        try {
            AppointmentEntity appointmentEntity  = service.updateAppointment(appointment);
            LOGGER.info("APPOINTMENT UPDATED.");
            return ResponseEntity.status(HttpStatus.OK).body(appointmentEntity);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    /**
     * Deletes an appointment by the given payload
     *
     * @param appointment - Entity object of appointment
     */
    @DeleteMapping(value = "/")
    public ResponseEntity<?> deleteAppointment(@RequestBody AppointmentEntity appointment){
        try {
            service.deleteAppointment(appointment);
            LOGGER.info("APPOINTMENT DELETED.");
            return ResponseEntity.ok().body("APPOINTMENT DELETED.");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }


    /**
     * Deletes an appointment by a given valid id
     *
     * @param id - id of appointment
     */

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteAppointmentById(@PathVariable Long id){
        try {
            service.deleteAppointmentById(id);
            LOGGER.info("APPOINTMENT DELETED.");
            return ResponseEntity.ok().body("APPOINTMENT DELETED.");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
