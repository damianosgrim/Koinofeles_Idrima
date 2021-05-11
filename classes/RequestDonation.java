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
            if (d1.id1==d2.id2){return 0;} //pws kalw to id apo to entity
            else if(d1.id=!d2.id){return 1;}
        }
    }
}
