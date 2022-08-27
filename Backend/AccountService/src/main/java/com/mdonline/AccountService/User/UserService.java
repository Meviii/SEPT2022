package com.mdonline.AccountService.User;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdonline.AccountService.Doctor.Doctor;
import com.mdonline.AccountService.Doctor.DoctorRepository;
import com.mdonline.AccountService.Exceptions.CustomException;
import com.mdonline.AccountService.Patient.Patient;
import com.mdonline.AccountService.Patient.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;

    @Autowired
    public UserService(PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        System.out.println("User Service layer created.");

    }

    // Returns all patients if found, else, throws error
    public List<User> getAllUsers() {
        List<User> allUserList = new ArrayList<>();
        List<Patient> patientList = patientRepository.findUsersByUserType("Patient");
        List<Doctor> doctorList = doctorRepository.findUsersByUserType("Doctor");

        allUserList.addAll(patientList);
        allUserList.addAll(doctorList);
        return allUserList;
    }

    public User getUserById(int id){
        User toReturn;
        if (patientRepository.findById(id) != null){
            toReturn = patientRepository.findById(id);
        }else if (doctorRepository.findById(id) != null){
            toReturn = doctorRepository.findById(id);
        }else{
            throw new CustomException("User not found", HttpStatus.NOT_FOUND);
        }
        return toReturn;

    }

    // Returns patient by EMAIL if found, else, throws error
    public User getUserByEmail(String email) {
        User toReturn;

        if (patientRepository.findByEmail(email) != null){
            toReturn = patientRepository.findByEmail(email);
        }else if (doctorRepository.findByEmail(email) != null){
            toReturn = doctorRepository.findByEmail(email);
        }else{
            throw new CustomException("User not found", HttpStatus.NOT_FOUND);
        }
        return toReturn;

    }

    public void updateUser(String user, int id){
        User toReturn;

        try {
            if (user.contains("\"userType\": \"Doctor\"")) {
                toReturn = new ObjectMapper().readValue(user, Doctor.class);
                toReturn.setId(id);
                doctorRepository.save(toReturn);
            } else if (user.contains("\"userType\": \"Patient\"")) {
                toReturn = new ObjectMapper().readValue(user, Patient.class);
                toReturn.setId(id);
                patientRepository.save(toReturn);
            } else {
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Was userType included?");
                throw new CustomException("Was userType included? Or user not found, create instead.", HttpStatus.MULTI_STATUS);
            }
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
        }
    }

    public void createUser(String user) throws JsonProcessingException {
        User userToCreate;

        if (user.contains("\"userType\": \"Doctor\"")) {
            userToCreate = new ObjectMapper().readValue(user, Doctor.class);
            doctorRepository.save(userToCreate);
        }else if (user.contains("\"userType\": \"Patient\"")){
            userToCreate = new ObjectMapper().readValue(user, Patient.class);
            doctorRepository.save(userToCreate);
        }else{
            throw new CustomException("Was userType included? Or user already exists.", HttpStatus.MULTI_STATUS);
        }
    }

    public void deleteUser(int id){
        User userToDelete = this.getUserById(id);

        if (userToDelete.getUserType().toLowerCase().contentEquals("doctor")){
            doctorRepository.delete((Doctor) userToDelete);
        }else if (userToDelete.getUserType().toLowerCase().contentEquals("patient")){
            patientRepository.delete((Patient) userToDelete);
        }else{
            throw new CustomException("Was userType included? Or user does not exist.", HttpStatus.MULTI_STATUS);
        }
    }
}
