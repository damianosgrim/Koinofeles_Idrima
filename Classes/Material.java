import java.util.*;
public class Material extends Entity{

    private double level1; //η ποσοτητα που δικαιοuτai 1 ατομο 
    private double level2; //η ποσοτητα που δικαιουνται 2-4 ατομα 
    private double level3; //η ποσοτητα που δικαιουνται 5+ ατομα 
    
    public static int num(Beneficiary b) {
        if(b.getNoPersons()==1) {return 1;}
        else if(b.getNoPersons()>=2 && b.getNoPersons()<=4) {return 2;}
        else if(b.getNoPersons()>=5) {return 3;} }
    
    public  String getDetails(){
        if (num()==1) {return level1 + " the object is material"; }
        else if (num()==2) {return level2 + " the object is material"; }
        else if (num()==3) {return level3 + "  the object is material"; }
        
        
    }
     //@override    
    public String toString(){
        return "info: " + getEntityInfo() + "details "+ getDetails();
     }
     
    //prepei na epistrefei ta levels, na doume ti kanoun levels 
}