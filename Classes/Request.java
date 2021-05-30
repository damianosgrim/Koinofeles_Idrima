public class Request extends RequestDonationList{
    
    //@override
    public static void add(RequestDonation requestdonation, double quant){  // εξαιρεση!!!
         for (int i = 0; i<rdEntities.size(); i++)
        {
        if(rdEntities.get(i).getEntity().getId()== requestdonation.getEntity().getId()) {
            requestdonation.setQuantity(requestdonation.getQuantity()+quant);
            rdEntities.get(i).setQuantity(requestdonation.getQuantity()+quant);
        }
        else if (rdEntities.get(i).getEntity().getId() != requestdonation.getEntity().getId()){
        rdEntities.add(requestdonation);}
    } 
   }
    
    public void modify(RequestDonation d ,double quantity){
        if(rdEntities.contains(d)){
        d.setQuantity(quantity);
        rdEntities.get(rdEntities.indexOf(d)).setQuantity(quantity);
    }
    }
    
    public boolean validRequestDonation(Beneficiary b, RequestDonation d){  // ελεγχος ποσοτητας
        boolean l=false;
       if(b.getNoPersons()==1) {
           if(d.getQuantity()<=Material.getLevel1()){
               l = true;
        }
       }
        else if(b.getNoPersons()>=2 && b.getNoPersons()<=4) {
             if(d.getQuantity()<=Material.getLevel2()){
               l = true;
        }
        }
        else if(b.getNoPersons()>=5) {
             if(d.getQuantity()<=Material.getLevel3()){
               l = true;
        } 
    }
        return l;
        
    }
    
    public void commit(Beneficiary b, RequestDonation d){
        try{
            if(validRequestDonation(b,d)){
                rdEntities.remove(d);
                b.receivedList.add(d); }
            }
            catch(Exception e){
            System.out.println("You can't make a request :( ");
        }
    }
            
            
}
  


