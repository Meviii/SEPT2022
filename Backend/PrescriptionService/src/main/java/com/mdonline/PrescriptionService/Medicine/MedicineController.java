package com.mdonline.PrescriptionService.Medicine;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1/medicine")
@CrossOrigin(origins = "*")
public class MedicineController {
    MedicineService service;

    @Autowired
    public MedicineController(MedicineService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public List<MedicineEntity> getAllMedicines(){
        return service.getAllMedicines();
    }

    @GetMapping(value = "/{id}")
    public MedicineEntity getMedicineById(@PathVariable int id){
        return service.getMedicineById(id);
    }

    @PostMapping(value = "/name")
    public MedicineEntity getMedicineByName(@RequestBody ObjectNode medicineName){
        return service.getMedicineByName(medicineName.get("name").asText());
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> saveMedicine(@Valid @RequestBody MedicineEntity medicineEntity){
        MedicineEntity medicine = service.saveMedicine(medicineEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicine);
    }

    @PutMapping(value = "/")
    public ResponseEntity<?> updateMedicine(@Valid @RequestBody MedicineEntity medicineEntity){
        MedicineEntity medicine = service.updateMedicine(medicineEntity);
        return ResponseEntity.status(HttpStatus.OK).body(medicine);
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<?> deleteMedicine(@RequestBody MedicineEntity medicineEntity){
        service.deleteMedicine(medicineEntity);
        return ResponseEntity.ok().body("MEDICINE DELETED.");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteMedicineById(@PathVariable int id){
        service.deleteById(id);
        return ResponseEntity.ok().body("MEDICINE DELETED.");
    }

}
