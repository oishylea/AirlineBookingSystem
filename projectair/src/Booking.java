import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private int bookingId;
    private static int nextBookingId = 1;
    private String bookingDate;
    private String seatCategory;
    private Flight flight;
    private Customer customer;
    private List<Baggage> baggageList;
    private List<Meal> mealList; 


    // Constructors
    public Booking() {
        this.baggageList = new ArrayList<>();
        this.mealList = new ArrayList<>();
    }

    public Booking(String bookingDate, String seatCategory, Flight flight, Customer customer) {
        this.bookingId = nextBookingId++;
        this.bookingDate = bookingDate;
        this.seatCategory = seatCategory;
        this.flight = flight;
        this.customer = customer;
        this.baggageList = new ArrayList<>();
        this.mealList = new ArrayList<>(); 
    }

    // Getters and Setters
    public int getBookingId() { return bookingId; }
    public String getBookingDate() { return bookingDate; }
    public String getSeatCategory() { return seatCategory; }
    public Flight getFlight() { return flight; }
    public Customer getCustomer() { return customer; }
    public String getDescription() {
        return "Booking ID: " + bookingId + " \nFlight Details: " + bookingDate + " \nSeat Category: " + seatCategory + " \nFlight: " + flight.getFlightNumber();
    }

    public void setBookingId(int bookingId) { this.bookingId = bookingId; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }
    public void setSeatCategory(String seatCategory) { this.seatCategory = seatCategory; }
    public void setFlight(Flight flight) { this.flight = flight; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    // Add a method to add baggage
    public void addBaggage(Baggage baggage) {
        this.baggageList.add(baggage);
    }

    // Add a method to get the baggage list
    public List<Baggage> getBaggageList() {
        return this.baggageList;
    }

    // Add a method to add meal
    public void addMeal(Meal meal) {
        this.mealList.add(meal);
    }

    // Add a method to get the meal list
    public List<Meal> getMealList() {
        return this.mealList;
    }

    public void saveBookingToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(this.getBookingId() + "," + this.getCustomer().getName() + "," + this.getFlight().getFlightNumber() + "," + this.getSeatCategory());
        } catch (IOException e) {
            System.out.println("Error saving booking to file: " + e.getMessage());
        }
    }
}
