package com.mdonline.PrescriptionService.Medicine;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
public class MedicineServiceTest {
    @MockBean
    private MedicineRepository repository;

    @InjectMocks
    private MedicineServiceImpl service;

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
    public void testCreateMedicine(){
        MedicineEntity medicine = medicineObject();
        Mockito.when(repository.save(medicine)).thenReturn(medicine);
        assertEquals(medicine, service.saveMedicine(medicine));
    }

    @Test
    public void testDeleteAppointment(){
        MedicineEntity medicine = medicineObject();
        service.deleteMedicine(medicine);
        verify(repository, times(1)).delete(medicine);
    }

    @Test
    public void testGetMedicineById(){
        MedicineEntity medicine = medicineObject();
        Mockito.when(repository.findById(medicine.getId())).thenReturn(Optional.ofNullable(medicineObject()));
        assertNotNull(service.getMedicineById(medicine.getId()));
    }

    @Test
    public void testGetMedicineByName(){
        MedicineEntity medicine = medicineObject();
        Mockito.when(repository.findByName(medicine.getName())).thenReturn(medicineObject());
        assertNotNull(service.getMedicineByName(medicine.getName()));
    }

    @Test
    public void testGetAllMedicines(){
        Mockito.when(repository.findAll()).thenReturn(medicineList());
        assertEquals(3, service.getAllMedicines().size());
    }

}
