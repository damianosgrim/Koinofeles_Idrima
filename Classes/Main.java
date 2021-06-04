import java.util.*;
public class Main {
public static void main(String[] args) {
 //δημιουργία αντικειμένου τύπου admin
Admin ad = new Admin("Chryssa", "Pateli", "13033");
//δημιουργία αντικειμένου τύπου Organization
Organization org = new Organization("KoinofelesIdrimaCEID", ad);

//δημιουργία αντικειμένου τύπου Menu
Menu menu = new Menu();

//δημιουργία αντικειμένου τύπου Material
Material mlk = new Material();
mlk.setName("Milk");
mlk.setDescription("Dairy product 1lt ");
mlk.getId();
org.addEntity(mlk);

//δημιουργία αντικειμένου τύπου Material
Material sug = new Material();
sug.setName("Sugar");
sug.setDescription("Sweetener 1kg ");
sug.getId(); 
org.addEntity(sug);

//δημιουργία αντικειμένου τύπου Material
Material rc = new Material();
rc.setName("Rice");
rc.setDescription("Cereal grain 500gr ");
rc.getId();
org.addEntity(rc);

//δημιουργία αντικειμένου τύπου Service
Service mds = new Service();
mds.setName("MedicalSupport");
mds.setDescription("Health service");
mds.getId();
org.addEntity(mds);

//δημιουργία αντικειμένου τύπου Service
Service nrs = new Service();
nrs.setName("NurserySupport");
nrs.setDescription("Health service");
nrs.getId();
org.addEntity(nrs);

//δημιουργία αντικειμένου τύπου Service
Service bs = new Service();
bs.setName("BabySitting");
bs.setDescription("Housekeeping ");
bs.getId();
org.addEntity(bs);

//δημιουργία αντικειμένου τύπου Beneficiary
Beneficiary b1 = new Beneficiary("Maria", "Kouri", "13032", 4); 
Beneficiary b2 = new Beneficiary("Damianos", "Grimanis", "13031", 2); 
 
//δημιουργία αντικειμένου τύπου Donator
Donator d = new Donator("Eleni", "Vogiatzaki", "13030");
//προσθήκη στον οργανισμό
org.insertBeneficiary(b1);
org.insertBeneficiary(b2);
org.insertDonator(d);


try
{
    menu.Scan(); //καλεί την scan της menu
}
catch (NullLineReadedException nlre) //εξαίρεση για κενή γραμμή
{
    nlre.printStackTrace(); 
}
}
}

