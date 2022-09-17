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
@Table(name = "Medicines")
public class MedicineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long id;

    @Column(name = "name")
    @NotBlank(message = "Drug name is missing")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String name;

    @Column(name = "description")
    @NotBlank(message = "Drug information is missing")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String description;

    @Column(name = "dosage")
    @NotNull(message = "Drug dosage information is missing")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private double dosage;

    @JsonIgnore
    @ManyToMany(mappedBy = "medicines")
    private List<PrescriptionEntity> prescribed = new ArrayList<>();

    public MedicineEntity(String name, String description, double dosage) {
        this.name = name;
        this.description = description;
        this.dosage = dosage;
    }

    public MedicineEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDosage() {
        return dosage;
    }

    public void setDosage(double dosage) {
        this.dosage = dosage;
    }

    @Override
    public String toString() {
        return "MedicineEntity{" +
                "id=" + id +
                ", medicineName='" + name + '\'' +
                ", medicineDesc='" + description + '\'' +
                ", medicineDosage=" + dosage +
                '}';
    }
}
