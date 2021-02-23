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
     * @throws IllegalArgumentException
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
     * @return template string, containing code and capacity
     */
    public String getTemplate() {
        String template = "| " + code + " | " + capacity + " |";
        return template;
    }

    public String getCode() {
        return code;
    }

    public int getCapacity() {
        return capacity;
    }
}