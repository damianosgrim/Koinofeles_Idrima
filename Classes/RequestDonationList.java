import java.util.*;
public class RequestDonationList{
    public static ArrayList<RequestDonation> rdEntities=new ArrayList<RequestDonation>(); //δημιουργία λίστας
    static RequestDonation rdon;
    
    public static ArrayList<RequestDonation> getrdEntities(){
        return rdEntities;
    }
    
    //constructor χωρίς ορίσματα
    public RequestDonationList(){}
    
    //getter για την RequestDonation
    public static RequestDonation getRequestDonation(){return rdon;}
    
    //καταχώρηση ενός id του entity και επιστροφή του αντίστοιχου requestdonation 
    public static RequestDonation get(int id){
        RequestDonation r =null;
        for (int i = 0; i<rdEntities.size(); i++){
            if (id==rdEntities.get(i).getEntity().getId()){ r= rdEntities.get(i);}
         } 
         return r;
      }
    
    //προσθήκη requestdonation στην rdentities και τροποποίση του quantity εάν ήδη υπάρχει 
    public static void add(RequestDonation requestdonation, double quant){  
         for (int i = 0; i<rdEntities.size(); i++)
        {
        if(rdEntities.get(i).getEntity().getId()== requestdonation.getEntity().getId()) {
            requestdonation.setQuantity(requestdonation.getQuantity()+quant);
            rdEntities.get(i).setQuantity(requestdonation.getQuantity()+quant);
        }
        else if (rdEntities.get(i).getEntity().getId() != requestdonation.getEntity().getId()){
        rdEntities.add(requestdonation);}
    }  
    } 

    //διαγραφή ενός requestdonation από την λίστα
     public static void remove(RequestDonation requestdonation){
        rdEntities.remove(requestdonation);  
    }
    
    //αλλαγή της ποσότητας ενός product
    public void modify(RequestDonation d ,double quantity){
        if(rdEntities.contains(d)){
        d.setQuantity(quantity);
        rdEntities.get(rdEntities.indexOf(d)).setQuantity(quantity);
    }
    }
    
    //εκτύπωση των στοιχείων της λίστας
    public void monitor(){
        for (RequestDonation requestdon : rdEntities) { 
            System.out.println("name of donation " + requestdon.getEntity().getName() + ", quantity " +requestdon.getQuantity()); }
        }
    
    //εκαθάριση της λίστας
    public void reset(){
    rdEntities.clear();
    }
}
