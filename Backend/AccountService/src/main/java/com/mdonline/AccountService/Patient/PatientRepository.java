package com.mdonline.AccountService.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    // Finds patient by ID
    Patient findById(int id);

    // Finds patient by EMAIL
    Patient findByEmail(String email);

    // Finds ALL patients
    List<Patient> findAll();

    // Adds new patient
    @Override
    <S extends Patient> S save(S entity);
}