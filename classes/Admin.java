public class Admin extends User {
private boolean isAdmin=true;

public Admin (String firstname, String lastname, String phone) 
{ super(firstname, lastname, phone); }

public boolean isAdmin() { return true; }
}