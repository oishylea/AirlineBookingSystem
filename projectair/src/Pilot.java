public class Pilot extends Person{
    
    String licenseNumber;
    int experienceYears;

    public Pilot(){
        super();
    }

    public Pilot(String name, String gender, int age, String idNumber, String phoneNumber, String licenseNumber, int experienceYears) {
        super(name, gender, age, idNumber, phoneNumber); 
        this.licenseNumber = licenseNumber;
        this.experienceYears = experienceYears;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void printpersondata(){
        System.out.println("\n===== Pilot details =====");
        super.printpersondata(); 
        System.out.println("Pilot Licence Number\t: "+licenseNumber+
                              "\nPilot Experience Years\t: "+experienceYears);

    }


}
