public class Service extends Entity{
      public String getDetails(){
          return ("the object is service");
        }
      //@override
    public String toString(){
    return "info: " + getEntityInfo() + "details "+ getDetails();
    }
}
