package com.mdonline.PrescriptionService.Medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Business logic of Medicine URI endpoints and data handling.
 */
@Service
public class MedicineServiceImpl implements MedicineService {

    private MedicineRepository repository;

    @Autowired
    public MedicineServiceImpl(MedicineRepository repository) {
        this.repository = repository;
    }

    /**
     * Creates a new Medicine and saves into datastore.
     *
     * @param medicineEntity - Medicine object to save
     *
     * @Return - Medicine object if medicine has been created
     */
    @Override
    public MedicineEntity saveMedicine(MedicineEntity medicineEntity) {
        return repository.save(medicineEntity);
    }

    /**
     * Finds and updates a Medicine by given medicine object if object id is found in the datastore.
     *
     * @param medicineEntity - Medicine object
     *
     * @Return - Medicine object if medicine has been updated
     */
    @Override
    public MedicineEntity updateMedicine(MedicineEntity medicineEntity) {
        return repository.save(medicineEntity);
    }

    /**
     * Deletes a Medicine if object id exists in datastore
     *
     * @param medicineEntity - Medicine object
     *
     */

    @Override
    public void deleteMedicine(MedicineEntity medicineEntity) {
        repository.delete(medicineEntity);
    }

    /**
     * Deletes a Medicine if id exists in datastore
     *
     * @param id - Medicine id to delete
     *
     */
    @Override
    public void deleteById(long id) { repository.deleteById(id); }

    /**
     * Finds and returns a Medicine by id if id is found in the datastore.
     *
     * @param id - Medicine id
     * @Return - Medicine OR null
     */
    @Override
    public MedicineEntity getMedicineById(long id) {
        return repository.findById(id).get();
    }

    /**
     * Finds and returns a Medicine by name if id is found in the datastore.
     *
     * @param name - Medicine name
     * @Return - Medicine OR null
     */
    @Override
    public MedicineEntity getMedicineByName(String name) {
        return repository.findByName(name);
    }

    /**
     * Finds and returns Medicine list
     *
     * @Return - MedicineList OR EmptyList
     */
    @Override
    public List<MedicineEntity> getAllMedicines() {
        return repository.findAll();
    }
}
