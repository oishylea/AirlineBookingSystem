import java.util.ArrayList;
import java.util.List;

public class Flight {
    private int flightId;
    private String flightNumber;
    private String departureTime;
    private String arrivalTime;
    private String departureLocation;
    private String arrivalLocation;
    private List<Airplane> airplanes;

    // Constructors
    public Flight() {
        this.airplanes = new ArrayList<>();
    }

    public Flight(int flightId, String flightNumber, String departureTime, String arrivalTime, String departureLocation, String arrivalLocation) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.airplanes = new ArrayList<>();
    }

    public void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }

    public String displayAllAirplanes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Airplanes in Flight ").append(this.getFlightId()).append(":\n\n");
        for (Airplane airplane : airplanes) {
            sb.append("Airplane ID: ").append(airplane.getPlaneId())
              .append(", Model: ").append(airplane.getPlaneModel())
              .append(", Manufacturer: ").append(airplane.getPlaneFacturer())
              .append(", Capacity: ").append(airplane.getPlaneCapacity())
              .append(", Availability: ").append(airplane.getPlaneAvailability())
              .append("\n");
        }
        return sb.toString();
    }

    // Getters and Setters
    public int getFlightId() { return flightId; }
    public String getFlightNumber() { return flightNumber; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalTime() { return arrivalTime; }
    public String getDepartureLocation() { return departureLocation; }
    public String getArrivalLocation() { return arrivalLocation; }
    public List<Airplane> getAirplanes() { return airplanes; }

    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }
    public void setDepartureLocation(String departureLocation) { this.departureLocation = departureLocation; }
    public void setArrivalLocation(String arrivalLocation) { this.arrivalLocation = arrivalLocation; }
    public void setAirplanes(List<Airplane> airplanes) { this.airplanes = airplanes; }
}