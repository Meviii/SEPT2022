package com.mdonline.PrescriptionService.Medicine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineEntity, Long> {
    MedicineEntity findByMedicineName(String name);
}