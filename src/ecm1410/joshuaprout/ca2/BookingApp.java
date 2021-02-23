package ecm1410.joshuaprout.ca2;

import java.awt.print.Book;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingApp {

    /**
     * Main Menu function, will run until -1 is presssed
     *
     * @param args
     */
    public static void main(String[] args) {

        BookingApp app = new BookingApp();

        //Creates room
        Room room = new Room("E123", 8);

        //Creates Assistant
        Assistant assistant = new Assistant("beans@uok.ac.uk", "Beans");

        //Creates University
        University uni = new University();

        //Adds room and assistant
        uni.addAssistant(assistant);
        uni.addRoom(room);

        //Creates BookingSystem
        BookingSystem bookingSystem = new BookingSystem();


        Scanner input = new Scanner(System.in);
        String choice = "0";

        while (choice != "-1") {
            System.out.println("-------------------University of Knowledge - Covid Test-----------------------");
            System.out.println("");
            System.out.println("Manage Bookings");
            System.out.println("");
            System.out.println("Please, enter the number to select your option");
            System.out.println("");
            System.out.println("To manage Bookable Rooms:");
            System.out.println("    1. List");
            System.out.println("    2. Add");
            System.out.println("    3. Remove");
            System.out.println("To manage Assistants on Shift");
            System.out.println("    4. List");
            System.out.println("    5. Add");
            System.out.println("    6. Remove");
            System.out.println("To manage Bookings:");
            System.out.println("    7. List");
            System.out.println("    8. Add");
            System.out.println("    9. Remove");
            System.out.println("    10. Conclude");

            choice = input.nextLine();

            switch (choice) {
                case "0":
                    break;
                case "1":
                    System.out.println(bookingSystem.listRooms());
                    break;
                case "2":
                    addRoom(uni, bookingSystem);
                    break;
                case "3":
                    break;
                case "4":
                    System.out.println(bookingSystem.listAssistants());
                    break;
                case "5":
                    addAssistant(uni, bookingSystem);
                    break;
                case "6":
                    break;
                case "7":
                    System.out.println(bookingSystem.listBookings());
                    break;
                case "8":
                    break;
                case "9":
                    break;
                case "10":
                    break;
            }
        }
    }

    /**
     * Adds a bookable room to the Booking System, from the available rooms in university
     *
     * @param uni
     * @param bookingSystem
     */
    private static void addRoom(University uni, BookingSystem bookingSystem) {
        Scanner input = new Scanner(System.in);
        String choice = "2";
        while (!choice.equals("0")) {
            System.out.println("-------------------University of Knowledge - Covid Test-----------------------\n");
            System.out.println("Adding Bookable Room\n");

            // Prints available rooms, with a sequential id
            ArrayList<Room> rooms = uni.getRooms();
            int index = 11;
            for (Room room : rooms) {
                System.out.println(index + ". " + room.getTemplate());
                index++;
            }

            System.out.println("Please enter one of the following:\n");
            System.out.println("The sequential ID assigned to a room, a date (dd/mm/yyyy, and a time (HH:MM),");
            System.out.println("seperated by a white space.");
            System.out.println("0. Back to main menu.");
            System.out.println("-1. Quit application");

            choice = input.nextLine();

            //Splits string into index choice and time string
            String[] choices = choice.split(" ",2);
            int i = Integer.parseInt(choices[0]);

            // Gets the chosen room from the rooms list for the inputted user index
            for (Room room : rooms) {
                // Checks input is in range
                if (i < 10 && i <= index) {
                    Room chosenroom = rooms.get(i - 11);
                    try {
                        bookingSystem.addBookableRoom(new BookableRoom(chosenroom, choices[1]);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid room code");
                    } catch (java.time.format.DateTimeParseException d) {
                        System.out.println("Invalid date format");
                    }
                }
            }

            private static void addAssistant (University uni, BookingSystem bookingSystem){
                Scanner input = new Scanner(System.in);
                String choice = "2";
                while (!choice.equals("0")) {
                    System.out.println("-------------------University of Knowledge - Covid Test-----------------------\n");
                    System.out.println("Adding assistant on shift\n");
                    System.out.println(uni.listAssistants());
                    System.out.println("Please enter one of the following:\n");
                    System.out.println("The seqential ID of an assistant and date (dd/mm/yyyy), and a time (HH:MM), seperated by a whitespace.");
                    System.out.println("0. Back to main menu");
                    System.out.println("-1 Quit application");

                    choice = input.nextLine();
                    try {
                        bookingSystem.addAssistantOnShiftFromString(choice, uni);
                        System.out.println("Assistant created successfully");
                    } catch (IllegalArgumentException | DateTimeParseException e) {
                        System.out.println(e.getMessage());
                    } catch (ArrayIndexOutOfBoundsException g) {
                        System.out.println("Invalid format of input");
                    }
                }
            }

            private static void addBooking (University uni, BookingSystem bookingSystem){
                Scanner input = new Scanner(System.in);
                String choice = "2";

                while (!choice.equals("0")) {
                    System.out.println("-------------------University of Knowledge - Covid Test-----------------------\n");
                    System.out.println("Adding Booking\n");
                    System.out.println(bookingSystem.listSlots());
                    System.out.println("Please enter one of the following:\n");
                    System.out.println("The seqential ID of an assistant and date (dd/mm/yyyy), and a time (HH:MM), seperated by a whitespace.");
                    System.out.println("0. Back to main menu");
                    System.out.println("-1 Quit application");
                }
