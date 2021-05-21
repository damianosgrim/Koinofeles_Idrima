import java.util.*;
public class Beneficiary extends User {
int noPersons=1;

public Beneficiary(String firstname, String lastname, String phone, int noPersons) 
{ super(firstname, lastname, phone);
  this.noPersons=noPersons; }
  
public int getNoPersons() { return noPersons; }
public void setNoPersons(int noPersons) {this.noPersons=noPersons;}

// na koitaksoume wrappers

ArrayList<RequestDonationList> receivedList = new ArrayList<RequestDonationList>();
ArrayList<Request> requestsList = new ArrayList<Request>();

}
