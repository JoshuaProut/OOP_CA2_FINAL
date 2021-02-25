package ecm1410.joshuaprout.ca2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Manages matching rooms and assistants with bookings
 */
public class BookingSystem {

    private ArrayList<BookableRoom> bookableRooms;

    private ArrayList<AssistantOnShift> assistantsOnShift;

    private ArrayList<Booking> bookings;

    private int testID;

    /**
     * Constructor
     */
    public BookingSystem() {
        bookableRooms = new ArrayList<BookableRoom>();
        assistantsOnShift = new ArrayList<AssistantOnShift>();
        bookings = new ArrayList<Booking>();
        testID = 0;
    }

    /**
     * Adds BookableRoom to array
     *
     * @param bookableRoom
     * @throws IllegalArgumentException
     */
    public void addBookableRoom(BookableRoom bookableRoom) throws IllegalArgumentException{
        // Checks that bookable room for this room and time have not been created
        for (BookableRoom room: bookableRooms) {
            if(room.getCode() == bookableRoom.getCode() && room.getSlotStart() == bookableRoom.getSlotStart()) {
                throw new IllegalArgumentException("Bookable room already exists");
            }
        }
        this.bookableRooms.add(bookableRoom);
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

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    /**
     * Takes a datetime, and matches a bookable room and assistant at that time
     *
     * @param startTime
     */
    public void addBookingAtTime(LocalDateTime startTime, String email) throws IllegalArgumentException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


        // Searches through all bookable rooms and assistants on shift, until it finds a valid booking opportunity
        boolean found = false;
        for (AssistantOnShift assistant : assistantsOnShift) {
            for (BookableRoom room : bookableRooms) {
                /* For a valid booking opportunity, all three of the assistant time, room time and chosen booking time
                 must match. The assistant must have status FREE and the room can not be full
                 */
                if (assistant.getShiftStart().equals(room.getSlotStart()) && assistant.getShiftStart().equals(startTime)
                        && assistant.getStatus().equals("FREE") && !room.getStatus().equals("FULL")) {
                    // Adds new booking to the system
                    addBooking(new Booking(room, assistant, email, assistant.getShiftStart()));

                    //Sets Assistant to busy and increments room occupancy
                    assistant.setBusy();
                    room.incOccupancy();

                    found = true;
                }
            }
        }
        if (found == false) {
            throw new IllegalArgumentException("Booking could not be created");
        }
    }

    public ArrayList<AssistantOnShift> getAssistantsOnShift() {
        return assistantsOnShift;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public ArrayList<BookableRoom> getBookableRooms() {
        return bookableRooms;
    }

    public ArrayList<LocalDateTime> getSlots() {
        ArrayList<LocalDateTime> availableTimes = new ArrayList<>();

        // Iterates through the room
        for (BookableRoom room : bookableRooms) {
            for (AssistantOnShift assistant : assistantsOnShift) {
                if (room.getSlotStart().equals(assistant.getShiftStart()) && !availableTimes.contains(assistant.getShiftStart())) {
                    availableTimes.add(assistant.getShiftStart());
                }
            }
        }
        return availableTimes;
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

    public void removeAssistantOnShift(AssistantOnShift assistantOnShift) {
        if (assistantOnShift.getStatus().equals("FREE")) {
            assistantsOnShift.remove(assistantOnShift);
        }
    }

    public void removeBooking(Booking booking) throws IllegalArgumentException {
        // Checks booking is scheduled, if complete it cannot be deleted
        if (booking.getStatus().equals("SCHEDULED")) {
            bookings.remove(booking);
        } else {
            throw new IllegalArgumentException("Booking is completed, cannot be removed");
        }
    }

    public void removeRoom(BookableRoom bookableRoom) {
        if (bookableRoom.getStatus().equals("EMPTY")) {
            bookableRooms.remove(bookableRoom);
        }
    }


}


