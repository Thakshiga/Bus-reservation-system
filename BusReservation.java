import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

// Class for Customer
class Customer {
    private String name;
    private String mobileNumber;
    private String emailId;
    private String city;
    private int age;

    public Customer(String name, String mobileNumber, String emailId, String city, int age) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.city = city;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public String getEmailId() {
        return emailId;
    }
    public String getCity() {
        return city;
    }
    public int getAge() {
        return age;
    }
    public void displayCustomerDetails() {
        System.out.println(" * Customer Name: " + name);
        System.out.println(" * Mobile Number: " + mobileNumber);
        System.out.println(" * Email ID: " + emailId);
        System.out.println(" * City: " + city);
        System.out.println(" * Age: " + age);
    }
    // Method to return customer details as a string for saving to a file
    public String toFileString() {
        return name + "," + mobileNumber + "," + emailId + "," + city + "," + age;
    }
}

// Class for Bus
class Bus {
    private String busNumber;
    private int totalSeats;
    private String startingPoint;
    private String endingPoint;
    private String startingTime;
    private double fare;

    public Bus(String busNumber, int totalSeats, String startingPoint, String endingPoint, String startingTime, double fare) {
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.startingTime = startingTime;
        this.fare = fare;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public String getEndingPoint() {
        return endingPoint;
    }
    public int getTotalSeats() {
    return totalSeats;
    }
    public String getStartingTime() {
    return startingTime;
    }
    public double getFare() {
        return fare;
    }

    public void displayBusDetails() {
        System.out.println(" * Bus Number: " + busNumber);
        System.out.println(" * Total Seats: " + totalSeats);
        System.out.println(" * Starting Point: " + startingPoint);
        System.out.println(" * Ending Point: " + endingPoint);
        System.out.println(" * Starting Time: " + startingTime);
        System.out.println(" * Fare: " + fare);
    }

    // Method to return bus details as a string for saving to a file
    public String toFileString() {
        return busNumber + "," + totalSeats + "," + startingPoint + "," + endingPoint + "," + startingTime + "," + fare;
    }
}
class Reservation {
    private String customerName;
    private String mobileNumber;
    private String busNumber;
    private String reservationDate;
    private int seatNumber;

    public Reservation(String customerName, String mobileNumber, String busNumber, String reservationDate, int seatNumber) {
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.busNumber = busNumber;
        this.reservationDate = reservationDate;
        this.seatNumber = seatNumber;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String toFileString() {
        return customerName + "," + mobileNumber + "," + busNumber + "," + reservationDate + "," + seatNumber;
    }

    public void displayReservationDetails() {
        System.out.println("Reservation Details:");
        System.out.println(" * Customer Name: " + customerName);
        System.out.println(" * Mobile Number: " + mobileNumber);
        System.out.println(" * Bus Number: " + busNumber);
        System.out.println(" * Reservation Date: " + reservationDate);
        System.out.println(" * Seat Number: " + seatNumber);
    }
}
 

public class BusReservation {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Bus> buses = new ArrayList<>();
    private static final String CUSTOMER_FILE = "customers.txt";
    private static final String BUS_FILE = "buses.txt";
    private static List<Reservation> reservations = new ArrayList<>();
    private static final String RESERVATION_FILE = "reservations.txt";
    private static final String WAITING_QUEUE_FILE = "waiting_queue.txt";
    private static Queue<WaitingQueueEntry> waitingQueue = new LinkedList<>();

    public static void main(String[] args) {
        loadCustomers();
        loadBuses();
        loadReservations();
        loadWaitingQueue();
        Scanner scanner = new Scanner(System.in);
        

        while (true) {
    System.out.println("╔════════════════════════════════════════════════╗");
    System.out.println("║         Welcome to Bus Reservation System      ║");
    System.out.println("╠════════════════════════════════════════════════╣");
    System.out.println("║   1. Register New Customer                     ║");
    System.out.println("║   2. View Registered Customers                 ║");
    System.out.println("║   3. Register New Bus                          ║");
    System.out.println("║   4. View Registered Bus Details               ║");
    System.out.println("║   5. Search Buses                              ║");
    System.out.println("║   6. Reserve Seat                              ║");
    System.out.println("║   7. View Reservations                         ║");
    System.out.println("║   8. Additional Seat Request                   ║");
    System.out.println("║   9. Cancel Seat Reservation                   ║");
    System.out.println("║   10. view waiting Queue                       ║");
    System.out.println("║   11. Exit                                     ║");
    System.out.println("╚════════════════════════════════════════════════╝");
    System.out.print(" Choose an option: ");
            int choice = getValidInt(scanner);

            switch (choice) {
                case 1:
                    registerCustomer(scanner);
                    break;
                case 2:
                    viewRegisteredCustomers(scanner);
                    break;
                case 3:
                    registerBus(scanner);
                    break;
                case 4:
                    viewRegisteredBuses(scanner);
                    break;
                case 5:
                    searchBuses(scanner);
                    break;

                 case 6:
                    reserveSeat(scanner);
                    break;
                case 7:
                    viewReservations(scanner);
                    break;
                case 8:
                    handleAdditionalSeatRequest();
                    break;
                case 9:
                    cancelSeatReservation(scanner);
                    break;
                case 10:
                    viewWaitingQueue();
                    break;
                case 11:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        }
    }
   

    private static int getValidInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }
    }

    // Load customers from the file
    private static void loadCustomers() {
        try (BufferedReader br = new BufferedReader(new FileReader(CUSTOMER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Customer customer = new Customer(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]));
                customers.add(customer);
            }
        } catch (IOException e) {
            System.out.println("No existing customer data found.");
        }
    }

    // Load buses from the file
    private static void loadBuses() {
        try (BufferedReader br = new BufferedReader(new FileReader(BUS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Bus bus = new Bus(data[0], Integer.parseInt(data[1]), data[2], data[3], data[4], Double.parseDouble(data[5]));
                buses.add(bus);
            }
        } catch (IOException e) {
            System.out.println("No existing bus data found.");
        }
    }

    // Save customers to the file
    private static void saveCustomers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CUSTOMER_FILE))) {
            for (Customer customer : customers) {
                bw.write(customer.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving customer data.");
        }
    }

    // Save buses to the file
    private static void saveBuses() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BUS_FILE))) {
            for (Bus bus : buses) {
                bw.write(bus.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving bus data.");
        }
    }

    // Customer Registration
   private static void registerCustomer(Scanner scanner) {
        try {
            System.out.print("Enter Customer Name: ");
            String name = scanner.next();
            System.out.print("Enter Mobile Number: ");
            String mobileNumber = scanner.next();
            System.out.print("Enter Email ID: ");
            String emailId = scanner.next();
            System.out.print("Enter City: ");
            String city = scanner.next();
            System.out.print("Enter Age: ");
            int age = getValidInt(scanner);
            Customer newCustomer = new Customer(name, mobileNumber, emailId, city, age);
            customers.add(newCustomer);
            saveCustomers(); 
            System.out.println("Customer registered successfully!\n");
        } catch (Exception e) {
            System.out.println("An error occurred during customer registration: " + e.getMessage());
        }
    }
    private static void viewRegisteredCustomers(Scanner scanner) {
    System.out.println("Registered Customers (Newest to Oldest):");
    if (customers.isEmpty()) {
        System.out.println("No customers have been registered yet.");
        return;
    }
    Stack<Customer> customerStack = new Stack<>();
        for (Customer customer : customers) {
            customerStack.push(customer);
        }
        // Display customers
        int customerCount = customers.size();
        while (!customerStack.isEmpty()) {
            Customer currentCustomer = customerStack.pop();
             System.out.println("-------------------------------");
            System.out.println("Customer " + customerCount + ":");
            currentCustomer.displayCustomerDetails();
            System.out.println("-------------------------------");
            customerCount--;
        }
    System.out.println("Choose an option:");
    System.out.println("1. Update Customer Details");
    System.out.println("2. Delete Customer Details");
    System.out.println("3. Go Back to Main Menu");

    int option = getValidInt(scanner);

    switch (option) {
        case 1:
            updateCustomerDetails(scanner);
            break;
        case 2:
            deleteCustomerDetails(scanner);
            break;
        case 3:
            return; 
        default:
            System.out.println("Invalid option! Please try again.");
            break;
    }
}

// Method to update customer details
private static void updateCustomerDetails(Scanner scanner) {
    System.out.print("Enter customer index to update (1 to " + customers.size() + "): ");
    int index = getValidInt(scanner) - 1;
    if (index < 0 || index >= customers.size()) {
        System.out.println("Invalid customer index.");
        return;
    }
    Customer customer = customers.get(index);
  
    System.out.print("Enter Name (current: " + customer.getName() + "): ");
    String newName = scanner.next();
    System.out.print("Enter new Mobile Number (current: " + customer.getMobileNumber() + "): ");
    String newMobileNumber = scanner.next();
    System.out.print("Enter new Email ID (current: " + customer.getEmailId() + "): ");
    String newEmailId = scanner.next();
    System.out.print("Enter new city (current: " + customer.getCity() + "): ");
    String newCity = scanner.next();
    System.out.print("Enter new Age (current: " + customer.getAge() + "): ");
    int newAge = scanner.nextInt();

    // Update the customer information
    customer = new Customer(newName, newMobileNumber, newEmailId, newCity, newAge);
    customers.set(index, customer);
    saveCustomers(); 
    System.out.println("Customer details updated successfully!");
}

// Method to delete customer details
private static void deleteCustomerDetails(Scanner scanner) {
        System.out.print("Enter customer index to delete (1 to " + customers.size() + "): ");
        int index = getValidInt(scanner) - 1;

        if (index < 0 || index >= customers.size()) {
            System.out.println("Invalid customer index.");
            return;
        }
        System.out.print("Are you sure you want to delete Customer " + (index + 1) + "? (yes/no): ");
        String confirmation = scanner.next().toLowerCase();
        if (confirmation.equals("yes")) {
            customers.remove(index);
            saveCustomers(); // Save changes after deletion
            System.out.println("Customer details deleted successfully!");
        } else {
            System.out.println("Deletion cancelled.");
        }
}
    // Bus Registration
    private static void registerBus(Scanner scanner) {
        System.out.print("Enter Bus Number: ");
        String busNumber = scanner.next();

        System.out.print("Enter Total Seats: ");
        int totalSeats = getValidInt(scanner);

        System.out.print("Enter Starting Point: ");
        String startingPoint = scanner.next();

        System.out.print("Enter Ending Point: ");
        String endingPoint = scanner.next();

        System.out.print("Enter Starting Time: ");
        String startingTime = scanner.next();

        System.out.print("Enter Fare: ");
        double fare = scanner.nextDouble();

        Bus newBus = new Bus(busNumber, totalSeats, startingPoint, endingPoint, startingTime, fare);
        buses.add(newBus);
        saveBuses(); 

        System.out.println("Bus registered successfully!\n");
    }

   
    // Method to view registered buses
    private static void viewRegisteredBuses(Scanner scanner) {
        System.out.println("Registered Buses (Newest to Oldest):");
        if (buses.isEmpty()) {
            System.out.println("No buses have been registered yet.");
            return;
        }
            Stack<Bus> busStack = new Stack<>();
    for (Bus bus : buses) {
        busStack.push(bus);
    }
    int registrationOrder = buses.size(); 
    while (!busStack.isEmpty()) {
        System.out.println("--------------------------------");
        System.out.println("Bus " + registrationOrder + ":");
        Bus currentBus = busStack.pop();
        currentBus.displayBusDetails();
          System.out.println("--------------------------------");
        registrationOrder--;
    } 
        System.out.println("Choose an option:");
        System.out.println("1. Update Bus Details");
        System.out.println("2. Delete Bus Details");
        System.out.println("3. Go Back to Main Menu");
        int option = getValidInt(scanner);
        switch (option) {
            case 1:
                System.out.print("Enter Bus Index to Update (1 to " + buses.size() + "): ");
                int updateIndex = getValidInt(scanner) - 1; 
                if (updateIndex >= 0 && updateIndex < buses.size()) {
                    updateBusDetails(scanner, updateIndex); 
                    } else {
                System.out.println("Invalid Bus Index."); 
            }
            break;
            case 2:
                System.out.print("Enter Bus Index to Delete (1 to " + buses.size() + "): ");
                int deleteIndex = getValidInt(scanner) - 1;
                if (deleteIndex >= 0 && deleteIndex < buses.size()) {
                System.out.print("Are you sure you want to delete this bus? (yes/no): ");
                String confirmation = scanner.next().trim().toLowerCase();
                 if (confirmation.equals("yes")) {
                deleteBusDetails(deleteIndex);
                 } else {
                 System.out.println("Deletion canceled.");
                 }
                 } else {
                System.out.println("Invalid Bus Index.");
                 }
                 break;
            case 3:
                return; 
            default:
                System.out.println("Invalid option. Returning to main menu.");
        }
    }

    // Method to update bus details
    private static void updateBusDetails(Scanner scanner, int index) {
        Bus existingBus = buses.get(index); 

      
        System.out.print("Enter Bus Number (current: " + existingBus.getBusNumber() + "): ");
        String newBusNumber = scanner.next();

        System.out.print("Enter Total Seats (current: " + existingBus.getTotalSeats() + "): ");
        int newTotalSeats = getValidInt(scanner);

        System.out.print("Enter Starting Point (current: " + existingBus.getStartingPoint() + "): ");
        String newStartingPoint = scanner.next();

        System.out.print("Enter Ending Point (current: " + existingBus.getEndingPoint() + "): ");
        String newEndingPoint = scanner.next();

        System.out.print("Enter Starting Time (current: " + existingBus.getStartingTime() + "): ");
        String newStartingTime = scanner.next();

        System.out.print("Enter Fare (current: " + existingBus.getFare() + "): ");
        double newFare = scanner.nextDouble();

     
        Bus updatedBus = new Bus(newBusNumber, newTotalSeats, newStartingPoint, newEndingPoint, newStartingTime, newFare);
        buses.set(index, updatedBus); 
        saveBuses(); 

        System.out.println("Bus details updated successfully!");
    }

    // Method to delete bus details
    private static void deleteBusDetails(int index) {
        buses.remove(index);
        System.out.println("Bus details deleted successfully!");
        saveBuses(); // Save changes
    }

    // Search Buses
    private static void searchBuses(Scanner scanner) {
        System.out.print("Enter Starting Point: ");
        String startingPoint = scanner.next();

        System.out.print("Enter Ending Point: ");
        String endingPoint = scanner.next();

        boolean found = false;
        System.out.println("Available Buses from " + startingPoint + " to " + endingPoint + ":");
        for (Bus bus : buses) {
            if (bus.getStartingPoint().equalsIgnoreCase(startingPoint) && bus.getEndingPoint().equalsIgnoreCase(endingPoint)) {
                bus.displayBusDetails();
                System.out.println("-----------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No buses found for the given route.");
        }
    }
   private static void reserveSeat(Scanner scanner) {
    System.out.print("Enter Mobile Number for Verification: ");
    String mobileNumber = scanner.next();

    Customer customer = null;
    try {
        customer = findCustomerByMobileNumber(mobileNumber);
        if (customer == null) {
            System.out.println("Customer not registered. Please register first.");
            return;
        }
    } catch (NullPointerException e) {
        System.out.println("A null pointer exception occurred. Please ensure the input and search operation are valid.");
        return;
    }

    System.out.print("Enter Starting Point: ");
    String startingPoint = scanner.next();
    System.out.print("Enter Ending Point: ");
    String endingPoint = scanner.next();

    String reservationDate;
    while (true) {
        System.out.print("Enter Reservation Date (dd/mm/yyyy): ");
        reservationDate = scanner.next();
        if (isValidDate(reservationDate)) {
            break;
        } else {
            System.out.println("Invalid date. Please enter a valid date in the format dd/mm/yyyy.");
        }
    }

    // Search for available buses
    List<Bus> availableBuses = searchBusesByRouteAndDate(startingPoint, endingPoint, reservationDate);
    if (availableBuses.isEmpty()) {
        System.out.println("No available buses for the selected route and date.");
        return;
    }

    System.out.println("Available Buses:");
    for (Bus bus : availableBuses) {
        bus.displayBusDetails();
        System.out.println(" * Available Seats: " + getAvailableSeatsForBus(bus.getBusNumber(), reservationDate));
        System.out.println("-------------------------------");
    }

    System.out.print("Enter Bus Number for Reservation: ");
    String busNumber = scanner.next();
    Bus selectedBus = findBusByNumber(busNumber);
    if (selectedBus == null) {
        System.out.println("Bus number does not exist.");
        return;
    }

    Reservation existingReservation = findReservation(mobileNumber, busNumber, reservationDate);
    if (existingReservation != null) {
        System.out.println("You already have a reservation for this bus and date.");
        System.out.println("For additional seat requests, please use the Additional Seat Request option.");
        return;
    }

    int availableSeats = getAvailableSeatsForBus(busNumber, reservationDate);

    int seatNumber;
    if (availableSeats > 0) {
        seatNumber = selectedBus.getTotalSeats() - availableSeats + 1;
        System.out.println("Seat reserved successfully! Seat Number: " + seatNumber);
    } else {
        addToWaitingQueue(customer, busNumber, reservationDate);
        System.out.println("Bus is full. You have been placed in the waiting queue.");
        return;
    }

    Reservation reservation = new Reservation(customer.getName(), mobileNumber, busNumber, reservationDate, seatNumber);
    reservations.add(reservation);
    saveReservations();
    reservation.displayReservationDetails();
}


private static Reservation findReservation(String mobileNumber, String busNumber, String reservationDate) {
    for (Reservation reservation : reservations) {
        if (reservation.getMobileNumber().equals(mobileNumber) &&
            reservation.getBusNumber().equals(busNumber) &&
            reservation.getReservationDate().equals(reservationDate)) {
            return reservation;
        }
    }
    return null;
}
    private static List<Bus> searchBusesByRouteAndDate(String startingPoint, String endingPoint, String reservationDate) {
        List<Bus> result = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getStartingPoint().equalsIgnoreCase(startingPoint) && bus.getEndingPoint().equalsIgnoreCase(endingPoint)) {
                result.add(bus);
            }
        }
        return result;
    }

    private static Bus findBusByNumber(String busNumber) {
        for (Bus bus : buses) {
            if (bus.getBusNumber().equals(busNumber)) {
                return bus;
            }
        }
        return null;
    }

    private static Customer findCustomerByMobileNumber(String mobileNumber) {
        for (Customer customer : customers) {
            if (customer.getMobileNumber().equals(mobileNumber)) {
                return customer;
            }
        }
        return null;
    }

    private static int getAvailableSeatsForBus(String busNumber, String reservationDate) {
        int reservedSeats = 0;
        for (Reservation reservation : reservations) {
            if (reservation.getBusNumber().equals(busNumber) && reservation.getReservationDate().equals(reservationDate)) {
                reservedSeats++;
            }
        }
        Bus bus = findBusByNumber(busNumber);
        return bus != null ? bus.getTotalSeats() - reservedSeats : 0;
    }

    private static void saveReservations() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RESERVATION_FILE))) {
            for (Reservation reservation : reservations) {
                bw.write(reservation.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving reservation data.");
        }
    }

    
    private static void loadReservations() {
        reservations.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(RESERVATION_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String customerName = data[0].trim();
                    String mobileNumber = data[1].trim();
                    String busNumber = data[2].trim();
                    String reservationDate = data[3].trim();
                    int seatNumber = Integer.parseInt(data[4].trim());
                    reservations.add(new Reservation(customerName, mobileNumber, busNumber, reservationDate, seatNumber));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading reservations: " + e.getMessage());
        }
    }
    private static boolean isValidDate(String date) {
    String[] parts = date.split("/");
    if (parts.length != 3) return false;

    int day, month, year;
    try {
        day = Integer.parseInt(parts[0]);
        month = Integer.parseInt(parts[1]);
        year = Integer.parseInt(parts[2]);
    } catch (NumberFormatException e) {
        return false; 
    }
    // Check for valid month
    if (month < 1 || month > 12) {
        return false;
    }
    // Check for valid year (four digits)
    if (year < 1000 || year > 9999) {
        return false;
    }
    // Check for valid day based on the month
    switch (month) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            return day >= 1 && day <= 31; 
        case 4: case 6: case 9: case 11:
            return day >= 1 && day <= 30; 
        case 2:
            // Leap year check for February
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            return isLeapYear ? (day >= 1 && day <= 29) : (day >= 1 && day <= 28);
        default:
            return false;
    }
    }
private static void addToWaitingQueue(Customer customer, String busNumber, String reservationDate) {
    // logic to manage waiting queue
    WaitingQueueEntry entry = new WaitingQueueEntry(customer.getName(), customer.getMobileNumber(), busNumber, reservationDate);
    waitingQueue.add(entry);
    saveWaitingQueue();
}

private static void saveWaitingQueue() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(WAITING_QUEUE_FILE))) {
        for (WaitingQueueEntry entry : waitingQueue) {
            bw.write(entry.getCustomerName() + "," + entry.getMobileNumber() + "," + entry.getBusNumber() + "," + entry.getReservationDate());
            bw.newLine();
        }
    } catch (IOException e) {
        System.out.println("Error saving waiting queue data.");
    }
}
  private static void viewReservations(Scanner scanner) {
        System.out.println("Choose an option:");
        System.out.println("1. View All Reservations");
        System.out.println("2. View Reservations by Bus Number");
        System.out.print("Enter your choice: ");
        int option = getValidInt(scanner);

        switch (option) {
            case 1:
                displayAllReservations();
                break;
            case 2:
                System.out.print("Enter Bus Number: ");
                String busNumber = scanner.next();
                displayReservationsByBusNumber(busNumber);
                break;
            default:
                System.out.println("Invalid choice! Please select again.");
        }
    }
private static void displayAllReservations() {
    System.out.println("All Reservations:");
    boolean hasReservations = false;
    try (BufferedReader br = new BufferedReader(new FileReader(RESERVATION_FILE))) {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim(); 

            if (line.isEmpty()) {
                continue; 
            }
            String[] data = line.split(",");
            if (data.length == 5) {
                hasReservations = true;
                System.out.println("Customer Name: " + data[0]);
                System.out.println("Mobile Number: " + data[1]);
                System.out.println("Bus Number: " + data[2]);
                System.out.println("Reservation Date: " + data[3]);
                System.out.println("Seat Number: " + data[4]);
                System.out.println("-------------------------------");
            } else {
                System.out.println("Invalid reservation data format: " + line + " (Expected 5 fields, found " + data.length + ")");
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading reservation data: " + e.getMessage());
    }
    if (!hasReservations) {
        System.out.println("No reservations found.");
    }
}

private static void displayReservationsByBusNumber(String busNumber) {
    System.out.println("Reservations for Bus Number: " + busNumber);
    try (BufferedReader br = new BufferedReader(new FileReader(RESERVATION_FILE))) {
        String line;
        boolean found = false;
        while ((line = br.readLine()) != null) {
            line = line.trim(); 
            if (line.isEmpty()) {
                continue; 
            }
            String[] data = line.split(",");
            if (data.length >= 5) { 
                if (data[2].equalsIgnoreCase(busNumber)) {
                    System.out.println("Customer Name: " + data[0]);
                    System.out.println("Mobile Number: " + data[1]);
                    System.out.println("Reservation Date: " + data[3]);
                    System.out.println("Seat Number: " + data[4]);
                    System.out.println("-------------------------------");
                    found = true;
                }
            } else {
                System.out.println("Invalid reservation data format: " + line + " (Expected at least 5 fields, found " + data.length + ")");
            }
        }
        if (!found) {
            System.out.println("No reservations found for this bus number.");
        }
    } catch (IOException e) {
        System.out.println("Error reading reservation data.");
    }
}

private static void handleAdditionalSeatRequest() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter your mobile number: ");
    String mobileNumber = scanner.nextLine();
    if (checkReservationExists(mobileNumber)) {
        System.out.println("You have an existing reservation.");
        
        System.out.print("Enter bus number: ");
        String busNumber = scanner.nextLine();
        System.out.print("Enter reservation date: ");
        String reservationDate = scanner.nextLine();
        
        if (checkReservationDetails(mobileNumber, busNumber, reservationDate)) {
            System.out.println("Reservation found. Adding to waiting list.");
            Customer customer = findCustomerByMobileNumber(mobileNumber); 
            addToWaitingQueue(customer, busNumber, reservationDate);
        } else {
            System.out.println("No reservation found for the given bus number and date. so please use reserve seat option");
        }
    } else {
        System.out.println("No reservation exists for this mobile number.  please use reserve seat option");
    }
}

private static boolean checkReservationExists(String mobileNumber) {
    // Logic to read from RESERVATION_FILE and check if reservation exists
    try (BufferedReader br = new BufferedReader(new FileReader(RESERVATION_FILE))) {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim(); // Trim any whitespace

            if (line.isEmpty()) {
                continue; // Skip empty lines
            }

            String[] data = line.split(",");

            // Ensure that the data array has enough fields to access index 1
            if (data.length > 1 && data[1].equals(mobileNumber)) { 
                return true;
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading reservation data.");
    }
    return false;
}
private static boolean checkReservationDetails(String mobileNumber, String busNumber, String reservationDate) {
    // Logic to check if the specific reservation exists for the given details
    try (BufferedReader br = new BufferedReader(new FileReader(RESERVATION_FILE))) {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim(); // Trim any whitespace

            if (line.isEmpty()) {
                continue; // Skip empty lines
            }

            String[] data = line.split(",");

            // Ensure the data array has enough fields to access indexes 1, 2, and 3
            if (data.length > 3 && 
                data[1].equals(mobileNumber) && 
                data[2].equals(busNumber) && 
                data[3].equals(reservationDate)) {
                return true;
            } else if (data.length <= 3) {
                System.out.println("Invalid reservation data format: " + line);
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading reservation data.");
    }
    return false;
}


private static void cancelSeatReservation(Scanner scanner) {
    System.out.print("Enter Mobile Number: ");
    String mobileNumber = scanner.next();
    System.out.print("Enter Bus Number: ");
    String busNumber = scanner.next();
    System.out.print("Enter Reservation Date (dd/mm/yyyy): ");
    String reservationDate = scanner.next();
    System.out.print("Enter Seat Number: ");
    int seatNumber = scanner.nextInt();
    loadReservations(); 
    Reservation reservationToCancel = null;
    // Check for the reservation in the reservations list
    for (Reservation reservation : reservations) {
        if (reservation.getMobileNumber().equals(mobileNumber) &&
            reservation.getBusNumber().equals(busNumber) &&
            reservation.getReservationDate().equals(reservationDate) &&
            reservation.getSeatNumber() == seatNumber) {
            reservationToCancel = reservation;
            break;
        }
    }
    if (reservationToCancel != null) {
        System.out.print("Are you sure you want to cancel the reservation for " + 
        reservationToCancel.getCustomerName() + " for seat " + seatNumber + "? (yes/no): ");
        String confirmation = scanner.next();

        if (confirmation.equalsIgnoreCase("yes")) {
            reservations.remove(reservationToCancel);
            System.out.println("Reservation canceled successfully for " + reservationToCancel.getCustomerName() 
            + " for seat number " + seatNumber);

            notifyAdjacentSeats(seatNumber, busNumber, reservationDate);

            assignWaitingQueueSeat(busNumber, reservationDate, seatNumber);
            saveReservations();
        } else {
            System.out.println("Reservation cancellation aborted.");
        }
    } else {
        System.out.println("No reservation found for the provided details.");
    }
}

private static void notifyAdjacentSeats(int seatNumber, String busNumber, String reservationDate) {
    int previousSeat = seatNumber - 1;
    int nextSeat = seatNumber + 1;
    for (Reservation reservation : reservations) {
        if (reservation.getBusNumber().equals(busNumber) && 
            reservation.getReservationDate().equals(reservationDate) &&
            (reservation.getSeatNumber() == previousSeat || reservation.getSeatNumber() == nextSeat)) {
            
            System.out.println("Notification: Dear " + reservation.getCustomerName() + ", your partner seat " + seatNumber + " has been canceled. ");
        }
    }
}
private static void assignWaitingQueueSeat(String busNumber, String reservationDate, int seatNumber) {
    loadWaitingQueue();
    if (!waitingQueue.isEmpty()) {
        WaitingQueueEntry firstWaiting = null;
        for (WaitingQueueEntry entry : waitingQueue) {
            if (entry.getBusNumber().equals(busNumber) && entry.getReservationDate().equals(reservationDate)) {
                firstWaiting = entry; 
                break;
            }
        }
        if (firstWaiting != null) {
            // Create a new reservation for the waiting customer
            Reservation newReservation = new Reservation(
                    firstWaiting.getCustomerName(),
                    firstWaiting.getMobileNumber(),
                    busNumber,
                    reservationDate,
                    seatNumber 
            );
            reservations.add(newReservation);
            System.out.println("Seat number " + seatNumber + " has been assigned to " + firstWaiting.getCustomerName());
            System.out.println("Notification: Dear " + firstWaiting.getCustomerName() + ", you have been assigned seat number " + seatNumber + ".");
            waitingQueue.remove(firstWaiting); 
            saveWaitingQueue();
        } else {
            System.out.println("No customers in the waiting queue for this bus and date.");
        }
    } else {
        System.out.println("No customers in the waiting queue for this bus and date.");
    }
}
private static void loadWaitingQueue() {
        waitingQueue.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(WAITING_QUEUE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String customerName = parts[0].trim();
                    String mobileNumber = parts[1].trim();
                    String busNumber = parts[2].trim();
                    String reservationDate = parts[3].trim();
                    waitingQueue.add(new WaitingQueueEntry(customerName, mobileNumber, busNumber, reservationDate));
                } else {
                    System.out.println("Invalid line in waiting queue file: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading waiting queue file: " + e.getMessage());
        }
    }
private static List<WaitingQueueEntry> readWaitingQueue() {
    List<WaitingQueueEntry> waitingQueueEntries = new ArrayList<>();
    
    try (BufferedReader br = new BufferedReader(new FileReader(WAITING_QUEUE_FILE))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 4) {
                WaitingQueueEntry entry = new WaitingQueueEntry(parts[0], parts[1], parts[2], parts[3]);
                waitingQueueEntries.add(entry);
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading waiting queue file: " + e.getMessage());
    }
    
    return waitingQueueEntries;
}
private static void viewWaitingQueue() {
    List<WaitingQueueEntry> waitingQueue = readWaitingQueue();

    if (waitingQueue.isEmpty()) {
        System.out.println("No entries in the waiting queue.");
    } else {
        System.out.println("Waiting Queue Entries:");
        for (int i = 0; i < waitingQueue.size(); i++) {
            WaitingQueueEntry entry = waitingQueue.get(i);
            System.out.println("Entry " + (i + 1) + ":");
            System.out.println(" * Customer Name: " + entry.getCustomerName());
            System.out.println(" * Mobile Number: " + entry.getMobileNumber());
            System.out.println(" * Bus Number: " + entry.getBusNumber());
            System.out.println(" * Reservation Date: " + entry.getReservationDate());
            System.out.println("-------------------------------");
        }
    }
}
}