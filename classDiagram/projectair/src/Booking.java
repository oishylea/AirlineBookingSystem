public class Booking {
    private int bookingId;
    private String bookingDate;
    private String seatCategory;
    private Flight flight;
    private Customer customer;

    // Constructors
    public Booking() {}

    public Booking(int bookingId, String bookingDate, String seatCategory, Flight flight, Customer customer) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.seatCategory = seatCategory;
        this.flight = flight;
        this.customer = customer;
    }

    // Getters and Setters
    public int getBookingId() { return bookingId; }
    public String getBookingDate() { return bookingDate; }
    public String getSeatCategory() { return seatCategory; }
    public Flight getFlight() { return flight; }
    public Customer getCustomer() { return customer; }
    
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }
    public void setSeatCategory(String seatCategory) { this.seatCategory = seatCategory; }
    public void setFlight(Flight flight) { this.flight = flight; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
