import java.util.*;
import java.io.*;
import java.lang.*;
public class Menu {
     static Scanner scan = new Scanner(System.in);
     private static String ans;
     private static String phone;
     
 
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
        System.out.println("Do you want to sign up as (1)Beneficiary or (2)Donator? (1/2)");
        ans=scan.nextLine();
        switch (ans) {
            case "1": 
            Menu.SignB();
            break;
            
            case "2": 
            Menu.SignD();
            break;
            
            default: 
                System.out.println("Invalid command!");
            break;   
        }

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


//Μέθοδος εγρραφής χρήστη ως Beneficiary
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
    System.out.println("Welcome " + b.getFirstName() + " " + b.getLastName() + ", your phone is " + b.getPhone() + ", you're benefiaciary and the number of your family members are: " + b.getNoPersons() + ".");  
    System.out.println("1.Add Request  2.Show Requests  3.Commit  4.Back  5.Logout  6.Exit  (Enter the number of the option you want)");
    ans=scan.nextLine();
        switch (ans) {
            case "1": 
            break;
            
            case "2": 
            break;
            
            case "3": 
            break;
            
            case "4": 
            System.out.println("Do you want to sign in as: " + b.getFirstName() + " " + b.getLastName() +"? (y/n)");
             ans=scan.nextLine();
              if ((ans.equals("n") || ans.equals("no") )) {LogOut();}
              else if(ans.equals("y") || ans.equals("yes") ) {
              Menu.MenuB(b);  
             }  
            break;
            
            case "5": 
            LogOut();
            break;
            
            case "6": 
            ExitFromProgram();
            break;
            
            default: 
            System.out.println("Invalid command!");
            break;   
        }
}

//Menu Donator
public static void MenuD(Donator d) {
    System.out.println("Welcome " + d.getFirstName() + " " + d.getLastName() + ", your phone is " + d.getPhone() + ", you're donator."); 
    System.out.println("1.Add Offer  2.Show Offers  3.Commit  4.Back  5.Logout  6.Exit  (Enter the number of the option you want)");
    ans=scan.nextLine();
        switch (ans) {
            case "1": 
            break;
            
            case "2": 
            break;
            
            case "3": 
            break;
            
            case "4": 
            System.out.println("Do you want to sign in as: " + d.getFirstName() + " " + d.getLastName() +"? (y/n)");
             ans=scan.nextLine();
              if ((ans.equals("n") || ans.equals("no") )) {LogOut();}
              else if(ans.equals("y") || ans.equals("yes") ) {
              Menu.MenuD(d);  
             }  
            break;
            
            case "5": 
            LogOut();
            break;
            
            case "6": 
            ExitFromProgram();
            break;
            
            default: 
            System.out.println("Invalid command!");
            break;   
        }
}

//Menu Admin
public static void MenuA(Admin a) {
    System.out.println("Welcome " + a.getFirstName() + " " + a.getLastName() + ", your phone is " + a.getPhone() + ", you're admin."); 
    System.out.println("1.View  2.Monitor Organization  3.Back  4.Logout  5.Exit  (Enter the number of the option you want)");
    ans=scan.nextLine();
        switch (ans) {
            case "1": 
            break;
            
            case "2": 
            break;
            
            case "3": 
            System.out.println("Do you want to sign in as: " + a.getFirstName() + " " + a.getLastName() +"? (y/n)");
             ans=scan.nextLine();
              if ((ans.equals("n") || ans.equals("no") )) {LogOut();}
              else if(ans.equals("y") || ans.equals("yes") ) {
              Menu.MenuA(a);  
             }  
            break;
            
            case "4": 
            LogOut();
            break;
            
            case "5": 
            ExitFromProgram();
            break;
            
            default: 
            System.out.println("Invalid command!");
            break;   
        }
}

//Αποσύνδεση χρήστη και επιστοροφή στην αρχική σελίδα
public static void LogOut() {
    System.out.println("You have log out and returned to home page");
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
