package com.mdonline.PrescriptionService.Prescription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<PrescriptionEntity, Long> {

    @Query(value = "SELECT * FROM Prescription WHERE patient_id = ?1 ORDER BY date DESC",
            nativeQuery = true)
    List<PrescriptionEntity> findPrescriptionByPatientIdOrderByDateDesc(long patientId);

    @Query(value = "SELECT * FROM Prescription WHERE doctor_id = ?1 ORDER BY date DESC",
            nativeQuery = true)
    List<PrescriptionEntity> findPrescriptionByDoctorIdOrderByDateDesc(long doctorId);
}
