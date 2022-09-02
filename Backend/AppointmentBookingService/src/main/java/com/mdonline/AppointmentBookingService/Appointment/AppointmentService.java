package com.mdonline.AppointmentBookingService.Appointment;

import java.util.List;

public interface AppointmentService {
    AppointmentEntity saveAppointment(AppointmentEntity appointmentEntity);
    AppointmentEntity updateAppointment(AppointmentEntity appointmentEntity);
    void deleteAppointment(AppointmentEntity appointmentEntity);
    AppointmentEntity getAppointmentById(int id);
    List<AppointmentEntity> getAppointmentsByPatientId(int id);
    List<AppointmentEntity> getUpcomingAppointmentsByPatientId(int id);
    List<AppointmentEntity> getCompletedAppointmentsByPatientId(int id);
    List<AppointmentEntity> getAppointmentsByDoctorId(int id);
    List<AppointmentEntity> getUpcomingAppointmentsByDoctorId(int id);
    List<AppointmentEntity> getCompletedAppointmentsByDoctorId(int id);
    List<AppointmentEntity> getAllAppointments();
    List<AppointmentEntity> getAllUpcomingAppointments();
    List<AppointmentEntity> getAllCompletedAppointments();
}
