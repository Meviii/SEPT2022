package com.mdonline.PrescriptionService.Prescription;

import java.util.List;

public interface PrescriptionService {
    PrescriptionEntity savePrescription(PrescriptionEntity prescriptionEntity);

    PrescriptionEntity updatePrescription(PrescriptionEntity prescriptionEntity);

    void deletePrescription(PrescriptionEntity prescriptionEntity);

    void deletePrescriptionById(long id);

    PrescriptionEntity getPrescriptionById(long id);

    List<PrescriptionEntity> getPrescriptionByPatientId(long id);

    List<PrescriptionEntity>  getPrescriptionByDoctorId(long id);

    List<PrescriptionEntity> getAllPrescriptions();
}
