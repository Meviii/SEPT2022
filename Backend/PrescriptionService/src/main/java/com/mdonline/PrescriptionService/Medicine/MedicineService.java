package com.mdonline.PrescriptionService.Medicine;

import java.util.List;

public interface MedicineService {
    MedicineEntity saveMedicine(MedicineEntity medicineEntity);
    MedicineEntity updateMedicine(MedicineEntity medicineEntity);
    void deleteMedicine(MedicineEntity medicineEntity);

    void deleteById(long id);
    MedicineEntity getMedicineById(long id);
    MedicineEntity getMedicineByName(String name);
    List<MedicineEntity> getAllMedicines();
}
