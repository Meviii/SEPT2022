package com.mdonline.AppointmentBookingService.Event;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mdonline.AppointmentBookingService.Appointment.AppointmentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EventController.class)
public class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @MockBean
    private AppointmentService appointmentService;

    @MockBean
    private EventRepository repository;

    @Autowired
    Jackson2ObjectMapperBuilder mapperBuilder;

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
    public void testSaveEvent() throws Exception {
        EventEntity event = eventObject();
        Mockito.when(eventService.saveEvent(event)).thenReturn(event);

        ObjectMapper mapper = mapperBuilder.build();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(event);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/event/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                        .andExpect(status().isCreated());
    }

    @Test
    public void testDeleteEvent() throws Exception {
        EventEntity event = eventObject();
        doNothing().when(eventService).deleteEvent(event);

        ObjectMapper mapper = mapperBuilder.build();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(event);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/event/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                        .andExpect(status().isOk());
    }

    @Test
    public void deleteEventById() throws Exception {
        EventEntity event = eventObject();
        doNothing().when(eventService).deleteEventById(event.getId());

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/event/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetEventByUserId() throws Exception {
        Mockito.when(eventService.getEventByUserId(2L)).thenReturn(eventList());
        mockMvc.perform(get("/api/v1/event/1")).andExpect(status().isOk());
    }

    @Test
    public void testGetUpcomingEventByUserId() throws Exception {
        Mockito.when(eventService.getUpcomingEventByUserId(2L)).thenReturn(eventList());
        mockMvc.perform(get("/api/v1/event/upcoming/1")).andExpect(status().isOk());
    }

    @Test
    public void testGetPastEventByUserId() throws Exception {
        Mockito.when(eventService.getPastEventByUserId(2L)).thenReturn(eventList());
        mockMvc.perform(get("/api/v1/event/past/1")).andExpect(status().isOk());
    }

}
