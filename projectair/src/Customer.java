import java.io.*;
import java.util.List;
//import java.util.Scanner;
import java.util.ArrayList;


public class Customer extends Person{
    
    String passportNumber;
    List<Booking> bookings;


    public Customer(){
        super();
    }

    public Customer(String name, String gender, int age, String idNumber, String phoneNumber, String passportNumber){
        super(name, gender, age, idNumber, phoneNumber); 
        this.passportNumber = passportNumber;
        bookings = new ArrayList<>();


    }
    
    public static List<Customer> loadCustomers(String customerFile, String bookingFile) throws IOException {
        List<Customer> customers = new ArrayList<>();
        BufferedReader customerReader = new BufferedReader(new FileReader(customerFile));
        BufferedReader bookingReader = new BufferedReader(new FileReader(bookingFile));

        // Load customers
        String line;
        while ((line = customerReader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 6) {
                customers.add(new Customer(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4], parts[5]));
            }
        }
        customerReader.close();

        // Load bookings and associate with customers
        while ((line = bookingReader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 4) {
                int bookingId = Integer.parseInt(parts[0]);
                String customerName = parts[1];
                String flightDetails = parts[2];
                String seatCategory = parts[3];

                // Create flight object from flight details (assuming flight details contain the necessary information)
                String[] flightParts = flightDetails.split("-");
                String flightNumber = flightParts[0];
                String departureTime = flightParts[1];
                String arrivalTime = flightParts[2];
                Flight flight = new Flight(0, flightNumber, departureTime, arrivalTime, "Unknown", "Unknown");

                Booking booking = new Booking(flightDetails, seatCategory, flight, null);
                booking.setBookingId(bookingId);

                for (Customer customer : customers) {
                    if (customer.getName().equals(customerName)) {
                        customer.addBooking(booking);
                        booking.setCustomer(customer);
                        break;
                    }
                }
            }
        }
        bookingReader.close();

        return customers;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
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

    public static Customer loadCustomer(String customerString) {
        String[] parts = customerString.split(",");
        return new Customer(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4], parts[5]);
    }

    /*public static Customer chooseCustomer(List<Customer> customers) {
        System.out.println("Choose a customer:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i).getName());
        }
        System.out.print("Enter the number of the customer: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return customers.get(choice - 1);
        scanner.close();
    }*/
}
