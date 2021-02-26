package ecm1410.joshuaprout.ca2;

/**
 * A room in the university
 */
public class Room {

    private String code;

    private int capacity;

    /**
     * Constructor for room
     *
     * @param code     Must be unique
     * @param capacity Must be more than 0
     * @throws IllegalArgumentException If capacity is less than 0
     */
    public Room(String code, int capacity) throws IllegalArgumentException {

        // TODO check code is unique

        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }

        this.code = code;
        this.capacity = capacity;
    }

    /**
     * Returns formatted template string
     *
     * @return template string, containing code and capacity
     */
    public String getTemplate() {
        return "| " + code + " | " + capacity + " |";
    }

    /**
     * Returns room code
     *
     * @return room code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets capacity of the room, how many assistants can work in one room
     *
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }
}