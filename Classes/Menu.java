import java.util.*;
import java.io.*;
import java.lang.*;
public class Menu {
     static Scanner scan = new Scanner(System.in);
     private static String ans;
     private static String phone;
     private static boolean havelogout=true; //Maς δείχνει αν ο χρήστης είναι συνδεδεμένος στο σύστημα
 
    
public static void Scan() throws NullLineReadedException{
    System.out.println("Welcome to our Donator-Beneficiary system");
    System.out.println("Please enter a phone number: ");
    int search = 0; //Εκχωρηση τιμής 1,2,3 ανάλογα με τον τύπο του user 
     Beneficiary b; //Βοηθητική μεταβλητή
     Donator d; //Βοηθητική μεταβλητή
     ans=scan.nextLine();
     phone=ans;
for(int i = 0; i<Organization.getdonatorList().size(); i++){
         if(Organization.getdonatorList().get(i).getPhone().equals(ans)){
             search=1;
             d=Organization.getdonatorList().get(i);
             System.out.println("The phone number " + ans + " has been already added in the system as donator");
             System.out.println("Do you want to sign in as: " + d.getFirstName() + " " + d.getLastName() +"? (y/n)");
             ans=scan.nextLine();
             if ((ans.equals("n") || ans.equals("no") )) {LogOut();}
            else if(ans.equals("y") || ans.equals("yes") ) {
            Menu.MenuD(d); //Καλέι την μέθοδο με όρισμα την βοηθητική μεταβλητή d τύπου Donator με βάση το τηλέφωνο που βρέθηκε
            } 
        } 
        
} 
for(int i = 0; i<Organization.getbeneficiaryList().size(); i++){
         if(Organization.getbeneficiaryList().get(i).getPhone().equals(ans)){
              search=2;
              b=Organization.getbeneficiaryList().get(i);
              System.out.println("The phone number " + ans + " has been already added in the system as beneficiary");
             System.out.println("Do you want to sign in as: " + b.getFirstName() + " " + b.getLastName() +"? (y/n)");
             ans=scan.nextLine();
              if ((ans.equals("n") || ans.equals("no") )) {ExitFromProgram();}
              else if(ans.equals("y") || ans.equals("yes") ) {
              Menu.MenuB(b);  //Καλέι την μέθοδο με όρισμα την βοηθητική μεταβλητή b τύπου Benefiaciary με βάση το τηλέφωνο που βρέθηκε
             }  
         }
} 
if (Organization.getAdmin().getPhone().equals(ans)) {
    search = 3;
    System.out.println("The phone number " + ans + " has been already added in the system as admin");
     System.out.println("Do you want to sign in as: " + Organization.getAdmin().getFirstName() + " " + Organization.getAdmin().getLastName() +"? (y/n)");
    ans=scan.nextLine();
    if ((ans.equals("n") || ans.equals("no") )) {ExitFromProgram();}
    else if(ans.equals("y") || ans.equals("yes") ) {
    Menu.MenuA(Organization.getAdmin()); 
    }
}


if(search==0) {
    System.out.println("Do you want to sign up in our system? (y/n)");
    ans=scan.nextLine();
    while (ans.equals("")) {
       System.out.println("Do you want to sign up in our system? (y/n)"); 
       ans=scan.nextLine(); }
    if ((ans.equals("n") || ans.equals("no") )) {ExitFromProgram();}
    else if(ans.equals("y") || ans.equals("yes") ) {
        boolean exit=false;
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
                System.out.println("Invalid command!");
            break;   
        }
    }while(!exit);

    } 
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
     if (havelogout==true) {
    System.out.println("Welcome " + b.getFirstName() + " " + b.getLastName() + ", your phone is " + b.getPhone() + ", you're benefiaciary and the number of your family members are: " + b.getNoPersons() + ".");
    havelogout=false; }
    boolean exit=false;
    do{
    System.out.println("1.Add Request  2.Show Requests  3.Commit  4.Back  5.Logout  6.Exit  (Enter the number of the option you want)");
    ans=scan.nextLine();
        switch (ans) {
            case "1":
            exit=true;
            break;
            
            case "2": 
            exit=true;
            break;
            
            case "3":
            exit=true;
            break;
            
            case "4": 
            System.out.println("Do you want to sign in as: " + b.getFirstName() + " " + b.getLastName() +"? (y/n)");
             ans=scan.nextLine();
              if ((ans.equals("n") || ans.equals("no") )) {LogOut();}
              else if(ans.equals("y") || ans.equals("yes") ) {
              Menu.MenuB(b);  
              exit=true;
             }  
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

//Menu Donator
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
            boolean ex=false;
            System.out.println("Select what type of offer you want to add");
            do{
            System.out.println("1.Matterial  2.Offer (Press b to back)");
            ans=scan.nextLine();
            switch (ans) {
                case "1":
                ex=true;
                break;
                
                case "2":
                ex=true;
                break;
                
                case "b":
                MenuD(d);
                ex=true;
                break;
                
                default: 
            System.out.println("Invalid command!");
            break;   
            }
        }while(!ex);
        exit=true;
            break;
            
            case "2": 
            exit=true;
            break;
            
            case "3": 
            exit=true;
            break;
            
            case "4": 
            System.out.println("Do you want to sign in as: " + d.getFirstName() + " " + d.getLastName() +"? (y/n)");
             ans=scan.nextLine();
              if ((ans.equals("n") || ans.equals("no") )) {LogOut();}
              else if(ans.equals("y") || ans.equals("yes") ) {
              Menu.MenuD(d);  
             }  
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
                System.out.println("1.Material  2.Services"  );
                ans=scan.nextLine(); 
                switch(ans){
                    case "1":
                                Organization.showEntityinCategory(ans);
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
                         
                    ex=true;
                     
                     break;
                
                    case "2":
                                Organization.showEntityinCategory(ans);
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
                    ex= true;    
                     break;
                
                    default: 
                                System.out.println("Invalid command");
                    break;
                }
            }while(!ex);
            exit=true;
              break;
            
            case "2": 
            exit=true;  
            break;
            
            case "3": 
            System.out.println("Do you want to sign in as: " + a.getFirstName() + " " + a.getLastName() +"? (y/n)");
             ans=scan.nextLine();
              if ((ans.equals("n") || ans.equals("no") )) {LogOut();}
              else if(ans.equals("y") || ans.equals("yes") ) {
              Menu.MenuA(a);  
             }  
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
