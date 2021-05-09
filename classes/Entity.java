public abstract class Entity{
    private String name; //ονομα.                   
    private String description; //συντομη περγραφή
    private int id; //κωδικός είδους
    
    public String getName(){return name;}
    public void setName(String name){this.name=name;}       
    
     public String getDescription(){return description;}
     public void setDescription(String description){this.description=description;}
    
    public int getId(){return id;}
    public void setId(int id){this.id=id;}
     
    public String getEntityInfo(){
        return name + description + id;
    }
    
    abstract String getDetails();
    
    public String toString(){
        return "info: " + getEntityInfo() + "details "+ getDetails(); //εκτύπωση!! προσοχή
        }
}
