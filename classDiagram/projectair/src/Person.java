public class Person {
    private String name;
    private String gender;
    private int age;
    private String idNumber;
    private String phoneNumber;

    // Constructors
    public Person() {}

    public Person(String name, String gender, int age, String idNumber, String phoneNumber) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getIdNumber() { return idNumber; }
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
