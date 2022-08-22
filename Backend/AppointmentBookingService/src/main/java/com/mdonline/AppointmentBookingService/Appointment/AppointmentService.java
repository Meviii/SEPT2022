package com.mdonline.AppointmentBookingService.Appointment;

import java.util.List;

public interface AppointmentService {
    AppointmentEntity saveAppointment(AppointmentEntity appointmentEntity);
    AppointmentEntity updateAppointment(AppointmentEntity appointmentEntity);
    void deleteAppointment(AppointmentEntity appointmentEntity);
    AppointmentEntity getAppointmentById(int id);
    List<AppointmentEntity> getAllAppointments();
}
