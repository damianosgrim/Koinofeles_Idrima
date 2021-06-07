import java.util.*;
public class Material extends Entity{

    private static double level1=5; //η ποσοτητα που δικαιουται 1 ατομο 
    private static double level2=10; //η ποσοτητα που δικαιουνται 2-4 ατομα 
    private static double level3=20; //η ποσοτητα που δικαιουνται 5+ ατομα 
    public int EntityCategory=1;
    
    //getters για levels
    public static double  getLevel1(){return level1;}
    public static double getLevel2(){return level2;}
    public static double getLevel3(){return level3;}
     
    ////setters για levels
    public void setLevel1(double level1){this.level1=level1;}
    public void setLevel2(double level2){this.level2=level2;}
    public void setLevel3(double level3){this.level3=level3;}
    
    //getters για επιστροφή των ποσοτήτων του κάθε level και του είδους 
    public String getDetails(){
       
        return ("level1: "+ level1 + " level2 " + level2 + " level3 " + level3 + " this object is material");
        
    }
     
    
    //μέθοδος για την εκτύπωση πληροφοριών και λεπτομερειών //@override    
    public String toString(){
        return "info: " + getEntityInfo() + "details "+ getDetails();
     }
    
//μέθοδος που δηλώνεται για να χρησιμοποιηθεί στην Organization ώστε να εκτυπώνει Materials
    public int getCategory(){
        return EntityCategory;
    }
}
