import javax.swing.*;

public class AirlineManagementSystem {
    public static void main(String[] args) {
        // Sample data
        Airplane airplane = new Airplane(1, "Boeing 747", "Boeing", 400, true);
        Flight flight = new Flight(101, "AA123", "10:00 AM", "1:00 PM", "New York", "Los Angeles", airplane);
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
