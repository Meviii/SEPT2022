package com.mdonline.AccountService.Prescription;

import com.mdonline.AccountService.Doctor.Doctor;
import com.mdonline.AccountService.Patient.Patient;
import com.mdonline.AccountService.User.User;
import com.mdonline.AccountService.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PrescriptionService {

    private RestTemplate restTemplate;
    private UserService userService;

    @Autowired
    public PrescriptionService(RestTemplate restTemplate, UserService userService) {
        this.restTemplate = restTemplate;
        this.userService = userService;
    }

    public ResponseEntity<List<Prescription>> getPrescriptionsOfUser(long id) {
        ResponseEntity<List<Prescription>> prescriptions;
        User userDetails;
        ParameterizedTypeReference<List<Prescription>> prescriptionRef = new ParameterizedTypeReference<>() {};

        if (userService.getUserById(id).getUserType().equalsIgnoreCase("doctor")){
            userDetails = new Doctor();
            userDetails.setId(id);

            prescriptions = restTemplate.exchange("http://prescription-service/api/v1/prescription/doctor/" +
                    userDetails.getId(), HttpMethod.GET, null, prescriptionRef);

        }else if (userService.getUserById(id).getUserType().equalsIgnoreCase("patient")) {
            userDetails = new Patient();
            userDetails.setId(id);

            prescriptions = restTemplate.exchange("http://prescription-service/api/v1/prescription/patient/" +
                    userDetails.getId(), HttpMethod.GET, null, prescriptionRef);
        }else{
            return null;
        }

        return prescriptions;
    }
}
