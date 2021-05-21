import java.util.*;
public class Offers extends RequestDonationList{
    public void commit(){  
        ArrayList <rdEntities> copy = RequestDonationList (currentDonations); //update currentDonation with copy from rdEntities
    rdEntities.clear(); //clear rdEntities
    } //update currentDonations with rdEntities.
}
