import java.util.*;
public class Donator extends User {
ArrayList<Offers> offersList = new ArrayList<Offers>();

//constructor χωρίς ορίσματα
public Donator(){}

// na koitaksoume wrappers
public Donator(String first, String last, String ph) 
{ super(first, last, ph); }
}
