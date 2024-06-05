public class Inheritance {
    
    public static void main(String[] args) {

        Pilot pilot1 = new Pilot("Jane Smith", "Female", 42, "987654321", "010-555-5678", "ABC123", 15);
        pilot1.printpersondata();
        
        CrewMember crew1 = new CrewMember("Jannah", "Female", 20, "981423651", "019-477-5678", "Head Cabin Crew");
        crew1.printpersondata();

        Customer cust1 = new Customer("Aiman", "Male", 25,"0414121100","012-666-4751","880624");
        cust1.printpersondata();
    }
}
