import java.util.*;
public abstract class Entity{
    private String name; //ονομα δωρεάς
    private String description; //συντομη περγραφή
    private int id; //κωδικός είδους
     private static int CID = 0; // βοηθητικη μεταβλητη για αναθεση id
    
    //getter-setter για όνομα δωρεάς
    public String getName(){return name;}
    public void setName(String name){this.name=name;}       
    
    //getter-setter για περιγραφή δωρεάς
    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}
    
    //getter-setter για ID δωρεάς
    public int getId(){
         ++CID;
        id = CID;
        return id;
    }
    public void setId(int id){this.id=id;}
    
    //επιστροφή πληροφοριών
    public String getEntityInfo(){
        String cat="" ; // μεταβλητη για διαχωρισμο Id εμφανιζει M:material. S:service
        if(getCategory()==1){ cat="M" ;} 
        else if(getCategory()==2){ cat="S";}
        return "Name of donation: " +name + " and is " + description + " ID:  " + cat  + id; 
    }
    
    //αφηρημένη μέθοδος
    public abstract String getDetails();
    
    //εκτύπωση πληροφοριών
    public String toString(){
        return "info: " + getEntityInfo() + "details "+ getDetails(); 
    }
    
   //μέθοδος που δηλώνεται για να διαχωρίζει τα Services ή τα Materials (προσθήκη σώματος υποκλάσεις)
    public abstract int getCategory();
}
   
