package com.mdonline.PrescriptionService.Prescription;

import java.util.List;

public interface PrescriptionService {
    PrescriptionEntity savePrescription(PrescriptionEntity prescriptionEntity);

    PrescriptionEntity updatePrescription(PrescriptionEntity prescriptionEntity);

    void deletePrescription(PrescriptionEntity prescriptionEntity);

    void deletePrescriptionById(int id);

    PrescriptionEntity getPrescriptionById(int id);

    List<PrescriptionEntity> getPrescriptionByPatientId(int id);

    List<PrescriptionEntity>  getPrescriptionByDoctorId(int id);

    List<PrescriptionEntity> getAllPrescriptions();
}
