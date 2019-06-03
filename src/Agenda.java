import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Agenda {
    protected String nomAgenda;
    protected  List<Contact> listeContacts;
    protected static int nbrContactsPersonnels = 0;
    protected static int getNbrContactsCommerciaux = 0;

    public Agenda() {
        this.listeContacts = new ArrayList<>();
    }

    public Agenda(String nomAgenda, List<Contact> listeContacts){
        this.nomAgenda = nomAgenda;
        this.listeContacts = listeContacts;
    }
    public void rechercherParNom(String nom){
        List<Contact> trouvesParNom = new ArrayList<>();
        for (int i = 0; i < listeContacts.size() ; i++) {
            if (listeContacts.get(i).getNom().equals(nom)){
                trouvesParNom.add(listeContacts.get(i));
            }
        }
        afficherContactsRecherches(trouvesParNom);
        appuyerEntreePourMenu();
    }
    public  void afficherContactsRecherches(List<Contact> contactsRecherches){
        if (contactsRecherches.size() == 0){
            System.out.println(Constantes.MSG_NO_CONTACT);
        } else {
            for (int i = 0; i < contactsRecherches.size(); i++) {
                contactsRecherches.get(i).afficheDonnees();
            }
        }
    }
    public  void rechercherParPosition(int pos){
        if (pos > 0 && pos <= listeContacts.size()) {
            listeContacts.get(pos - 1).afficheDonnees();
        } else {
            System.out.print(Constantes.MSG_ERR_POS_INVALIDE);
        }
        appuyerEntreePourMenu();;
    }
    public void rechercherParMotCle(String key){
        List<Contact> trouvesParMotCle = new ArrayList<Contact>();
        for (int i = 0; i < listeContacts.size() ; i++) {
            if (listeContacts.get(i).getMotsCle().contains(key)){
                trouvesParMotCle.add(listeContacts.get(i));
            }
        }
        afficherContactsRecherches(trouvesParMotCle);
        appuyerEntreePourMenu();
    }
    public void afficherTous(){
        for (int i = 0; i < listeContacts.size() ; i++) {
            listeContacts.get(i).afficheDonnees();
        }
        appuyerEntreePourMenu();
    }
    public void afficherQuantites(){
        System.out.println(Constantes.MSG_NBR_CONTACTS + listeContacts.size());
        System.out.println(Constantes.MSG_NBR_PERSO + nbrContactsPersonnels);
        System.out.println(Constantes.MSG_NBR_COMM + getNbrContactsCommerciaux);
        System.out.println(Constantes.MSG_NBR_GENERIQUES + (listeContacts.size() -
                (nbrContactsPersonnels + getNbrContactsCommerciaux)));
        appuyerEntreePourMenu();
    }
    public void insererContact(){
        System.out.println(Constantes.MSG_SOL_TYPE_CONTACT);
        switch (Principale.lireClavier()){
            case "1":
                insererContactPersonnel();
                appuyerEntreePourMenu();
                break;
            case "2":
                insererContactCommercial();
                appuyerEntreePourMenu();
                break;
            case "3":
                insererContactGenerique();
                appuyerEntreePourMenu();
                break;
            default:
                System.out.println(Constantes.MSG_ERR_CHOIX_INVALIDE);
                appuyerEntreePourMenu();
                break;
        }

    }
    public void insererContactGenerique(){
        System.out.print(Constantes.MSG_SOL_NOM);
        String name = Principale.lireClavier();
        System.out.print(Constantes.MSG_SOL_DATE_NAISSANCE);
        Date birthday = convertirStringtoDate(Principale.lireClavier());
        System.out.print(Constantes.MSG_SOL_MOTSCLE);
        List<String> keyWords = creerListeMotsCles(Principale.lireClavier());
        listeContacts.add(new Contact(name, birthday, keyWords));
        System.out.println(Constantes.MSG_NEW_CONTACT);
    }
    public void insererContactPersonnel(){
        System.out.print(Constantes.MSG_SOL_NOM);
        String name = Principale.lireClavier();
        System.out.print(Constantes.MSG_SOL_TEL);
        String numero = Principale.lireClavier();
        System.out.println(Constantes.MSG_SOL_TYPETEL);
        String typetel = validerTypeTel(Principale.lireClavier());
        System.out.print(Constantes.MSG_SOL_DATE_NAISSANCE);
        Date birthday = convertirStringtoDate(Principale.lireClavier());
        System.out.print(Constantes.MSG_SOL_MOTSCLE);
        List<String> keyWords = creerListeMotsCles(Principale.lireClavier());
        listeContacts.add(new ContactPersonnel(name, new Telephone(numero, typetel), birthday, keyWords));
        System.out.println(Constantes.MSG_NEW_CONTACT);
        nbrContactsPersonnels++;
    }
    public String validerTypeTel(String typeTel) {
        String type = "";
        if (typeTel.equals("1"))
            type = "Cellulaire";
        else if (typeTel.equals("2"))
            type = "Maison";
        else {
            System.out.println(Constantes.MSG_ERR_CHOIX_INVALIDE);
            insererContactPersonnel();
        }
        return type;
    }
    public void insererContactCommercial(){
        System.out.print(Constantes.MSG_SOL_NOM);
        String name = Principale.lireClavier();
        List<Telephone> listTel = creerListeTelephone();
        System.out.print(Constantes.MSG_SOL_DATE_NAISSANCE);
        Date birthday = convertirStringtoDate(Principale.lireClavier());
        System.out.print(Constantes.MSG_SOL_ENTREPRISE);
        String entreprise = Principale.lireClavier();
        System.out.print(Constantes.MSG_SOL_MOTSCLE);
        List<String> keyWords = creerListeMotsCles(Principale.lireClavier());
        listeContacts.add(new ContactCommercial(name, birthday, keyWords, listTel, entreprise));
        System.out.println(Constantes.MSG_NEW_CONTACT);
        getNbrContactsCommerciaux++;
    }
    public List<Telephone> creerListeTelephone(){
        List<Telephone> listTel = new ArrayList<Telephone>();
        System.out.println(Constantes.MSG_3_TEL);
        System.out.print(Constantes.MSG_SOL_TEL_BUREAU);
        listTel.add(new Telephone(Principale.lireClavier(), "Bureau"));
        System.out.print(Constantes.MSG_SOL_TEL_CELL);
        listTel.add(new Telephone(Principale.lireClavier(), "Cellulaire"));
        System.out.print(Constantes.MSG_SOL_TEL_MAISON);
        listTel.add(new Telephone(Principale.lireClavier(), "Maison"));
        return listTel;
    }

    public List<String> creerListeMotsCles(String key){
        List<String> keyWords = new ArrayList<>();
        while (!key.equals("")) {
            keyWords.add(key);
            System.out.print(Constantes.MSG_SOL_MOTSCLE);
            key = Principale.lireClavier();
        }
        return keyWords;
    }

    public void appuyerEntreePourMenu(){
        System.out.print(Constantes.MSG_ENTREE);
        String entree = Principale.lireClavier();
        if (entree.equals(""))
            Principale.validerChoixMenu(listeContacts, Principale.afficherMenu());
        else
            appuyerEntreePourMenu();
    }
    public static Date convertirStringtoDate(String date){
        Date birthday = null;
        try {
            birthday = new SimpleDateFormat("yyyy/MM/dd").parse(date);
        } catch(ParseException pe){
            System.out.println("\nMauvais format de date de naissance. Veuillez recommencer.");
        }
        return birthday;
    }
}
