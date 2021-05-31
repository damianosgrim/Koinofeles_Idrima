import java.util.*;  //wrappers
public class Beneficiary extends User {
    int noPersons=1; //αριθμός ατόμων της οικογένειας
    
    //constructor χωρίς ορίσματα
    public Beneficiary(){}
    
    //constructor με ορίσματα όνομα, επώνυμο, τηλέφωνο και αριθμό ατόμων 
    public Beneficiary(String firstname, String lastname, String phone, int noPersons) 
    { super(firstname, lastname, phone);
      this.noPersons=noPersons; }
    
    //getter-setter για τον αριθμό ατόμων
    public int getNoPersons() { return noPersons; }
    public void setNoPersons(int noPersons) {this.noPersons=noPersons;}
    
    //λίστα με τις παροχές που έχει λάβει ο Beneficiary
    ArrayList<RequestDonationList> receivedList = new ArrayList<RequestDonationList>(); 
    
    //λίστα με τις παροχές που επιθυμεί να λάβει ο Beneficiary
    ArrayList<Request> requestsList = new ArrayList<Request>();
}
