public abstract class User {
private String firstname;  //Επιλέγουμε να έχουμε και όνομα και επώνυμο αντι για σκέτο name
private String lastname;
private String phone;

public User (String firstname, String lastname, String phone) 
{   this.firstname = new String(firstname);
    this.lastname = new String(lastname);
    this.phone = new String(phone); }

public String getFirstName() { return firstname; }
public void setFirstName(String firstname) {this.firstname=firstname;}

public String getLastName() { return lastname; }
public void setLastName(String lastname) { this.lastname=lastname;}

public String getPhone() { return phone; }
public void setPhone(String Phone) { this.phone=phone;}

//Επιστρέφει false και για όλες τις υποκλάσεις εκτός απο το Admin που έχουμε κάνει override.
public boolean isAdmin() { return false; } 
}

