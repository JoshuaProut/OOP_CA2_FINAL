package ecm1410.joshuaprout.ca2;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        //Creates assistants on shift
        bookingSystem.addAssistantOnShift(new AssistantOnShift(assistant, "27/02/2021 07:00"));

        //Creates bookable rooms
        bookingSystem.addBookableRoom(new BookableRoom(room, "27/02/2021 07:00"));


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
                    addBooking(uni, bookingSystem);
                    break;
                case "9":
                    break;
                case "10":
                    concludeBooking(bookingSystem);
                    break;
                default:
                    System.out.println("Invalid option");

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
                System.out.println(index + " " + room.getTemplate());
                index++;
            }

            System.out.println("Please enter one of the following:\n");
            System.out.println("The sequential ID assigned to a room, a date (dd/mm/yyyy, and a time (HH:MM),");
            System.out.println("seperated by a white space.");
            System.out.println("0. Back to main menu.");
            System.out.println("-1. Quit application");

            choice = input.nextLine();

            if (!choice.equals("0") && !choice.equals("-1")) {

                //Splits string into index choice and time string
                String[] choices = choice.split(" ", 2);
                int i = Integer.parseInt(choices[0]);

                // If input is in available range of room indexes
                if (i > 10 && i <= index) {
                    Room chosenroom = rooms.get(i - 11);
                    // Adds new Bookable Room to system
                    try {
                        bookingSystem.addBookableRoom(new BookableRoom(chosenroom, choices[1]));
                        System.out.println("Bookable Room created successfully");
                    } catch (DateTimeParseException d) {
                        System.out.println(d.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Invalid room choice");
                }

            }
        }
    }

    /**
     * User chooses an assistant and a start time to create an assistant on shift
     *
     * @param uni           - the university that the assistant belongs to
     * @param bookingSystem - the booking system in use
     */
    private static void addAssistant(University uni, BookingSystem bookingSystem) {
        Scanner input = new Scanner(System.in);
        String choice = "2";
        while (!choice.equals("0")) {
            System.out.println("-------------------University of Knowledge - Covid Test-----------------------\n");
            System.out.println("Adding assistant on shift\n");

            // Lists available assistants from the university
            ArrayList<Assistant> assistants = uni.getAssistants();
            int index = 11;
            for (Assistant assistant : assistants) {
                System.out.println(index + " " + assistant.getTemplate());
            }

            System.out.println("Please enter one of the following:\n");
            System.out.println("The seqential ID of an assistant and date (dd/mm/yyyy), and a time (HH:MM), seperated by a whitespace.");
            System.out.println("0. Back to main menu");
            System.out.println("-1 Quit application");

            choice = input.nextLine();

            if (!choice.equals("0") && !choice.equals("-1")) {
                String[] choices = choice.split(" ", 2);
                int i = Integer.parseInt(choices[0]);

                if (i > 10 && i <= index) {
                    try {
                        // Creates assistant on shift using the chosen assistant and the time part of the input string

                        bookingSystem.addAssistantOnShift(new AssistantOnShift(assistants.get(i - 11), choices[1]));
                        System.out.println("Assistant created successfully");
                    } catch (DateTimeParseException d) {
                        System.out.println("Invalid date format");
                    }
                } else {
                    System.out.println("Invalid choice");
                }
            }
        }
    }

    /**
     * Creates a new booking
     * <p>
     * Presents user with an indexed list of available timeslots, passes chosen timeslot and student email to
     * booking system
     *
     * @param uni
     * @param bookingSystem
     */
    private static void addBooking(University uni, BookingSystem bookingSystem) {
        Scanner input = new Scanner(System.in);
        String choice = "2";

        while (!choice.equals("0")) {
            System.out.println("-------------------University of Knowledge - Covid Test-----------------------\n");
            System.out.println("Adding Booking\n");

            ArrayList<LocalDateTime> slotTimes = bookingSystem.getSlots();
            int index = 11;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            for (LocalDateTime slotTime : slotTimes) {
                System.out.println(index + " " + slotTime.format(formatter));
            }
            System.out.println("Please enter one of the following:\n");
            System.out.println("The sequential ID of the available time slot and the student email, separated by a whitespace.");
            System.out.println("0. Back to main menu");
            System.out.println("-1 Quit application");

            choice = input.nextLine();

            if (!choice.equals("0") && !choice.equals("-1")) {
                String[] choices = choice.split(" ", 2);
                int i = Integer.parseInt(choices[0]);

                if (i > 10 && i <= index) {
                    try {
                        // Gives booking system the date and time, for it to match an assistant and room to create the
                        // booking
                        bookingSystem.addBookingAtTime(slotTimes.get(i - 11), choices[1]);
                        System.out.println("Booking created successfully");
                    } catch (DateTimeParseException d) {
                        System.out.println("Invalid date format");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Invalid choice");
                }
            }

        }
    }

    private static void concludeBooking(BookingSystem bookingSystem) {
        Scanner input = new Scanner(System.in);

        System.out.println("University of Knowledge - COVID test\n");
        ArrayList<Booking> bookings = bookingSystem.getBookings();
        int i = 11;
        for (Booking booking : bookings) {
            if (booking.getStatus().equals("SCHEDULED")) {
                System.out.println(i + " | " + booking.getTemplate());
            }
        }
        System.out.println("\nPlease enter one of the following:\n");
        System.out.println("The sequential ID to select the booking to be completed");
        System.out.println("0. Back to main menu\n-1. Quit application");

        String choice = input.nextLine();

        if (!choice.equals("0") && !choice.equals("-1")){




    }
