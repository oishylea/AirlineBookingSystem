public class Airplane {
    private int planeId;
    private String planeModel;
    private String planeFacturer;
    private int planeCapacity;
    private boolean planeAvailability;

    // Constructors
    public Airplane() {}

    public Airplane(int planeId, String planeModel, String planeFacturer, int planeCapacity, boolean planeAvailability) {
        this.planeId = planeId;
        this.planeModel = planeModel;
        this.planeFacturer = planeFacturer;
        this.planeCapacity = planeCapacity;
        this.planeAvailability = planeAvailability;
    }

    // Getters and Setters
    
    public int getPlaneId() { 
        return planeId; }

    public String getPlaneModel() {
        return planeModel; }

    public String getPlaneFacturer() {
        return planeFacturer; }

    public int getPlaneCapacity() {
        return planeCapacity; }

    public boolean getPlaneAvailability() {
        return planeAvailability; }
    
    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel; }

    public void setPlaneFacturer(String planeFacturer) {
        this.planeFacturer = planeFacturer; }

    public void setPlaneCapacity(int planeCapacity) {
        this.planeCapacity = planeCapacity; }

    public void setPlaneAvailability(boolean planeAvailability) {
        this.planeAvailability = planeAvailability; }

    public void display() {
        System.out.println("Plane ID: " + planeId);
        System.out.println("Plane Model: " + planeModel);
        System.out.println("Plane Manufacturer: " + planeFacturer);
        System.out.println("Plane Capacity: " + planeCapacity);
        System.out.println("Plane Availability: " + planeAvailability);
        }
}
