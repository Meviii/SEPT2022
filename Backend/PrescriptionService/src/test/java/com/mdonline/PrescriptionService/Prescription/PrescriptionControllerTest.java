package com.mdonline.PrescriptionService.Prescription;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mdonline.PrescriptionService.Medicine.MedicineEntity;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PrescriptionController.class)
public class PrescriptionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrescriptionService service;

    @Autowired
    Jackson2ObjectMapperBuilder mapperBuilder;

    public PrescriptionEntity prescriptionObject() throws ParseException {
        List<MedicineEntity> medicines = new ArrayList<>();
        medicines.add(new MedicineEntity("Medicine X", "Medicine X description", 3.0));
        medicines.add(new MedicineEntity("Medicine Y", "Medicine Y description", 3.0));
        medicines.add(new MedicineEntity("Medicine Z", "Medicine Z description", 3.0));

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = (java.util.Date) dateFormatter.parse("2022-10-10");


        return new PrescriptionEntity(medicines, "2 week", "Test prescription",
                date, 2L, 1L);
    }

    public List<PrescriptionEntity> prescriptionList() throws ParseException {
        List<PrescriptionEntity> prescriptionList = new ArrayList<>();
        Collections.addAll(prescriptionList,
                prescriptionObject(),
                prescriptionObject(),
                prescriptionObject());
        return prescriptionList;
    }

    @Test
    public void testSavePrescription() throws Exception {
        PrescriptionEntity prescription = prescriptionObject();
        Mockito.when(service.savePrescription(prescription)).thenReturn(prescription);

        ObjectMapper mapper = mapperBuilder.build();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(prescription);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/prescription/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void testDeletePrescription() throws Exception {
        PrescriptionEntity prescription = prescriptionObject();
        doNothing().when(service).deletePrescription(prescription);

        ObjectMapper mapper = mapperBuilder.build();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(prescription);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/prescription/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetPrescriptionById() throws Exception {
        PrescriptionEntity prescription = prescriptionObject();
        Mockito.when(service.getPrescriptionById(prescription.getId())).thenReturn(prescription);
        mockMvc.perform(get("/api/v1/prescription/1")).andExpect(status().isOk());
    }

    @Test
    public void testGetAllPrescriptions() throws Exception {
        Mockito.when(service.getAllPrescriptions()).thenReturn(prescriptionList());
        mockMvc.perform(get("/api/v1/prescription/")).andExpect(status().isOk());
    }

    @Test
    public void testGetPrescriptionByPatientId() throws Exception {
        Mockito.when(service.getPrescriptionByPatientId(1L)).thenReturn(prescriptionList());
        mockMvc.perform(get("/api/v1/prescription/patient/1")).andExpect(status().isOk());
    }

    @Test
    public void testGetPrescriptionByDoctorId() throws Exception {
        Mockito.when(service.getPrescriptionByDoctorId(2L)).thenReturn(prescriptionList());
        mockMvc.perform(get("/api/v1/prescription/doctor/1")).andExpect(status().isOk());
    }

}
