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
    
    //εξαιρεση ελεγχει αν υπάρχει ήδη το entity που βάζουμε
    public void addEntity(Entity entity) {
         if(entityList.contains(entity)){
             throw new IllegalArgumentException("This entity is already in the list.");
            }
        else{
            entityList.add(entity);
            }
    }
        
    public void removeEntity(int entity) {entityList.remove(entity);}
    
    //εξαιρεση ελεγχει αν υπάρχει ήδη ο donator που βάζουμε
    public static void insertDonator(Donator donator) {
        if(donatorList.contains(donator)){
             throw new IllegalArgumentException("This donator is already in the list.");
            }
        else{
            donatorList.add(donator);
            }
        }
        
    //αφαιρει έναν donator απο τον οργανισμό
    public void removeDonator(int donator) {donatorList.remove(donator);}
    
    //εξαιρεση ελεγχει αν υπάρχει ήδη ο beneficiary που βάζουμε
    public static void insertBeneficiary(Beneficiary beneficiary) {
        if(beneficiaryList.contains(beneficiary)){
             throw new IllegalArgumentException("This beneficiary is already in the list.");
            }
        else{
            beneficiaryList.add(beneficiary);
            }
     } 
     //αφαιρει έναν beneficiary απο τον οργανισμό 
    public void removeBeneficiary(int beneficiary) {beneficiaryList.remove(beneficiary);}
    
    public void listEntities() {for (Entity entity : entityList) { System.out.println(entity.getDetails()); }}
    
    // εμφανίζει τους δωρητές Donators.
    public void listDonators() {for (Donator donator : donatorList) { System.out.println(donator.getFirstName() + donator.getLastName() ); }} 
    
    
    public void listBeneficiary() {for (Beneficiary beneficiary : beneficiaryList) { System.out.println(beneficiary.getFirstName() + beneficiary.getLastName() ); }}
    
}
