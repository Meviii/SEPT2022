package com.mdonline.PrescriptionService.Prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

/**
 * WEB Endpoint controller/ URI Controller
 */
@RestController
@RequestMapping(path="/api/v1/prescription")
@CrossOrigin(origins = "*")
public class PrescriptionController {

    private PrescriptionService service;

    @Autowired
    public PrescriptionController(PrescriptionService service) {
        this.service = service;
    }

    /**
     * Returns all the prescriptions
     */
    @GetMapping(value = "/")
    public List<PrescriptionEntity> getAllPrescriptions() {
        return service.getAllPrescriptions();
    }

    /**
     * Returns a prescription by Prescription id
     * @param id - prescription id
     */
    @GetMapping(value = "/{id}")
    public PrescriptionEntity getPrescriptionById(@PathVariable long id) {
        return service.getPrescriptionById(id);
    }

    /**
     * Returns all the prescriptions by doctor id
     * @param id - doctor id
     */

    @GetMapping(value = "/doctor/{id}")
    public List<PrescriptionEntity> getPrescriptionByDoctorId(@PathVariable long id) {
        return service.getPrescriptionByDoctorId(id);
    }

    /**
     * Returns all the prescriptions by patient id
     * @param id - patient id
     */

    @GetMapping(value = "/patient/{id}")
    public List<PrescriptionEntity> getPrescriptionByPatientId(@PathVariable long id) {
        return service.getPrescriptionByPatientId(id);
    }

    /**
     * Creates a prescription by a given valid payload
     *
     * @param prescription - Entity object of prescription
     */

    @PostMapping(value = "/")
    public ResponseEntity<?> savePrescription(@Valid @RequestBody PrescriptionEntity prescription){
        try{
            PrescriptionEntity prescriptionEntity = service.savePrescription(prescription);
            return ResponseEntity.status(HttpStatus.CREATED).body(prescriptionEntity);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    /**
     * Updates a prescription by the given payload
     *
     * @param prescription - Entity object of prescription
     */

    @PutMapping(value = "/")
    public ResponseEntity<?> updatePrescription(@Valid @RequestBody PrescriptionEntity prescription){
        try{
            PrescriptionEntity prescriptionEntity = service.updatePrescription(prescription);
            return ResponseEntity.status(HttpStatus.OK).body(prescriptionEntity);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    /**
     * Deletes a prescription by the given payload
     *
     * @param prescription - Entity object of prescription
     */

    @DeleteMapping(value = "/")
    public ResponseEntity<?> deletePrescription(@RequestBody PrescriptionEntity prescription){
        try{
            service.deletePrescription(prescription);
            return ResponseEntity.ok().body("PRESCRIPTION DELETED.");
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    /**
     * Deletes a prescription by a given valid id
     *
     * @param id - id of prescription
     */
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
