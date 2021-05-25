import java.util.*;
public class RequestDonationList{
    public static ArrayList<RequestDonation> rdEntities=new ArrayList<RequestDonation>(); //δημιουργία λίστας
    static RequestDonation rdon;
    
    public static ArrayList<RequestDonation> getrdEntities(){
        return rdEntities;
    }
    
    //constructor χωρίς ορίσματα
    public RequestDonationList(){}
    
    //μέθοδοι
    public static RequestDonation getRequestDonation(){return rdon;}
    
    
    //καταχώρηση ενός id και επιστροφή του κατάλληλου rdEntities
    public static RequestDonation get(int id){
        RequestDonation r =null;
        for (int i = 0; i<rdEntities.size(); i++){
            if (id==rdEntities.get(i).getEntity().getId()){ r= rdEntities.get(i);}
         } 
         return r;
      }
    
    //προσθήκη ενός requestdonation στην rdentities και αλλαγή της ποσότητας εάν υπάρχει ήδη   
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
