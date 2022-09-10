package com.mdonline.AppointmentBookingService.Appointment;

import com.mdonline.AppointmentBookingService.Util.TimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public void deleteAppointmentById(Long id) { repository.deleteById(id); }

    @Override
    public AppointmentEntity getAppointmentById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<AppointmentEntity> getAppointmentsByPatientId(Long id) {
        return repository.findByPatientIdOrderByStartAsc(id);
    }

    @Override
    public List<AppointmentEntity> getUpcomingAppointmentByPatientId(Long id) {
        return repository.findUpcomingAppointmentByPatientIdOrderByDateAsc(id);
    }

    @Override
    public List<AppointmentEntity> getCompletedAppointmentByPatientId(Long id) {
        return repository.findCompletedAppointmentByPatientIdOrderByDateDesc(id);
    }

    @Override
    public List<AppointmentEntity> getAppointmentByDoctorId(Long id) {
        return repository.findByDoctorIdOrderByStartAsc(id);
    }

    @Override
    public List<AppointmentEntity> getUpcomingAppointmentByDoctorId(Long id) {
        return repository.findUpcomingAppointmentByDoctorIdOrderByDateAsc(id);
    }

    @Override
    public List<AppointmentEntity> getCompletedAppointmentByDoctorId(Long id) {
        return repository.findCompletedAppointmentByDoctorIdOrderByDateDesc(id);
    }

    @Override
    public List<AppointmentEntity> getAllAppointments() {
        return repository.findAll();
    }

    @Override
    public List<AppointmentEntity> getAllUpcomingAppointments() {
        return repository.findUpcomingAppointmentOrderByDateAsc();
    }

    @Override
    public List<AppointmentEntity> getAllCompletedAppointments() {
        return repository.findCompletedAppointmentOrderByDateDesc();
    }
    @Override
    public List<AppointmentTimeSlotImpl> getAvailableTime(Long id, Date date) {
        List<AppointmentTimeSlot> bookedTimeslots = repository.findAvailableTimeByDoctorIdAndDate(id, date);
        List<LocalDateTime> timeSlots = new TimeSlot(date).getTimeSlots();

        Set<LocalDateTime> takenStartTime = bookedTimeslots.stream()
                .map(AppointmentTimeSlot::getStart)
                .collect(Collectors.toSet());

        List<AppointmentTimeSlotImpl> availableSlots = timeSlots.stream()
                .filter(dateTime -> !takenStartTime.contains(dateTime))
                .map(dateTime -> new AppointmentTimeSlotImpl(dateTime, dateTime.plusMinutes(15)))
                .collect(Collectors.toList());

        return availableSlots;
    }
}
