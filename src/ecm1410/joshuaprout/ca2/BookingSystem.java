package ecm1410.joshuaprout.ca2;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Manages matching rooms and assistants with bookings
 */
public class BookingSystem {

    private class Slot {
        private LocalDateTime dateTime;

        private int index;

        public Slot(LocalDateTime dateTime, int index) {
            this.dateTime = dateTime;
            this.index = index;
        }
    }

    private ArrayList<BookableRoom> bookableRooms;

    private ArrayList<AssistantOnShift> assistantsOnShift;

    private ArrayList<Booking> bookings;

    private ArrayList<Slot> slots;

    /**
     * Constructor
     */
    public BookingSystem() {
        bookableRooms = new ArrayList<BookableRoom>();
        assistantsOnShift = new ArrayList<AssistantOnShift>();
        bookings = new ArrayList<Booking>();
    }

    /**
     * Adds BookableRoom to array
     *
     * @param bookableRoom
     */
    public void addBookableRoom(BookableRoom bookableRoom) {
        this.bookableRooms.add(bookableRoom);
        //TODO check if bookable room already exists
    }

    /**
     * Adds AssistantOnShift to array
     *
     * @param assistantOnShift
     */
    public void addAssistantOnShift(AssistantOnShift assistantOnShift) {
        //TODO check that assistant not already assigned for same shift
        this.assistantsOnShift.add(assistantOnShift);

    }

    /*
    public String listSlots() {
        for (BookableRoom room : bookableRooms) {
            for (AssistantOnShift assistant : assistantsOnShift) {
                if (room.getSlotStart().equals(assistant.getShiftStart())) {
                }
            }
        }

    }

     */

    /**
     * Returns formatted string as lines of BookableRoom template strings
     *
     * @return formatted template string
     */
    public String listRooms() {
        String template = new String("\n");

        for (BookableRoom room : bookableRooms) {
            template = template + room.getTemplate() + "\n";
        }
        return template;
    }

    /**
     * Returns formatted string as lines of AssistantOnShift template strings
     *
     * @return formatted template string
     */
    public String listAssistants() {
        String template = new String("\n");

        for (AssistantOnShift assistantOnShift : assistantsOnShift) {
            template = template + assistantOnShift.getTemplate() + "\n";
        }

        return template;
    }

    public String listBookings() {
        String template = new String("\n");

        for (Booking booking : bookings) {
            template = template + booking.getTemplate() + "\n";
        }
        return template;
    }


}


