import javax.swing.*;
import java.util.List;
import java.util.Scanner;


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




        Scanner scanner = new Scanner(System.in);
        String message = "Welcome to Air UTM Booking System !";
        JOptionPane.showMessageDialog(null, message, "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);

        String message1 = "[1] Display Airline List\n"
                        + "[2] Display Flight List\n"
                        + "[3] Book a Flight";

        String optionInput = JOptionPane.showInputDialog(null, message1, "Enter your option");
        int option = Integer.parseInt(optionInput);

        if (option == 1){



            String displayAirplane1 = flight1.displayAllAirplanes();
            String displayAirplane2 = flight2.displayAllAirplanes();

            JOptionPane.showMessageDialog(null, displayAirplane1, "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, displayAirplane2, "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);

        }

        else if (option ==2){

            StringBuilder airplaneInfo = new StringBuilder();

            for (Flight flight : new Flight[]{flight1, flight2}) {
                airplaneInfo.append("Flight ").append(flight.getFlightNumber()).append(" : ").append(flight.getDepartureLocation()+" -> ").append(flight.getArrivalLocation()+"\n");
                for (Airplane airplane : flight.getAirplanes()) {
                    airplaneInfo.append("- ").append(airplane.getPlaneId()).append(" (").append(airplane.getPlaneFacturer()).append(", Capacity: ").append(airplane.getPlaneCapacity()).append(")\n");
                }
                airplaneInfo.append("\n");
            }

            JOptionPane.showMessageDialog(null, airplaneInfo.toString(), "Air UTM Booking System", JOptionPane.INFORMATION_MESSAGE);
                
        }


        Customer customer = new Customer("John Doe", "Male", 30, "ID12345", "123-456-7890", "P12345678");
        Booking booking = new Booking(201, "2024-06-04", "Economy", flight1, customer);
        Baggage baggage = new Baggage(301, 23.5, "Checked", booking);
        Payment payment = new Payment(401, 500.00, "2024-06-01", "Credit Card", booking);
        Meal meal = new Meal(501, "Vegetarian", "None", 15.00, customer);
        Ticket ticket = new Ticket(601, "12A", "Economy", 500.00, booking);
        Gate gate = new Gate(701, "G12", "Terminal 3", flight1);
        Pilot pilot = new Pilot("Alice Smith", "Female", 45, "ID67890", "987-654-3210", "LN12345", 20);
        CrewMember crewMember = new CrewMember("Bob Johnson", "Male", 35, "ID54321", "654-321-9876", "Flight Attendant");

        // Display booking information
        String bookingInfo = "Booking ID:\t\t" + booking.getBookingId() +
                             "\nBooking Date:\t" + booking.getBookingDate() +
                             "\nSeat Category:\t" + booking.getSeatCategory() +
                             "\nFlight Number:\t" + booking.getFlight().getFlightNumber() +
                             "\nCustomer Name:\t" + booking.getCustomer().getName() +
                             "\nBaggage Weight:\t" + baggage.getWeight() +
                             "\nPayment Amount:\t$" + payment.getAmount() +
                             "\nMeal Type:\t" + meal.getMealType() +
                             "\nTicket Seat Number:\t" + ticket.getSeatNumber() +
                             "\nGate Number:\t" + gate.getGateNumber() +
                             "\nPilot Name:\t" + pilot.getName() +
                             "\nCrew Member Role:\t" + crewMember.getRole();
        
        JOptionPane.showMessageDialog(null, bookingInfo, "Booking Information", JOptionPane.INFORMATION_MESSAGE);
    }
}