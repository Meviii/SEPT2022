package com.mdonline.PrescriptionService.Medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1")
@CrossOrigin(origins = "*")
public class MedicineController {
    @Autowired
    MedicineService service;

    @GetMapping(value = "/medicine")
    public List<MedicineEntity> getAllMedicines(){
        return service.getAllMedicines();
    }

    @GetMapping(value = "/medicine/{id}")
    public MedicineEntity getMedicineById(@PathVariable int id){
        return service.getMedicineById(id);
    }

    @GetMapping(value = "/medicine/name/{name}")
    public MedicineEntity getMedicineByName(@PathVariable String name){
        return service.getMedicineByName(name);
    }

    @PostMapping(value = "/medicine/save")
    public ResponseEntity<?> saveMedicine(@Valid @RequestBody MedicineEntity medicineEntity){
        MedicineEntity medicine = service.saveMedicine(medicineEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicine);
    }

    @PutMapping(value = "/medicine/update")
    public ResponseEntity<?> updateMedicine(@Valid @RequestBody MedicineEntity medicineEntity){
        MedicineEntity medicine = service.updateMedicine(medicineEntity);
        return ResponseEntity.status(HttpStatus.OK).body(medicine);
    }

    @DeleteMapping(value = "/medicine/delete")
    public ResponseEntity<?> deleteMedicine(@RequestBody MedicineEntity medicineEntity){
        service.deleteMedicine(medicineEntity);
        return ResponseEntity.ok().body("MEDICINE DELETED.");
    }

    @DeleteMapping(value = "/medicine/delete/{id}")
    public ResponseEntity<?> deleteMedicineById(@PathVariable int id){
        service.deleteById(id);
        return ResponseEntity.ok().body("MEDICINE DELETED.");
    }

}
