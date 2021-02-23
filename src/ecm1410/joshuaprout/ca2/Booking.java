package ecm1410.joshuaprout.ca2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * An individual booking for a test, combining an assistant on shift and a bookable room.
 */
public class Booking {
    private BookableRoom room;

    private AssistantOnShift assistant;

    private String status;

    private int id;

    private String email;

    private LocalDateTime timeStart;

    public Booking(BookableRoom room, AssistantOnShift assistant, int id, String email,
                   String timeStart) {

        // Validates room has space
        if (room.getStatus() == "FULL") {
            throw new IllegalArgumentException("Room is full");
        }
        // Adds 1 to room capacity
        room.incOccupancy();
        this.room = room;


        // Validates assistant is available
        if (assistant.getStatus() == "BUSY") {
            throw new IllegalArgumentException("Assistant is busy");
        }
        // Changes assistant to busy
        assistant.setBusy();
        this.assistant = assistant;

        this.id = id;

        // Validates email format
        if (!email.endsWith("@uok.ac.uk")) {
            throw new IllegalArgumentException("Email must end with 'uok.ac.uk'");
        }
        this.email = email;

        // Converts date time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        this.timeStart = LocalDateTime.parse(timeStart, formatter);
    }

    public String getTemplate() {
        String template = new String("");
        template = "| " + timeStart + " | " + status + " | " + assistant.getEmail() + " | " + room.getCode() + " | "
                + email;
        return template;
    }
}