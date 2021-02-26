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

    public Booking(BookableRoom room, AssistantOnShift assistant, String email,
                   LocalDateTime timeStart) throws IllegalArgumentException {

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
        this.timeStart = timeStart;
        this.status = "SCHEDULED";
    }

    public String getTemplate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String template = new String("");
        template = "| " + timeStart.format(formatter) + " | " + status + " | " + assistant.getEmail() + " | " + room.getCode() + " | "
                + email;
        return template;
    }

    public String getStatus() {
        return status;
    }

    public void setComplete() {
        status = "COMPLETED";
    }

    public AssistantOnShift getAssistant() {
        return assistant;
    }

    public BookableRoom getRoom() {
        return room;
    }
}
