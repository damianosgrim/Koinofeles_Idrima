import java.util.*;
public class Organization { //check wrappers
        private static String name;
        private static Admin admin;
        
        //λίστα με τα είδη που μπορούν να διανεμηθούν σε Beneficiarie
        static ArrayList<Entity> entityList = new ArrayList<Entity>();
        //λίστα με τους δωρητές
        static ArrayList<Donator> donatorList = new ArrayList<Donator>();
        //λίστα με τους επωφελούμενους
        static ArrayList<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();
        
        public static ArrayList<Entity> getentityList(){
        return entityList;
    }
    
        public static ArrayList<Donator> getdonatorList(){
            return donatorList;
        }
        
        public static ArrayList<Beneficiary> getbeneficiaryList(){
            return beneficiaryList;
        }
        
        //constructor χωρίς ορίσματα
        public Organization(){}
        
        //constructor με ορίσματα όνομα και admin 
        public Organization(String name, Admin admin) 
        {this.name=name;
         this.admin=admin; }
         
         public static ArrayList<RequestDonationList> currentDonations = new ArrayList<RequestDonationList>();
           /* public static RequestDonationList currentDonations; //pithani prosthiki methodou add apo tin RDL ston setter
        public static RequestDonationList getCurrentDon(){return currentDonations;}
        public static void setCurrentDon(RequestDonationList currDon) {currentDonations=currDon;}*/
          
        //getter-setter για admin 
        public static Admin getAdmin() {return admin;}
        public void setAdmin(Admin admin) {this.admin=admin;}
        
        //εξαίρεση ελέγχει αν υπάρχει ήδη το entity που βάζουμε
        public void addEntity(Entity entity) {
             if(entityList.contains(entity)){
                 throw new IllegalArgumentException("This entity is already in the list.");
                }
            else{
                entityList.add(entity);}
        }
         
        //διαγράφει ένα entity
        public void removeEntity(int entity) {entityList.remove(entity);}
        
        //εξαίρεση ελέγχει αν υπάρχει ήδη ο donator που βάζουμε
        public static void insertDonator(Donator donator) {
            if(donatorList.contains(donator)){
                 throw new IllegalArgumentException("This donator is already in the list.");
                }
            else{
                donatorList.add(donator);}
            }
            
        //αφαιρεί έναν donator απο τον οργανισμό
        public void removeDonator(int donator) {donatorList.remove(donator);}
        
        //εξαίρεση ελέγχει αν υπάρχει ήδη ο Βeneficiary που βάζουμε
        public static void insertBeneficiary(Beneficiary beneficiary) {
            if(beneficiaryList.contains(beneficiary)){
                 throw new IllegalArgumentException("This beneficiary is already in the list.");
                }
            else{
                beneficiaryList.add(beneficiary);}
         } 
         
         //αφαιρεί έναν Beneficiary απο τον οργανισμό 
        public void removeBeneficiary(int beneficiary) {beneficiaryList.remove(beneficiary);}
    
        //υπάρχουσες κατηγορίες των entity και λίστα με όλα τα entity ανά συγκεκριμένη κατηγορία
        public static void listEntities() {for (Entity entity : entityList) { System.out.println(entity.getDetails()); }}
        
        //εμφανίζει τους δωρητές Donators
        public void listDonators() {
            for (Donator donator : donatorList) 
            { System.out.println(donator.getFirstName() + donator.getLastName() ); }
        } 
        
        //εμφανίζει τους δωρητές Βeneficiary
        public void listBeneficiary() {
            for (Beneficiary beneficiary : beneficiaryList) 
            { System.out.println(beneficiary.getFirstName() + beneficiary.getLastName() ); }
        }
        
        //προσδιορισμός entity (service-material) για εκτύπωση στο menu
        public static void showEntityinCategory(String Category){
            int counter=1;
            switch(Category){
                case "1":
                    for(Entity i: entityList){
                        if(i.getEntityCategory()==1){
                            System.out.println(""+ counter + " " + i.getName());
                            counter++;
                        }
                    }
                    break;
                    
                case "2":
                    for(Entity i: entityList){
                        if(i.getEntityCategory()==2){
                            System.out.println(""+ counter + " " + i.getName());
                            counter++;
                        }
                    }
                    break;
                
                default:
                System.out.println("Invalid command!");
                    break;
            }
        }
}
