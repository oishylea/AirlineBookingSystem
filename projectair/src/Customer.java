import java.io.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class Customer extends Person{
    
    String passportNumber;

    public Customer(){
        super();
    }

    public Customer(String name, String gender, int age, String idNumber, String phoneNumber, String passportNumber){
        super(name, gender, age, idNumber, phoneNumber); 
        this.passportNumber = passportNumber;


    }
    
    public static List<Customer> loadCustomers(String fileName) throws IOException {
        List<Customer> customers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 6) {
                customers.add(new Customer(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4], parts[5]));
            }
        }
        reader.close();
        return customers;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void printpersondata(){
        System.out.println("\n===== Customer Details =====");

        super.printpersondata(); 
        System.out.println("Customer Passport Num.\t: "+passportNumber);

    }
}
