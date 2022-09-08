package com.mdonline.AccountService.Medicine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mdonline.AccountService.Prescription.Prescription;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Drug name is missing")
    private String medicineName;

    @Column(name = "description")
    @NotBlank(message = "Drug information is missing")
    private String medicineDesc;

    @Column(name = "dosage")
    @NotNull(message = "Drug dosage information is missing")
    private double medicineDosage;

    @JsonIgnore
    @ManyToMany(mappedBy = "medicines")
    private List<Prescription> prescribed = new ArrayList<>();

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
