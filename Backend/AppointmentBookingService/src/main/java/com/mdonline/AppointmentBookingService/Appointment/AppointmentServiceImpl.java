package com.mdonline.AppointmentBookingService.Appointment;

import com.mdonline.AppointmentBookingService.Util.TimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Business logic of Appointment URI endpoints and data handling.
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    /**
     * Creates a new Appointment and saves into datastore.
     *
     * @param appointmentEntity - Appointment object to save
     *
     * @Return - Appointment object if appointment has been created
     */
    @Override
    public AppointmentEntity saveAppointment(AppointmentEntity appointmentEntity) {
        return repository.save(appointmentEntity);
    }

    /**
     * Finds and updates an Appointment by given appointment object if object id is found in the datastore.
     *
     * @param appointmentEntity - Appointment object
     *
     * @Return - Appointment object if appointment has been updated
     */

    @Override
    public AppointmentEntity updateAppointment(AppointmentEntity appointmentEntity) {
        return repository.save(appointmentEntity);
    }

    /**
     * Deletes an Appointment if object id exists in datastore
     *
     * @param appointmentEntity - Appointment object
     *
     */

    @Override
    public void deleteAppointment(AppointmentEntity appointmentEntity) {
        repository.delete(appointmentEntity);
    }

    /**
     * Deletes an Appointment if id exists in datastore
     *
     * @param id - Appointment id to delete
     *
     */

    @Override
    public void deleteAppointmentById(Long id) { repository.deleteById(id); }

    /**
     * Finds and returns an Appointment by id if id is found in the datastore.
     *
     * @param id - Appointment id
     * @Return - Appointment OR null
     */

    @Override
    public AppointmentEntity getAppointmentById(Long id) {
        return repository.findById(id).get();
    }

    /**
     * Finds and returns Appointment list by Patient id if it is found in the datastore.
     *
     * @param id - Patient id
     * @Return - AppointmentList OR EmptyList
     */

    @Override
    public List<AppointmentEntity> getAppointmentByPatientId(Long id) {
        return repository.findByPatientIdOrderByStartAsc(id);
    }

    /**
     * Finds and returns upcoming Appointment list by Patient id if it is found in the datastore.
     *
     * @param id - Patient id
     * @Return - AppointmentList OR EmptyList
     */

    @Override
    public List<AppointmentEntity> getUpcomingAppointmentByPatientId(Long id) {
        return repository.findUpcomingAppointmentByPatientIdOrderByDateAsc(id);
    }

    /**
     * Finds and returns completed Appointment list by Patient id if it is found in the datastore.
     *
     * @param id - Patient id
     * @Return - AppointmentList OR EmptyList
     */

    @Override
    public List<AppointmentEntity> getCompletedAppointmentByPatientId(Long id) {
        return repository.findCompletedAppointmentByPatientIdOrderByDateDesc(id);
    }

    /**
     * Finds and returns Appointment list by Doctor id if it is found in the datastore.
     *
     * @param id - Doctor id
     * @Return - AppointmentList OR EmptyList
     */

    @Override
    public List<AppointmentEntity> getAppointmentByDoctorId(Long id) {
        return repository.findByDoctorIdOrderByStartAsc(id);
    }

    /**
     * Finds and returns upcoming Appointment list by Doctor id if it is found in the datastore.
     *
     * @param id - Doctor id
     * @Return - AppointmentList OR EmptyList
     */

    @Override
    public List<AppointmentEntity> getUpcomingAppointmentByDoctorId(Long id) {
        return repository.findUpcomingAppointmentByDoctorIdOrderByDateAsc(id);
    }

    /**
     * Finds and returns completed Appointment list by Doctor id if it is found in the datastore.
     *
     * @param id - Doctor id
     * @Return - AppointmentList OR EmptyList
     */

    @Override
    public List<AppointmentEntity> getCompletedAppointmentByDoctorId(Long id) {
        return repository.findCompletedAppointmentByDoctorIdOrderByDateDesc(id);
    }

    /**
     * Finds and returns Appointment list
     *
     * @Return - AppointmentList OR EmptyList
     */

    @Override
    public List<AppointmentEntity> getAllAppointments() {
        return repository.findAll();
    }

    /**
     * Finds and returns upcoming Appointment list
     *
     * @Return - AppointmentList OR EmptyList
     */

    @Override
    public List<AppointmentEntity> getAllUpcomingAppointments() {
        return repository.findUpcomingAppointmentOrderByDateAsc();
    }

    /**
     * Finds and returns completed Appointment list
     *
     * @Return - AppointmentList OR EmptyList
     */

    @Override
    public List<AppointmentEntity> getAllCompletedAppointments() {
        return repository.findCompletedAppointmentOrderByDateDesc();
    }

    /**
     * Finds and returns available timeslot by Date and Doctor id
     *
     * @param id - Doctor id
     * @param date - Date
     * @Return - AppointmentTimeSlot OR EmptyList
     */
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
