import java.util.*;
public class RequestDonationList{
    static ArrayList<RequestDonation> rdEntities=new ArrayList<RequestDonation>(); //create a list
    RequestDonation rdon;
    
    //constructor χωρίς ορίσματα
    public RequestDonationList(){    
    }
    
    //methods
    public RequestDonation getRequestDonation(){return rdon;}
    
    public static RequestDonation get(int id){
        for (int i = 0; i<rdEntities.size(); i++)
            if (id==rdEntities.get(i).getId()){return rdEntities.get(i).getRequestDonation();}
    } //return requestdonation and give id of entity
    
    public static void add(RequestDonation requestdonation, double quant){  
        if(rdEntities.contains(requestdonation)) {
           int quan = requestdonation.getEntity().getQuantity();
           requestdonation.getEntity().setQuantity(quan+quant);
       /* for (int i = 0; i<rdEntities.size(); i++)
        //check if this donation already exists
            if (requestdonation.get_id()==rdEntities.get(i).getId()){i.setQuantity(i.getQuantity()+requestdonation.getQuantity());} 
            else {rdEntities.add(requestdonation);}   //add a requestdonation in the list */
    } }
    
    
    public void remove(RequestDonation requestdonation){
        rdEntities.remove(requestdonation);  
    }//remove a requestdonation from the list

    public void modify(double quantity){
        setQuantity(quantity);
    }//change quantity of a product
    
    public String monitor(){
    System.out.println(rdEntities);
    }//print list's content
    
    public void reset(){
    rdEntities.clear();}//clear the list 
    }
