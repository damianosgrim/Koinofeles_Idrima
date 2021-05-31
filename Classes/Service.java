import java.util.*;
public class Service extends Entity{
    int EntityCategory=2;
    
    public String getDetails(){
          return ("the object is service");
    }
        
      //@override
    public String toString(){
    return "info: " + getEntityInfo() + "details "+ getDetails();
    }
    
     //μέθοδος που δηλώνεται για να χρησιμοποιηθεί στην main ώστε να εκτυπώνει στον Admin την ποσότητα των Services
    public int getEntityCategory(){
        return EntityCategory;
    }
      
}
