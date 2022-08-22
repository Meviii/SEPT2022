package com.project.mdonline.Appointment;

import com.project.mdonline.Doctor.Doctor;
import com.project.mdonline.Patient.Patient;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patientId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctorId;

    @Column(name = "appointment_payment_amount")
    private double paymentAmount;

    @Column(name = "appointment_date")
    private java.sql.Date date;

    @Column(name = "appointment_time")
    private java.sql.Time time;

    public AppointmentEntity() {
    }

    public AppointmentEntity(Patient patientId, Doctor doctorId, double paymentAmount, Date date, Time time) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.paymentAmount = paymentAmount;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", paymentAmount=" + paymentAmount +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
