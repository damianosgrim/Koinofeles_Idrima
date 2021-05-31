public class Service extends Entity{
    public int EntityCategory=2;
      public String getDetails(){
          return ("the object is service");
        }
      //@override
    public String toString(){
    return "info: " + getEntityInfo() + "details "+ getDetails();
    }
     public int getEntityCategory(){
        return EntityCategory;
    }
      
}
