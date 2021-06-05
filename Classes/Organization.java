import java.util.*;
public class Organization { 
        private static String name;
        private static Admin admin;
        
        //λίστα με τα είδη που μπορούν να διανεμηθούν σε Beneficiaries
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
         
        //δημιουργία αντικειμένου currentDonations τύπου RequestDonationList
        public static RequestDonationList currentDonations; 
        public static RequestDonationList getCurrentDon(){return currentDonations;}
        public static void setCurrentDon(RequestDonationList currDon) {currentDonations=currDon;}
          
        //getter-setter για admin 
        public static Admin getAdmin() {return admin;}
        public void setAdmin(Admin admin) {this.admin=admin;}
        
        //getter για το όνομα του οργανισμού
        public static String getOrgName() {return name;}
        
        //ελέγχει αν υπάρχει ήδη το entity που βάζουμε και αν δεν υπάρχει το προσθέτει
        public void addEntity(Entity entity) {
             if(entityList.contains(entity)){
                 throw new IllegalArgumentException("This entity is already in the list."); //εξαίρεση εάν υπάρχει ήδη
                }
            else{
                entityList.add(entity);} 
        }
        
       /* public void addCuDon(RequestDonation rd){
            currentDonations.add(rd); } */              //μέθοδος που θα προσέθετε ένα requestdonation στην currentdonation
        
        //διαγράφει ένα entity
        public void removeEntity(int entity) {entityList.remove(entity);}
        
        //προσθήκη donator στην donator list
        public static void insertDonator(Donator donator) {
            if(donatorList.contains(donator)){
                    //εξαίρεση ελέγχει αν υπάρχει ήδη ο donator που βάζουμε
                 throw new IllegalArgumentException("This donator is already in the list."); 
                }
            else{
                donatorList.add(donator);}
            }
            
        //αφαιρεί έναν donator απο τον οργανισμό
        public static void removeDonator(Donator donator) {donatorList.remove(donator);}
        
        
        //προσθήκη benenficiary στην beneficiarylist
        public static void insertBeneficiary(Beneficiary beneficiary) {
            if(beneficiaryList.contains(beneficiary)){
                    //εξαίρεση ελέγχει αν υπάρχει ήδη ο beneficiary που βάζουμε
                 throw new IllegalArgumentException("This beneficiary is already in the list."); 
                }
            else{
                beneficiaryList.add(beneficiary);}
         } 
         
         //αφαιρεί έναν Beneficiary απο τον οργανισμό 
        public static void removeBeneficiary(Beneficiary beneficiary) {beneficiaryList.remove(beneficiary);}
    
        //υπάρχουσες κατηγορίες των entity και λίστα με όλα τα entity ανά συγκεκριμένη κατηγορία
        public static void listEntities() {for (Entity entity : entityList) { System.out.println(entity.getDetails()); }}
        
        //εμφανίζει τους δωρητές Donators
        public  static  void listDonators() {
            int count=1;
            for (Donator donator : donatorList) 
            { System.out.println(count + ". " + donator.getFirstName() + " " + donator.getLastName() ); 
            count++;}
        } 
        
        //εμφανίζει τους Βeneficiary
        public static void listBeneficiary() {
            int count=1;
            for (Beneficiary beneficiary : beneficiaryList) 
            { System.out.println(count + ". " + beneficiary.getFirstName() + " " + beneficiary.getLastName());
                count++; }
        }
        
        //προσδιορισμός entity (service-material) για εκτύπωση στο menu
        public static void showCategory(String Category){
            int counter=1;
            switch(Category){
                //αν το Category ειναι 1 τότε εμφανίζει τα Materials αριθμημένα
                case "1": 
                    for(Entity i: entityList){
                        if(i.getCategory()==1){
                            System.out.println(""+ counter + " " + i.getName());
                            counter++;
                        }
                    }
                    break;
                
                //αν το Category ειναι 2 τότε εμφανίζει τα Services αριθμημένα
                case "2":
                    for(Entity i: entityList){
                        if(i.getCategory()==2){
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
