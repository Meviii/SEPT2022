package com.mdonline.AppointmentBookingService.Appointment;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@WebMvcTest(AppointmentController.class)
public class AppointmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppointmentService service;

    @MockBean
    private AppointmentRepository repository;

    @Autowired
    Jackson2ObjectMapperBuilder mapperBuilder;

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
    public void testSaveAppointment() throws Exception {
        AppointmentEntity appointment = appointmentObject();
        Mockito.when(service.saveAppointment(appointment)).thenReturn(appointment);

        ObjectMapper mapper = mapperBuilder.build();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(appointment);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/appointment/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateAppointment() throws Exception {
        AppointmentEntity appointment = appointmentObject();
        Mockito.when(service.updateAppointment(appointment)).thenReturn(appointment);

        ObjectMapper mapper = mapperBuilder.build();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(appointment);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/appointment/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteAppointment() throws Exception {
        AppointmentEntity appointment = appointmentObject();
        doNothing().when(service).deleteAppointment(appointment);

        ObjectMapper mapper = mapperBuilder.build();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(appointment);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/appointment/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                        .andExpect(status().isOk());
    }

    @Test
    public void testDeleteAppointmentById() throws Exception {
        AppointmentEntity appointment = appointmentObject();
        doNothing().when(service).deleteAppointmentById(appointment.getId());

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/appointment/{id}", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }


    @Test
    public void testGetAllAppointments() throws Exception {
        Mockito.when(service.getAllAppointments()).thenReturn(Stream.concat(upcomingAppointmentList().stream(), completedAppointmentList().stream()).toList());
        mockMvc.perform(get("/api/v1/appointment/")).andExpect(status().isOk());
    }

    @Test
    public void testGetAllUpcomingAppointments() throws Exception {
        Mockito.when(service.getAllUpcomingAppointments()).thenReturn(upcomingAppointmentList());
        mockMvc.perform(get("/api/v1/appointment/upcoming")).andExpect(status().isOk());
    }

    @Test
    public void testGetAllCompletedAppointments() throws Exception {
        Mockito.when(service.getAllCompletedAppointments()).thenReturn(completedAppointmentList());
        mockMvc.perform(get("/api/v1/appointment/completed")).andExpect(status().isOk());
    }

    @Test
    public void testGetAppointmentsByPatientId() throws Exception {
        Mockito.when(service.getAppointmentByPatientId(1L)).thenReturn(upcomingAppointmentList());
        mockMvc.perform(get("/api/v1/appointment/patient/1")).andExpect(status().isOk());
    }

    @Test
    public void testGetUpcomingAppointmentByPatientId() throws Exception {
        Mockito.when(service.getUpcomingAppointmentByPatientId(1L)).thenReturn(upcomingAppointmentList());
        mockMvc.perform(get("/api/v1/appointment/upcoming/patient/1")).andExpect(status().isOk());
    }

    @Test
    public void testGetCompletedAppointmentByPatientId() throws Exception {
        Mockito.when(service.getCompletedAppointmentByPatientId(1L)).thenReturn(completedAppointmentList());
        mockMvc.perform(get("/api/v1/appointment/completed/patient/1")).andExpect(status().isOk());
    }

    @Test
    public void testGetAppointmentByDoctorId() throws Exception {
        Mockito.when(service.getAppointmentByDoctorId(1L)).thenReturn(upcomingAppointmentList());
        mockMvc.perform(get("/api/v1/appointment/doctor/1")).andExpect(status().isOk());
    }

    @Test
    public void testGetUpcomingAppointmentByDoctorId() throws Exception {
        Mockito.when(service.getUpcomingAppointmentByDoctorId(1L)).thenReturn(upcomingAppointmentList());
        mockMvc.perform(get("/api/v1/appointment/upcoming/doctor/1")).andExpect(status().isOk());
    }

    @Test
    public void getCompletedAppointmentByDoctorId() throws Exception {
        Mockito.when(service.getCompletedAppointmentByDoctorId(1L)).thenReturn(completedAppointmentList());
        mockMvc.perform(get("/api/v1/appointment/completed/doctor/1")).andExpect(status().isOk());
    }

}
