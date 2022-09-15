package com.mdonline.ChatService.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name="chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="creation_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    private Date creationDate;

    @Column(name="doctor_id")
    @NotNull
    private long doctorId;

    @Column(name="patient_id")
    @NotNull
    private long patientId;

    public Chat() {
        this.creationDate = new Date();
    }

    public Chat(long doctorId, long patientId) {
        this.creationDate = new Date();
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
        return "Chat{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                '}';
    }
}
