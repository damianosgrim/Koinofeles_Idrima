import java.util.*;
import java.io.*;
public class Menu {
     static Scanner scan = new Scanner(System.in);
     private static String ans;
public static void Scan() throws NullLineReadedException{
    System.out.println("Welcome to our Donator-Beneficiary system");
    System.out.println("Please enter a phone number: ");
    boolean search = false;
     ans=scan.nextLine();
     for(int i = 0; i<Organization.getdonatorList().size(); i++){
         if(Organization.getdonatorList().get(i).getPhone().equals(ans)){
              System.out.println("The phone number " + phone + " has been already added in the system");
         
        }
     }  
   
} 
}
