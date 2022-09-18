package com.mdonline.PrescriptionService.Prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Business logic of Prescription URI endpoints and data handling.
 */
@Service
public class PrescriptionServiceImpl implements PrescriptionService{

    private PrescriptionRepository repository;

    @Autowired
    public PrescriptionServiceImpl(PrescriptionRepository repository) {
        this.repository = repository;
    }

    /**
     * Creates a new Prescription and saves into datastore.
     *
     * @param prescriptionEntity - Prescription object to save
     *
     * @Return - Prescription object if prescription has been created
     */
    @Override
    public PrescriptionEntity savePrescription(PrescriptionEntity prescriptionEntity) {
        return repository.save(prescriptionEntity);
    }

    /**
     * Finds and updates a Prescription by given prescription object if object id is found in the datastore.
     *
     * @param prescriptionEntity - Prescription object
     *
     * @Return - Prescription object if prescription has been updated
     */

    @Override
    public PrescriptionEntity updatePrescription(PrescriptionEntity prescriptionEntity) {
        return repository.save(prescriptionEntity);
    }

    /**
     * Deletes a Prescription if object id exists in datastore
     *
     * @param prescriptionEntity - Prescription object
     *
     */

    @Override
    public void deletePrescription(PrescriptionEntity prescriptionEntity) {
        repository.delete(prescriptionEntity);
    }

    /**
     * Deletes a Prescription if id exists in datastore
     *
     * @param id - Prescription id to delete
     *
     */
    @Override
    public void deletePrescriptionById(long id) {
            repository.deleteById(id);
    }

    /**
     * Finds and returns a Prescription by id if id is found in the datastore.
     *
     * @param id - Prescription id
     * @Return - Prescription OR null
     */

    @Override
    public PrescriptionEntity getPrescriptionById(long id) {
        return repository.findById(id).get();
    }

    /**
     * Finds and returns Prescription list by Patient id if it is found in the datastore.
     *
     * @param id - Patient id
     * @Return - PrescriptionList OR EmptyList
     */
    @Override
    public List<PrescriptionEntity> getPrescriptionByPatientId(long id) {
        return repository.findPrescriptionByPatientIdOrderByDateDesc(id);
    }

    /**
     * Finds and returns Prescription list by Doctor id if it is found in the datastore.
     *
     * @param id - Doctor id
     * @Return - PrescriptionList OR EmptyList
     */
    @Override
    public List<PrescriptionEntity> getPrescriptionByDoctorId(long id) {
        return repository.findPrescriptionByDoctorIdOrderByDateDesc(id);
    }

    /**
     * Finds and returns Prescription list
     *
     * @Return - PrescriptionList OR EmptyList
     */
    @Override
    public List<PrescriptionEntity> getAllPrescriptions() {
        return repository.findAll();
    }
}
