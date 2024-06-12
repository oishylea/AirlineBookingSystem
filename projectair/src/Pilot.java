import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Pilot> loadPilots(String fileName) throws IOException {
        List<Pilot> pilots = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 7) {
                pilots.add(new Pilot(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4], parts[5], Integer.parseInt(parts[6])));
            }
        }
        reader.close();
        return pilots;
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
