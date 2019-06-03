
import java.util.Date;
import java.util.List;

public class ContactCommercial extends Contact {
    protected  List<Telephone> telephones;
    protected  String entreprise;

    public ContactCommercial(){}
    public ContactCommercial(String nom, Date dateNaissance, List<String> motsCle, List<Telephone> telephones, String entreprise){
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.motsCle = motsCle;
        this.telephones = telephones;
        this.entreprise = entreprise;
    }
    public void afficheDonnees(){
        System.out.println("\nNom: " + nom + "\n" +
                "Date de naissance (AAAA/MM/JJ) : " + convertirDateToString(dateNaissance) + "\n" +
                afficherTelephones() +
                "Nom de l'entreprise : " + entreprise + "\n" +
                "Mots-cle(s) : " + motsCle.toString() + "\n");
    }
    //public static int getAge(){return 0;}
    //public String getNom(){return this.nom;}
    public String getTelephones(){return telephones.toString();}
    public void addTelephone(Telephone tel){
        telephones.add(tel);
    }
    public String afficherTelephones(){
        String tel = "";
        for (int i = 0; i < telephones.size(); i++) {
            tel += telephones.get(i).toString() + "\n";
        }
        return tel;
    }
}
