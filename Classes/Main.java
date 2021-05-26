import java.util.*;
public class Main {
public static void main(String[] args) {
Admin ad = new Admin("Chryssa", "Pateli", "13033");
Organization org = new Organization("KoinofelesIdrimaCEID", ad);

Menu menu = new Menu();

Material mlk = new Material();
mlk.setName("milk");
org.addEntity(mlk);

Material sug = new Material();
sug.setName("sugar");
org.addEntity(sug);

Material rc = new Material();
rc.setName("rice");
org.addEntity(rc);

Service mds = new Service();
mds.setName("MedicalSupport");
org.addEntity(mds);

Service nrs = new Service();
nrs.setName("NurserySupport");
org.addEntity(nrs);

Service bs = new Service();
bs.setName("BabySitting");
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
