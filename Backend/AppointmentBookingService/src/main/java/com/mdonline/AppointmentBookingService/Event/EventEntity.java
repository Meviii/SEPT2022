package com.mdonline.AppointmentBookingService.Event;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Table(name = "Events")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @Column(name = "date")
    @NotNull(message = "Event date cannot be null")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "type")
    @NotNull(message = "Event type cannot be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String type;

    @NotNull(message = "Event creator id cannot be null")
    @Column(name = "creator_id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long creatorId;

    @NotNull(message = "User id cannot be null")
    @Column(name = "doctor_id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long doctorId;
}
