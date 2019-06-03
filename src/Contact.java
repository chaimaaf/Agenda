import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Contact {
    protected  String nom;
    protected  Date dateNaissance;
    protected  List<String> motsCle;

    public Contact(){}
    public Contact(String nom, Date dateNaissance, List<String> motsCle){
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.motsCle = motsCle;
    }
    public void afficheDonnees(){
        System.out.println("\nNom: " + nom + "\n" +
                "Date de naissance (AAAA/MM/JJ) : " + convertirDateToString(dateNaissance) + "\n" +
                "Mots-cle(s) : " + motsCle.toString() + "\n");
    }
    public  int getAge(){
        LocalDate today = LocalDate.now();
        LocalDate birth = convertirDateNaissance(dateNaissance);
        int age = (int) ChronoUnit.YEARS.between(birth, today);
        return age;
    }
    public  LocalDate convertirDateNaissance(Date dateNaissance){
        return dateNaissance.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    public  String getNom(){
        return nom;
    }
    public  List<String> getMotsCle(){
        return motsCle;
    }
    public String convertirDateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }
}
