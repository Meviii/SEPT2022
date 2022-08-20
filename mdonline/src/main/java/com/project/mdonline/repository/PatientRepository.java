package com.project.mdonline.repository;

import com.project.mdonline.model.Patient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

    Patient findPatientByID(int id);

    Patient findPatientByEmail(String email);

    // Returns admin by id in database
    List<Patient> findAllPatient();
}