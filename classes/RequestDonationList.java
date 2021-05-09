import java.util.ArrayList;
public class RequestDonationList{
    ArrayList<String> rdEntities=new ArrayList<String>(); //create a list
    
    //methods
    public void get(){}//return requestdonation and give id of entity
    
    public void add(){}//add a requestdonation in the list
    
    public void remove(){
    rdEntities.remove(); //add argument to remove a specific object from the list 
    }//remove a requestdonation from the list
    
    public void modify(){
    
    }//change quantity of a product
    
    public void monitor(){
    System.out.println(rdEntities);
    }//print list's inhalt
    
    public void reset(){
    rdEntities.clear();}//clear the list
}
