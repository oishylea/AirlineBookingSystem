public class Pilot extends Person {
    private String licenseNumber;
    private int experienceYears;

    // Constructors
    public Pilot() {}

    public Pilot(String name, String gender, int age, String idNumber, String phoneNumber, String licenseNumber, int experienceYears) {
        super(name, gender, age, idNumber, phoneNumber);
        this.licenseNumber = licenseNumber;
        this.experienceYears = experienceYears;
    }

    // Getters and Setters
    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }
}


