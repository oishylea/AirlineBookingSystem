public class Baggage {
    private int baggageId;
    private double weight;
    private String baggageType;
    private Booking booking;

    // Constructors
    public Baggage() {}

    public Baggage(int baggageId, double weight, String baggageType, Booking booking) {
        this.baggageId = baggageId;
        this.weight = weight;
        this.baggageType = baggageType;
        this.booking = booking;
    }

    // Getters and Setters
    public int getBaggageId() { return baggageId; }
    public double getWeight() { return weight; }
    public String getBaggageType() { return baggageType; }
    public Booking getBooking() { return booking; }
    
    public void setWeight(double weight) { this.weight = weight; }
    public void setBaggageType(String baggageType) { this.baggageType = baggageType; }
    public void setBooking(Booking booking) { this.booking = booking; }

    public void printBaggage() {
        System.out.println("Baggage ID: " + baggageId + ", Weight: " + weight + ", Type: " + baggageType);
    }
}
