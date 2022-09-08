package com.mdonline.AccountService.Prescription;

import com.mdonline.AccountService.Medicine.Medicine;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToMany
    @JoinTable(name = "Prescription_medicine",
            joinColumns = @JoinColumn(name = "prescription_id"),
            inverseJoinColumns = @JoinColumn(name = "medicine_id"))
    private List<Medicine> medicines = new ArrayList<>();

    @Column(name = "duration")
    @NotNull(message = "Duration value is missing")
    private String prescriptionDuration;

    @Column(name = "description")
    @NotNull(message = "Prescription information is missing")
    private String prescriptionDesc;

    @Column(name = "date")
    @NotNull(message = "Prescription date is missing")
    private Date prescriptionDate;

    @Column(name = "doctor_id")
    @NotNull(message = "Doctor id is missing")
    private int doctorId;

    @Column(name = "patient_id")
    @NotNull(message = "Patient id is missing")
    private int patientId;

    @Override
    public String toString() {
        return "PrescriptionEntity{" +
                "id=" + id +
                ", medicines=" + medicines +
                ", PrescriptionDuration=" + prescriptionDuration +
                ", PrescriptionDesc=" + prescriptionDesc +
                ", PrescriptionDate=" + prescriptionDate +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                '}';
    }
}
