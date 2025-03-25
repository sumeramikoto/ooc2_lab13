/*
 * This class is intended to be the main class for this Project. All necessary methods are getting calls from this class.
 *
 *
 */

import java.awt.*;
import java.util.Scanner;

public class Main {
    static String[][] adminUserNameAndPassword = new String[10][2];

    public static void main(String[] args) {
        int countNumOfUsers = 1;
        RolesAndPermissions r1 = new RolesAndPermissions();
        FlightRepository f1 = new FlightRepository();
        FlightReservation bookingAndReserving = new FlightReservation();
        CustomerRepository c1 = new CustomerRepository();
        f1.flightScheduler();
        Scanner read = new Scanner(System.in);

       
        System.out.println(
                "\n\t\t\t\t\t+++++++++++++ Welcome to BAV AirLines +++++++++++++\n\nTo Further Proceed, Please enter a value.");
        System.out.println(
                "\n***** Default Username && Password is root-root ***** Using Default Credentials will restrict you to just view the list of Passengers....\n");
        MenuDisplays.displayMainMenu();
        int desiredOption = read.nextInt();
        while (desiredOption < 0 || desiredOption > 8) {
            System.out.print("ERROR!! Please enter value between 0 - 4. Enter the value again :\t");
            desiredOption = read.nextInt();
        }

        do {
            Scanner read1 = new Scanner(System.in);

            if (desiredOption == 1) {

                /* Default username and password.... */
                adminUserNameAndPassword[0][0] = "root";
                adminUserNameAndPassword[0][1] = "root";
                
                System.out.print("\nEnter the UserName to login to the Management System :     ");
                String username = read1.nextLine();
                System.out.print("Enter the Password to login to the Management System :    ");
                String password = read1.nextLine();
                System.out.println();

                /* Checking the RolesAndPermissions...... */
                if (r1.isPrivilegedUserOrNot(username, password) == -1) {
                    System.out.printf(
                            "\n%20sERROR!!! Unable to login Cannot find user with the entered credentials.... Try Creating New Credentials or get yourself register by pressing 4....\n",
                            "");
                } else if (r1.isPrivilegedUserOrNot(username, password) == 0) {
                    System.out.println(
                            "You've standard/default privileges to access the data... You can just view customers data..."
                                    + "Can't perform any actions on them....");
                    c1.displayCustomersData();
                } else {
                    System.out.printf(
                            "%-20sLogged in Successfully as \"%s\"..... For further Proceedings, enter a value from below....",
                            "", username);

                    /*
                     * Going to Display the CRUD operations to be performed by the privileged
                     * user.....Which includes Creating, Updating
                     * Reading(Searching) and deleting a customer....
                     */
                    do {
                        MenuDisplays.display2ndLayerMenu(username);
                        System.out.print("Enter the desired Choice :   ");
                        desiredOption = read.nextInt();
                        /* If 1 is entered by the privileged user, then add a new customer...... */
                        if (desiredOption == 1) {
                           
                            c1.addNewCustomer();
                        } else if (desiredOption == 2) {
                            /*
                             * If 2 is entered by the privileged user, then call the search method of the
                             * Customer class
                             */
                            
                            c1.displayCustomersData();
                            System.out.print("Enter the CustomerID to Search :\t");
                            String customerID = read1.nextLine();
                            System.out.println();
                            c1.searchUser(customerID);
                        } else if (desiredOption == 3) {
                            /*
                             * If 3 is entered by the user, then call the update method of the Customer
                             * Class with required
                             * arguments.....
                             */
                            
                            c1.displayCustomersData();
                            System.out.print("Enter the CustomerID to Update its Data :\t");
                            String customerID = read1.nextLine();
                            if (!CustomerRepository.customerCollection.isEmpty()) {
                                c1.editUserInfo(customerID);
                            } else {
                                System.out.printf("%-50sNo Customer with the ID %s Found...!!!\n", " ", customerID);
                            }

                        } else if (desiredOption == 4) {
                            /*
                             * If 4 is entered, then ask the user to enter the customer id, and then delete
                             * that customer....
                             */
                            c1.displayCustomersData();
                            System.out.print("Enter the CustomerID to Delete its Data :\t");
                            String customerID = read1.nextLine();
                            if (!CustomerRepository.customerCollection.isEmpty()) {
                                c1.deleteUser(customerID);
                            } else {
                                System.out.printf("%-50sNo Customer with the ID %s Found...!!!\n", " ", customerID);
                            }
                        } else if (desiredOption == 5) {
                            /* Call the Display Method of Customer Class.... */
                            c1.displayCustomersData();
                        } else if (desiredOption == 6) {
                            c1.displayCustomersData();
                            System.out.print(
                                    "\n\nEnter the ID of the user to display all flights registered by that user...");
                            String id = read1.nextLine();
                            bookingAndReserving.displayFlightsRegisteredByOneUser(id);
                        } else if (desiredOption == 7) {
                            System.out.print(
                                    "Do you want to display Passengers of all flights or a specific flight.... 'Y/y' for displaying all flights and 'N/n' to look for a"
                                            +
                                            " specific flight.... ");
                            char choice = read1.nextLine().charAt(0);
                            if ('y' == choice || 'Y' == choice) {
                                bookingAndReserving.displayRegisteredUsersForAllFlight();
                            } else if ('n' == choice || 'N' == choice) {
                                f1.displayFlightSchedule();
                                System.out.print(
                                        "Enter the Flight Number to display the list of passengers registered in that flight... ");
                                String flightNum = read1.nextLine();
                                bookingAndReserving.displayRegisteredUsersForASpecificFlight(flightNum);
                            } else {
                                System.out.println("Invalid Choice...No Response...!");
                            }
                        } else if (desiredOption == 8) {
                            f1.displayFlightSchedule();
                            System.out.print("Enter the Flight Number to delete the flight : ");
                            String flightNum = read1.nextLine();
                            f1.deleteFlight(flightNum);

                        } else if (desiredOption == 0) {
                            ;
                            System.out.println("Thanks for Using BAV Airlines Ticketing System...!!!");

                        } else {
                            System.out.println(
                                    "Invalid Choice...Looks like you're Robot...Entering values randomly...You've Have to login again...");

                            desiredOption = 0;
                        }

                    } while (desiredOption != 0);

                }
            } else if (desiredOption == 2) {
                /*
                 * If desiredOption is 2, then call the registration method to register a
                 * user......
                 */
                System.out.print("\nEnter the UserName to Register :    ");
                String username = read1.nextLine();
                System.out.print("Enter the Password to Register :     ");
                String password = read1.nextLine();
                while (r1.isPrivilegedUserOrNot(username, password) != -1) {
                    System.out.print("ERROR!!! Admin with same UserName already exist. Enter new UserName:   ");
                    username = read1.nextLine();
                    System.out.print("Enter the Password Again:   ");
                    password = read1.nextLine();
                }

                /* Setting the credentials entered by the user..... */
                adminUserNameAndPassword[countNumOfUsers][0] = username;
                adminUserNameAndPassword[countNumOfUsers][1] = password;

                /* Incrementing the numOfUsers */
                countNumOfUsers++;
            } else if (desiredOption == 3) {
                System.out.print("\n\nEnter the Email to Login : \t");
                String userName = read1.nextLine();
                System.out.print("Enter the Password : \t");
                String password = read1.nextLine();
                String[] result = r1.isPassengerRegistered(userName, password).split("-");

                if (Integer.parseInt(result[0]) == 1) {
                    int desiredChoice;
                    System.out.printf(
                            "\n\n%-20sLogged in Successfully as \"%s\"..... For further Proceedings, enter a value from below....",
                            "", userName);
                    do {
                        MenuDisplays.display3rdLayerMenu(userName);
                        System.out.print("Enter the desired Choice :   ");
                        desiredChoice = read.nextInt();
                        if (desiredChoice == 1) {
                            f1.displayFlightSchedule();
                            System.out.print("\nEnter the desired flight number to book :\t ");
                            String flightToBeBooked = read1.nextLine();
                            System.out.print("Enter the Number of tickets for " + flightToBeBooked + " flight :   ");
                            int numOfTickets = read.nextInt();
                            while (numOfTickets > 10) {
                                System.out.print(
                                        "ERROR!! You can't book more than 10 tickets at a time for single flight....Enter number of tickets again : ");
                                numOfTickets = read.nextInt();
                            }
                            bookingAndReserving.bookFlight(flightToBeBooked, numOfTickets, result[1]);
                        } else if (desiredChoice == 2) {
                            c1.editUserInfo(result[1]);
                        } else if (desiredChoice == 3) {
                            System.out.print(
                                    "Are you sure to delete your account...It's an irreversible action...Enter Y/y to confirm...");
                            char confirmationChar = read1.nextLine().charAt(0);
                            if (confirmationChar == 'Y' || confirmationChar == 'y') {
                                c1.deleteUser(result[1]);
                                System.out.printf("User %s's account deleted Successfully...!!!", userName);
                                desiredChoice = 0;
                            } else {
                                System.out.println("Action has been cancelled...");
                            }
                        } else if (desiredChoice == 4) {
                            f1.displayFlightSchedule();
                            MenuDisplays.displayMeasurementInstructions();
                        } else if (desiredChoice == 5) {
                            bookingAndReserving.cancelFlight(result[1]);
                        } else if (desiredChoice == 6) {
                            bookingAndReserving.displayFlightsRegisteredByOneUser(result[1]);
                        } else {
                            if (desiredChoice != 0) {
                                System.out.println(
                                        "Invalid Choice...Looks like you're Robot...Entering values randomly...You've Have to login again...");
                            }
                            desiredChoice = 0;
                        }
                    } while (desiredChoice != 0);

                } else {
                    System.out.printf(
                            "\n%20sERROR!!! Unable to login Cannot find user with the entered credentials.... Try Creating New Credentials or get yourself register by pressing 4....\n",
                            "");
                }
            } else if (desiredOption == 4) {
                c1.addNewCustomer();
            } else if (desiredOption == 5) {
                manualInstructions();
            }

            MenuDisplays.displayMainMenu();
            desiredOption = read1.nextInt();
            while (desiredOption < 0 || desiredOption > 5) {
                System.out.print("ERROR!! Please enter value between 0 - 5. Enter the value again :\t");
                desiredOption = read1.nextInt();
            }
        } while (desiredOption != 0);

    }



    static void manualInstructions() {
        Scanner read = new Scanner(System.in);
        System.out.printf("%n%n%50s %s Welcome to BAV Airlines User Manual %s", "", "+++++++++++++++++",
                "+++++++++++++++++");
        System.out.println("\n\n\t\t(a) Press 1 to display Admin Manual.");
        System.out.println("\t\t(b) Press 2 to display User Manual.");
        System.out.print("\nEnter the desired option :    ");
        int choice = read.nextInt();
        while (choice < 1 || choice > 2) {
            System.out.print("ERROR!!! Invalid entry...Please enter a value either 1 or 2....Enter again....");
            choice = read.nextInt();
        }
        if (choice == 1) {
            MenuDisplays.displayAdminManual();
        } else {
            MenuDisplays.displayUserManual();
        }
    }


}