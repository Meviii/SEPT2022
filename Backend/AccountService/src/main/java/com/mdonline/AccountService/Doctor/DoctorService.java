package com.mdonline.AccountService.Doctor;

import com.mdonline.AccountService.Exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
        System.out.println("Doctor Service layer created.");

    }

    // Returns doctor by ID if found, else, throws error
    public Doctor getDoctorById(int id) {
        Doctor doctorToReturn = doctorRepository.findById(id);

        if (doctorToReturn == null) {
            throw new CustomException("Entity not found", "601", HttpStatus.NOT_FOUND);
        }

        return doctorToReturn;
    }

    // Returns all doctors if found, else, throws error
    public List<Doctor> getAllDoctor() {
//        List<Doctor> doctorsToReturn = doctorRepository.findAll();
//
//        if (doctorsToReturn == null) {
//            throw new CustomException("Entity not found", "601", HttpStatus.NOT_FOUND);
//        }
//
//        return doctorsToReturn;
        return null;
    }

    // Returns doctor by EMAIL if found, else, throws error
    public Doctor getDoctorByEmail(String email) {
        Doctor doctorToReturn = doctorRepository.findByEmail(email);

        if (doctorToReturn == null) {
            throw new CustomException("Entity not found", "601", HttpStatus.NOT_FOUND);
        }

        return doctorToReturn;
    }

    // Adds new doctor
    public void addNewDoctor(Doctor doctor) {

        if (doctor.getEmail() == "" || doctor.getPassword() == "" ||
                doctor.getPassword() == null || doctor.getEmail() == null ||
                doctor.getId() != null) {
            throw new CustomException("Incorrect key values", "603", HttpStatus.BAD_REQUEST);
        }

        doctorRepository.save(doctor);
    }

    // Updates doctor
    public void updateDoctor(int id, Map<String, String> doctor){

        Doctor retrievedDoctor = doctorRepository.findById(id);

        if (retrievedDoctor.getEmail() == null) {
            throw new CustomException("Doctor not found", "601", HttpStatus.NOT_FOUND);
        }

        for (Map.Entry<String,String> entry : doctor.entrySet()){
            if (entry.getKey() == "firstName"){
                retrievedDoctor.setFirstName(entry.getValue());
            }else if (entry.getKey() == "country"){
                retrievedDoctor.setCountry(entry.getValue());
            }else if (entry.getKey() == "middleName"){
                retrievedDoctor.setMiddleName(entry.getValue());
            }else if (entry.getKey() == "lastName"){
                retrievedDoctor.setLastName(entry.getValue());
            }else if (entry.getKey() == "phone"){
                retrievedDoctor.setPhone(Integer.parseInt(entry.getValue()));
            }else if (entry.getKey() == "birth"){
                retrievedDoctor.setBirth(Date.valueOf(entry.getValue()));
            }else if (entry.getKey() == "streetNo"){
                retrievedDoctor.setStreetNo(Integer.parseInt(entry.getValue()));
            }else if (entry.getKey() == "streetName"){
                retrievedDoctor.setStreetName(entry.getValue());
            }else if (entry.getKey() == "city"){
                retrievedDoctor.setCity(entry.getValue());
            }else if (entry.getKey() == "state"){
                retrievedDoctor.setState(entry.getValue());
            }else if (entry.getKey() == "postCode"){
                retrievedDoctor.setPostCode(Integer.parseInt(entry.getValue()));
            }else if (entry.getKey() == "password") {
                retrievedDoctor.setPassword(entry.getValue());
            }else if (entry.getKey() == "profession"){
                retrievedDoctor.setProfession(entry.getValue());
            }else{
                throw new CustomException("Incorrect key values", "603", HttpStatus.BAD_REQUEST);
            }
        }
        doctorRepository.save(retrievedDoctor);
    }
}
