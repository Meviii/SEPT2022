package com.mdonline.PrescriptionService.Medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    private MedicineRepository repository;

    @Autowired
    public MedicineServiceImpl(MedicineRepository repository) {
        this.repository = repository;
    }

    @Override
    public MedicineEntity saveMedicine(MedicineEntity medicineEntity) {
        return repository.save(medicineEntity);
    }

    @Override
    public MedicineEntity updateMedicine(MedicineEntity medicineEntity) {
        return repository.save(medicineEntity);
    }

    @Override
    public void deleteMedicine(MedicineEntity medicineEntity) {
        repository.delete(medicineEntity);
    }

    @Override
    public void deleteById(long id) { repository.deleteById(id); }

    @Override
    public MedicineEntity getMedicineById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public MedicineEntity getMedicineByName(String name) {
        return repository.findByMedicineName(name);
    }

    @Override
    public List<MedicineEntity> getAllMedicines() {
        return repository.findAll();
    }
}
