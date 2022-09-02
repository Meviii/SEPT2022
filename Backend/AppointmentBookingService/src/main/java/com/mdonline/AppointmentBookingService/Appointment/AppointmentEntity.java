package com.mdonline.AppointmentBookingService.Appointment;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "Appointment")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private int id;

    @Column(name = "patient_id")
    @NotNull(message = "Patient Id is required")
    private int patientId;

    @Column(name = "doctor_id")
    @NotNull(message = "Doctor Id is required")
    private int doctorId;

    @Column(name = "appointment_payment_amount")
    @DecimalMin(value = "1.00", message = "Payment amount cannot be less than 1.00")
    private double paymentAmount;

    @Column(name = "appointment_date")
    @Future
    @NotNull(message = "Date cannot be null")
    private Date date;

    @Column(name = "appointment_time")
    @NotNull(message = "Time cannot be null")
    private Time time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
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
        return "AppointmentEntity{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", paymentAmount=" + paymentAmount +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
