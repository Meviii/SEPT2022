package com.mdonline.AppointmentBookingService.Appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Override
    public AppointmentEntity saveAppointment(AppointmentEntity appointmentEntity) {
        return repository.save(appointmentEntity);
    }

    @Override
    public AppointmentEntity updateAppointment(AppointmentEntity appointmentEntity) {
        return repository.save(appointmentEntity);
    }

    @Override
    public void deleteAppointment(AppointmentEntity appointmentEntity) {
        repository.delete(appointmentEntity);
    }

    @Override
    public AppointmentEntity getAppointmentById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public List<AppointmentEntity> getAllAppointments() {
        return repository.findAll();
    }
}
