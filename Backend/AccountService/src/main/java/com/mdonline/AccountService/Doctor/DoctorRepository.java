package com.mdonline.AccountService.Doctor;

import com.mdonline.AccountService.Patient.Patient;
import com.mdonline.AccountService.User.User;
import com.mdonline.AccountService.User.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {


    // Finds doctor by ID
    User findById(int id);

    // Find patient by email
    User findByEmail(String email);

    // Find all doctors
    List<Doctor> findUsersByUserType(String usertype);

    @Override
    <S extends Doctor> S save(S entity);

    void save(User toCreate);
}