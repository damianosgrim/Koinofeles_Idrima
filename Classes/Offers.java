import java.util.*;


public class Offers extends RequestDonationList{
    public static void commit(){  
       ArrayList <RequestDonation> rdEntitiesCopy = new  ArrayList<RequestDonation> (currentDonations); //ενημέρωση των currentDonations με το περιεχόμενο rdEntities
   
    rdEntities.clear(); //εκαθάριση της rdEntities
    } 
}

