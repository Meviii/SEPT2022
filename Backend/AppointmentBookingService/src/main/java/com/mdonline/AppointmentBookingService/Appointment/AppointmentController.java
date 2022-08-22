package com.mdonline.AppointmentBookingService.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AppointmentController {
    @Autowired
    AppointmentService service;
//    PatientService patientService;
//    DoctorService doctorService;

    @RequestMapping(value = "getallappointments", method = RequestMethod.GET)
    public List<AppointmentEntity> getAllAppointments(){
        return service.getAllAppointments();
    }

//    @PostMapping(value = "saveappointment")
//    public void saveAppointment(@RequestBody Appointment appointment){
//        try {
//            Doctor doctor = doctorService.getDoctorById(appointment.getDoctorId());
//            Patient patient = patientService.getPatientById(appointment.getPatientId());
//            AppointmentEntity appointmentEntity = new AppointmentEntity(
//                    patient,
//                    doctor,
//                    appointment.getPaymentAmount(),
//                    appointment.getDate(),
//                    appointment.getTime());
//            service.saveAppointment(appointmentEntity);
//        } catch (Exception exception) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "");
//        }
//
//    }

    @RequestMapping(value = "updateappointment", method = RequestMethod.PUT)
    public void updateAppointment(@RequestBody AppointmentEntity appointmentEntity){
        System.out.print(appointmentEntity);
        try {
            service.updateAppointment(appointmentEntity);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "");
        }
    }

    @RequestMapping(value = "deleteappointment", method = RequestMethod.DELETE)
    public void deleteAppointment(@RequestBody AppointmentEntity appointmentEntity){
        try {
            service.deleteAppointment(appointmentEntity);
        } catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "");
        }
    }
}
