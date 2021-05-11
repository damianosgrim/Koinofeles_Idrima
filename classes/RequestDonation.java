import java.util.*;
public class RequestDonation
{
    Entity entity;
    double quantity; 
    
    public RequestDonation(Entity entity, double quantity){
    this.entity=entity;
    this.quantity=quantity;
    }
    
    
    //interface comparator
    public int compare(RequestDonation d1, RequestDonation d2)
        {
            if (d1.getId()==d2.getId()){return 0;} 
            else if(d1.getId()=!d2.getId()){return 1;}
        }
    }
