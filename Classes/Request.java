public class Request extends RequestDonationList{
    public void add(){
    
    }
    
    public void modify(){
    }
    
    public void validRequestDonation(Beneficiary b){
        double level;
       if(b.getNoPersons()==1) {level = 1;}
        else if(b.getNoPersons()>=2 && b.getNoPersons()<=4) {level = 2;}
        else if(b.getNoPersons()>=5) {level = 3;} 
    }
        
        
        
    
}

