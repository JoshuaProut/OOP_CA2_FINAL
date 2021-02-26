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
     *
     * @return template string
     */
    public String getTemplate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "| " + shiftStart.format(formatter) + " | " + status + " | " + assistant.getEmail() + " |";
    }

    public String getStatus() {
        return status;
    }

    public void setBusy() {
        this.status = "BUSY";
    }

    public void setFree() {
        this.status = "FREE";
    }

    public String getEmail() {
        return assistant.getEmail();
    }

    public LocalDateTime getShiftStart() {
        return shiftStart;
    }
}
