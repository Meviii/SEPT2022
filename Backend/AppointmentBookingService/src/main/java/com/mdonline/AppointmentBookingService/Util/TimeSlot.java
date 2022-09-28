package com.mdonline.AppointmentBookingService.Util;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class holds the data of the TimeSlot object.
 */

public class TimeSlot {
    List<LocalDateTime> timeSlots;

    static int startTime = 7;
    static int endTime = 24;

    /**
     * The constructor constructs Day's time slots,
     * Each Appointment timeslot is 15 minutes,
     * Day's start time is set to 7am,
     * Day's end time is set to 12pm
     */
    public TimeSlot(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH) + 1;
        int DAY = calendar.get(Calendar.DAY_OF_MONTH);

        for(int i = startTime; i < endTime; i++){
            List<LocalDateTime> timeSlotInAnHour = List.of(
                LocalDateTime.of(YEAR, MONTH, DAY, i, 00),
                LocalDateTime.of(YEAR, MONTH, DAY, i, 15),
                LocalDateTime.of(YEAR, MONTH, DAY, i, 30),
                LocalDateTime.of(YEAR, MONTH, DAY, i, 45));

            if(timeSlots == null){
                timeSlots = timeSlotInAnHour;
            } else {
                timeSlots = Stream.concat(timeSlots.stream(), timeSlotInAnHour.stream()).collect(Collectors.toList());
            }
        }
    }

    public List<LocalDateTime> getTimeSlots() { return timeSlots; }
}
