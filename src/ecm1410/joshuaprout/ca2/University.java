package ecm1410.joshuaprout.ca2;

import java.util.ArrayList;

/**
 * Contains list of Assistants and Rooms that can be used for testing.
 */
public class University {

    private ArrayList<Assistant> assistants;

    private ArrayList<Room> rooms;

    /**
     * Constructor for university
     */
    public University() {
        assistants = new ArrayList<Assistant>();
        rooms = new ArrayList<Room>();
    }

    /**
     * Adds Assistant to University
     *
     * @param assistant
     */
    public void addAssistant(Assistant assistant) {
        assistants.add(assistant);
    }

    /**
     * Adds Room to University
     *
     * @param room
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Returns a template string for all rooms
     *
     * @return template string for all rooms
     */
    public String listRooms() {
        String template = new String("\n");
        for (Room room : rooms) {
            template += room.getTemplate() + "\n";
        }

        return template;
    }

    /**
     * Returns template string for all assistants
     *
     * @return template string for all assistants
     */
    public String listAssistants() {
        String template = new String("\n");
        for (Assistant assistant : assistants) {
            template += assistant.getTemplate();
        }

        return template;
    }

    public ArrayList<Assistant> getAssistants() {
        return assistants;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * Returns Room for a given code
     *
     * @param code - code for the room
     * @return Room
     * @throws IllegalArgumentException
     */
    public Room getRoomByCode(String code) throws IllegalArgumentException {
        for (Room room: rooms) {
            if (room.getCode().equals(code)) {
                return room;
            }
        }
        throw new IllegalArgumentException("Unknown code");
    }

    public Assistant getAssistantByEmail(String email) throws IllegalArgumentException {
        for (Assistant assistant : assistants) {
            if (assistant.getEmail().equals(email)) {
                return assistant;
            }
        }
        throw new IllegalArgumentException("Unkown email");
    }
}
