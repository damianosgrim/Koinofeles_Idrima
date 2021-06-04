import java.util.*;
public class RequestDonation
{
    Entity entity;
    double quantity; 
    
    //consuctor με ορίσματα entity και quantity
    public RequestDonation(Entity entity, double quantity){
    this.entity=entity;
    this.quantity=quantity;
    }
    
    //επιστρέφει το id για ένα requestdonation 
    public int get_id(){return entity.getId();} 
    
    //getter για το entity
    public Entity getEntity(){return entity;}
    
    //setter-getter για το Quantity
    public void setQuantity(double quantity){this.quantity=quantity;} 
    public double getQuantity(){return quantity;}
        
    //interface comparator για την σύγκριση δύο αντικειμένων με βάση το ID
    private int compare(Entity d1, Entity d2)
        {
            if (d1.getId()==d2.getId()){return 0;} 
            else {return 1;}
        }
}
