import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.awt.GridLayout;
import java.awt.BorderLayout;

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
        for (Airplane airplane : new Airplane[] { airplane1, airplane2, airplane3, airplane4, airplane5 }) {
            if (airplane.getPlaneFacturer().equals("AirAsia")) {
                airAsiaAirplanes.add(airplane);
            } else if (airplane.getPlaneFacturer().equals("Firefly")) {
                fireflyAirplanes.add(airplane);
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
            customers = Customer.loadCustomers("projectair/src/Customers.txt");
            pilots = Pilot.loadPilots("projectair\\src\\pilots.txt");
            crewMembers = CrewMember.loadCrewMembers("projectair\\src\\crew.txt");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }

        try (Scanner scanner = new Scanner(System.in)) { // Try-with-resources statement
            String message = "Welcome to Air UTM Booking System !";
            JOptionPane.showMessageDialog(null, message, "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);

            String message1 = "[1] Display Airline List\n"
                    + "[2] Display Flight List\n"
                    + "[3] Book a Flight\n"
                    + "[4] View Customer List\n"
                    + "[5] View Pilot List\n"
                    + "[6] View Crew Member List\n"
                    + "[7] Meal";

            String optionInput = JOptionPane.showInputDialog(null, message1, "Enter your option");
            int option = Integer.parseInt(optionInput);

            if (option == 1) {

                String[] options = { "AirAsia", "Firefly" };
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
                    } else {
                        // Handle unexpected option selection
                        System.out.println("Unknown option selected");
                    }
                } else {
                    // User canceled the dialog
                    System.out.println("Dialog canceled");
                }
            }

            else if (option == 2) {

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

            } else if (option == 3) {
                // Booking a flight
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
                        String customerName = JOptionPane.showInputDialog("Enter your name:");
                        String seatNumber = JOptionPane.showInputDialog("Enter seat number:");
                        Customer customer = findCustomerByName(customers, customerName);
                        if (customer == null) {
                            JOptionPane.showMessageDialog(null, "Customer not found.");
                            return;
                        }
            
                        Ticket ticket = new Ticket(1, seatNumber, "Economy", 299.99, null); // Temporary null for booking
                        Booking booking = new Booking(1, "2024-06-04", "Economy", selectedFlight, customer);
                        ticket.setBooking(booking); // Set the booking for the ticket
            
                        Object[] options = { "Proceed with Payment" };
                        int choice = JOptionPane.showOptionDialog(null,
                                "------ Flight booking details ------\n\nName:\t" + customer.getName() +
                                        "\nAge:\t\t" + customer.getAge() +
                                        "\nGender:\t\t" + customer.getGender() +
                                        "\nPassport Number : " + customer.getPassportNumber() +
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
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Airplane selection cancelled.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Flight not found.");
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

            if (option == 7) {
                // View Meal List
                StringBuilder mealInfo = new StringBuilder("Meal List:\n");
                for (Meal meal : new Meal[] { meal1, meal2, meal3, meal4, meal5 }) {
                    mealInfo.append(meal.getMealId())
                            .append(" - ")
                            .append(meal.getMealType())
                            .append(" (")
                            .append(meal.getDietaryRestrictions())
                            .append(") - RM")
                            .append(meal.getPrice())
                            .append("\n");
                }
                JOptionPane.showMessageDialog(null, mealInfo.toString(), "Air UTM Booking System",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        } // The scanner will be closed automatically here
    }

    private static Customer findCustomerByName(List<Customer> customers, String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }
}
