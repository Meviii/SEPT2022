package com.mdonline.PrescriptionService.Prescription;


import com.mdonline.PrescriptionService.Medicine.MedicineEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class PrescriptionRepositoryTest {
    @Autowired
    private PrescriptionRepository repository;

    public PrescriptionEntity savePrescription() throws ParseException {
        List<MedicineEntity> medicines = new ArrayList<>();
        medicines.add(new MedicineEntity("Medicine X", "Medicine X description", 3.0));
        medicines.add(new MedicineEntity("Medicine Y", "Medicine Y description", 3.0));
        medicines.add(new MedicineEntity("Medicine Z", "Medicine Z description", 3.0));

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = (java.util.Date) dateFormatter.parse("2022-10-10");


        return repository.save(new PrescriptionEntity(medicines, "2 week", "Test prescription",
                date, 2L, 1L));
    }

    public void savePrescriptionList() throws ParseException {
        repository.save(savePrescription());
        repository.save(savePrescription());
        repository.save(savePrescription());
    }

    @Test
    public void testCreatePrescription() throws ParseException {
        PrescriptionEntity prescription = savePrescription();
        assertNotNull(prescription);
        assertTrue(prescription.getId() > 0);
    }

    @Test
    public void testDeletePrescription() throws ParseException {
        PrescriptionEntity prescription = savePrescription();
        repository.deleteById(prescription.getId());

        Optional<PrescriptionEntity> prescriptionOptional = repository.findById(prescription.getId());
        assertThat(prescriptionOptional).isEmpty();
    }

    @Test
    public void testGetPrescriptionById() throws ParseException {
        PrescriptionEntity prescription = savePrescription();
        PrescriptionEntity prescriptionDB = repository.findById(prescription.getId()).get();
        assertNotNull(prescriptionDB);
    }

    @Test
    public void testGetAllPrescriptions() throws ParseException {
        savePrescriptionList();
        List<PrescriptionEntity> prescriptionList = repository.findAll();
        assertThat(prescriptionList.size()).isEqualTo(3);
    }

}
