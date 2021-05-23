import java.util.*;


public class Offers extends RequestDonationList{
    public static void commit(){  
       ArrayList <RequestDonation> rdEntitiesCopy = new  ArrayList<RequestDonation> (currentDonations); //update currentDonation with copy from rdEntities
   
    rdEntities.clear(); //clear rdEntities
    } //update currentDonations with rdEntities.
}

