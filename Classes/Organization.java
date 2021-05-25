import java.util.*;
public class Organization { //check wrappers
private static String name;
private Admin admin;
static ArrayList<Entity> entityList = new ArrayList<Entity>();
static ArrayList<Donator> donatorList = new ArrayList<Donator>();
static ArrayList<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();

    //Constructor για το Organization
    public Organization(String name, Admin admin) 
    {this.name=name;
     this.admin=admin; }
     
    public static RequestDonationList currentDonations; //pithani prosthiki methodou add apo tin RDL ston setter
    public RequestDonationList getCurrentDon(){return currentDonations;}
    public void setCurrentDon(RequestDonationList currentDonations){this.currentDonations=currentDonations;}
      
    public Admin getAdmin() {return admin;}
    public void setAdmin(Admin admin) {this.admin=admin;}
    
    public void addEntity(Entity entity) {entityList.add(entity);} //Eξαίρεση
    public void removeEntity(int entity) {entityList.remove(entity);}
    
    public void insertDonator(Donator donator) {donatorList.add(donator);} //Eξαίρεση
    public void removeDonator(int donator) {donatorList.remove(donator);}
    
    public void insertBeneficiary(Beneficiary beneficiary) {beneficiaryList.add(beneficiary);} //Eξαίρεση
    public void removeBeneficiary(int beneficiary) {beneficiaryList.remove(beneficiary);}
    
    public void listEntities() {for (Entity entity : entityList) { System.out.println(entity.getDetails()); }}
    public void listDonators() {for (Donator donator : donatorList) { System.out.println(donator.getFirstName() + donator.getLastName() ); }}
    public void listBeneficiary() {for (Beneficiary beneficiary : beneficiaryList) { System.out.println(beneficiary.getFirstName() + beneficiary.getLastName() ); }}
    
    public static int exists(String num){   
    boolean num1 = donatorList.contains(num); 
    boolean num2 = beneficiaryList.contains(num);
    if(num1||num2)
    {return 0;} else {return 1;}
    //να κοιτάξουμε wrappers
    }
}
    
