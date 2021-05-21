import java.util.*;
public class Menu {
public static void Scan() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter a phone number: ");
    String phone=scan.nextLine();
    
    /* boolean num1 = donatorList.contains(phone);
    boolean num2 = beneficiaryList.contains(phone); */
    
    if(exists(phone)==0) { System.out.println("The phone number " + phone + " has been already added in the system"); }
    else { System.out.println("Do you want to sign up in our system? (y/n): ");
           String ans1=scan.nextLine();
           if(ans1=="y"||ans1=="yes") {
               System.out.println("Sign up as Beneficiary or Donator? (b/d): ");
               String ans2=scan.nextLine();
               if(ans2=="b"||ans2=="beneficiary") { System.out.println("You sign up as beneficiary"); }
               else if(ans2=="d"||ans2=="donator") {System.out.println("You sign up as donator"); }
            }
           else if(ans1=="n"||ans1=="no") {System.out.println("Goodbyeeee :( ");}
        }
} 
}

    
   
   
