package ecm1410.joshuaprout.ca2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * A room within a 60 minute timeslot that can be assigned for testing.
 */
public class BookableRoom {

    private Room room;

    private int occupancy;

    private String status;

    private LocalDateTime slotStart;

    /**
     * Constructor
     *
     * @param room - the room in the university that this BookableRoom is representing
     * @param timeString - string in format dd/MM/yyyy HH:mm
     */
    public BookableRoom(Room room, String timeString) throws DateTimeParseException {
        this.room = room;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.slotStart = LocalDateTime.parse(timeString, formatter);
        this.occupancy = 0;
        updateStatus();
    }

    /**
     * Gets template for the Bookable Room.
     */
    public String getTemplate() {
        String template = "| " + slotStart + " | " + status + " | " + room.getCode() + " | occupancy: "
                + " |";
        return template;
    }

    /**
     * Increments occupancy
     */
    public void incOccupancy() {
        this.occupancy++;
        this.updateStatus();
    }

    /**
     * Decrements occupancy
     */
    public void decOccupancy() {
        this.occupancy--;
        this.updateStatus();
    }

    /**
     * Updates the status of the room, whether it is EMPTY, AVAILABLE or FULL
     */
    private void updateStatus() {
        if (occupancy == 0) {
            status = "EMPTY";
        } else if (occupancy < room.getCapacity()) {
            status = "AVAILABLE";
        } else {
            status = "FULL";
        }
    }

    public String getCode() {
        return room.getCode();
    }

    public LocalDateTime getSlotStart() {
        return slotStart;
    }

    public String getStatus() {
        return status;
    }
}