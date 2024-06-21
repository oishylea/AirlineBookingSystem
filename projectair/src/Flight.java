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
    private Gate gate;

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
            sb.append("Airplane ID:\t").append(airplane.getPlaneId()) 
              .append(", Model:\t").append(airplane.getPlaneModel())
              .append(", Manufacturer:\t").append(airplane.getPlaneFacturer())
              .append(", Capacity:\t").append(airplane.getPlaneCapacity())
              .append(", Availability:\t").append(airplane.getPlaneAvailability())
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
    public Gate getGate() { return gate; }
    

    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }
    public void setDepartureLocation(String departureLocation) { this.departureLocation = departureLocation; }
    public void setArrivalLocation(String arrivalLocation) { this.arrivalLocation = arrivalLocation; }
    public void setAirplanes(List<Airplane> airplanes) { this.airplanes = airplanes; }
    public void setGate(Gate gate) { this.gate = gate; }


}