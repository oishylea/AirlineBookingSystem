public class Flight {
    private int flightId;
    private String flightNumber;
    private String departureTime;
    private String arrivalTime;
    private String departureLocation;
    private String arrivalLocation;
    private Airplane airplane;

    // Constructors
    public Flight() {}

    public Flight(int flightId, String flightNumber, String departureTime, String arrivalTime, String departureLocation, String arrivalLocation, Airplane airplane) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.airplane = airplane;
    }

    // Getters and Setters
    public int getFlightId() { return flightId; }
    public String getFlightNumber() { return flightNumber; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalTime() { return arrivalTime; }
    public String getDepartureLocation() { return departureLocation; }
    public String getArrivalLocation() { return arrivalLocation; }
    public Airplane getAirplane() { return airplane; }
    
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }
    public void setDepartureLocation(String departureLocation) { this.departureLocation = departureLocation; }
    public void setArrivalLocation(String arrivalLocation) { this.arrivalLocation = arrivalLocation; }
    public void setAirplane(Airplane airplane) { this.airplane = airplane; }
}
