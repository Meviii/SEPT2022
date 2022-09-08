package com.mdonline.PrescriptionService.Prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{

    private PrescriptionRepository repository;

    @Autowired
    public PrescriptionServiceImpl(PrescriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public PrescriptionEntity savePrescription(PrescriptionEntity prescriptionEntity) {
        return repository.save(prescriptionEntity);
    }

    @Override
    public PrescriptionEntity updatePrescription(PrescriptionEntity prescriptionEntity) {
        return repository.save(prescriptionEntity);
    }

    @Override
    public void deletePrescription(PrescriptionEntity prescriptionEntity) {
        repository.delete(prescriptionEntity);
    }

    @Override
    public void deletePrescriptionById(long id) {
            repository.deleteById(id);
    }

    @Override
    public PrescriptionEntity getPrescriptionById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<PrescriptionEntity> getPrescriptionByPatientId(long id) {
        return repository.findPrescriptionByPatientIdOrderByDateDesc(id);
    }

    @Override
    public List<PrescriptionEntity> getPrescriptionByDoctorId(long id) {
        return repository.findPrescriptionByDoctorIdOrderByDateDesc(id);
    }

    @Override
    public List<PrescriptionEntity> getAllPrescriptions() {
        return repository.findAll();
    }
}
