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

    /**
     * Constructor.
     *
     * Room must be empty or available, assistant must be free, email must end in @uok.ac.uk
     *
     * @param room The bookable room for the test to be performed in
     * @param assistant The assistant on shift performing the test
     * @param email The email of the student being tested
     * @param timeStart The time the test session will start
     * @throws IllegalArgumentException
     */

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

    /**
     * Gets template, includes time start, status, assistant, room, and student email
     * @return template string
     */
    public String getTemplate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String template = new String("");
        template = "| " + timeStart.format(formatter) + " | " + status + " | " + assistant.getEmail() + " | " + room.getCode() + " | "
                + email;
        return template;
    }

    /**
     * Gets status, either SCHEDULED or COMPLETED
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the test as being COMPLETED
     */
    public void setComplete() {
        status = "COMPLETED";
    }

    /**
     * Returns the assistant performing the test
     * @return assistant
     */
    public AssistantOnShift getAssistant() {
        return assistant;
    }

    /**
     * Returns the room that the test will be performed in
     * @return
     */
    public BookableRoom getRoom() {
        return room;
    }
}
