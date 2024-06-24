import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.util.Date;

public class AirlineManagementSystem {
    public static void main(String[] args) {

        Flight flight1 = new Flight(1, "Johor - KLIA2-12:00-14:30", "12:00", "14:30", "Johor", "KLIA 2");
        Flight flight2 = new Flight(2, "KLIA2 - Johor-08:00-10:30", "08:00", "10:30", "KLIA 2", "Johor");
        Flight flight3 = new Flight(3, "KLIA2 - Johor-11:30-14:00", "11:30", "14:00", "KLIA 2", "Johor");


        Airplane airplane1 = new Airplane(101, "Airbus A320-200", "AirAsia", 180, true);
        Airplane airplane2 = new Airplane(102, "Airbus A321neo", "AirAsia", 236, true);
        Airplane airplane3 = new Airplane(103, "Boeing 737 MAX 8", "AirAsia", 178, true);
        Airplane airplane4 = new Airplane(104, "ATR 72-600", "Firefly", 72, true);
        Airplane airplane5 = new Airplane(105, "Boeing 737-800", "Firefly", 189, true);
        Airplane airplane6 = new Airplane(106, "Bombardier Q400", "Local Airlines", 78, true);
        Airplane airplane7 = new Airplane(107, "Embraer E190-E2", "Local Airlines", 114, true);
        Airplane airplane8 = new Airplane(108, "ATR 42-600", "Local Airlines", 48, true);
        Airplane airplane9 = new Airplane(109, "Bombardier Dash 8 Q300", "Local Airlines", 50, true);

        List<Airplane> airAsiaAirplanes = new ArrayList<>();
        List<Airplane> fireflyAirplanes = new ArrayList<>();
        List<Airplane> localAirplanes = new ArrayList<>();

        for (Airplane airplane : new Airplane[] { airplane1, airplane2, airplane3, airplane4, airplane5,
                                                    airplane6, airplane7, airplane8, airplane9 }) {
            if (airplane.getPlaneFacturer().equals("AirAsia")) {
                airAsiaAirplanes.add(airplane);
            } else if (airplane.getPlaneFacturer().equals("Firefly")) {
                fireflyAirplanes.add(airplane);
            } else if (airplane.getPlaneFacturer().equals("Local Airlines")){
                localAirplanes.add(airplane);
            }
        }

        flight1.addAirplane(airplane1);
        flight1.addAirplane(airplane2);
        flight1.addAirplane(airplane6);
        flight1.addAirplane(airplane7);

        flight2.addAirplane(airplane3);
        flight2.addAirplane(airplane4);
        flight2.addAirplane(airplane5);
        flight2.addAirplane(airplane9);

        flight3.addAirplane(airplane1);
        flight3.addAirplane(airplane2);
        flight3.addAirplane(airplane8);

        Gate gate1 = new Gate(01, "A01", "A", flight1);
        Gate gate2 = new Gate(02, "A02", "A", flight2);
        Gate gate3 = new Gate(02, "B05", "B", flight3);

        flight1.setGate(gate3);
        flight2.setGate(gate2);
        flight3.setGate(gate1);

        Customer customer1 = new Customer("John Doe", "Male", 28, "C001", "5551234567", "A12345678");

        Meal meal1 = new Meal(101, "Nasi Lemak", "Halal", 8.50, customer1);
        Meal meal2 = new Meal(102, "Chicken Rice", "Halal", 7.00, customer1);
        Meal meal3 = new Meal(103, "Vegetarian Pasta", "Vegetarian", 6.50, customer1);
        Meal meal4 = new Meal(104, "Thai Green Curry", "Gluten-Free", 9.00, customer1);
        Meal meal5 = new Meal(105, "Vegan Salad", "Vegan", 5.50, customer1);

        List<Customer> customers = new ArrayList<>();
        List<Pilot> pilots = new ArrayList<>();
        List<CrewMember> crewMembers = new ArrayList<>();

        try {
            customers = Customer.loadCustomers("projectair\\src\\Customers.txt","projectair\\src\\bookings.txt");
            pilots = Pilot.loadPilots("projectair\\src\\pilots.txt");
            crewMembers = CrewMember.loadCrewMembers("projectair\\src\\crew.txt");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }

        try (Scanner scanner = new Scanner(System.in)) { // Try-with-resources statement
            String message = "Welcome to Air UTM Booking System!";
            JOptionPane.showMessageDialog(null, message, "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);
        
            // Sign-in Section for Crew Member
            String welcomeMessage = "Welcome Crew Member";
            JOptionPane.showMessageDialog(null, welcomeMessage, "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);
        
            String userName = JOptionPane.showInputDialog("Enter your username:");
            if (userName == null || userName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username cannot be empty. Exiting system.");
                return;
            }
        
            String userId = JOptionPane.showInputDialog("Enter your ID:");
            if (userId == null || userId.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ID cannot be empty. Exiting system.");
                return;
            }
        
            boolean signedIn = false;
        
            // Replace with your actual crew member authentication logic
            if (findCrewMemberByNameAndId(crewMembers, userName, userId) != null) {
                signedIn = true;
                JOptionPane.showMessageDialog(null, "Login successful.\n Welcome, Crew Member!", "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Crew Member not found or ID does not match.");
            }
        
            if (!signedIn) {
            JOptionPane.showMessageDialog(null, "Sign-in failed. Exiting system.");
            return;
}


            while(true){            
                String message1 = 
                 "[1] Book a Flight\n" 
                + "[2] Book a Meal\n"
                + "[3] Check In a Baggage\n"
                + "[4] View Customer List\n"
                + "[5] View Pilot List\n"
                + "[6] View Crew Member List\n"
                + "[7] Display Airline List\n"
                + "[8] Display Flight List\n"                
                + "[9] Display Booking\n"
                + "[10] Exit\n";

            String optionInput = JOptionPane.showInputDialog(null, message1, "Enter your option");
            int option = Integer.parseInt(optionInput);

            if (option == 7) {

                String[] options = { "AirAsia", "Firefly" ,"Local Airlines"};
                JComboBox<String> optionList = new JComboBox<>(options);
                optionList.setSelectedIndex(0);

                JPanel dialogPanel = new JPanel();
                dialogPanel.setLayout(new BorderLayout());

                JLabel textLabel = new JLabel("<html>Select Airline Company :<br><br></html>");
                dialogPanel.add(textLabel, BorderLayout.NORTH);

                dialogPanel.add(optionList, BorderLayout.CENTER);

                int result = JOptionPane.showOptionDialog(null, dialogPanel, "Air UTM Booking System",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (result == JOptionPane.OK_OPTION) {

                    int selectedIndex = optionList.getSelectedIndex();
                    String selectedOption = options[selectedIndex];

                    if (selectedOption.equals("AirAsia")) {
                        StringBuilder displayAirplane1 = new StringBuilder();
                        for (Airplane airplane : airAsiaAirplanes) {
                            displayAirplane1.append(airplane.getPlaneId())
                                    .append(" - Model ").append(airplane.getPlaneModel())
                                    .append(" - Capacity ").append(airplane.getPlaneCapacity())
                                    .append(" - Availability ").append(airplane.getPlaneAvailability())
                                    .append("\n");
                        }
                        JOptionPane.showMessageDialog(null, "AirAsia Airline List\n\n" + displayAirplane1.toString(),
                                "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);
                    } else if (selectedOption.equals("Firefly")) {

                        StringBuilder displayAirplane2 = new StringBuilder();

                        for (Airplane airplane : fireflyAirplanes) {
                            displayAirplane2.append(airplane.getPlaneId())
                                    .append(" - Model ").append(airplane.getPlaneModel())
                                    .append(" - Capacity ").append(airplane.getPlaneCapacity())
                                    .append(" - Availability ").append(airplane.getPlaneAvailability())
                                    .append("\n");
                        }
                        JOptionPane.showMessageDialog(null, "Firefly Airline List\n\n" + displayAirplane2.toString(),
                                "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);
                    } else if (selectedOption.equals("Local Airlines")) {

                        StringBuilder displayAirplane3 = new StringBuilder();

                        for (Airplane airplane : localAirplanes) {
                            displayAirplane3.append(airplane.getPlaneId())
                                    .append(" - Model ").append(airplane.getPlaneModel())
                                    .append(" - Capacity ").append(airplane.getPlaneCapacity())
                                    .append(" - Availability ").append(airplane.getPlaneAvailability())
                                    .append("\n");
                        }
                        JOptionPane.showMessageDialog(null, "Local Airline List\n\n" + displayAirplane3.toString(),
                                "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Handle unexpected option selection
                        System.out.println("Unknown option selected");
                    }
                } else {
                    // User canceled the dialog
                    System.out.println("Dialog canceled");
                }
            }

            else if (option == 8) {

                String[] optionDepart = { "KLIA2", "Johor", "Sabah" };
                JComboBox<String> optionDepartList = new JComboBox<>(optionDepart);
                optionDepartList.setSelectedIndex(0);

                String[] optionArrival = { "KLIA2", "Johor", "Sabah" };
                JComboBox<String> optionArrivalList = new JComboBox<>(optionArrival);
                optionArrivalList.setSelectedIndex(0);

                JPanel dialogPanel = new JPanel();
                dialogPanel.setLayout(new GridLayout(3, 2, 8, 8)); // Use GridLayout with 2 rows and 2 columns

                JLabel textFlightSelectLabel = new JLabel("<html>Search Flight :<br><br></html>");
                JLabel textFlightSelect2Label = new JLabel("<html><br></html>");
                dialogPanel.add(textFlightSelectLabel);
                dialogPanel.add(textFlightSelect2Label);

                JLabel textDepartLabel = new JLabel("<html>Select Departure Location<br><br></html>");
                dialogPanel.add(textDepartLabel);
                dialogPanel.add(optionDepartList);

                JLabel textArrivalLabel = new JLabel("<html>Select Arrival Location<br><br></html>");
                dialogPanel.add(textArrivalLabel);
                dialogPanel.add(optionArrivalList);

                int result = JOptionPane.showOptionDialog(null, dialogPanel, "Air UTM Booking System",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (result == JOptionPane.OK_OPTION) {

                    int selectedDepartIndex = optionDepartList.getSelectedIndex();
                    String selectedDepartOption = optionDepart[selectedDepartIndex];

                    int selectedArrivalIndex = optionArrivalList.getSelectedIndex();
                    String selectedArrivalOption = optionArrival[selectedArrivalIndex];

                    if (selectedDepartOption.equals("KLIA2") && selectedArrivalOption.equals("Johor")) {
                        String flightInfo = "Flight " + flight2.getDepartureLocation() + " -> "
                                + flight2.getArrivalLocation() + "\n\n";

                        Object[][] tableData = new Object[flight2.getAirplanes().size()
                                + flight3.getAirplanes().size()][6];

                        int row = 0;
                        for (Flight flight : Arrays.asList(flight2, flight3)) {
                            for (Airplane airplane : flight.getAirplanes()) {
                                tableData[row][0] = flight.getFlightNumber();
                                tableData[row][1] = airplane.getPlaneId();
                                tableData[row][2] = airplane.getPlaneFacturer();
                                tableData[row][3] = airplane.getPlaneCapacity();
                                tableData[row][4] = flight.getDepartureTime();
                                tableData[row][5] = flight.getArrivalTime();
                                row++;
                            }
                        }

                        String[] columnNames = { "Flight No.", "Plane ID", "Manufacturer", "Capacity", "Departure",
                                "Arrival" };

                        JTable table = new JTable(tableData, columnNames);
                        JScrollPane scrollPane = new JScrollPane(table);

                        Object[] messagee = { flightInfo, scrollPane };
                        JOptionPane.showMessageDialog(null, messagee, "Air UTM Booking System",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                    else if (selectedDepartOption.equals("Johor") && selectedArrivalOption.equals("KLIA2")) {

                        String flightInfo = "Flight " + flight1.getDepartureLocation() + " -> "
                                + flight1.getArrivalLocation() + "\n\n";

                        Object[][] tableData = new Object[flight1.getAirplanes().size()][6];

                        int row = 0;
                        for (Flight flight : Arrays.asList(flight1)) {
                            for (Airplane airplane : flight.getAirplanes()) {
                                tableData[row][0] = flight.getFlightNumber();
                                tableData[row][1] = airplane.getPlaneId();
                                tableData[row][2] = airplane.getPlaneFacturer();
                                tableData[row][3] = airplane.getPlaneCapacity();
                                tableData[row][4] = flight.getDepartureTime();
                                tableData[row][5] = flight.getArrivalTime();
                                row++;
                            }
                        }

                        String[] columnNames = { "Flight No.", "Plane ID", "Manufacturer", "Capacity", "Departure",
                                "Arrival" };

                        JTable table = new JTable(tableData, columnNames);
                        JScrollPane scrollPane = new JScrollPane(table);

                        Object[] messagee = { flightInfo, scrollPane };
                        JOptionPane.showMessageDialog(null, messagee, "Air UTM Booking System",
                                JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "No flight(s) available.", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    // User canceled the dialog
                    System.out.println("Dialog canceled");
                }

            } else if (option == 1) {
                // Booking a flight
                try {
                    List<Customer> custo = Customer.loadCustomers("C:\\xampp\\htdocs\\oop\\projectair\\src\\customers.txt", "C:\\xampp\\htdocs\\oop\\projectair\\src\\bookings.txt");
                    if (custo == null || custo.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No customers loaded", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
            
                    // Select Customer Name
                    String[] customerNames = new String[custo.size()];
                    for (int i = 0; i < custo.size(); i++) {
                        customerNames[i] = custo.get(i).getName();
                    }
                    String customerName = (String) JOptionPane.showInputDialog(null, "Select Customer:", "Customer Selection", JOptionPane.QUESTION_MESSAGE, null, customerNames, customerNames[0]);
            
                    Customer selectedCustomer = null;
                    for (Customer customer : custo) {
                        if (customer.getName().equals(customerName)) {
                            selectedCustomer = customer;
                            break;
                        }
                    }
            
                    if (selectedCustomer != null) {
                        // Select Flight Number
                        String[] flightOptions = { flight1.getFlightNumber(), flight2.getFlightNumber(), flight3.getFlightNumber() };
                        String flightNumber = (String) JOptionPane.showInputDialog(null, "Select Flight Number:",
                                "Flight Selection", JOptionPane.QUESTION_MESSAGE, null, flightOptions, flightOptions[0]);
            
                        Flight selectedFlight = null;
                        for (Flight flight : new Flight[] { flight1, flight2, flight3 }) {
                            if (flight.getFlightNumber().equals(flightNumber)) {
                                selectedFlight = flight;
                                break;
                            }
                        }
            
                        if (selectedFlight != null) {
                            // Airplane selection
                            List<Airplane> airplanes = selectedFlight.getAirplanes();
                            String[] airplaneOptions = new String[airplanes.size()];
                            for (int i = 0; i < airplanes.size(); i++) {
                                airplaneOptions[i] = airplanes.get(i).getPlaneFacturer() + " (" + airplanes.get(i).getPlaneModel() + ")";
                            }
                            String selectedAirplane = (String) JOptionPane.showInputDialog(null, "Select Airplane:",
                                    "Airplane Selection", JOptionPane.QUESTION_MESSAGE, null, airplaneOptions, airplaneOptions[0]);
            
                            if (selectedAirplane != null) {
                                String seatNumber = JOptionPane.showInputDialog("Enter seat number:");
                                Ticket ticket = new Ticket(1, seatNumber, "Economy", 299.99, null); // Temporary null for booking
                                Booking booking = new Booking("2024-06-04", "Economy", selectedFlight, selectedCustomer);
                                booking.saveBookingToFile("C:\\xampp\\htdocs\\oop\\projectair\\src\\bookings.txt");
                                ticket.setBooking(booking); // Set the booking for the ticket
            
                                Object[] options = { "Proceed with Payment" };
                                int choice = JOptionPane.showOptionDialog(null,
                                        "------ Flight booking details ------\n\nName:\t" + selectedCustomer.getName() +
                                                "\nAge:\t\t" + selectedCustomer.getAge() +
                                                "\nGender:\t\t" + selectedCustomer.getGender() +
                                                "\nPassport Number : " + selectedCustomer.getPassportNumber() +
                                                "\n\n" + selectedFlight.getDepartureLocation() + " -> " + selectedFlight.getArrivalLocation() +
                                                "\nAirplane:\t" + selectedAirplane +
                                                "\nSeat Number:\t" + ticket.getSeatNumber() +
                                                "\nClass:\t" + booking.getSeatCategory() +
                                                "\nGate:\t" + selectedFlight.getGate().getGateNumber() + " Terminal " + selectedFlight.getGate().getTerminal(),
                                        "Flight Booking Details", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                                        null, options, options[0]);
            
                                if (choice == 0) {
                                    // Code to handle payment
                                    JOptionPane.showMessageDialog(null, "Proceeding to payment...");
                                    // Get payment details
                                    String paymentMethod = (String) JOptionPane.showInputDialog(null, "Select payment method:",
                                            "Payment Method", JOptionPane.QUESTION_MESSAGE, null, new String[] {"Credit Card", "Debit Card", "E-Wallet"}, "Credit Card");
                                    double amount = ticket.getTicketPrice(); // Assuming the ticket price is the amount to be paid
                                    String paymentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date()); // Current date
            
                                    // Create a new payment
                                    Payment payment = new Payment(1, amount, paymentDate, paymentMethod, booking);
                                    payment.confirmPayment();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Airplane selection cancelled.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Flight not found.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Customer not found.");
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error loading customers and bookings: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            
            else if (option == 4) {
                // View Customer List
                StringBuilder customerInfo = new StringBuilder("Customer List:\n");
                for (Customer customer : customers) {
                    customerInfo.append(customer.getName()).append(" - ").append(customer.getPassportNumber())
                            .append("\n");
                }
                JOptionPane.showMessageDialog(null, customerInfo.toString(), "Air UTM Booking System",
                        JOptionPane.INFORMATION_MESSAGE);

            } else if (option == 5) {
                // View Pilot List
                StringBuilder pilotInfo = new StringBuilder("Pilot List:\n");
                for (Pilot pilot : pilots) {
                    pilotInfo.append(pilot.getName()).append(" - ").append(pilot.getLicenseNumber()).append("\n");
                }
                JOptionPane.showMessageDialog(null, pilotInfo.toString(), "Air UTM Booking System",
                        JOptionPane.INFORMATION_MESSAGE);

            } else if (option == 6) {
                // View Crew Member List
                StringBuilder crewInfo = new StringBuilder("Crew Member List:\n");
                for (CrewMember crewMember : crewMembers) {
                    crewInfo.append(crewMember.getName()).append(" - ").append(crewMember.getRole()).append("\n");
                }
                JOptionPane.showMessageDialog(null, crewInfo.toString(), "Air UTM Booking System",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            else if (option == 2) {
                // Load customers and bookings
                try {
                    List<Customer> custo = Customer.loadCustomers("C:\\xampp\\htdocs\\oop\\projectair\\src\\customers.txt", "C:\\xampp\\htdocs\\oop\\projectair\\src\\bookings.txt");
                    if (custo == null || custo.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No customers loaded", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
            
                    String[] customerNames = new String[custo.size()];
                    for (int i = 0; i < custo.size(); i++) {
                        customerNames[i] = custo.get(i).getName();
                    }
            
                    String input = (String) JOptionPane.showInputDialog(null, "Select a customer", "Select Customer", JOptionPane.QUESTION_MESSAGE, null, customerNames, customerNames[0]);
                    if (input != null) {
                        Customer selectedCustomer = null;
                        for (Customer customer : custo) {
                            if (customer.getName().equals(input)) {
                                selectedCustomer = customer;
                                break;
                            }
                        }
            
                        if (selectedCustomer != null) {
                            List<Booking> bookings = selectedCustomer.getBookings();
                            if (bookings.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "No bookings found for selected customer", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
            
                            String[] bookingDescriptions = new String[bookings.size()];
                            for (int i = 0; i < bookings.size(); i++) {
                                bookingDescriptions[i] = bookings.get(i).getDescription();
                            }
            
                            String bookingInput = (String) JOptionPane.showInputDialog(null, "Select a booking", "Select Booking", JOptionPane.QUESTION_MESSAGE, null, bookingDescriptions, bookingDescriptions[0]);
                            if (bookingInput != null) {
                                Booking selectedBooking = null;
                                for (Booking booking : bookings) {
                                    if (booking.getDescription().equals(bookingInput)) {
                                        selectedBooking = booking;
                                        break;
                                    }
                                }
            
                                if (selectedBooking != null) {
                                    StringBuilder mealInfo = new StringBuilder("Meal List:\n");
                                    Meal[] meals = { meal1, meal2, meal3, meal4, meal5 };
                                    for (Meal meal : meals) {
                                        mealInfo.append(meal.getMealId())
                                                .append(" - ")
                                                .append(meal.getMealType())
                                                .append(" (")
                                                .append(meal.getDietaryRestrictions())
                                                .append(") - RM")
                                                .append(meal.getPrice())
                                                .append("\n");
                                    }
            
                                    String mealInput = (String) JOptionPane.showInputDialog(null, mealInfo.toString() + "\nSelect a meal by ID:", "Select Meal", JOptionPane.QUESTION_MESSAGE, null, null, null);
                                    if (mealInput != null) {
                                        Meal selectedMeal = null;
                                        try {
                                            int mealId = Integer.parseInt(mealInput);
                                            for (Meal meal : meals) {
                                                if (meal.getMealId() == mealId) {
                                                    selectedMeal = meal;
                                                    break;
                                                }
                                            }
            
                                            if (selectedMeal != null) {
                                                selectedMeal.setCustomer(selectedCustomer);
                                                selectedBooking.addMeal(selectedMeal);
            
                                                JOptionPane.showMessageDialog(null, "Meal ordered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                                                // Print customer, booking, and meal details
                                                StringBuilder details = new StringBuilder();
                                                details.append("Customer Details:\n");
                                                details.append("Name: ").append(selectedCustomer.getName()).append("\n");
                                                details.append("Phone: ").append(selectedCustomer.getPhoneNumber()).append("\n\n");
            
                                                details.append("Booking Details:\n");
                                                details.append("Description: ").append(selectedBooking.getDescription()).append("\n");
                                                /*details.append("Departure: ").append(selectedBooking.getDeparture()).append("\n");
                                                details.append("Arrival: ").append(selectedBooking.getArrival()).append("\n");
                                                details.append("Date: ").append(selectedBooking.getDate()).append("\n");
                                                details.append("Price: $").append(selectedBooking.getPrice()).append("\n\n");*/
            
                                                details.append("\nMeal Details:\n");
                                                details.append("Meal ID: ").append(selectedMeal.getMealId()).append("\n");
                                                details.append("Type: ").append(selectedMeal.getMealType()).append("\n");
                                                details.append("Dietary Restrictions: ").append(selectedMeal.getDietaryRestrictions()).append("\n");
                                                details.append("Price: RM").append(selectedMeal.getPrice()).append("\n");
            
                                                JOptionPane.showMessageDialog(null, details.toString(), "Booking Details", JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Meal not found.", "Error", JOptionPane.ERROR_MESSAGE);
                                            }
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "Invalid meal ID input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Booking not found.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Customer not found.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error loading customers and bookings: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (option == 32) { // Add baggage details for existing booking
                try {
                    List<Customer> custo = Customer.loadCustomers("C:\\xampp\\htdocs\\oop\\projectair\\src\\customers.txt", "C:\\xampp\\htdocs\\oop\\projectair\\src\\bookings.txt");
                    if (custo == null || custo.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No customers loaded", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
            
                    String[] customerNames = new String[custo.size()];
                    for (int i = 0; i < custo.size(); i++) {
                        customerNames[i] = custo.get(i).getName();
                    }
            
                    String input = (String) JOptionPane.showInputDialog(null, "Select a customer", "Select Customer", JOptionPane.QUESTION_MESSAGE, null, customerNames, customerNames[0]);
                    if (input != null) {
                        Customer selectedCustomer = null;
                        for (Customer customer : customers) {
                            if (customer.getName().equals(input)) {
                                selectedCustomer = customer;
                                break;
                            }
                        }
            
                        if (selectedCustomer != null) {
                            List<Booking> bookings = selectedCustomer.getBookings();
                            if (bookings.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "No bookings found for selected customer", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
            
                            String[] bookingDescriptions = new String[bookings.size()];
                            for (int i = 0; i < bookings.size(); i++) {
                                bookingDescriptions[i] = bookings.get(i).getDescription();
                            }
            
                            String bookingInput = (String) JOptionPane.showInputDialog(null, "Select a booking", "Select Booking", JOptionPane.QUESTION_MESSAGE, null, bookingDescriptions, bookingDescriptions[0]);
                            if (bookingInput != null) {
                                Booking selectedBooking = null;
                                for (Booking booking : bookings) {
                                    if (booking.getDescription().equals(bookingInput)) {
                                        selectedBooking = booking;
                                        break;
                                    }
                                }
            
                                if (selectedBooking != null) {
                                    String weightInput = JOptionPane.showInputDialog("Enter baggage weight (in kg):");
                                    try {
                                        double weight = Double.parseDouble(weightInput);
                                        String baggageType = (String) JOptionPane.showInputDialog(null, "Select baggage type:", "Baggage Type", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Checked", "Hand Carry", "Special"}, "Checked");
            
                                        Baggage baggage = new Baggage(1, weight, baggageType, selectedBooking);
                                        selectedBooking.addBaggage(baggage);
            
                                        JOptionPane.showMessageDialog(null, "Baggage details added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                                        // Print customer, booking, and baggage details
                                        StringBuilder details = new StringBuilder();
                                        details.append("Customer Details:\n");
                                        details.append("Name: ").append(selectedCustomer.getName()).append("\n");
                                        details.append("Phone: ").append(selectedCustomer.getPhoneNumber()).append("\n\n");

                                        details.append("Booking Details:\n");
                                        details.append("Description: ").append(selectedBooking.getDescription()).append("\n");
                                        /*details.append("Departure: ").append(selectedBooking.getDeparture()).append("\n");
                                        details.append("Arrival: ").append(selectedBooking.getArrival()).append("\n");
                                        details.append("Date: ").append(selectedBooking.getDate()).append("\n");
                                        details.append("Price: $").append(selectedBooking.getPrice()).append("\n\n");*/

                                        details.append("Baggage Details:\n");
                                        details.append("Weight: ").append(baggage.getWeight()).append(" kg\n");
                                        details.append("Type: ").append(baggage.getBaggageType()).append("\n");

                                        JOptionPane.showMessageDialog(null, details.toString(), "Booking Details", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    
                                     catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Invalid weight input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Booking not found.", "Error", JOptionPane.ERROR_MESSAGE);
                                        
                                    
                                } } else {
                                    JOptionPane.showMessageDialog(null, "Customer not found.", "Error",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid customer selection: " + input, "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        } }
                     catch (IOException e) {
                        System.out.println("Error loading customers, please try" + e.getMessage());
                    }  
               
        } 

        else if (option == 9) { // Display booking details for a selected customer
            try {
                List<Customer> custo = Customer.loadCustomers("C:\\xampp\\htdocs\\oop\\projectair\\src\\customers.txt", "C:\\xampp\\htdocs\\oop\\projectair\\src\\bookings.txt");
                if (custo == null || custo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No customers loaded", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                String[] customerNames = new String[custo.size()];
                for (int i = 0; i < custo.size(); i++) {
                    customerNames[i] = customers.get(i).getName();
                }
        
                String input = (String) JOptionPane.showInputDialog(null, "Select a customer", "Select Customer", JOptionPane.QUESTION_MESSAGE, null, customerNames, customerNames[0]);
                if (input != null) {
                    Customer selectedCustomer = null;
                    for (Customer customer : customers) {
                        if (customer.getName().equals(input)) {
                            selectedCustomer = customer;
                            break;
                        }
                    }
        
                    if (selectedCustomer != null) {
                        List<Booking> bookings = selectedCustomer.getBookings();
                        if (bookings.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No bookings found for selected customer", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
        
                        String[] bookingDescriptions = new String[bookings.size()];
                        for (int i = 0; i < bookings.size(); i++) {
                            bookingDescriptions[i] = bookings.get(i).getDescription();
                        }
        
                        String bookingInput = (String) JOptionPane.showInputDialog(null, "Select a booking", "Select Booking", JOptionPane.QUESTION_MESSAGE, null, bookingDescriptions, bookingDescriptions[0]);
                        if (bookingInput != null) {
                            Booking selectedBooking = null;
                            for (Booking booking : bookings) {
                                if (booking.getDescription().equals(bookingInput)) {
                                    selectedBooking = booking;
                                    break;
                                }
                            }
        
                            if (selectedBooking != null) {
                                StringBuilder details = new StringBuilder();
                                details.append("Customer Details:\n");
                                details.append("Name: ").append(selectedCustomer.getName()).append("\n");
                                details.append("Phone: ").append(selectedCustomer.getPhoneNumber()).append("\n\n");
        
                                details.append("Booking Details:\n");
                                details.append("Description: ").append(selectedBooking.getDescription()).append("\n");
                                // Add more booking details here as needed
        
                                JOptionPane.showMessageDialog(null, details.toString(), "Booking Details", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Booking not found.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid booking selection", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Customer not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid customer selection", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error loading customers, please try again: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        

        else if (option == 10) {
             JOptionPane.showMessageDialog(null, "Thank you for using Air UTM Booking System!", "Goodbye",
                JOptionPane.INFORMATION_MESSAGE);
            break;
               

    } else {
            // Handle invalid option
            JOptionPane.showMessageDialog(null, "Invalid option. Please select a valid option.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        }
     } // The scanner will be closed automatically here
    

    



    
    private static CrewMember findCrewMemberByNameAndId(List<CrewMember> crewMembers, String name, String id) {
        for (CrewMember crewMember : crewMembers) {
            if (crewMember.getName().equalsIgnoreCase(name) && crewMember.getIdNumber().equalsIgnoreCase(id)) {
                return crewMember;
            }
        }
        return null;
    }
}

