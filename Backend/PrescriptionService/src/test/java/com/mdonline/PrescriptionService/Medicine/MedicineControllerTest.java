package com.mdonline.PrescriptionService.Medicine;


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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MedicineController.class)
public class MedicineControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicineService service;

    @Autowired
    Jackson2ObjectMapperBuilder mapperBuilder;

    public MedicineEntity medicineObject(){
        return new MedicineEntity("Medicine X", "Medicine X description", 3.0);
    }

    public List<MedicineEntity> medicineList(){
        List<MedicineEntity> medicineList = new ArrayList<>();
        Collections.addAll(medicineList,
                new MedicineEntity("Medicine X", "Medicine X description", 3.0),
                new MedicineEntity("Medicine Y", "Medicine Y description", 3.0),
                new MedicineEntity("Medicine Z", "Medicine Z description", 3.0));
        return medicineList;
    }

    @Test
    public void testSaveMedicine() throws Exception {
        MedicineEntity medicine = medicineObject();
        Mockito.when(service.saveMedicine(medicine)).thenReturn(medicine);

        ObjectMapper mapper = mapperBuilder.build();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(medicine);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/medicine/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void testDeleteAppointment() throws Exception {
        MedicineEntity medicine = medicineObject();
        doNothing().when(service).deleteMedicine(medicine);

        ObjectMapper mapper = mapperBuilder.build();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(medicine);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/medicine/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMedicineById() throws Exception {
        MedicineEntity medicine = medicineObject();
        Mockito.when(service.getMedicineById(medicine.getId())).thenReturn(medicine);
        mockMvc.perform(get("/api/v1/medicine/1")).andExpect(status().isOk());
    }

    @Test
    public void testGetMedicineByName() throws Exception {
        MedicineEntity medicine = medicineObject();
        Mockito.when(service.getMedicineByName(medicine.getName())).thenReturn(medicine);

        ObjectMapper mapper = mapperBuilder.build();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(medicine);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/medicine/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetAllMedicines() throws Exception {
        Mockito.when(service.getAllMedicines()).thenReturn(medicineList());
        mockMvc.perform(get("/api/v1/medicine/")).andExpect(status().isOk());
    }


}
