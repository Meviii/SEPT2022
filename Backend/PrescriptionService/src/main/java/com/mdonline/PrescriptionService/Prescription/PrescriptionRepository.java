package com.mdonline.PrescriptionService.Prescription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<PrescriptionEntity, Integer> {
    @Query(value = "SELECT * FROM Prescription WHERE patient_id = ?1 ORDER BY prescription_date DESC",
            nativeQuery = true)
    List<PrescriptionEntity> findPrescriptionByPatientIdOrderByDateDesc(int patientId);

    @Query(value = "SELECT * FROM Prescription WHERE doctor_id = ?1 ORDER BY prescription_date DESC",
            nativeQuery = true)
    List<PrescriptionEntity> findPrescriptionByDoctorIdOrderByDateDesc(int doctorId);
}
