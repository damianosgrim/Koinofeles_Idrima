import java.util.*;
public class Organization { //check wrappers
private static String name;
private static Admin admin;
static ArrayList<Entity> entityList = new ArrayList<Entity>();
static ArrayList<Donator> donatorList = new ArrayList<Donator>();
static ArrayList<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();

    public static ArrayList<Donator> getdonatorList(){
        return donatorList;
    }
    
    public static ArrayList<Beneficiary> getbeneficiaryList(){
        return beneficiaryList;
    }
    
     public Organization(){}
    //Constructor για το Organization
    public Organization(String name, Admin admin) 
    {this.name=name;
     this.admin=admin; }
     
     public static ArrayList<RequestDonationList> currentDonations = new ArrayList<RequestDonationList>();
   /* public static RequestDonationList currentDonations; //pithani prosthiki methodou add apo tin RDL ston setter
    public static RequestDonationList getCurrentDon(){return currentDonations;}
    public static void setCurrentDon(RequestDonationList currDon) {currentDonations=currDon;}*/
      
    public static Admin getAdmin() {return admin;}
    public void setAdmin(Admin admin) {this.admin=admin;}
    
    public void addEntity(Entity entity) {entityList.add(entity);} //Eξαίρεση
    public void removeEntity(int entity) {entityList.remove(entity);}
    
    public static void insertDonator(Donator donator) {donatorList.add(donator);} //Eξαίρεση
    public void removeDonator(int donator) {donatorList.remove(donator);}
    
    public static void insertBeneficiary(Beneficiary beneficiary) {beneficiaryList.add(beneficiary);} //Eξαίρεση
    public void removeBeneficiary(int beneficiary) {beneficiaryList.remove(beneficiary);}
    
    public void listEntities() {for (Entity entity : entityList) { System.out.println(entity.getDetails()); }}
    public void listDonators() {for (Donator donator : donatorList) { System.out.println(donator.getFirstName() + donator.getLastName() ); }}
    public void listBeneficiary() {for (Beneficiary beneficiary : beneficiaryList) { System.out.println(beneficiary.getFirstName() + beneficiary.getLastName() ); }}
    
    
}
