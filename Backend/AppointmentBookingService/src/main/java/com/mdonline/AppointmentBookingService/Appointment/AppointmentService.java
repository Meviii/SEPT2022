package com.mdonline.AppointmentBookingService.Appointment;

import java.util.Date;
import java.util.List;

public interface AppointmentService {
    AppointmentEntity saveAppointment(AppointmentEntity appointmentEntity);
    AppointmentEntity updateAppointment(AppointmentEntity appointmentEntity);
    void deleteAppointment(AppointmentEntity appointmentEntity);

    void deleteAppointmentById(Long id);
    AppointmentEntity getAppointmentById(Long id);
    List<AppointmentEntity> getAppointmentsByPatientId(Long id);
    List<AppointmentEntity> getUpcomingAppointmentByPatientId(Long id);
    List<AppointmentEntity> getCompletedAppointmentByPatientId(Long id);
    List<AppointmentEntity> getAppointmentByDoctorId(Long id);
    List<AppointmentEntity> getUpcomingAppointmentByDoctorId(Long id);
    List<AppointmentEntity> getCompletedAppointmentByDoctorId(Long id);
    List<AppointmentEntity> getAllAppointments();
    List<AppointmentEntity> getAllUpcomingAppointments();
    List<AppointmentEntity> getAllCompletedAppointments();
    List<AppointmentTimeSlotImpl> getAvailableTime(Long id, Date date);
}
