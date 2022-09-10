package com.mdonline.PrescriptionService.Medicine;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @Column(name = "id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long id;

    @Column(name = "name")
    @NotBlank(message = "Drug name is missing")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String medicineName;

    @Column(name = "description")
    @NotBlank(message = "Drug information is missing")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String medicineDesc;

    @Column(name = "dosage")
    @NotNull(message = "Drug dosage information is missing")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
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
