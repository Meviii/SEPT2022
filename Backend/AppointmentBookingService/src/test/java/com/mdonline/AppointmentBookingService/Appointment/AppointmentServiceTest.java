package com.mdonline.AppointmentBookingService.Appointment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class AppointmentServiceTest {

    @MockBean
    private AppointmentRepository repository;

    @InjectMocks
    private AppointmentServiceImpl service;

    public AppointmentEntity appointmentObject(){
        LocalDateTime start = LocalDateTime.of(2022, Month.OCTOBER, 1, 9, 30, 00);
        LocalDateTime end = LocalDateTime.of(2022, Month.OCTOBER, 1, 9, 45, 00);
        return new AppointmentEntity(1L, 2L,99.00, start, end);
    }

    public List<AppointmentEntity> upcomingAppointmentList(){
        List<AppointmentEntity> appointmentList = new ArrayList<AppointmentEntity>();
        Collections.addAll(appointmentList,
                new AppointmentEntity(1L, 2L,99.00,
                    LocalDateTime.of(2022, Month.OCTOBER, 11, 9, 30, 00),
                    LocalDateTime.of(2022, Month.OCTOBER, 11, 9, 45, 00)),
                new AppointmentEntity(1L, 2L,99.00,
                    LocalDateTime.of(2022, Month.OCTOBER, 22, 9, 30, 00),
                    LocalDateTime.of(2022, Month.OCTOBER, 22, 9, 45, 00))
                );
        return appointmentList;
    }

    public List<AppointmentEntity> completedAppointmentList(){
        List<AppointmentEntity> appointmentList = new ArrayList<AppointmentEntity>();
        Collections.addAll(appointmentList,
                new AppointmentEntity(1L, 2L,99.00,
                        LocalDateTime.of(2022, Month.AUGUST, 11, 9, 30, 00),
                        LocalDateTime.of(2022, Month.AUGUST, 11, 9, 45, 00)),
                new AppointmentEntity(1L, 2L,99.00,
                        LocalDateTime.of(2022, Month.AUGUST, 22, 9, 30, 00),
                        LocalDateTime.of(2022, Month.AUGUST, 22, 9, 45, 00))
        );
        return appointmentList;
    }

    @Test
    public void testCreateAppointment(){
        AppointmentEntity appointment = appointmentObject();
        Mockito.when(repository.save(appointment)).thenReturn(appointment);
        assertEquals(appointment, service.saveAppointment(appointment));
    }

    @Test
    public void testUpdateAppointment(){
        AppointmentEntity appointment = appointmentObject();
        Mockito.when(repository.save(appointment)).thenReturn(appointment);
        assertEquals(appointment, service.updateAppointment(appointment));
    }

    @Test
    public void testDeleteAppointment(){
        AppointmentEntity appointment = appointmentObject();
        service.deleteAppointment(appointment);
        verify(repository, times(1)).delete(appointment);
    }

    @Test
    public void testGetAppointmentByPatientId(){
        Mockito.when(repository.findByPatientIdOrderByStartAsc(1L)).thenReturn(upcomingAppointmentList());
        assertEquals(2, service.getAppointmentByPatientId(1L).size());
    }

    @Test
    public void testGetUpcomingAppointmentByPatientId(){
        Mockito.when(repository.findUpcomingAppointmentByPatientIdOrderByDateAsc(1L)).thenReturn(upcomingAppointmentList());
        assertEquals(2, service.getUpcomingAppointmentByPatientId(1L).size());
    }

    @Test
    public void testGetCompletedAppointmentByPatientId(){
        Mockito.when(repository.findCompletedAppointmentByPatientIdOrderByDateDesc(1L)).thenReturn(completedAppointmentList());
        assertEquals(2, service.getCompletedAppointmentByPatientId(1L).size());
    }

    @Test
    public void testGetAppointmentByDoctorId(){
        Mockito.when(repository.findByDoctorIdOrderByStartAsc(2L)).thenReturn(upcomingAppointmentList());
        assertEquals(2, service.getAppointmentByDoctorId(2L).size());
    }

    @Test
    public void testGetUpcomingAppointmentByDoctorId(){
        Mockito.when(repository.findUpcomingAppointmentByDoctorIdOrderByDateAsc(2L)).thenReturn(upcomingAppointmentList());
        assertEquals(2, service.getUpcomingAppointmentByDoctorId(2L).size());
    }

    @Test
    public void testGetCompletedAppointmentByDoctorId(){
        Mockito.when(repository.findCompletedAppointmentByDoctorIdOrderByDateDesc(2L)).thenReturn(completedAppointmentList());
        assertEquals(2, service.getCompletedAppointmentByDoctorId(2L).size());
    }

    @Test
    public void testGetAllAppointments(){
        Mockito.when(repository.findAll()).thenReturn(Stream.concat(upcomingAppointmentList().stream(), completedAppointmentList().stream()).collect(Collectors.toList()));
        assertEquals(4, service.getAllAppointments().size());
    }

    @Test
    public void testGetAllUpcomingAppointments(){
        Mockito.when(repository.findUpcomingAppointmentOrderByDateAsc()).thenReturn(upcomingAppointmentList());
        assertEquals(2, service.getAllUpcomingAppointments().size());
    }

    @Test
    public void testGetAllCompletedAppointments(){
        Mockito.when(repository.findCompletedAppointmentOrderByDateDesc()).thenReturn(completedAppointmentList());
        assertEquals(2, service.getAllCompletedAppointments().size());
    }

    @Test
    public void testBookedTimexSlotByDoctorIdAndDate() throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = (java.util.Date) dateFormatter.parse("2022-10-11");

        List<AppointmentTimeSlot> timeSlot = new ArrayList<>();
        timeSlot.add(new AppointmentTimeSlotImpl(
                LocalDateTime.of(2022, Month.OCTOBER, 11, 9, 30, 00),
                LocalDateTime.of(2022, Month.OCTOBER, 11, 9, 45, 00)));

        Mockito.when(repository.findAvailableTimeByDoctorIdAndDate(2L, date)).thenReturn(timeSlot);
        assertEquals(67, service.getAvailableTime(2L, date).size());
    }

}
