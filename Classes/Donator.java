import java.util.*;  
public class Donator extends User {

    //δημιουργία λίστας για την καταχώρηση όσων επιθυμεί ο Donator
    static ArrayList<Offers> offersList = new ArrayList<Offers>();
    
     public static ArrayList<Offers> getoffersList(){
        return  offersList;
    }
    //constructor χωρίς ορίσματα
    public Donator(){}
    
    //constructor με ορίσματα όνομα, επώνυμο, τηλέφωνο
    public Donator(String first, String last, String ph) 
    { super(first, last, ph); }

}
