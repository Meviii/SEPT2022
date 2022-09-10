package com.mdonline.ChatService.Model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @CreatedDate
    @Column(name="creation_date", nullable = false)
    private Date creationDate;

    @Column(name="doctor_id", nullable = false)
    private long doctorId;

    @Column(name="patient_id", nullable = false)
    private long patientId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="chat_id", referencedColumnName = "id")
    private List<Message> messages;

    public Chat() {
    }

    public Chat(long doctorId, long patientId, List<Message> messages) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.messages = messages;
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

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", messages=" + messages +
                '}';
    }
}
