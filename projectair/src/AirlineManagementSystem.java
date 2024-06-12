import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class AirlineManagementSystem {
    public static void main(String[] args) {

        Flight flight1 = new Flight(1, "AF123", "08:00", "10:00", "Johor", "KLIA 2");
        Flight flight2 = new Flight(2, "ED412", "08:00", "10:30", "KLIA 2", "Kedah");

        Airplane airplane1 = new Airplane(201, "Boeing 737-800", "Malaysia Airlines", 189, true);
        Airplane airplane2 = new Airplane(202, "Airbus A320", "AirAsia", 180, true);
        Airplane airplane3 = new Airplane(203, "ATR 72-600", "Firefly", 72, true);
        Airplane airplane4 = new Airplane(204, "Boeing 737-800F", "MASkargo", 200, true);
        Airplane airplane5 = new Airplane(205, "Cessna Citation Mustang", "Berjaya Air", 4, true);

        flight1.addAirplane(airplane1);
        flight1.addAirplane(airplane2);
        flight2.addAirplane(airplane3);
        flight2.addAirplane(airplane4);
        flight2.addAirplane(airplane5);

        List<Customer> customers = new ArrayList<>();
        List<Pilot> pilots = new ArrayList<>();
        List<CrewMember> crewMembers = new ArrayList<>();

        try {
            customers = Customer.loadCustomers("C:\\Users\\JEGANATH\\OneDrive\\Documents\\GitHub\\oop\\projectair\\src\\Customers.txt");
            pilots = Pilot.loadPilots("C:\\Users\\JEGANATH\\OneDrive\\Documents\\GitHub\\oop\\projectair\\src\\pilots.txt");
            crewMembers = CrewMember.loadCrewMembers("C:\\Users\\JEGANATH\\OneDrive\\Documents\\GitHub\\oop\\projectair\\src\\crew.text");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }

        try (Scanner scanner = new Scanner(System.in)) {  // Try-with-resources statement
            String message = "Welcome to Air UTM Booking System !";
            JOptionPane.showMessageDialog(null, message, "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);

            String message1 = "[1] Display Airline List\n"
                    + "[2] Display Flight List\n"
                    + "[3] Book a Flight\n"
                    + "[4] View Customer List\n"
                    + "[5] View Pilot List\n"
                    + "[6] View Crew Member List";

            String optionInput = JOptionPane.showInputDialog(null, message1, "Enter your option");
            int option = Integer.parseInt(optionInput);

            if (option == 1) {

                String[] options = {"Flight 1", "Flight 2"};
                JComboBox<String> optionList = new JComboBox<>(options);
                optionList.setSelectedIndex(0);

                int result = JOptionPane.showOptionDialog(null, optionList, "Air UTM Booking System",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (result == JOptionPane.OK_OPTION) {
                    // User selected an option from the dropdown
                    int selectedIndex = optionList.getSelectedIndex();
                    String selectedOption = options[selectedIndex];

                    if (selectedOption.equals("Flight 1")) {
                        String displayAirplane1 = flight1.displayAllAirplanes();
                        JOptionPane.showMessageDialog(null, displayAirplane1, "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);

                    } else if (selectedOption.equals("Flight 2")) {
                        String displayAirplane2 = flight2.displayAllAirplanes();
                        JOptionPane.showMessageDialog(null, displayAirplane2, "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Handle unexpected option selection
                        System.out.println("Unknown option selected");
                    }
                } else {
                    // User canceled the dialog
                    System.out.println("Dialog canceled");
                }
            } else if (option == 2) {

                StringBuilder airplaneInfo = new StringBuilder();

                for (Flight flight : new Flight[]{flight1, flight2}) {
                    airplaneInfo.append("Flight ").append(flight.getFlightNumber()).append(" : ").append(flight.getDepartureLocation()).append(" -> ").append(flight.getArrivalLocation()).append("\n");
                    for (Airplane airplane : flight.getAirplanes()) {
                        airplaneInfo.append("- ").append(airplane.getPlaneId()).append(" (").append(airplane.getPlaneFacturer()).append(", Capacity: ").append(airplane.getPlaneCapacity()).append(")\n");
                    }
                    airplaneInfo.append("\n");
                }

                JOptionPane.showMessageDialog(null, airplaneInfo.toString(), "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);

            } else if (option == 3) {
                // Booking a flight
                String flightNumber = JOptionPane.showInputDialog("Enter Flight Number:");
                Flight selectedFlight = null;

                for (Flight flight : new Flight[]{flight1, flight2}) {
                    if (flight.getFlightNumber().equals(flightNumber)) {
                        selectedFlight = flight;
                        break;
                    }
                }

                if (selectedFlight != null) {
                    String customerName = JOptionPane.showInputDialog("Enter your name:");
                    String seatNumber = JOptionPane.showInputDialog("Enter seat number:");
                    Customer customer = findCustomerByName(customers, customerName);
                    if (customer == null) {
                        JOptionPane.showMessageDialog(null, "Customer not found.");
                        return;
                    }
                    Ticket ticket = new Ticket(1, seatNumber, "Economy", 299.99, null);  // Temporary null for booking
                    Booking booking = new Booking(1, "2024-06-04", "Economy", selectedFlight, customer);
                    ticket.setBooking(booking);  // Set the booking for the ticket

                    JOptionPane.showMessageDialog(null, "Flight booked successfully for " + customer.getName() +
                            "\nFlight Number: " + selectedFlight.getFlightNumber() +
                            "\nSeat Number: " + ticket.getSeatNumber());
                } else {
                    JOptionPane.showMessageDialog(null, "Flight not found.");
                }
            } else if (option == 4) {
                // View Customer List
                StringBuilder customerInfo = new StringBuilder("Customer List:\n");
                for (Customer customer : customers) {
                    customerInfo.append(customer.getName()).append(" - ").append(customer.getPassportNumber()).append("\n");
                }
                JOptionPane.showMessageDialog(null, customerInfo.toString(), "Customer List", JOptionPane.INFORMATION_MESSAGE);

            } else if (option == 5) {
                // View Pilot List
                StringBuilder pilotInfo = new StringBuilder("Pilot List:\n");
                for (Pilot pilot : pilots) {
                    pilotInfo.append(pilot.getName()).append(" - ").append(pilot.getLicenseNumber()).append("\n");
                }
                JOptionPane.showMessageDialog(null, pilotInfo.toString(), "Pilot List", JOptionPane.INFORMATION_MESSAGE);

            } else if (option == 6) {
                // View Crew Member List
                StringBuilder crewInfo = new StringBuilder("Crew Member List:\n");
                for (CrewMember crewMember : crewMembers) {
                    crewInfo.append(crewMember.getName()).append(" - ").append(crewMember.getRole()).append("\n");
                }
                JOptionPane.showMessageDialog(null, crewInfo.toString(), "Crew Member List", JOptionPane.INFORMATION_MESSAGE);
            }
        }  // The scanner will be closed automatically here
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
