import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lecture {
    protected List<Contact> listeContacts = new ArrayList<>();

    public static List<Contact> lireFichierCSV(String nomDuFichier){
        FileReader file;
        BufferedReader in;
        String ligne = "";
        List<Contact> contacts = new ArrayList<>();
        try {
            file = new FileReader(nomDuFichier);
            in = new BufferedReader(file);
            while ((ligne = in.readLine()) != null){
                //System.out.println(ligne);
               String [] uneLigneDuCSV = ligne.split(",");
               Contact c = creerObjets(uneLigneDuCSV);
                //System.out.println(c.getNom());
               contacts.add(c);
            }
            file.close();
            in.close();
        } catch (FileNotFoundException fnfe){
            System.out.println(Constantes.MSG_ERR_FNFE);
            System.exit(-1);
        } catch (IOException ioe){
            System.out.println("IOException");
        } finally {
            return contacts;
        }
    }

    public static Contact creerObjets(String [] tabCSV){
        Contact contact = null;
        if (tabCSV[0].equals("Generique")){
            contact = creerObjetContact(tabCSV);
        } else if (tabCSV[0].equals("Personnel")){
            contact = creerObjetContactPersonnel(tabCSV);
            Agenda.nbrContactsPersonnels++;
        } else if (tabCSV[0].equals("Commercial")){
            contact = creerObjetContactCommercial(tabCSV);
            Agenda.getNbrContactsCommerciaux++;
        }
        return contact;
    }

    public static Contact creerObjetContact(String[] tabCSV){
        List<String> motsCle = new ArrayList<>();
        String dateDeNaissance = confirmerFormatDateNaissance(tabCSV);
        String nom = tabCSV[4];
        for (int i = 5; i < tabCSV.length ; i++) {
            motsCle.add(tabCSV[i]);
        }
        return new Contact(nom, Agenda.convertirStringtoDate(dateDeNaissance), motsCle);
    }
    public static Contact creerObjetContactPersonnel(String [] tabCSV){
        List<String> motsCle = new ArrayList<>();
        String dateDeNaissance = confirmerFormatDateNaissance(tabCSV);
        String nom = tabCSV[4];
        for (int i = 7; i < tabCSV.length ; i++) {
            motsCle.add(tabCSV[i]);
        }
        return new ContactPersonnel(nom, new Telephone(tabCSV[5], tabCSV[6]),
                Agenda.convertirStringtoDate(dateDeNaissance), motsCle );
    }
    public static Contact creerObjetContactCommercial(String [] tabCSV){
        List<Telephone> listeTelephones = new ArrayList<>();
        List<String> motsCle = new ArrayList<>();
        String entreprise = tabCSV[1];
        String dateDeNaissance = confirmerFormatDateNaissanceCommercial(tabCSV);
        String nom = tabCSV[5];
        listeTelephones.add(new Telephone(tabCSV[6], "Bureau"));
        listeTelephones.add(new Telephone(tabCSV[8], "Cellulaire"));
        listeTelephones.add(new Telephone(tabCSV[10], "Maison"));
        for (int i = 12; i < tabCSV.length ; i++) {
            motsCle.add(tabCSV[i]);
        }
        return new ContactCommercial(nom, Agenda.convertirStringtoDate(dateDeNaissance), motsCle,
                listeTelephones, entreprise);
    }

    public static String confirmerFormatDateNaissance(String[] tabCSV){
        String dateDeNaissance = "";
        if (tabCSV[2].length()  == 1 && tabCSV[1].length()  == 1){
            dateDeNaissance = tabCSV[3] + "/0" + tabCSV[2] + "/0" + tabCSV[1];
        } else if (tabCSV[2].length()  == 1) {
            dateDeNaissance = tabCSV[3] + "/0" + tabCSV[2] + "/" + tabCSV[1];
        } else if (tabCSV[1].length()  == 1) {
            dateDeNaissance = tabCSV[3] + "/" + tabCSV[2] + "/0" + tabCSV[1];
        } else if ((tabCSV[2].length()  == 2) && (tabCSV[1].length()  == 2)) {
            dateDeNaissance = tabCSV[3] + "/" + tabCSV[2] + "/" + tabCSV[1];
        }
        return dateDeNaissance;
    }

    public static String confirmerFormatDateNaissanceCommercial(String[] tabCSV){
        String dateDeNaissance = "";
        if (tabCSV[3].length()  == 1 && tabCSV[2].length()  == 1){
            dateDeNaissance = tabCSV[4] + "/0" + tabCSV[3] + "/0" + tabCSV[2];
        } else if (tabCSV[3].length()  == 1) {
            dateDeNaissance = tabCSV[4] + "/0" + tabCSV[3] + "/" + tabCSV[2];
        } else if (tabCSV[2].length()  == 1) {
            dateDeNaissance = tabCSV[4] + "/" + tabCSV[3] + "/0" + tabCSV[2];
        } else if ((tabCSV[3].length()  == 2) && (tabCSV[2].length()  == 2)) {
            dateDeNaissance = tabCSV[4] + "/" + tabCSV[3] + "/" + tabCSV[2];
        }
        return dateDeNaissance;
    }
}
