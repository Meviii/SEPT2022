package com.mdonline.PrescriptionService.Prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1/prescription")
@CrossOrigin(origins = "*")
public class PrescriptionController {

    private PrescriptionService service;

    @Autowired
    public PrescriptionController(PrescriptionService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public List<PrescriptionEntity> getAllPrescriptions() {
        return service.getAllPrescriptions();
    }

    @GetMapping(value = "/{id}")
    public PrescriptionEntity getPrescriptionById(@PathVariable long id) {
        return service.getPrescriptionById(id);
    }


    @GetMapping(value = "/doctor/{id}")
    public List<PrescriptionEntity> getPrescriptionByDoctorId(@PathVariable long id) {
        return service.getPrescriptionByDoctorId(id);
    }

    @GetMapping(value = "/patient/{id}")
    public List<PrescriptionEntity> getPrescriptionByPatientId(@PathVariable long id) {
        return service.getPrescriptionByPatientId(id);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> savePrescription(@Valid @RequestBody PrescriptionEntity prescription){
        try{
            PrescriptionEntity prescriptionEntity = service.savePrescription(prescription);
            return ResponseEntity.status(HttpStatus.CREATED).body(prescriptionEntity);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PutMapping(value = "/")
    public ResponseEntity<?> updatePrescription(@Valid @RequestBody PrescriptionEntity prescription){
        try{
            PrescriptionEntity prescriptionEntity = service.updatePrescription(prescription);
            return ResponseEntity.status(HttpStatus.OK).body(prescriptionEntity);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<?> deletePrescription(@RequestBody PrescriptionEntity prescription){
        try{
            service.deletePrescription(prescription);
            return ResponseEntity.ok().body("PRESCRIPTION DELETED.");
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletePrescriptionById(@PathVariable int id){
        try{
            service.deletePrescriptionById(id);
            return ResponseEntity.ok().body("PRESCRIPTION DELETED.");
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }


}
