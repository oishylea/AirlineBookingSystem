public class CrewMember extends Person {
    private String role;

    // Constructors
    public CrewMember() {}

    public CrewMember(String name, String gender, int age, String idNumber, String phoneNumber, String role) {
        super(name, gender, age, idNumber, phoneNumber);
        this.role = role;
    }

    // Getters and Setters
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}