package com.mdonline.AppointmentBookingService.Appointment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class AppointmentRepositoryTest {

    @Autowired
    private AppointmentRepository repository;

    public AppointmentEntity saveAppointment(){
        LocalDateTime start = LocalDateTime.of(2022, Month.OCTOBER, 1, 9, 30, 00);
        LocalDateTime end = LocalDateTime.of(2022, Month.OCTOBER, 1, 9, 45, 00);
        return repository.save(new AppointmentEntity(1L, 2L,99.00, start, end));
    }

    public void saveAppointmentList(){
        repository.save(new AppointmentEntity(1L, 2L,99.00,
                LocalDateTime.of(2022, Month.OCTOBER, 10, 9, 30, 00),
                LocalDateTime.of(2022, Month.OCTOBER, 10, 9, 45, 00)));
        repository.save(new AppointmentEntity(3L, 4L,99.00,
                LocalDateTime.of(2022, Month.OCTOBER, 11, 9, 30, 00),
                LocalDateTime.of(2022, Month.OCTOBER, 11, 9, 45, 00)));
        repository.save(new AppointmentEntity(1L, 2L,99.00,
                LocalDateTime.of(2022, Month.OCTOBER, 12, 9, 30, 00),
                LocalDateTime.of(2022, Month.OCTOBER, 12, 9, 45, 00)));
        repository.save(new AppointmentEntity(3L, 4L,99.00,
                LocalDateTime.of(2022, Month.OCTOBER, 13, 9, 30, 00),
                LocalDateTime.of(2022, Month.OCTOBER, 13, 9, 45, 00)));
    }

    @Test
    public void testCreateAppointment(){
        AppointmentEntity appointment = saveAppointment();
        assertNotNull(appointment);
        assertTrue(appointment.getId() > 0);
    }

    @Test
    public void testUpdateAppointment(){
        AppointmentEntity appointment = saveAppointment();
        LocalDateTime updatedStart = LocalDateTime.of(2022, Month.OCTOBER, 29, 9, 30, 00);
        LocalDateTime updatedEnd = LocalDateTime.of(2022, Month.OCTOBER, 29, 9, 45, 00);

        appointment.setPaymentAmount(100.00);
        appointment.setStart(updatedStart);
        appointment.setEnd(updatedEnd);

        AppointmentEntity updatedAppointment = repository.save(appointment);

        assertNotNull(updatedAppointment);
        assertTrue(updatedAppointment.getPaymentAmount() == 100.00);
        assertTrue(updatedAppointment.getStart() == updatedStart);
        assertTrue(updatedAppointment.getEnd() == updatedEnd);
    }

    @Test
    public void testDeleteAppointment(){
        AppointmentEntity appointment = saveAppointment();
        repository.deleteById(appointment.getId());

        Optional<AppointmentEntity> appointmentOptional = repository.findById(appointment.getId());
        assertThat(appointmentOptional).isEmpty();
    }

    @Test
    public void testGetAppointmentById(){
        AppointmentEntity appointment = saveAppointment();
        AppointmentEntity appointmentDB = repository.findById(appointment.getId()).get();
        assertNotNull(appointmentDB);
    }

    @Test
    public void testGetAppointmentByPatientId(){
        saveAppointmentList();
        List<AppointmentEntity> appointmentList = repository.findByPatientIdOrderByStartAsc(1L);
        assertThat(appointmentList.size()).isEqualTo(2);
    }

    @Test
    public void testGetUpcomingAppointmentByPatientId(){
        saveAppointmentList();
        List<AppointmentEntity> appointmentList = repository.findUpcomingAppointmentByPatientIdOrderByDateAsc(1L);
        assertThat(appointmentList.size()).isEqualTo(2);
        assertThat(appointmentList.get(0).getStart()).isEqualTo(LocalDateTime.of(2022, Month.OCTOBER, 10, 9, 30, 00));
        assertThat(appointmentList.get(0).getEnd()).isEqualTo(LocalDateTime.of(2022, Month.OCTOBER, 10, 9, 45, 00));
    }

    @Test
    public void testGetCompletedAppointmentByPatientId(){
        saveAppointmentList();
        List<AppointmentEntity> appointmentList = repository.findCompletedAppointmentByPatientIdOrderByDateDesc(1L);
        assertThat(appointmentList).isEmpty();
    }

    @Test
    public void testGetAppointmentByDoctorId(){
        saveAppointmentList();
        List<AppointmentEntity> appointmentList = repository.findByDoctorIdOrderByStartAsc(2L);
        assertThat(appointmentList.size()).isEqualTo(2);
        assertThat(appointmentList.get(0).getStart()).isEqualTo(LocalDateTime.of(2022, Month.OCTOBER, 10, 9, 30, 00));
        assertThat(appointmentList.get(0).getEnd()).isEqualTo(LocalDateTime.of(2022, Month.OCTOBER, 10, 9, 45, 00));
    }

    @Test
    public void testGetUpcomingAppointmentByDoctorId(){
        saveAppointmentList();
        List<AppointmentEntity> appointmentList = repository.findUpcomingAppointmentByDoctorIdOrderByDateAsc(2L);
        assertThat(appointmentList.size()).isEqualTo(2);
        assertThat(appointmentList.get(0).getStart()).isEqualTo(LocalDateTime.of(2022, Month.OCTOBER, 10, 9, 30, 00));
        assertThat(appointmentList.get(0).getEnd()).isEqualTo(LocalDateTime.of(2022, Month.OCTOBER, 10, 9, 45, 00));
    }

    @Test
    public void testGetCompletedAppointmentByDoctorId(){
        saveAppointmentList();
        List<AppointmentEntity> appointmentList = repository.findCompletedAppointmentByDoctorIdOrderByDateDesc(2L);
        assertThat(appointmentList).isEmpty();
    }

    @Test
    public void testGetAllAppointments(){
        saveAppointmentList();
        List<AppointmentEntity> appointmentList = repository.findAll();
        assertThat(appointmentList.size()).isEqualTo(4);
    }

    @Test
    public void testGetAllUpcomingAppointments(){
        saveAppointmentList();
        List<AppointmentEntity> appointmentList = repository.findUpcomingAppointmentOrderByDateAsc();
        assertThat(appointmentList.size()).isEqualTo(4);
    }

    @Test
    public void testGetAllCompletedAppointments(){
        saveAppointmentList();
        List<AppointmentEntity> appointmentList = repository.findCompletedAppointmentOrderByDateDesc();
        assertThat(appointmentList).isEmpty();
    }

    @Test
    public void testBookedTimeSlotByDoctorIdAndDate() throws ParseException {
        saveAppointmentList();
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = (java.util.Date) dateFormatter.parse("2022-10-10");

        List<AppointmentTimeSlot> timeSlotList = repository.findAvailableTimeByDoctorIdAndDate(2L, date);
        assertThat(timeSlotList.size()).isEqualTo(1);
    }

}
