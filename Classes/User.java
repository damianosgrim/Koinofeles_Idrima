public abstract class User {
    private  String firstname;  //Επιλέγουμε να έχουμε και όνομα και επώνυμο αντί για σκέτο name
    private  String lastname;
    private String phone;
    
    //constructor χωρίς ορίσματα
    public User(){}
    
    //constructor με ορίσματα (προσθήκη πληροφοριών για χρήστη)
    public User (String first, String last, String ph) 
    {   firstname = first;
        lastname = last;
        phone = ph; }
    
    //getter-setter για το όνομα
    public  String getFirstName() { return firstname; }
    public  void setFirstName(String first) {firstname=first;}
    
    //getter-setter για επίθετο
    public  String getLastName() { return lastname; }
    public  void setLastName(String last) { lastname=last;}
    
    //getter-setter για τηλέφωνο
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone=phone;}
    
    //μέθοδος επιστρέφει false για όλες τις υποκλάσεις εκτός από το Admin που έχουμε κάνει override.
    public boolean isAdmin() { return false; } 
}
