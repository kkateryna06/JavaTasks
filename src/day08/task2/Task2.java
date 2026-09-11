package day08.task2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;



public class Task2 {
    public static class Meeting {
    private final String title;
    private final LocalDateTime startDateTime;
    private final LocalDateTime endDateTime;

    public Meeting(
            String title,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime
    ) {
        if (title == null || title.isBlank())
            throw new IllegalArgumentException("Title can't be null or blank");
        if (startDateTime == null || endDateTime == null)
            throw new IllegalArgumentException("Date can't be null");
        if (!endDateTime.isAfter(startDateTime))
            throw new IllegalArgumentException("End date must be after start date");
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public long calculateDurationInMinutes() {
        Duration duration = Duration.between(startDateTime, endDateTime);

        return duration.toMinutes();
    }
    public Meeting postpone(long minutes) {
        if (minutes < 1)
            throw new IllegalArgumentException("Minutes must be greater than 0");

        return new Meeting(title,
                startDateTime.plusMinutes(minutes),
                endDateTime.plusMinutes(minutes)
        );
    }

}

    public static void main(String[] args) {
        Meeting meeting = new Meeting("Java Interview",
                LocalDateTime.of(2026, 9, 10, 10, 0, 0),
                LocalDateTime.of(2026, 9, 10, 11, 30, 0)
        );

        System.out.println(meeting.calculateDurationInMinutes());

        Meeting rescheduledMeeting = meeting.postpone(45);
        System.out.println(rescheduledMeeting.calculateDurationInMinutes());

        System.out.println(meeting.getStartDateTime() + "-" + meeting.getEndDateTime());
        System.out.println(rescheduledMeeting.getStartDateTime() + "-" + rescheduledMeeting.getEndDateTime());

        try {
            new Meeting("English class",
                    LocalDateTime.of(2026, 9, 11, 0, 0, 0),
                    LocalDateTime.of(2026, 9, 11, 0, 0, 0)
            );
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new Meeting("English class",
                    LocalDateTime.of(2026, 9, 11, 5, 0, 0),
                    LocalDateTime.of(2026, 9, 11, 0, 0, 0)
            );
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            meeting.postpone(-10);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }try {
            meeting.postpone(0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
