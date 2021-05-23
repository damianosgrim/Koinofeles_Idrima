import java.util.*;
public class RequestDonationList{
    public static ArrayList<RequestDonation> rdEntities=new ArrayList<RequestDonation>(); //create a list
    static RequestDonation rdon;
    
    public static ArrayList<RequestDonation> getrdEntities(){
        return rdEntities;
    }
    
    //constructor χωρίς ορίσματα
    public RequestDonationList(){}
    
    //methods
    public static RequestDonation getRequestDonation(){return rdon;}
    
    
    // give id of entity and return requestdonation 
    public static RequestDonation get(int id){
        RequestDonation r =null;
        for (int i = 0; i<rdEntities.size(); i++){
            if (id==rdEntities.get(i).getEntity().getId()){ r= rdEntities.get(i);}
         } 
         return r;
      }
    
    //add a requestdonation in rdentities and if already exists change  quantity    
    public static void add(RequestDonation requestdonation, double quant){  // εξαιρεση!!!
         for (int i = 0; i<rdEntities.size(); i++)
        {
        if(rdEntities.get(i).getEntity().getId()== requestdonation.getEntity().getId()) {
            requestdonation.setQuantity(requestdonation.getQuantity()+quant);
            rdEntities.get(i).setQuantity(requestdonation.getQuantity()+quant);
        }
        else if (rdEntities.get(i).getEntity().getId() != requestdonation.getEntity().getId()){
        rdEntities.add(requestdonation);}
    }  
