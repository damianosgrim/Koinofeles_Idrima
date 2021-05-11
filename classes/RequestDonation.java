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
    private int compare(Entity d1, Entity d2)
        {
            if (d1.getId()==d2.getId()){return 0;} 
            else {return 1;}
        }
    }
