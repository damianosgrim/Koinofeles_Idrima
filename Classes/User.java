public abstract class User {
private static String firstname;  //Επιλέγουμε να έχουμε και όνομα και επώνυμο αντί για σκέτο name
private static String lastname;
private String phone;

//constructor χωρίς ορίσματα
public User(){}
//με ορίσματα 
public User (String first, String last, String ph) 
{   firstname = first;
    lastname = last;
    phone = ph; }

public static String getFirstName() { return firstname; }
public static void setFirstName(String first) {firstname=first;}

public static String getLastName() { return lastname; }
public static void setLastName(String last) { lastname=last;}

public String getPhone() { return phone; }
public void setPhone(String phone) { this.phone=phone;}

//Επιστρέφει false και για όλες τις υποκλάσεις εκτός απο το Admin που έχουμε κάνει override.
public boolean isAdmin() { return false; } 
}
 
