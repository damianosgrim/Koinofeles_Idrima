public class NullLineReadedException extends Exception //εξαίρεση για την περίπτωση κενής γραμμής 
{
    public NullLineReadedException(String message){
        super(message);
    }
}
