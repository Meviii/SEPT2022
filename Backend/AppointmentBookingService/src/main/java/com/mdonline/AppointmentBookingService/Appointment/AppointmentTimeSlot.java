package com.mdonline.AppointmentBookingService.Appointment;

import java.time.LocalDateTime;

public interface AppointmentTimeSlot {
    LocalDateTime getStart();
    LocalDateTime getEnd();
}
