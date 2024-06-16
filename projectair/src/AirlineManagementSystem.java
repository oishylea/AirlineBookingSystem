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

        Flight flight1 = new Flight(1, "AF123", "12:00", "14:30", "Johor", "KLIA 2");
        Flight flight2 = new Flight(2, "ED412", "08:00", "10:30", "KLIA 2", "Johor");
        Flight flight3 = new Flight(3, "FG254", "11:30", "14:00", "KLIA 2", "Johor");

        Airplane airplane1 = new Airplane(101, "Airbus A320-200", "AirAsia", 180, true);
        Airplane airplane2 = new Airplane(102, "Airbus A321neo", "AirAsia", 236, true);
        Airplane airplane3 = new Airplane(103, "Boeing 737 MAX 8", "AirAsia", 178, true);
        Airplane airplane4 = new Airplane(104, "ATR 72-600", "Firefly", 72, true);
        Airplane airplane5 = new Airplane(105, "Boeing 737-800", "Firefly", 189, true);

        List<Airplane> airAsiaAirplanes = new ArrayList<>();
        List<Airplane> fireflyAirplanes = new ArrayList<>();
        for (Airplane airplane : new Airplane[] {airplane1, airplane2, airplane3, airplane4, airplane5}) {
            if (airplane.getPlaneFacturer().equals("AirAsia")) {
                airAsiaAirplanes.add(airplane);
            } else if (airplane.getPlaneFacturer().equals("Firefly")) {
                fireflyAirplanes.add(airplane);
            }
        }

        flight1.addAirplane(airplane1);
        flight1.addAirplane(airplane2);
        flight2.addAirplane(airplane3);
        flight2.addAirplane(airplane4);
        flight2.addAirplane(airplane5);
        flight3.addAirplane(airplane1);
        flight3.addAirplane(airplane2);

        Gate gate1 = new Gate (01,"A01","A",flight1);
        Gate gate2 = new Gate (02,"A02","A",flight2);

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

                String[] options = {"AirAsia", "Firefly"};
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
                        JOptionPane.showMessageDialog(null, "AirAsia Airline List\n\n"+displayAirplane1.toString(), "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);
                    } else if (selectedOption.equals("Firefly")) {

                        StringBuilder displayAirplane2 = new StringBuilder();

                        for (Airplane airplane : fireflyAirplanes) {
                            displayAirplane2.append(airplane.getPlaneId())
                            .append(" - Model ").append(airplane.getPlaneModel())
                            .append(" - Capacity ").append(airplane.getPlaneCapacity())
                            .append(" - Availability ").append(airplane.getPlaneAvailability())
                            .append("\n");
                        }
                        JOptionPane.showMessageDialog(null, "Firefly Airline List\n\n"+displayAirplane2.toString(), "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);
                    }
            else {
                        // Handle unexpected option selection
                        System.out.println("Unknown option selected");
                    }
                } else {
                    // User canceled the dialog
                    System.out.println("Dialog canceled");
                }
            } 
            
            
                else if (option == 2) {



                String[] optionDepart = {"KLIA2", "Johor","Sabah"};
                JComboBox<String> optionDepartList = new JComboBox<>(optionDepart);
                optionDepartList.setSelectedIndex(0);
                
                String[] optionArrival = {"KLIA2", "Johor","Sabah"};
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
                        String flightInfo = "Flight " + flight2.getDepartureLocation() + " -> " + flight2.getArrivalLocation() + "\n\n";
                    
                        Object[][] tableData = new Object[flight2.getAirplanes().size() + flight3.getAirplanes().size()][6];
                    
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
                    
                        String[] columnNames = {"Flight No.","Plane ID", "Manufacturer", "Capacity", "Departure", "Arrival"};
                    
                        JTable table = new JTable(tableData, columnNames);
                        JScrollPane scrollPane = new JScrollPane(table);
                    
                        Object[] messagee = {flightInfo, scrollPane};
                        JOptionPane.showMessageDialog(null, messagee, "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    else if (selectedDepartOption.equals("Johor") && selectedArrivalOption.equals("KLIA2")) {

                        StringBuilder airplaneInfo = new StringBuilder();

                        for (Flight flight : new Flight[]{flight1}) {
                                airplaneInfo.append("Flight ").append(flight.getFlightNumber()).append(" : ").append(flight.getDepartureLocation()).append(" -> ").append(flight.getArrivalLocation()).append("\n");
                                for (Airplane airplane : flight.getAirplanes()) {
                                    airplaneInfo.append("- ").append(airplane.getPlaneId()).append(" (").append(airplane.getPlaneFacturer()).append(", Capacity: ").append(airplane.getPlaneCapacity()).append(")\n");
                                }
                                airplaneInfo.append("\n");
                        }
                        JOptionPane.showMessageDialog(null, airplaneInfo.toString(), "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);


                    } else {
                        // Handle any other combination of departure and arrival locations
                        System.out.println("Departure: " + selectedDepartOption + ", Arrival: " + selectedArrivalOption);
                    }
                } else {
                    // User canceled the dialog
                    System.out.println("Dialog canceled");
                }


                
                

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
