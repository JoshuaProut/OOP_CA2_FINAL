package ecm1410.joshuaprout.ca2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * An assistant available to perform a covid test within a 60 minute window.
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
        return "| " + shiftStart + " | " + status + " | " + assistant.getEmail() + " |";
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
