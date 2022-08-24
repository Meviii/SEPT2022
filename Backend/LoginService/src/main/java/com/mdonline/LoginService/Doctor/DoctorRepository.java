package com.mdonline.LoginService.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    // Finds doctor by ID
    Doctor findDoctorByDoctorID (int id);

    // Finds doctor by EMAIL
    Doctor findDoctorByDoctorEmail(String email);

    // Finds ALL doctors
    List<Doctor> findAll();

}