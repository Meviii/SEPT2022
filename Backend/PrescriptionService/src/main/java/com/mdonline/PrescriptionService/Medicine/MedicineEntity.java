package com.mdonline.PrescriptionService.Medicine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mdonline.PrescriptionService.Prescription.PrescriptionEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Medicine")
public class MedicineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private int id;

    @Column(name = "medicine_name")
    @NotBlank(message = "Drug name is missing")
    private String medicineName;

    @Column(name = "medicine_description")
    @NotBlank(message = "Drug information is missing")
    private String medicineDesc;

    @Column(name = "medicine_dosage")
    @NotNull(message = "Drug dosage information is missing")
    private double medicineDosage;

    @JsonIgnore
    @ManyToMany(mappedBy = "medicines")
    private List<PrescriptionEntity> prescribed = new ArrayList<>();

    @Override
    public String toString() {
        return "MedicineEntity{" +
                "id=" + id +
                ", medicineName='" + medicineName + '\'' +
                ", medicineDesc='" + medicineDesc + '\'' +
                ", medicineDosage=" + medicineDosage +
                '}';
    }
}
