package com.mdonline.AppointmentBookingService.Appointment;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Appointments")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @Column(name = "patient_id")
    @NotNull(message = "Patient Id is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long patientId;

    @Column(name = "doctor_id")
    @NotNull(message = "Doctor Id is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long doctorId;

    @Column(name = "payment_amount")
    @DecimalMin(value = "1.00", message = "Payment amount cannot be less than 1.00")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private double paymentAmount;

    @Column(name = "start")
    @Future
    @NotNull(message = "Start Datetime cannot be null")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime start;

    @Column(name = "end")
    @Future
    @NotNull(message = "End Datetime cannot be null")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime end;

    @Override
    public String toString() {
        return "AppointmentEntity{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", paymentAmount=" + paymentAmount +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
