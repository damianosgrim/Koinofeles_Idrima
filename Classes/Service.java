import java.util.*;
public class Service extends Entity{
    public int EntityCategory=2;
    
    //μέθοδος που επιστρέφει το είδος της δωρεάς
    public String getDetails(){
          return ("the object is service");
    }
        
    //@override
    public String toString(){
    return "info: " + getEntityInfo() + "details "+ getDetails();
    }
    
    //μέθοδος που δηλώνεται για να χρησιμοποιηθεί στην Organization ώστε να εκτυπώνει Services
    public int getCategory(){
        return EntityCategory;
    }   
}
