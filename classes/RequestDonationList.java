import java.util.ArrayList;
public class RequestDonationList{
    ArrayList<RequestDonation> rdEntities=new ArrayList<RequestDonation>(); //create a list
    RequestDonation rdon;
    
    //methods
    public RequestDonation getRequestDonation(){return rdon;}
    
    public RequestDonation get(int id){
        for (int i =0; i<rdEntities.size(); i++)
            if (id==i.getId()){return i.getRequestDonation();}
    }//return requestdonation and give id of entity
    
    public void add(RequestDonation requestdonation){  
    rdEntities.add(Request Donation);}//add a requestdonation in the list
            //check if this donation already exists, how to use comparator
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
