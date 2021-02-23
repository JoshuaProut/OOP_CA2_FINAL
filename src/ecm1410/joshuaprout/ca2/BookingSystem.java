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
    }

    /**
     * Creates bookable room
     *
     * @param timeString in format roomcode dd/mm/yyyy hh:mm
     * @param uni
     * @throws IllegalArgumentException
     */
    public void addBookableRoomFromString(Room room, String timeString, University uni) throws IllegalArgumentException,
            java.time.format.DateTimeParseException {

        // Creates room and adds to BookableRooms list
        addBookableRoom(new BookableRoom(room, split[1]));
    }


    /**
     * Adds AssistantOnShift to array
     *
     * @param assistantOnShift
     */
    public void addAssistantOnShift(AssistantOnShift assistantOnShift) {
        this.assistantsOnShift.add(assistantOnShift);
    }

    /**
     * Creates and adds Assistant on shift
     *
     * @param string in format: AssistantEmail dd/mm/yyyy hh:mm
     * @param uni
     * @throws IllegalArgumentException
     * @throws java.time.format.DateTimeParseException
     * @throws ArrayIndexOutOfBoundsException
     */
    public void addAssistantOnShiftFromString(String string, University uni) throws IllegalArgumentException,
            java.time.format.DateTimeParseException, ArrayIndexOutOfBoundsException {
        // Splits strings
        String[] split = string.split(" ", 2);

        // Gets Assistant from email
        Assistant assistant = uni.getAssistantByEmail(split[0]);

        // Creates assistant and adds to Assistants on shift array
        addAssistantOnShift(new AssistantOnShift(assistant, split[1]));
    }

    public String listSlots() {
        for (BookableRoom room : bookableRooms) {
            for (AssistantOnShift assistant : assistantsOnShift) {
                if (room.getSlotStart().equals(assistant.getShiftStart()) {
                }
            }
        }
    }

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


