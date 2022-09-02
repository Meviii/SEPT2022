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
    public List<AppointmentEntity> getAppointmentsByPatientId(int id) {
        return repository.findByPatientIdOrderByDateDesc(id);
    }

    @Override
    public List<AppointmentEntity> getUpcomingAppointmentsByPatientId(int id) {
        return repository.findUpcomingAppointmentsByPatientIdOrderByDateAsc(id);
    }

    @Override
    public List<AppointmentEntity> getCompletedAppointmentsByPatientId(int id) {
        return repository.findCompletedAppointmentsByPatientIdOrderByDateDesc(id);
    }

    @Override
    public List<AppointmentEntity> getAppointmentsByDoctorId(int id) {
        return repository.findByDoctorIdOrderByDateDesc(id);
    }

    @Override
    public List<AppointmentEntity> getUpcomingAppointmentsByDoctorId(int id) {
        return repository.findUpcomingAppointmentsByDoctorIdOrderByDateAsc(id);
    }

    @Override
    public List<AppointmentEntity> getCompletedAppointmentsByDoctorId(int id) {
        return repository.findCompletedAppointmentsByDoctorIdOrderByDateDesc(id);
    }

    @Override
    public List<AppointmentEntity> getAllAppointments() {
        return repository.findAll();
    }

    @Override
    public List<AppointmentEntity> getAllUpcomingAppointments() {
        return repository.findUpcomingAppointmentsOrderByDateAsc();
    }

    @Override
    public List<AppointmentEntity> getAllCompletedAppointments() {
        return repository.findCompletedAppointmentsOrderByDateDesc();
    }
}
