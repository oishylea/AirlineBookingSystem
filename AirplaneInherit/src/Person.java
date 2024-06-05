public class Person {
    
    String name;
    String gender;
    int age;
    String idNumber;
    String phoneNumber;

    public Person(){}

    public Person(String name, String gender, int age, String idNumber, String phoneNumber){
        this.name=name;
        this.gender=gender;
        this.age=age;
        this.idNumber=idNumber;
        this.phoneNumber=phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void printpersondata(){
        System.out.println("Name\t\t\t: "+name+
                            "\nGender\t\t\t: "+gender+
                            "\nAge\t\t\t: "+ age+
                            "\nId Number\t\t: "+idNumber+
                            "\nPhone Number\t\t: "+phoneNumber);
    }
}
