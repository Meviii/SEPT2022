package com.mdonline.PrescriptionService.Prescription;

import com.mdonline.PrescriptionService.Medicine.MedicineEntity;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class PrescriptionServiceTest {
    @MockBean
    private PrescriptionRepository repository;

    @InjectMocks
    private PrescriptionServiceImpl service;

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
    public void testCreatePrescription() throws ParseException {
        PrescriptionEntity prescription = prescriptionObject();
        Mockito.when(repository.save(prescription)).thenReturn(prescription);
        assertEquals(prescription, service.savePrescription(prescription));
    }

    @Test
    public void testDeletePrescription() throws ParseException {
        PrescriptionEntity prescription = prescriptionObject();
        service.deletePrescription(prescription);
        verify(repository, times(1)).delete(prescription);
    }

    @Test
    public void testGetPrescriptionById() throws ParseException {
        PrescriptionEntity prescription = prescriptionObject();
        Mockito.when(repository.findById(prescription.getId())).thenReturn(Optional.ofNullable(prescriptionObject()));
        assertNotNull(service.getPrescriptionById(prescription.getId()));
    }

    @Test
    public void getPrescriptionByPatientId() throws ParseException {
        Mockito.when(repository.findPrescriptionByPatientIdOrderByDateDesc(1L)).thenReturn(prescriptionList());
        assertEquals(3, service.getPrescriptionByPatientId(1L).size());
    }

    @Test
    public void getPrescriptionByDoctorId() throws ParseException {
        Mockito.when(repository.findPrescriptionByDoctorIdOrderByDateDesc(2L)).thenReturn(prescriptionList());
        assertEquals(3, service.getPrescriptionByDoctorId(2L).size());
    }

    @Test
    public void testGetAllMedicines() throws ParseException {
        Mockito.when(repository.findAll()).thenReturn(prescriptionList());
        assertEquals(3, service.getAllPrescriptions().size());
    }
}
