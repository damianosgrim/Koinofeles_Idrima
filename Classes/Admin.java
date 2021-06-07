public class Admin extends User {
    
    //constuctor με ορίσματα όνομα, επώνυμο, τηλέφωνο
    public Admin (String first, String last, String ph) 
    { super(first, last, ph); }
    
    public boolean isAdmin() { return true; }//Override

}
