package ecm1410.joshuaprout.ca2;

import java.util.ArrayList;

/**
 * Contains list of Assistants and Rooms that can be used for testing.
 */
public class University {

    private ArrayList<Assistant> assistants;

    private ArrayList<Room> rooms;

    /**
     * Constructor
     */
    public University() {
        assistants = new ArrayList<Assistant>();
        rooms = new ArrayList<Room>();
    }

    /**
     * Adds Assistant to assistants list
     *
     * @param assistant Assistant to be added
     */
    public void addAssistant(Assistant assistant) {
        assistants.add(assistant);
    }

    /**
     * Adds Room to University
     *
     * @param room Room to be added
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Gets assistants
     *
     * @return Arraylist of assistants
     */
    public ArrayList<Assistant> getAssistants() {
        return assistants;
    }

    /**
     * Gets rooms
     *
     * @return ArrayList of rooms
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
