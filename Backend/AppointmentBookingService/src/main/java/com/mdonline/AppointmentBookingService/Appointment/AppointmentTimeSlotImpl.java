package com.mdonline.AppointmentBookingService.Appointment;

import java.time.LocalDateTime;

public class AppointmentTimeSlotImpl implements AppointmentTimeSlot {
    LocalDateTime start;
    LocalDateTime end;

    public AppointmentTimeSlotImpl(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public LocalDateTime getStart() {
        return this.start;
    }

    @Override
    public LocalDateTime getEnd() {
        return this.end;
    }
}
