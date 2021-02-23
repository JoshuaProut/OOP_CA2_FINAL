package ecm1410.joshuaprout.ca2;

public class Test {
    public static void main(String args[]) {

        //Creates room
        Room room = new Room("E123", 8);
        System.out.println(room.getTemplate());

        //Creates Assistant
        Assistant assistant = new Assistant("beans@uok.ac.uk", "Beans");
        System.out.println(assistant.getTemplate());

        //Creates University
        University uni = new University();

        //Adds room and assistant
        uni.addAssistant(assistant);
        uni.addRoom(room);

        //Creates BookingSystem
        BookingSystem bookingSystem = new BookingSystem();

    }
}
