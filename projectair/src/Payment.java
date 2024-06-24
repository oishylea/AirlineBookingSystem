import javax.swing.JOptionPane;

public class Payment {
    private int paymentId;
    private double amount;
    private String paymentDate;
    private String paymentMethod;
    private Booking booking;

    // Constructors
    public Payment() {}

    public Payment(int paymentId, double amount, String paymentDate, String paymentMethod, Booking booking) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.booking = booking;
    }

    // Getters and Setters
    public int getPaymentId() { return paymentId; }
    public double getAmount() { return amount; }
    public String getPaymentDate() { return paymentDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public Booking getBooking() { return booking; }
    
    public void setAmount(double amount) { this.amount = amount; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public void setBooking(Booking booking) { this.booking = booking; }
    public void confirmPayment() {
        String message = "Payment Confirmation:\n"
                + "Payment ID: " + paymentId + "\n"
                + "Amount: $" + amount + "\n"
                + "Payment Date: " + paymentDate + "\n"
                + "Payment Method: " + paymentMethod + "\n"
                + "Booking Details:\n"
                + "  Flight Number: " + booking.getFlight().getFlightNumber() + "\n"
                + "  Departure Location: " + booking.getFlight().getDepartureLocation() + "\n"
                + "  Arrival Location: " + booking.getFlight().getArrivalLocation() + "\n"
                + "  Seat Category: " + booking.getSeatCategory() + "\n"
                + "Payment successful. The booking has been confirmed.";

        JOptionPane.showMessageDialog(null, message, "Payment Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }
}
