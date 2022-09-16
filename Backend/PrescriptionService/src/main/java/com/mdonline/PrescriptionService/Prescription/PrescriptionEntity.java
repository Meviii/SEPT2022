package com.mdonline.PrescriptionService.Prescription;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mdonline.PrescriptionService.Medicine.MedicineEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Prescriptions")
public class PrescriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long id;

    @ManyToMany
    @JoinTable(name = "Medicine_Prescription",
            joinColumns = @JoinColumn(name = "prescription_id"),
            inverseJoinColumns = @JoinColumn(name = "medicine_id"))
    private List<MedicineEntity> medicines = new ArrayList<>();

    @Column(name = "duration")
    @NotNull(message = "Duration value is missing")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String duration;

    @Column(name = "description")
    @NotNull(message = "Prescription information is missing")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String description;

    @Column(name = "date")
    @NotNull(message = "Prescription date is missing")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name = "doctor_id")
    @NotNull(message = "Doctor id is missing")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long doctorId;

    @Column(name = "patient_id")
    @NotNull(message = "Patient id is missing")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long patientId;

    @Override
    public String toString() {
        return "PrescriptionEntity{" +
                "id=" + id +
                ", medicines=" + medicines +
                ", PrescriptionDuration=" + duration +
                ", PrescriptionDesc=" + description +
                ", PrescriptionDate=" + date +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                '}';
    }
}
