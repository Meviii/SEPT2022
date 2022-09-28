package com.mdonline.AppointmentBookingService.Event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EventRepositoryTest {
    @Autowired
    private EventRepository repository;

    public EventEntity saveEvent(){
        return repository.save(new EventEntity(
                LocalDate.of(2022, Month.OCTOBER, 11), "SET AVAILABILITY", 2L, 2L));
    }

    public void saveEventList(){
        repository.save(
                new EventEntity(LocalDate.of(2022, Month.OCTOBER, 11), "SET AVAILABILITY", 2L, 2L));
        repository.save(
                new EventEntity(LocalDate.of(2022, Month.OCTOBER, 12), "SET AVAILABILITY", 2L, 2L));
        repository.save(
                new EventEntity(LocalDate.of(2022, Month.OCTOBER, 13), "SET AVAILABILITY", 2L, 2L));
    }

    @Test
    public void testCreateEvent(){
        EventEntity event = saveEvent();
        assertNotNull(event);
        assertTrue(event.getId() > 0);
    }

    @Test
    public void testDeleteEvent(){
        EventEntity event = saveEvent();
        repository.deleteById(event.getId());

        Optional<EventEntity> eventOptional = repository.findById(event.getId());
        assertThat(eventOptional).isEmpty();
    }

    @Test
    public void testGetEventById(){
        EventEntity event = saveEvent();

        EventEntity eventDB = repository.findById(event.getId()).get();
        assertNotNull(eventDB);
    }

    @Test
    public void testGetEventByUserId(){
        saveEventList();

        List<EventEntity> eventList = repository.findByDoctorIdOrderByDateAsc(2L);
        assertThat(eventList.size()).isEqualTo(3);
    }

    @Test
    public void testGetEventByDoctorIdAndDate() throws ParseException {
        EventEntity event = saveEvent();

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = (java.util.Date) dateFormatter.parse("2022-10-11");

        EventEntity eventDB = repository.findByDoctorIdAndDate(2L, date);
        assertNotNull(eventDB);
    }

    @Test
    public void testGetUpcomingEventByUserId() {
        saveEventList();
        List<EventEntity> eventList = repository.findUpcomingEventByDoctorIdOrderByDateAsc(2L);
        assertThat(eventList.size()).isEqualTo(3);
    }

    @Test
    public void testGetPastEventByUserId()  {
        saveEventList();
        List<EventEntity> eventList = repository.findPastEventByDoctorIdOrderByDateDesc(2L);
        assertThat(eventList).isEmpty();
    }

}
