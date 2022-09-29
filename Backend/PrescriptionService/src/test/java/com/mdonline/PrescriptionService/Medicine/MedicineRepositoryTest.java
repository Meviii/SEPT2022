package com.mdonline.PrescriptionService.Medicine;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class MedicineRepositoryTest {
    @Autowired
    private MedicineRepository repository;

    public MedicineEntity saveMedicine(){
        return repository.save(new MedicineEntity("Medicine X", "Medicine X description", 3.0));
    }

    public void saveMedicineList(){
        repository.save(new MedicineEntity("Medicine X", "Medicine X description", 3.0));
        repository.save(new MedicineEntity("Medicine Y", "Medicine Y description", 3.0));
        repository.save(new MedicineEntity("Medicine Z", "Medicine Z description", 3.0));
    }

    @Test
    public void testCreateMedicine(){
        MedicineEntity medicine = saveMedicine();
        assertNotNull(medicine);
        assertTrue(medicine.getId() > 0);
    }

    @Test
    public void testDeleteMedicine(){
        MedicineEntity medicine = saveMedicine();
        repository.deleteById(medicine.getId());

        Optional<MedicineEntity> medicineOptional = repository.findById(medicine.getId());
        assertThat(medicineOptional).isEmpty();
    }

    @Test
    public void testGetMedicineById(){
        MedicineEntity medicine = saveMedicine();
        MedicineEntity medicineDB = repository.findById(medicine.getId()).get();
        assertNotNull(medicineDB);
    }

    @Test
    public void testGetMedicineByName(){
        MedicineEntity medicine = saveMedicine();
        MedicineEntity medicineDB = repository.findByName(medicine.getName());
        assertNotNull(medicineDB);
    }

    @Test
    public void testGetAllAppointments(){
        saveMedicineList();
        List<MedicineEntity> medicineList = repository.findAll();
        assertThat(medicineList.size()).isEqualTo(3);
    }

}
