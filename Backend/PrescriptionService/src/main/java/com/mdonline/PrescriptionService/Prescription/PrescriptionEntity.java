package com.mdonline.PrescriptionService.Prescription;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mdonline.PrescriptionService.Medicine.MedicineEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


/**
 * This class holds the data of the Prescription object.
 */
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

    public PrescriptionEntity() {
    }

    public PrescriptionEntity(List<MedicineEntity> medicines, String duration, String description, Date date, long doctorId, long patientId) {
        this.medicines = medicines;
        this.duration = duration;
        this.description = description;
        this.date = date;
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<MedicineEntity> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<MedicineEntity> medicines) {
        this.medicines = medicines;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

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
