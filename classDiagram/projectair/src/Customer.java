public class Customer extends Person {
    private String passportNumber;

    // Constructors
    public Customer() {}

    public Customer(String name, String gender, int age, String idNumber, String phoneNumber, String passportNumber) {
        super(name, gender, age, idNumber, phoneNumber);
        this.passportNumber = passportNumber;
    }

    // Getters and Setters
    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }
}
