import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewMember extends Person{
    
    String role;

    public CrewMember(){
        super();
    }

    public CrewMember(String name, String gender, int age, String idNumber, String phoneNumber, String role){
        super(name, gender, age, idNumber, phoneNumber); 
        this.role = role;
    }

    public static List<CrewMember> loadCrewMembers(String fileName) throws IOException {
        List<CrewMember> crewMembers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 6) {
                crewMembers.add(new CrewMember(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4], parts[5]));
            }
        }
        reader.close();
        return crewMembers;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void printpersondata(){
        System.out.println("\n===== Crew Details =====");

        super.printpersondata(); 
        System.out.println("Crew Member Role\t: "+role);

    }


}
