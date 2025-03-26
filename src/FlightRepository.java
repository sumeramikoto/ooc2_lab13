import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FlightRepository {
    private static int nextFlightDay = 0;
    static List<Flight> flightList = new ArrayList<>();

    public FlightRepository() {
    }

    public void flightScheduler() {
        int numOfFlights = 15;              // decides how many unique flights to be included/display in scheduler
        RandomGenerator randomGenerator = new RandomGenerator();
        for (int i = 0; i < numOfFlights; i++) {
            String[][] chosenDestinations = randomGenerator.randomDestinations();
            String[] distanceBetweenTheCities = FlightUtils.calculateDistance(Double.parseDouble(chosenDestinations[0][1]), Double.parseDouble(chosenDestinations[0][2]), Double.parseDouble(chosenDestinations[1][1]), Double.parseDouble(chosenDestinations[1][2]));
            String flightSchedule = createNewFlightsAndTime();
            String flightNumber = randomGenerator.randomFlightNumbGen(2, 1).toUpperCase();
            int numOfSeatsInTheFlight = randomGenerator.randomNumOfSeats();
            String gate = randomGenerator.randomFlightNumbGen(1, 30);
            flightList.add(new Flight(flightSchedule, flightNumber, numOfSeatsInTheFlight, chosenDestinations, distanceBetweenTheCities, gate.toUpperCase()));
        }
    }

    void deleteFlight(String flightNumber) {
        boolean isFound = false;
        Iterator<Flight> list = flightList.iterator();
        while (list.hasNext()) {
            Flight flight = list.next();
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                isFound = true;
                break;
            }
        }
        if (isFound) {
            list.remove();
        } else {
            System.out.println("Flight with given Number not found...");
        }
        displayFlightSchedule();
    }

    public String createNewFlightsAndTime() {
        Calendar c = Calendar.getInstance();
        // Incrementing nextFlightDay, so that next scheduled flight would be in the future, not in the present
        nextFlightDay += Math.random() * 7;
        c.add(Calendar.DATE, nextFlightDay);
        c.add(Calendar.HOUR, nextFlightDay);
        c.set(Calendar.MINUTE, ((c.get(Calendar.MINUTE) * 3) - (int) (Math.random() * 45)));
        Date myDateObj = c.getTime();
        LocalDateTime date = Instant.ofEpochMilli(myDateObj.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
        date = FlightUtils.getNearestHourQuarter(date);
        return date.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy, HH:mm a "));
    }


    public void displayFlightSchedule() {
        Iterator<Flight> flightIterator = flightList.iterator();
        System.out.println();
        System.out.print("+------+-------------------------------------------+-----------+------------------+-----------------------+------------------------+---------------------------+-------------+--------+------------------------+\n");
        System.out.printf("| Num  | FLIGHT SCHEDULE\t\t\t   | FLIGHT NO | Available Seats  | \tFROM ====>>       | \t====>> TO\t   | \t    ARRIVAL TIME       | FLIGHT TIME |  GATE  |   DISTANCE(MILES/KMS)  |%n");
        System.out.print("+------+-------------------------------------------+-----------+------------------+-----------------------+------------------------+---------------------------+-------------+--------+------------------------+\n");
        int i = 0;
        while (flightIterator.hasNext()) {
            i++;
            Flight f1 = flightIterator.next();
            System.out.println(f1.toString(i));
            System.out.print("+------+-------------------------------------------+-----------+------------------+-----------------------+------------------------+---------------------------+-------------+--------+------------------------+\n");
        }
    }

    public List<Flight> getFlightList() {
        return Collections.unmodifiableList(flightList);
    }
}
