import java.util.*;
public abstract class Entity{
    private String name; //ονομα δωρεάς
    private String description; //συντομη περγραφή
    private int id; //κωδικός είδους
    
    //getter-setter για όνομα δωρεάς
    public String getName(){return name;}
    public void setName(String name){this.name=name;}       
    
    //getter-setter για περιγραφή δωρεάς
    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}
    
    //getter-setter για ID δωρεάς
    public int getId(){return id;}
    public void setId(int id){this.id=id;}
    
    //επιστροφή πληροφοριών
    public String getEntityInfo(){
        return "Name of donation: " +name + " and is " + description + " ID: " + id;
    }
    
    //αφηρημένη μέθοδος
    public abstract String getDetails();
    
    //εκτύπωση πληροφοριών
    public String toString(){
        return "info: " + getEntityInfo() + "details "+ getDetails(); 
    }
    
    //μέθοδος που δηλώνεται για να χρησιμοποιηθεί στην main ώστε να εκτυπώνει στον Admin την ποσότητα των Materials
    public abstract int getEntityCategory();
}
