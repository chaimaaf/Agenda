import java.util.List;
import java.util.Scanner;

public class Principale {
    public static void main(String[] args){
        List<Contact> listeContacts = Lecture.lireFichierCSV(lireNomDuFichierCSV());
        System.out.print(Constantes.MSG_ENTETE);
        validerChoixMenu(listeContacts, afficherMenu());
    }

    public static String lireNomDuFichierCSV(){
        System.out.print(Constantes.MSG_SOL_CSV);
        return lireClavier();
    }

    public static String afficherMenu(){
        System.out.print(Constantes.MSG_MENU);
        String choix = lireClavier();
        return choix;
    }

    public static void validerChoixMenu(List<Contact> listeContacts, String choix){
        Agenda agenda = new Agenda("Agenda", listeContacts);
        switch (choix) {
            case "1" :
                System.out.print(Constantes.MSG_SOL_NOM);
                agenda.rechercherParNom(lireClavier());
                break;
            case "2" :
                System.out.print(Constantes.MSG_SOL_POS);
                agenda.rechercherParPosition(Integer.parseInt(lireClavier()));
                break;
            case "3" :
                System.out.print(Constantes.MSG_SOL_MOT);
                agenda.rechercherParMotCle(lireClavier());
                break;
            case "4" :
                agenda.insererContact();
                break;
            case "5" :
                agenda.afficherTous();
                break;
            case "6" :
                agenda.afficherQuantites();
                break;
            case "7" :
                System.out.println(Constantes.MSG_FIN);
                System.exit(-1);
                break;
            default:
                System.out.println("\nChoix invalide. Recommencez.\n");
                validerChoixMenu(listeContacts, afficherMenu());
                break;
        }
    }

    public static String lireClavier(){
        String input;

        Scanner Clavier = new Scanner(System.in);
        input = Clavier.nextLine();

        return input;
    }
}
