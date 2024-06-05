public class Customer extends Person{
    
    String passportNumber;

    public Customer(){
        super();
    }

    public Customer(String name, String gender, int age, String idNumber, String phoneNumber, String passportNumber){
        super(name, gender, age, idNumber, phoneNumber); 
        this.passportNumber = passportNumber;


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
