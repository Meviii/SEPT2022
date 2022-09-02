package com.mdonline.PrescriptionService.Prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{

    @Autowired
    private PrescriptionRepository repository;

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
    public void deletePrescriptionById(int id) {
            repository.deleteById(id);
    }

    @Override
    public PrescriptionEntity getPrescriptionById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public List<PrescriptionEntity> getPrescriptionByPatientId(int id) {
        return repository.findPrescriptionByPatientIdOrderByDateDesc(id);
    }

    @Override
    public List<PrescriptionEntity> getPrescriptionByDoctorId(int id) {
        return repository.findPrescriptionByDoctorIdOrderByDateDesc(id);
    }

    @Override
    public List<PrescriptionEntity> getAllPrescriptions() {
        return repository.findAll();
    }
}
