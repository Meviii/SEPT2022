package com.mdonline.AccountService.Patient;


import com.mdonline.AccountService.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    // Finds patient by ID
    Patient findById(int id);

    // Find patient by email
    Patient findByEmail(String email);

    // Finds ALL patients
    List<Patient> findUsersByUserType(String usertype);

    @Override
    <S extends Patient> S save(S entity);

    void save(User toCreate);
}