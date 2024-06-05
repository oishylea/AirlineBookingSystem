public class Ticket {
    private int ticketId;
    private String seatNumber;
    private String classType;
    private double ticketPrice;
    private Booking booking;

    // Constructors
    public Ticket() {}

    public Ticket(int ticketId, String seatNumber, String classType, double ticketPrice, Booking booking) {
        this.ticketId = ticketId;
        this.seatNumber = seatNumber;
        this.classType = classType;
        this.ticketPrice = ticketPrice;
        this.booking = booking;
    }

    // Getters and Setters
    public int getTicketId() { return ticketId; }
    public String getSeatNumber() { return seatNumber; }
    public String getClassType() { return classType; }
    public double getTicketPrice() { return ticketPrice; }
    public Booking getBooking() { return booking; }
    
    public void setTicketId(int ticketId) { this.ticketId = ticketId; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }
    public void setClassType(String classType) { this.classType = classType; }
    public void setTicketPrice(double ticketPrice) { this.ticketPrice = ticketPrice; }
    public void setBooking(Booking booking) { this.booking = booking; }

    public void printTicket() {
        System.out.println("Ticket ID: " + ticketId + ", Seat Number: " + seatNumber + ", Class Type: " + classType + ", Ticket Price: " + ticketPrice);
    }
}
