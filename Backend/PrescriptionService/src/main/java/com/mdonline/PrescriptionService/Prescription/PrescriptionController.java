package com.mdonline.PrescriptionService.Prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1")
@CrossOrigin(origins = "*")
public class PrescriptionController {
    @Autowired
    PrescriptionService service;

    @GetMapping(value = "/prescription")
    public List<PrescriptionEntity> getAllPrescriptions() {
        return service.getAllPrescriptions();
    }

    @GetMapping(value = "/prescription/{id}")
    public PrescriptionEntity getPrescriptionById(@PathVariable int id) {
        return service.getPrescriptionById(id);
    }


    @GetMapping(value = "/prescription/doctor/{id}")
    public List<PrescriptionEntity> getPrescriptionByDoctorId(@PathVariable int id) {
        return service.getPrescriptionByDoctorId(id);
    }

    @GetMapping(value = "/prescription/patient/{id}")
    public List<PrescriptionEntity> getPrescriptionByPatientId(@PathVariable int id) {
        return service.getPrescriptionByPatientId(id);
    }

    @PostMapping(value = "/prescription/save")
    public ResponseEntity<?> savePrescription(@Valid @RequestBody PrescriptionEntity prescription){
        try{
            PrescriptionEntity prescriptionEntity = service.savePrescription(prescription);
            return ResponseEntity.status(HttpStatus.CREATED).body(prescriptionEntity);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PutMapping(value = "/prescription/update")
    public ResponseEntity<?> updatePrescription(@Valid @RequestBody PrescriptionEntity prescription){
        try{
            PrescriptionEntity prescriptionEntity = service.updatePrescription(prescription);
            return ResponseEntity.status(HttpStatus.OK).body(prescriptionEntity);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @DeleteMapping(value = "/prescription/delete")
    public ResponseEntity<?> deletePrescription(@RequestBody PrescriptionEntity prescription){
        try{
            service.deletePrescription(prescription);
            return ResponseEntity.ok().body("PRESCRIPTION DELETED.");
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @DeleteMapping(value = "/prescription/delete/{id}")
    public ResponseEntity<?> deletePrescriptionById(@PathVariable int id){
        try{
            service.deletePrescriptionById(id);
            return ResponseEntity.ok().body("PRESCRIPTION DELETED.");
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }


}
