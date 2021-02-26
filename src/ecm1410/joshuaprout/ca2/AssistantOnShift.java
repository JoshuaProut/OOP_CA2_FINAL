package ecm1410.joshuaprout.ca2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * An assistant on a shift, lasting for 60 minutes starting from shiftStart.
 * During this time they can perform one test.
 */
public class AssistantOnShift {

    private Assistant assistant;

    private LocalDateTime shiftStart;

    private String status;

    /**
     * Constructor
     *
     * @param assistant
     * @param timeString
     */
    public AssistantOnShift(Assistant assistant, String timeString) throws DateTimeParseException {
        this.assistant = assistant;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.shiftStart = LocalDateTime.parse(timeString, formatter);
        setFree();
    }

    /**
     * Returns template string
     * @return template string
     */
    public String getTemplate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "| " + shiftStart.format(formatter) + " | " + status + " | " + assistant.getEmail() + " |";
    }

    /**
     * Gets status, whether the assistant is free or busy
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the assistant to BUSY, when they have been assigned a test to perform
     */
    public void setBusy() {
        this.status = "BUSY";
    }

    /**
     * Sets the assistant to FREE, when the test for the time slot has been cancelled
     */
    public void setFree() {
        this.status = "FREE";
    }

    /**
     * Gets assistant email
     * @return email string
     */
    public String getEmail() {
        return assistant.getEmail();
    }

    /**
     * Gets time of the start of the assistant shift
     *
     * @return LocalDateTime of shift start
     */
    public LocalDateTime getShiftStart() {
        return shiftStart;
    }
}
