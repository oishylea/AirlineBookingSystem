public class Gate {
    private int gateId;
    private String gateNumber;
    private String terminal;
    private Flight flight;

    // Constructors
    public Gate() {}

    public Gate(int gateId, String gateNumber, String terminal, Flight flight) {
        this.gateId = gateId;
        this.gateNumber = gateNumber;
        this.terminal = terminal;
        this.flight = flight;
    }

    // Getters and Setters
    public int getGateId() { 
        return gateId; }

    public String getGateNumber() {
        return gateNumber; }

    public String getTerminal() { 
        return terminal; }

    public Flight getFlight() {
         return flight; }
    
    public void setGateId(int gateId) { 
        this.gateId = gateId; }

    public void setGateNumber(String gateNumber) { 
        this.gateNumber = gateNumber; }

    public void setTerminal(String terminal) {
        this.terminal = terminal; }

    public void setFlight(Flight flight) {
        this.flight = flight; }
}
