public class CrewMember extends Person{
    
    String role;

    public CrewMember(){
        super();
    }

    public CrewMember(String name, String gender, int age, String idNumber, String phoneNumber, String role){
        super(name, gender, age, idNumber, phoneNumber); 
        this.role = role;


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
