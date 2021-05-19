import java.util.ArrayList;
public class Donator extends User {
ArrayList<Offers> offersList = new ArrayList<Offers>();


// na koitaksoume wrappers
public Donator(String firstname, String lastname, String phone) 
{ super(firstname, lastname, phone); }
}
