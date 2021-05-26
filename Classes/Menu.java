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
             Menu.MenuD(d); //Καλέι την μέθοδο με όρισμα την βοηθητική μεταβλητή d τύπου Donator με βάση το τηλέφωνο που βρέθηκε
        }  
} 
for(int i = 0; i<Organization.getbeneficiaryList().size(); i++){
         if(Organization.getbeneficiaryList().get(i).getPhone().equals(ans)){
              search=2;
              b=Organization.getbeneficiaryList().get(i);
              System.out.println("The phone number " + ans + " has been already added in the system as beneficiary");
              Menu.MenuB(b);  //Καλέι την μέθοδο με όρισμα την βοηθητική μεταβλητή b τύπου Benefiaciary με βάση το τηλέφωνο που βρέθηκε
        }  
} 
if (Organization.getAdmin().getPhone().equals(ans)) {
    search = 3;
    System.out.println("The phone number " + ans + " has been already added in the system as admin");
    Menu.MenuA(Organization.getAdmin()); 
    }


if(search==0) {
    System.out.println("Do you want to sign up in our system? (y/n)");
    ans=scan.nextLine();
    while (ans.equals("")) {
       System.out.println("Do you want to sign up in our system? (y/n)"); 
       ans=scan.nextLine(); }
    if ((ans.equals("n") || ans.equals("no") )) {Menu.exitFromProgram();}
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
     Menu.MenuD(d);    
}

//Menu Beneficiary
public static void MenuB(Beneficiary b) {
    System.out.println("Welcome " + b.getFirstName() + " " + b.getLastName() + " your phone is " + b.getPhone() + ", you're benefiaciary and the number of your family members are: " + b.getNoPersons() + ".");  
}

//Menu Donator
public static void MenuD(Donator d) {
    System.out.println("Welcome " + d.getFirstName() + " " + d.getLastName() + " your phone is " + d.getPhone() + ", you're donator.");  
}

//Menu Admin
public static void MenuA(Admin a) {
    System.out.println("Welcome " + a.getFirstName() + " " + a.getLastName() + " your phone is " + a.getPhone() + ", you're admin.");  
}


//Μέθοδος που τερματίζεi το πρόγραμμα
public static void exitFromProgram(){
    System.exit(0);
} 
}
