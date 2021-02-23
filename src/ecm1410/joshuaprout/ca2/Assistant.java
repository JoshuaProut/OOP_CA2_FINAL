package ecm1410.joshuaprout.ca2;

/**
 * A test assistant
 */
public class Assistant {

    private String email;

    private String name;

    /**
     * Constructor for Assistant class
     *
     * @param email Must end in @uok.ac.uk
     * @param name  Must not be empty
     */
    public Assistant(String email, String name) {

        if (email.endsWith("@uok.ac.uk") == false) {
            throw new IllegalArgumentException("Email must end with 'uok.ac.uk'");
        }

        this.email = email;
        this.name = name;
    }

    /**
     * Returns template for Assistant.
     * Contains name and email
     */
    public String getTemplate() {
        String template = "| " + name + " | " + email + " |";
        return template;
    }

    public String getEmail() {
        return email;
    }
}
