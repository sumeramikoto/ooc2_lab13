public class MenuDisplays {
    static void displayMainMenu() {
        System.out.println("\n\n\t\t(a) Press 0 to Exit.");
        System.out.println("\t\t(b) Press 1 to Login as admin.");
        System.out.println("\t\t(c) Press 2 to Register as admin.");
        System.out.println("\t\t(d) Press 3 to Login as Passenger.");
        System.out.println("\t\t(e) Press 4 to Register as Passenger.");
        System.out.println("\t\t(f) Press 5 to Display the User Manual.");
        System.out.print("\t\tEnter the desired option:    ");
    }

    static void displayMeasurementInstructions(){
        String symbols = "+---------------------------+";
        System.out.printf("\n\n %100s\n %100s", symbols, "| SOME IMPORTANT GUIDELINES |");
        System.out.printf("\n %100s\n", symbols);
        System.out.println("\n\t\t1. Distance between the destinations are based upon the Airports Coordinates(Latitudes && Longitudes) based in those cities\n");
        System.out.println("\t\t2. Actual Distance of the flight may vary from this approximation as Airlines may define their on Travel Policy that may restrict the planes to fly through specific regions...\n");
        System.out.println("\t\t3. Flight Time depends upon several factors such as Ground Speed(GS), AirCraft Design, Flight Altitude and Weather. Ground Speed for these calculations is 450 Knots...\n");
        System.out.println("\t\t4. Expect reaching your destination early or late from the Arrival Time. So, please keep a margin of ±1 hour...\n");
        System.out.println("\t\t5. The departure time is the moment that your plane pushes back from the gate, not the time it takes off. The arrival time is the moment that your plane pulls into the gate, not the time\n\t\t   it touches down on the runway...\n");
    }

    static void displayAdminManual() {
        System.out.println(
                "\n\n(1) Admin have the access to all users data...Admin can delete, update, add and can perform search for any customer...\n");
        System.out.println(
                "(2) In order to access the admin module, you've to get yourself register by pressing 2, when the main menu gets displayed...\n");
        System.out.println(
                "(3) Provide the required details i.e., name, email, id...Once you've registered yourself, press 1 to login as an admin... \n");
        System.out.println(
                "(4) Once you've logged in, 2nd layer menu will be displayed on the screen...From here on, you can select from variety of options...\n");
        System.out.println(
                "(5) Pressing \"1\" will add a new Passenger, provide the program with required details to add the passenger...\n");
        System.out.println(
                "(6) Pressing \"2\" will search for any passenger, given the admin(you) provides the ID from the table printing above....  \n");
        System.out.println(
                "(7) Pressing \"3\" will let you update any passengers data given the user ID provided to program...\n");
        System.out.println("(8) Pressing \"4\" will let you delete any passenger given its ID provided...\n");
        System.out.println("(9) Pressing \"5\" will let you display all registered passenger...\n");
        System.out.println(
                "(10) Pressing \"6\" will let you display all registered passengers...After selecting, program will ask, if you want to display passengers for all flights(Y/y) or a specific flight(N/n)\n");
        System.out.println(
                "(11) Pressing \"7\" will let you delete any flight given its flight number provided...\n");
        System.out.println(
                "(11) Pressing \"0\" will make you logged out of the program...You can login again any time you want during the program execution....\n");
    }

    static void displayUserManual() {
        System.out.println(
                "\n\n(1) Local user has the access to its data only...He/She won't be able to change/update other users data...\n");
        System.out.println(
                "(2) In order to access local users benefits, you've to get yourself register by pressing 4, when the main menu gets displayed...\n");
        System.out.println(
                "(3) Provide the details asked by the program to add you to the users list...Once you've registered yourself, press \"3\" to login as a passenger...\n");
        System.out.println(
                "(4) Once you've logged in, 3rd layer menu will be displayed...From here on, you embarked on the journey to fly with us...\n");
        System.out.println(
                "(5) Pressing \"1\" will display available/scheduled list of flights...To get yourself booked for a flight, enter the flight number and number of tickets for the flight...Max num of tickets at a time is 10 ...\n");
        System.out.println(
                "(7) Pressing \"2\" will let you update your own data...You won't be able to update other's data... \n");
        System.out.println("(8) Pressing \"3\" will delete your account... \n");
        System.out.println("(9) Pressing \"4\" will display randomly designed flight schedule for this runtime...\n");
        System.out.println("(10) Pressing \"5\" will let you cancel any flight registered by you...\n");
        System.out.println("(11) Pressing \"6\" will display all flights registered by you...\n");
        System.out.println(
                "(12) Pressing \"0\" will make you logout of the program...You can login back at anytime with your credentials...for this particular run-time... \n");
    }
}
