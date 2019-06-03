import java.util.Date;
import java.util.List;

public class ContactPersonnel extends Contact{
    protected  Telephone telephone;

    public ContactPersonnel(){}
    public ContactPersonnel(String nom, Telephone telephone, Date dateNaissance, List<String> motsCle){
        this.nom = nom;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
        this.motsCle = motsCle;
    }
    public void afficheDonnees(){
        System.out.println("\nNom : " + nom + "\n" +
                "Date de naissance (AAAA/MM/JJ) : " + convertirDateToString(dateNaissance) + "\n" +
                telephone + "\n" +
                "Mots-cle(s) : " + motsCle.toString() + "\n");
    }
    //public static int getAge(){return 0;}
    public void setTelephone(Telephone tel){
        this.telephone = tel;
    }
    public  Telephone getTelephone(){ return telephone;}
    public  String getNom(){ return nom;}
    public void setNom(String nom){
        this.nom = nom;
    }
}
