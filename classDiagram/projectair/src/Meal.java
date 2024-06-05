public class Meal {
    private int mealId;
    private String mealType;
    private String dietaryRestrictions;
    private double price;
    private Customer customer;

    // Constructors
    public Meal() {}

    public Meal(int mealId, String mealType, String dietaryRestrictions, double price, Customer customer) {
        this.mealId = mealId;
        this.mealType = mealType;
        this.dietaryRestrictions = dietaryRestrictions;
        this.price = price;
        this.customer = customer;
    }

    // Getters and Setters
    public int getMealId() { return mealId; }
    public String getMealType() { return mealType; }
    public String getDietaryRestrictions() { return dietaryRestrictions; }
    public double getPrice() { return price; }
    public Customer getCustomer() { return customer; }
    
    public void setMealType(String mealType) { this.mealType = mealType; }
    public void setDietaryRestrictions(String dietaryRestrictions) { this.dietaryRestrictions = dietaryRestrictions; }
    public void setPrice(double price) { this.price = price; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
