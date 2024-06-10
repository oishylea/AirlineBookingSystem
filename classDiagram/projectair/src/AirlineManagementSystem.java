import javax.swing.*;
import java.util.Scanner;


public class AirlineManagementSystem {
    public static void main(String[] args) {
        // Sample data
        Scanner scanner = new Scanner(System.in);
        String message = "Welcome to Air UTM Booking System !";
        JOptionPane.showMessageDialog(null, message, "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);


        String message1 = "[1] Display Airline List\n"
                        + "[2] Display Flight List\n"
                        + "[3] Book a Flight";

        String optionInput = JOptionPane.showInputDialog(null, message1, "Select the option:");
        int option = Integer.parseInt(optionInput);


        Flight flight = new Flight(1, "AF123", "08:00", "10:00", "Paris", "New York");

        // Create instances of the necessary classes
        Airplane airplane1 = new Airplane(201, "Boeing 737-800", "Malaysia Airlines", 189, true);
        Airplane airplane2 = new Airplane(202, "Airbus A320", "AirAsia", 180, true);
        Airplane airplane3 = new Airplane(203, "ATR 72-600", "Firefly", 72, true);
        Airplane airplane4 = new Airplane(204, "Boeing 737-800F", "MASkargo", 20000, true);
        Airplane airplane5 = new Airplane(205, "Cessna Citation Mustang", "Berjaya Air", 4, true);

        flight.addAirplane(airplane1);
        flight.addAirplane(airplane2);
        flight.addAirplane(airplane3);
        flight.addAirplane(airplane4);
        flight.addAirplane(airplane5);

        String displayAirplane = flight.displayAllAirplanes();
        JOptionPane.showMessageDialog(null, displayAirplane, "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);




        Customer customer = new Customer("John Doe", "Male", 30, "ID12345", "123-456-7890", "P12345678");
        Booking booking = new Booking(201, "2024-06-04", "Economy", flight, customer);
        Baggage baggage = new Baggage(301, 23.5, "Checked", booking);
        Payment payment = new Payment(401, 500.00, "2024-06-01", "Credit Card", booking);
        Meal meal = new Meal(501, "Vegetarian", "None", 15.00, customer);
        Ticket ticket = new Ticket(601, "12A", "Economy", 500.00, booking);
        Gate gate = new Gate(701, "G12", "Terminal 3", flight);
        Pilot pilot = new Pilot("Alice Smith", "Female", 45, "ID67890", "987-654-3210", "LN12345", 20);
        CrewMember crewMember = new CrewMember("Bob Johnson", "Male", 35, "ID54321", "654-321-9876", "Flight Attendant");

        // Display booking information
        String bookingInfo = "Booking ID: " + booking.getBookingId() +
                             "\nBooking Date: " + booking.getBookingDate() +
                             "\nSeat Category: " + booking.getSeatCategory() +
                             "\nFlight Number: " + booking.getFlight().getFlightNumber() +
                             "\nCustomer Name: " + booking.getCustomer().getName() +
                             "\nBaggage Weight: " + baggage.getWeight() +
                             "\nPayment Amount: $" + payment.getAmount() +
                             "\nMeal Type: " + meal.getMealType() +
                             "\nTicket Seat Number: " + ticket.getSeatNumber() +
                             "\nGate Number: " + gate.getGateNumber() +
                             "\nPilot Name: " + pilot.getName() +
                             "\nCrew Member Role: " + crewMember.getRole();
        
        JOptionPane.showMessageDialog(null, bookingInfo, "Booking Information", JOptionPane.INFORMATION_MESSAGE);
    }
}