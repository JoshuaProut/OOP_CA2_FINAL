package ecm1410.joshuaprout.ca2;

/**
 * A test assistant belonging to the university
 */
public class Assistant {

    private final String email;

    private final String name;

    /**
     * Constructor for Assistant class
     *
     * @param email Must end in @uok.ac.uk
     * @param name  Must not be empty
     * @throws IllegalArgumentException If email does not fit @uok.ac.uk
     */
    public Assistant(String email, String name) throws IllegalArgumentException {

        if (!email.endsWith("@uok.ac.uk")) {
            throw new IllegalArgumentException("Email must end with 'uok.ac.uk'");
        }

        this.email = email;
        this.name = name;
    }

    /**
     * Returns template for Assistant.
     *
     * Contains name and email
     * @return Template string
     */
    public String getTemplate() {
        return "| " + name + " | " + email + " |";
    }

    /**
     * Gets email
     * @return Email string
     */
    public String getEmail() {
        return email;
    }
}
