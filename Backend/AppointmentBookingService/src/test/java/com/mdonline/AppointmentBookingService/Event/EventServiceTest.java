package com.mdonline.AppointmentBookingService.Event;

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
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class EventServiceTest {

    @MockBean
    private EventRepository repository;

    @InjectMocks
    private EventServiceImpl service;

    public EventEntity eventObject(){
        return new EventEntity(
                LocalDate.of(2022, Month.OCTOBER, 11),
                "SET AVAILABILITY", 2L, 2L);
    }

    public List<EventEntity> eventList(){
        List<EventEntity> eventList = new ArrayList<>();
        Collections.addAll(eventList,
                new EventEntity(LocalDate.of(2022, Month.OCTOBER, 11), "SET AVAILABILITY", 2L, 2L),
                new EventEntity(LocalDate.of(2022, Month.OCTOBER, 12), "SET AVAILABILITY", 2L, 2L),
                new EventEntity(LocalDate.of(2022, Month.OCTOBER, 13), "SET AVAILABILITY", 2L, 2L)
        );
        return eventList;
    }

    @Test
    public void testCreateEvent(){
        EventEntity event = eventObject();
        Mockito.when(repository.save(event)).thenReturn(event);
        assertEquals(event, service.saveEvent(event));
    }

    @Test
    public void testDeleteEvent(){
        EventEntity event = eventObject();
        service.deleteEvent(event);
        verify(repository, times(1)).delete(event);
    }

    @Test
    public void testGetEventByUserId(){
        Mockito.when(repository.findByDoctorIdOrderByDateAsc(2L)).thenReturn(eventList());
        assertEquals(3, service.getEventByUserId(2L).size());
    }

    @Test
    public void testGetEventByDoctorIdAndDate() throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = (java.util.Date) dateFormatter.parse("2022-10-11");

        Mockito.when(repository.findByDoctorIdAndDate(2L, date)).thenReturn(eventObject());
        assertNotNull(service.getEventByDoctorIdAndDate(2L, date));
    }

    @Test
    public void testGetUpcomingEventByUserId() throws ParseException {
        Mockito.when(repository.findUpcomingEventByDoctorIdOrderByDateAsc(2L)).thenReturn(eventList());
        assertEquals(3, service.getUpcomingEventByUserId(2L).size());
    }

    @Test
    public void testGetPastEventByUserId() throws ParseException {
        Mockito.when(repository.findPastEventByDoctorIdOrderByDateDesc(2L)).thenReturn(eventList());
        assertEquals(3, service.getPastEventByUserId(2L).size());
    }


}
