package com.project.mdonline.Doctor;


import com.project.mdonline.Exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service()
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
        System.out.println("Doctor Service layer created.");
    }

    // Returns doctor by ID if found, else, throws error
    public Doctor getDoctorById(int id) {
        Doctor doctorToReturn = doctorRepository.findDoctorByDoctorID(id);

        if (doctorToReturn == null) {
            throw new CustomException("Entity not found", "601", HttpStatus.NOT_FOUND);
        }

        return doctorToReturn;
    }

    // Returns all doctors if found, else, throws error
    public List<Doctor> getAllDoctor() {
        List<Doctor> doctorsToReturn = doctorRepository.findAll();

        if (doctorsToReturn == null) {
            throw new CustomException("Entity not found", "601", HttpStatus.NOT_FOUND);
        }

        return doctorsToReturn;
    }

    // Returns doctor by EMAIL if found, else, throws error
    public Doctor getDoctorByEmail(String email) {
        Doctor doctorToReturn = doctorRepository.findDoctorByDoctorEmail(email);

        if (doctorToReturn == null) {
            throw new CustomException("Entity not found", "601", HttpStatus.NOT_FOUND);
        }

        return doctorToReturn;
    }

    // Adds new doctor
    public void addNewDoctor(Doctor doctor) {

        if (doctor.getDoctorEmail() == "" || doctor.getDoctorPassword() == "" || doctor.getDoctorPassword() == null || doctor.getDoctorEmail() == null) {
            throw new CustomException("Incorrect key values", "603", HttpStatus.BAD_REQUEST);
        }

        doctorRepository.save(doctor);
    }

    // Updates doctor
    public void updateDoctor(int id, Map<String, String> doctor){
        System.out.println(id);
        System.out.println(doctor);
        Doctor retrievedDoctor = doctorRepository.findDoctorByDoctorID(id);

        if (retrievedDoctor.getDoctorEmail() == null) {
            throw new CustomException("Doctor not found", "601", HttpStatus.NOT_FOUND);
        }

        for (Map.Entry<String,String> entry : doctor.entrySet()){
            if (entry.getKey() == "doctorFirstName"){
                retrievedDoctor.setDoctorFirstName(entry.getValue());
            }else if (entry.getKey() == "doctorCountry"){
                retrievedDoctor.setDoctorCountry(entry.getValue());
            }else if (entry.getKey() == "doctorMiddleName"){
                retrievedDoctor.setDoctorMiddleName(entry.getValue());
            }else if (entry.getKey() == "doctorLastName"){
                retrievedDoctor.setDoctorLastName(entry.getValue());
            }else if (entry.getKey() == "doctorPhone"){
                retrievedDoctor.setDoctorPhone(Integer.parseInt(entry.getValue()));
            }else if (entry.getKey() == "doctorBirth"){
                retrievedDoctor.setDoctorBirth(Date.valueOf(entry.getValue()));
            }else if (entry.getKey() == "doctorStreetNo"){
                retrievedDoctor.setDoctorStreetNo(Integer.parseInt(entry.getValue()));
            }else if (entry.getKey() == "doctorStreetName"){
                retrievedDoctor.setDoctorStreetName(entry.getValue());
            }else if (entry.getKey() == "doctorCity"){
                retrievedDoctor.setDoctorCity(entry.getValue());
            }else if (entry.getKey() == "doctorState"){
                retrievedDoctor.setDoctorState(entry.getValue());
            }else if (entry.getKey() == "doctorPostCode"){
                retrievedDoctor.setDoctorPostCode(Integer.parseInt(entry.getValue()));
            }else if (entry.getKey() == "doctorPassword"){
                retrievedDoctor.setDoctorPassword(entry.getValue());
            }else{
                throw new CustomException("Incorrect key values", "603", HttpStatus.BAD_REQUEST);
            }
        }
        doctorRepository.save(retrievedDoctor);
    }
}
