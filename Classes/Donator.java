import java.util.*;  //wrappers
public class Donator extends User {

    //δημιουργία λίστας για την καταχώρηση όσων επιθυμεί ο Donator
    ArrayList<Offers> offersList = new ArrayList<Offers>();
    
    //constructor χωρίς ορίσματα
    public Donator(){}
    
    //constructor με ορίσματα όνομα, επώνυμο, τηλέφωνο
    public Donator(String first, String last, String ph) 
    { super(first, last, ph); }
}
