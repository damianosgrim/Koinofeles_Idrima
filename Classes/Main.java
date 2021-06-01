import java.util.*;
public class Main {
public static void main(String[] args) {
Admin ad = new Admin("Chryssa", "Pateli", "13033");
Organization org = new Organization("KoinofelesIdrimaCEID", ad);


Menu menu = new Menu();

Material mlk = new Material();
mlk.setName("Milk");
mlk.setDescription("Dairy product 1lt ");
mlk.getId();
org.addEntity(mlk);


Material sug = new Material();
sug.setName("Sugar");
sug.setDescription("Sweetener 1kg ");
sug.getId(); 
org.addEntity(sug);

Material rc = new Material();
rc.setName("Rice");
rc.setDescription("Cereal grain 500gr ");
rc.getId();
org.addEntity(rc);

Service mds = new Service();
mds.setName("MedicalSupport");
mds.setDescription("Health service");
mds.getId();
org.addEntity(mds);

Service nrs = new Service();
nrs.setName("NurserySupport");
nrs.setDescription("Health service");
nrs.getId();
org.addEntity(nrs);

Service bs = new Service();
bs.setName("BabySitting");
bs.setDescription("Housekeeping ");
bs.getId();
org.addEntity(bs);


Beneficiary b1 = new Beneficiary("Maria", "Kouri", "13032", 4); //Etoimata Request
Beneficiary b2 = new Beneficiary("Damianos", "Grimanis", "13031", 2);  //Paroxes offers
Donator d = new Donator("Eleni", "Vogiatzaki", "13030");
org.insertBeneficiary(b1);
org.insertBeneficiary(b2);
org.insertDonator(d);
 
try
{
    menu.Scan();
}
catch (NullLineReadedException nlre)
{
    nlre.printStackTrace();
}
}
}

