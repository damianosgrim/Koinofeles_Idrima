import java.util.*;
import java.io.*;
import java.lang.*; //Για την ParseInt μετατροπή string σε int
public class Menu {
     static Scanner scan = new Scanner(System.in);
     private static String ans;
     private static String phone;
     //μεταβλητή που γίνεται true by default ή όταν κάποιος χρήστης κάνει logout και false όταν εμφανιστεί μήνυμα χαιρετισμού 
     private static boolean havelogout=true; 
 
    
public static void Scan() throws NullLineReadedException{
    System.out.println("Welcome to " + Organization.getOrgName() + "!");
    System.out.println("Please enter a phone number: ");
    int search = 0; //Εκχωρηση τιμής 1,2,3 ανάλογα με τον τύπο του user 
     Beneficiary b; //Βοηθητική μεταβλητή
     Donator d; //Βοηθητική μεταβλητή
     ans=scan.nextLine();
     phone=ans; //καταχώρηση της απάντησης σε μεταβλητή για διατήρηση της και να μην ξαναζητείται από τον χρήστη
      boolean exit=false; //μεταβλητή για αμυντικό προγραμματισμό
     
     /*μέθοδος η οποία ελέγχει αν το νούμερο που έχουμε βάλει ανήκει σε κάποιον Donator που είναι
     ήδη εγγεγραμμένος στο σύστημα*/
      for(int i = 0; i<Organization.getdonatorList().size(); i++){
           if(Organization.getdonatorList().get(i).getPhone().equals(ans)){
           
             search=1; //γίνεται 1 αν είναι don
             d=Organization.getdonatorList().get(i);
             System.out.println("The phone number " + ans + " has been already added in the system as donator");
             //αν το τηλέφωνο βρεθέι ρωτάει αν θέλει να συνδεθεί ως o συγκεκριμένος donator
             do{
             System.out.println("Do you want to sign in as: " + d.getFirstName() + " " + d.getLastName() +"? (y/n)");
             ans=scan.nextLine();
             if ((ans.equals("n") || ans.equals("no") )) {exit=true; LogOut();} //αν η πει όχι επιστρέφει στο αρχικό menu
             else if(ans.equals("y") || ans.equals("yes") ) {
                exit=true;
              Menu.MenuD(d); //Καλέι την μέθοδο με όρισμα την βοηθητική μεταβλητή d τύπου Donator με βάση το τηλέφωνο που βρέθηκε
             } 
           }while(!exit);
        } 
        } 
     
     //κάνει τον ίδιο έλεγχο αλλά για έναν Beneficiary
     for(int i = 0; i<Organization.getbeneficiaryList().size(); i++){
         if(Organization.getbeneficiaryList().get(i).getPhone().equals(ans)){
              search=2; //γίνεται 2 αν είναι ben
              b=Organization.getbeneficiaryList().get(i);
              System.out.println("The phone number " + ans + " has been already added in the system as beneficiary");
              do{
             System.out.println("Do you want to sign in as: " + b.getFirstName() + " " + b.getLastName() +"? (y/n)");
             ans=scan.nextLine();
              if ((ans.equals("n") || ans.equals("no") )) {exit=true; LogOut();}
              else if(ans.equals("y") || ans.equals("yes") ) {
                  exit=true;
              Menu.MenuB(b);  //Καλέι την μέθοδο με όρισμα την βοηθητική μεταβλητή b τύπου Benefiaciary με βάση το τηλέφωνο που βρέθηκε
             }  
            }while(!exit);
        }
      } 
     
     //κάνει τον ίδιο έλεγχο για έναν Admin
     if (Organization.getAdmin().getPhone().equals(ans)) {
         search = 3; //γίνεται 3 αν είναι adm
         System.out.println("The phone number " + ans + " has been already added in the system as admin");
         do{
         System.out.println("Do you want to sign in as: " + Organization.getAdmin().getFirstName() + " " + Organization.getAdmin().getLastName() +"? (y/n)");
         ans=scan.nextLine();
         if ((ans.equals("n") || ans.equals("no") )) {exit=true; LogOut();}
        else if(ans.equals("y") || ans.equals("yes") ) {
            exit=true;
        Menu.MenuA(Organization.getAdmin()); 
        }
       }while(!exit);
     }

     //στην περίπτωση που δεν υπάρχει το τηλέφωνο ρωτάει εάν θέλει να εγγραφεί
     if(search==0) { //παραμένει 0 εάν δεν υπάρχει το τηλ
         boolean ex= false;
         do{
        System.out.println("Do you want to sign up in our system? (y/n)");
        ans=scan.nextLine();
        if ((ans.equals("n") || ans.equals("no") )) {ex=true; ExitFromProgram();}
        else if(ans.equals("y") || ans.equals("yes") ) {
            ex=true;
            exit=false; 
            //ρωτάει αν θέλουμε να εγγραφούμε ως ben ή ως don
            do{
            System.out.println("Do you want to sign up as (1)Beneficiary or (2)Donator? (1/2)");
            ans=scan.nextLine();
            switch (ans) {
                case "1": 
                Menu.SignB();
                exit=true;
                break;
                
                case "2": 
                Menu.SignD();
                exit=true;
                break;
                
                default: 
                    System.out.println("Invalid command!"); //λάθος επιλογή
                break;   
            }
        }while(!exit);

    }
    }while(!ex);
  }
}

//Μέθοδος εγρραφής χρήστη ως Beneficiary
 public static void SignB() {
     Beneficiary b = new Beneficiary();
     b.setPhone(phone);
     
     System.out.println("Enter your First Name: ");
     ans=scan.nextLine();
      while (ans.equals("")) {
       System.out.println("Enter your First Name: "); 
       ans=scan.nextLine(); }
     b.setFirstName(ans);
     
     System.out.println("Enter your Last Name: ");
     ans=scan.nextLine();
      while (ans.equals("")) {
       System.out.println("Enter your Last Name: "); 
       ans=scan.nextLine(); }
     b.setLastName(ans);
    
     System.out.println("Insert members of your family: ");
     ans=scan.nextLine();
      while (ans.equals("")) {
       System.out.println("Insert members of your family: "); 
       ans=scan.nextLine();
     }
     b.setNoPersons(Integer.parseInt(ans)); 
     Organization.insertBeneficiary(b);
     System.out.println("You sign up successfully as Beneficiay!");
     System.out.println("Press Enter key to continue..."); 
     scan.nextLine();
     Menu.MenuB(b);    
}


//Μέθοδος εγγραφής χρήστη ως Beneficiary
 public static void SignD() {
     Donator d = new Donator();
     d.setPhone(phone);
     
     System.out.println("Enter your First Name: ");
     ans=scan.nextLine();
      while (ans.equals("")) {
       System.out.println("Enter your First Name: "); 
       ans=scan.nextLine(); }
     d.setFirstName(ans);
     
     System.out.println("Enter your Last Name: ");
     ans=scan.nextLine();
      while (ans.equals("")) {
       System.out.println("Enter your Last Name: "); 
       ans=scan.nextLine(); }
     d.setLastName(ans);
    
     Organization.insertDonator(d);
     System.out.println("You sign up successfully as Donator!");
     System.out.println("Press Enter key to continue...");
     scan.nextLine();
     MenuD(d);    
}

//Menu Beneficiary
public static void MenuB(Beneficiary b) {
    //η μεταβλητή havelogout είναι true και εμφανίζεται μήνυμα χαιρετισμού και στην συνέχεια γίνεται false οπότε όταν κάνουμε back δεν εμφανίζει τον χαιρετισμό
    if (havelogout==true) {
    System.out.println("Welcome " + b.getFirstName() + " " + b.getLastName() + ", your phone is " + b.getPhone() + ", you're benefiaciary and the number of your family members are: " + b.getNoPersons() + ".");
    havelogout=false; }
    boolean exit=false;
    do{
    System.out.println("1.Add Request  2.Show Requests  3.Commit  4.Back  5.Logout  6.Exit  (Enter the number of the option you want)");
    ans=scan.nextLine();
        switch (ans) {
            case "1":
         boolean Case=false;
         boolean ex=false;
         do{
            System.out.println("1.Material  2.Services (Press b to back)"  );
            ans=scan.nextLine(); 
            switch(ans){
                case "1":
                            Organization.showCategory(ans); //καλείται η μέθοδος που εκτυπώνει τα Materials αριθμημένα
                            do{
                            System.out.print("Type the name of a material for more details:");
                            ans=scan.nextLine();
                            boolean found=false;
                            //ψάχνει το Material και αν το βρει εμφανίζει τις πληροφορίες    
                            for(Entity i:Organization.getentityList()){
                                if(ans.equals(i.getName())){
                                    for(int j=0;j<Organization.getentityList().size();j++){
                                         if(Organization.getentityList().get(j).getName().equals(ans)){
                                            System.out.println(Organization.getentityList().get(j). getEntityInfo());
                                         }
                                    found=true;
                                    //ρωτάει τον χρηστη αν θελει να λαβει το Material
                                    System.out.println("Do you want to receive this material? (y/n)");
                                    ans=scan.nextLine();
                                    if (ans.equals("n") || ans.equals("no") ) {break;}
                                    else if (ans.equals("y") || ans.equals("yes")) {
                                         //ρωταει την ποσοτητα που θελει να λαβει
                                        System.out.println("Enter the quantity you want to receive");
                                        ans=scan.nextLine();
                                        //Κατασκευή αντικειμένου Request Donation για δαιγραφη του απο την λιστα αν το λαβει καποιος
                                        RequestDonation rq = new RequestDonation(i, Integer.parseInt(ans)); 
                                        RequestDonationList.remove(rq);
                                        System.out.println("You succesfully recieved " + ans + " " + i.getName());
                                        break;
                                    } 
                                }
                            } 
                        } 
                        Case=true;
                        //αν δεν βρεθει το Material εμφανιζει μηνυμα
                        if(found==false){System.out.println("The material doesn't exist!");} 
        
                          }while(!Case);
                     
                ex=false; //Για να ξανατρέξει στο προηγούμενο μενου  
                 
                 break;
            
                case "2":
                      //ααντιστοιχα με το service
                            Organization.showCategory(ans);
                            do{
                            System.out.print("Type the name of a service for more details:");
                           ans=scan.nextLine();
                            boolean found=false;
                            for(Entity i:Organization.getentityList()){
                                if(ans.equals(i.getName())){
                                    for(int j=0;j<Organization.getentityList().size();j++){
                                         if(Organization.getentityList().get(j).getName().equals(ans)){
                                            System.out.println(Organization.getentityList().get(j). getEntityInfo());
                                         }
                                        found=true;
                                        System.out.println("Do you want to receive this service? (y/n)");
                                        ans=scan.nextLine();
                                        if (ans.equals("n") || ans.equals("no") ) {break;}
                                        else if (ans.equals("y") || ans.equals("yes")) {
                                            System.out.println("Enter the hours of that service you want to recieve");
                                            ans=scan.nextLine();
                                            //Κατασκευή αντιεκιμένου Request Donation
                                            RequestDonation rq = new RequestDonation(i, Integer.parseInt(ans)); 
                                            RequestDonationList.remove(rq);
                                            //(An υπαρχει ήδη request don?)
                                            System.out.println("You succesfully received " + ans + " hours of " + i.getName());
                                            break;
                                            
                                        }
                                    }
                                }
                            }
                                    Case= true;
                            if(found==false){System.out.println("The service doesn't exist!");} 
        
                          }while(!Case);  
                ex= false; //Για να ξανατρέξει στο αμέσως προηγούμενο menu  
                 break;
                 
                case "b": 
                MenuB(b);
                break;
                
                default: 
                            System.out.println("Invalid command");
                break;
            }
        }while(!ex);
        exit=true;
          break;
      
    
            
            case "2": 
            
            break;
            
            case "3":
            
            break;
            
            case "4": 
            ex=false;
            do{
            System.out.println("Do you want to sign in as: " + b.getFirstName() + " " + b.getLastName() +"? (y/n)");
             ans=scan.nextLine();
              if ((ans.equals("n") || ans.equals("no") )) {LogOut();}
              else if(ans.equals("y") || ans.equals("yes") ) {
              Menu.MenuB(b);  
              ex=true;
             }  
            }while(!ex);
            exit=true;
            break;
            
            case "5":
            LogOut();
            exit=true;
            break;
            
            case "6": 
            ExitFromProgram();
            exit=true;
            break;
            
            default: 
            System.out.println("Invalid command!");
            break;   
        }
    }while(!exit);
}

//Menu Donator λειτουργεί με τον ιδιο τροπο με το menu Ben
public static void MenuD(Donator d) {
    if (havelogout==true) {
    System.out.println("Welcome " + d.getFirstName() + " " + d.getLastName() + ", your phone is " + d.getPhone() + ", you're donator."); 
    havelogout=false; }
    boolean exit=false;
    do{
        System.out.println("1.Add Offer  2.Show Offers  3.Commit  4.Back  5.Logout  6.Exit  (Enter the number of the option you want)");
        ans=scan.nextLine();
        switch (ans) {
        case "1":
        boolean Case=false;
         boolean ex=false;
         do{
            System.out.println("1.Material  2.Services (Press b to back)"  );
            ans=scan.nextLine(); 
            switch(ans){
                case "1":
                    
                            Organization.showCategory(ans);
                           do{
                            System.out.print("Type the name of a material for more details:");
                           ans=scan.nextLine();
                            boolean found=false;
                            for(Entity i:Organization.getentityList()){
                                if(ans.equals(i.getName())){
                                    for(int j=0;j<Organization.getentityList().size();j++){
                                         if(Organization.getentityList().get(j).getName().equals(ans)){
                                            System.out.println(Organization.getentityList().get(j). getEntityInfo());
                                         }
                                    found=true;
                                    System.out.println("Do you want to donate this material? (y/n)");
                                    ans=scan.nextLine();
                                    if (ans.equals("n") || ans.equals("no") ) {break;}
                                    else if (ans.equals("y") || ans.equals("yes")) {
                                        System.out.println("Enter the quantity you want to donate");
                                        ans=scan.nextLine();
                                        //Κατασκευή αντιεκιμένου Request Donation
                                        RequestDonation rq = new RequestDonation(i, Integer.parseInt(ans)); 
                                        RequestDonationList.add(rq, 0.0);
                                        
                                        System.out.println("You succesfully donated " + ans + " " + i.getName());
                                        break;
                                    }
                                }
                            }
                        }
                        Case=true;
                        if(found==false){System.out.println("The material doesn't exist!");} 
        
                          }while(!Case);
                     
                ex=false; //Για να ξανατρέξει
                 
                 break;
            
                case "2":
                            Organization.showCategory(ans);
                            do{
                            System.out.print("Type the name of a service for more details:");
                           ans=scan.nextLine();
                            boolean found=false;
                            for(Entity i:Organization.getentityList()){
                                if(ans.equals(i.getName())){
                                    for(int j=0;j<Organization.getentityList().size();j++){
                                         if(Organization.getentityList().get(j).getName().equals(ans)){
                                            System.out.println(Organization.getentityList().get(j). getEntityInfo());
                                         }
                                        found=true;
                                        System.out.println("Do you want to donate this service? (y/n)");
                                        ans=scan.nextLine();
                                        if (ans.equals("n") || ans.equals("no") ) {break;}
                                        else if (ans.equals("y") || ans.equals("yes")) {
                                            System.out.println("Enter the hours of that service you want to donate");
                                            ans=scan.nextLine();
                                            //Κατασκευή αντιεκιμένου Request Donation
                                            RequestDonation rq = new RequestDonation(i, Integer.parseInt(ans)); 
                                            RequestDonationList.add(rq, 0.0);
                                            
                                            System.out.println("You succesfully donated " + ans + " hours of " + i.getName());
                                            break;
                                            
                                        }
                                    }
                                }
                            }
                                    Case= true;
                            if(found==false){System.out.println("The service doesn't exist!");} 
        
                          }while(!Case);  
                ex= false; //Για να ξανατρέξει   
                 break;
                 
                case "b":
                MenuD(d);
                break;
                
                default: 
                            System.out.println("Invalid command");
                break;
            }
        }while(!ex);
        exit=true;
          break;
      
            
            case "2": 
    
            break;
            
            case "3": 
            
            break;
            
            case "4": 
            ex=false;
            do{
            System.out.println("Do you want to sign in as: " + d.getFirstName() + " " + d.getLastName() +"? (y/n)");
             ans=scan.nextLine();
              if ((ans.equals("n") || ans.equals("no") )) {LogOut();}
              else if(ans.equals("y") || ans.equals("yes") ) {
              Menu.MenuD(d);  
              ex=true;
             } 
            }while(!ex);
             exit=true;
            break;
            
            case "5": 
            LogOut();
            exit=true;
            break;
            
            case "6": 
            ExitFromProgram();
            exit=true;
            break;
            
            default: 
            System.out.println("Invalid command!");
            break;   
        }
    }while(!exit);
}

//Menu Admin
public static void MenuA(Admin a)  {
     if (havelogout==true) {
    System.out.println("Welcome " + a.getFirstName() + " " + a.getLastName() + ", your phone is " + a.getPhone() + ", you're admin."); 
    havelogout=false; }
    
    boolean exit=false;
    do{
    System.out.println("1.View  2.Monitor Organization  3.Back  4.Logout  5.Exit  (Enter the number of the option you want)");
    ans=scan.nextLine();
  
        switch (ans) {
            case "1": 
             boolean Case=false;
             boolean ex=false;
             do{
                System.out.println("1.Material  2.Services (Press b to back)"  );
                ans=scan.nextLine(); 
                switch(ans){
                    case "1":
                                Organization.showCategory(ans);
                               do{
                                System.out.print("Type the name of a material for more details:");
                               ans=scan.nextLine();
                                boolean found=false;
                                for(Entity i:Organization.getentityList()){
                                    if(ans.equals(i.getName())){
                                        for(int j=0;j<Organization.getentityList().size();j++){
                                             if(Organization.getentityList().get(j).getName().equals(ans)){
                                                System.out.println(Organization.getentityList().get(j). getEntityInfo());
                                             }
                                        }
                                        found=true;
                                        Case= true;
                                    }
                                }
                                if(found==false){System.out.println("The material doesn't exist!");} 
            
                              }while(!Case);
                         
                    ex=false; //Για να ξανατρέξει
                     
                     break;
                
                    case "2":
                                Organization.showCategory(ans);
                                do{
                                System.out.print("Type the name of a service for more details:");
                               ans=scan.nextLine();
                                boolean found=false;
                                for(Entity i:Organization.getentityList()){
                                    if(ans.equals(i.getName())){
                                        for(int j=0;j<Organization.getentityList().size();j++){
                                             if(Organization.getentityList().get(j).getName().equals(ans)){
                                                System.out.println(Organization.getentityList().get(j). getEntityInfo());
                                             }
                                        }
                                        found=true;
                                        Case= true;
                                    }
                                }
                                if(found==false){System.out.println("The service doesn't exist!");} 
            
                              }while(!Case);  
                    ex= false; //Για να ξανατρέξει   
                     break;
                     
                    case "b":
                    MenuA(a);
                    break;
                    
                    default: 
                                System.out.println("Invalid command");
                    break;
                }
            }while(!ex);
            exit=true;
              break;
            
            case "2": 
            ex=false;
            do{
            System.out.println("1.List Beneficiaries  2.List Donators  3.Reset Beneficiaries Lists (Press b to back)");
            ans=scan.nextLine();
            switch(ans){
                 case"1":
                 ListBen();
                 ex=false;
                 break;
                 
                 case"2":
                 ListDon();
                 ex=false;
                 break;
                 
                 case"3":
                 for(int j=0;j<Organization.getbeneficiaryList().size();j++){
                    Organization.getbeneficiaryList().get(j).receivedList.clear();}
                    System.out.println("All receivedList have been cleared");
                 ex=false;
                 break;
                 
                 case"b":
                 MenuA(a);
                 break;
                 
                 default:
                  System.out.println("Invalid command");
                  break;
                }
            }while(!ex);
                  
            exit=true;  
            break;
            
            case "3":
            ex=false;
            do{
            System.out.println("Do you want to sign in as: " + a.getFirstName() + " " + a.getLastName() +"? (y/n)");
             ans=scan.nextLine();
              if ((ans.equals("n") || ans.equals("no") )) {LogOut();}
              else if(ans.equals("y") || ans.equals("yes") ) {
              Menu.MenuA(a); 
              ex=true;
             }  
            }while(!ex);
             exit=true;
            break;
            
            case "4": 
            LogOut();
            exit=true;
            break;
            
            case "5": 
            ExitFromProgram();
            exit=true;
            break;
            
            default: 
            System.out.println("Invalid command!");
            break;   
        }
    }while(!exit);
}

//Μέθοδος υπο-menu του Admin για την διαχείρηση των Beneficiary
public static void ListBen() {
boolean e =false;
boolean e1=false;
boolean e2=false;
 Organization.listBeneficiary();
 do{
 System.out.println("Choose one Beneficiary by last name (Press b to go back)");
 ans=scan.nextLine();
 if (ans.equals("b")) {break;}
for(Beneficiary i:Organization.getbeneficiaryList()){
                    if(ans.equals(i.getLastName())){
                        for(int j=0;j<Organization.getbeneficiaryList().size();j++){
                        if(Organization.getbeneficiaryList().get(j).getLastName().equals(ans)){
                            e=true;
                                System.out.println(Organization.getbeneficiaryList().get(j).getreceivedList());
                                do{
                                System.out.println("Do you want to delete the list? (y/n)");
                                ans=scan.nextLine();
                                 if ((ans.equals("n") || ans.equals("no") )) {
                                     e1=true;
                                     do{
                                     System.out.println("Do you want to delete this Beneficiary? (y/n)");
                                     ans=scan.nextLine();
                                     if ((ans.equals("n") || ans.equals("no") )) {e2=true; break;} // pame piso
                                    else if(ans.equals("y") || ans.equals("yes") ){
                                     Organization.removeBeneficiary(Organization.getbeneficiaryList().get(j));
                                     System.out.println("Beneficiary successfully Deleted ");
                                     e2=true;
                                     break;
                                      }
                                      else{e2=false; System.out.println("Invalid command");}
                                 } while(!e2);
                                }
                            
                                else if(ans.equals("y") || ans.equals("yes") ){
                                    e1=true;
                                Organization.getbeneficiaryList().get(j).receivedList.clear();
                                 System.out.println("ReceivedList successfully Deleted ");
                                 do{
                                 System.out.println("Do you want to delete this Beneficiary? (y/n)");
                                  ans=scan.nextLine();
                                  if ((ans.equals("n") || ans.equals("no") )) {e2=true; break;} // pame piso
                                 else if(ans.equals("y") || ans.equals("yes") ){
                                   Organization.removeBeneficiary(Organization.getbeneficiaryList().get(j));
                                     System.out.println("Beneficiary successfully Deleted ");
                                     e2=true;
                                     break;
                                } 
                                 else{e2=false; System.out.println("Invalid command");}
                                }while(!e2);
                                }   
                
                            }while(!e1);
                        }
            }
        }
    }
}while(!e); 
}
 
//Μέθοδος υπο-menu του Admin για την διαχείρηση των Donator 
public static void ListDon() {
boolean e=false;
boolean e1=false;
boolean e2=false;
Organization.listDonators();
do{
      System.out.println("Choose one Donator by last name (Press b to go back)");
      ans=scan.nextLine();
    if (ans.equals("b")) {break;}
  for(Donator i:Organization.getdonatorList()){
                if(ans.equals(i.getLastName())){
                    for(int j=0;j<Organization.getdonatorList().size();j++){
                        e=true;
                        do{
                         if(Organization.getdonatorList().get(j).getLastName().equals(ans)){
                            System.out.println(Organization.getdonatorList().get(j).getoffersList());
                            e1=true;
                            do{
                                 System.out.println("Do you want to delete this Donator? (y/n)");
                                 ans=scan.nextLine();
                                 if ((ans.equals("n") || ans.equals("no") )) {e2=true; break;} // pame piso
                                else if(ans.equals("y") || ans.equals("yes") ){
                                    e2=true;
                                 Organization.removeDonator(Organization.getdonatorList().get(j));
                                 System.out.println("Donator successfully Deleted ");
                                 break;
                                  }
                                  else{e2=false; System.out.println("Invalid command");}
                                }while(!e2);
                             }
                        }while(!e1);  
                    }
                }
            }
} while(!e);
}
                            
 
//Αποσύνδεση χρήστη και επιστοροφή στην αρχική σελίδα
public static void LogOut() {
    System.out.println("You have log out and returned to home page");
    havelogout=true;
    try
    {  
    Menu.Scan();
    }
    catch (NullLineReadedException nlre)
    {
     nlre.printStackTrace();
     }
    }

//Μέθοδος που τερματίζεi το πρόγραμμα
public static void ExitFromProgram(){
    System.exit(0);
} 
}
