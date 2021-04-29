public class Material extends Entity{

    private double level1; //η ποσοτητα που δικαιουται 1 ατομο
    private double level2; // η ποσοτητα που δικαιουνται 2-4 ατομα
    private double level3; // η ποσότητα που δικαιουνται 5 και περισσότερα ατομα
    
    public String getDetails(){
        return (level1 + level2 + level3 + " the object is material" );
    }
}
        
