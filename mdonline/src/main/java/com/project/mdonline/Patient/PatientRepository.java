package com.project.mdonline.Patient;

import com.project.mdonline.Doctor.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

    // Finds patient by ID
    Patient findPatientByPatientID(int id);

    // Finds patient by EMAIL
    Patient findPatientByPatientEmail(String email);

    // Finds ALL patients
    List<Patient> findAll();

    // Adds new patient
    @Override
    <S extends Patient> S save(S entity);
}