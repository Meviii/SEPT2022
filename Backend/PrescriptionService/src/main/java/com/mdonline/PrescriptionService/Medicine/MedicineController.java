package com.mdonline.PrescriptionService.Medicine;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * WEB Endpoint controller/ URI Controller
 */
@RestController
@RequestMapping(path="/api/v1/medicine")
@CrossOrigin(origins = "*")
public class MedicineController {
    MedicineService service;

    private static final Logger LOGGER = LogManager.getLogger(MedicineController.class);

    @Autowired
    public MedicineController(MedicineService service) {
        this.service = service;
    }

    /**
     * Returns all the Medicines
     */
    @GetMapping(value = "/")
    public List<MedicineEntity> getAllMedicines(){
        return service.getAllMedicines();
    }

    /**
     * Returns a Medicine by unique id
     * @param id - medicine id
     */
    @GetMapping(value = "/{id}")
    public MedicineEntity getMedicineById(@PathVariable int id){
        return service.getMedicineById(id);
    }

    /**
     * Returns a Medicine by unique name
     * @param medicineName - medicine name
     */
    @PostMapping(value = "/name")
    public MedicineEntity getMedicineByName(@RequestBody ObjectNode medicineName){
        return service.getMedicineByName(medicineName.get("name").asText());
    }

    /**
     * Creates a Medicine by a given valid payload
     *
     * @param medicineEntity - Entity object of medicine
     */

    @PostMapping(value = "/")
    public ResponseEntity<?> saveMedicine(@Valid @RequestBody MedicineEntity medicineEntity){
        MedicineEntity medicine = service.saveMedicine(medicineEntity);
        LOGGER.info("MEDICINE CREATED.");
        return ResponseEntity.status(HttpStatus.CREATED).body(medicine);
    }

    /**
     * Updates a Medicine by a given valid payload
     *
     * @param medicineEntity - Entity object of medicine
     */

    @PutMapping(value = "/")
    public ResponseEntity<?> updateMedicine(@Valid @RequestBody MedicineEntity medicineEntity){
        MedicineEntity medicine = service.updateMedicine(medicineEntity);
        LOGGER.info("MEDICINE UPDATED.");
        return ResponseEntity.status(HttpStatus.OK).body(medicine);
    }

    /**
     * Deletes a Medicine by a given payload
     *
     * @param medicineEntity - Entity object of medicine
     */

    @DeleteMapping(value = "/")
    public ResponseEntity<?> deleteMedicine(@RequestBody MedicineEntity medicineEntity){
        service.deleteMedicine(medicineEntity);
        LOGGER.info("MEDICINE DELETED.");
        return ResponseEntity.ok().body("MEDICINE DELETED.");
    }

    /**
     * Deletes a Medicine by a given valid id
     *
     * @param id - id of medicine
     */


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteMedicineById(@PathVariable int id){
        service.deleteById(id);
        LOGGER.info("MEDICINE DELETED.");
        return ResponseEntity.ok().body("MEDICINE DELETED.");
    }

}
