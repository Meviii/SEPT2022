package com.mdonline.AccountService.Prescription;

import com.mdonline.AccountService.Exceptions.CustomException;
import com.mdonline.AccountService.User.UserService;
import com.mdonline.AccountService.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1/user")
public class PrescriptionController {

    private UserService userService;
    private Utility utility;
    private RestTemplate restTemplate;
    private PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionController(UserService userService, RestTemplate restTemplate, PrescriptionService prescriptionService) {
        this.userService = userService;
        this.utility = new Utility();
        this.restTemplate = restTemplate;
        this.prescriptionService = prescriptionService;
    }

    @GetMapping(value = "/{id}/prescription",produces="application/json")
    @ResponseBody
    public ResponseEntity<List<Prescription>> getAllPrescriptionsOfUser(@PathVariable @Valid long id) {

        ResponseEntity<List<Prescription>> prescriptions = prescriptionService.getPrescriptionsOfUser(id);

        if (prescriptions == null){
            throw new CustomException("No Prescriptions for user or user doesnt exist", HttpStatus.NOT_FOUND);
        }

        return prescriptions;
    }
}
