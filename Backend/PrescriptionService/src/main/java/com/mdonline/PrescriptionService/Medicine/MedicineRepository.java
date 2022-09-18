package com.mdonline.PrescriptionService.Medicine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface handles the Medicine related database queries via JPA and Hibernate
 */

@Repository
public interface MedicineRepository extends JpaRepository<MedicineEntity, Long> {
    MedicineEntity findByName(String name);
}