public class Constantes {
    public static final String MSG_ENTETE = "\n* * * AGENDA ELECTRONIQUE * * *\n";
    public static final String MSG_MENU = "\nMENU\n" +
            " 1. Rechercher un contact par nom\n" +
            " 2. Rechercher un contact par position\n" +
            " 3. Rechercher un contact par mots cles\n" +
            " 4. Insérer un contact\n" +
            " 5. Afficher tous les contacts\n" +
            " 6. Afficher statistiques\n" +
            " 7. Quitter\n\n" +
            "Veuillez choisir une option : ";
    public static final String MSG_SOL_NOM = "Veuillez entrer un nom : ";
    public static final String MSG_SOL_POS = "Veuillez entrer la position du contact: ";
    public static final String MSG_SOL_MOT = "Veuillez entrer un mot clé : ";
    public static final String MSG_SOL_CSV = "Veuillez entrer le nom du fichier CSV à charger: ";
    public static final String MSG_SOL_TYPE_CONTACT = "Quel type de contact souhaitez-vous ajouter?\n" +
            "    1: personnel\n " + "   2: commercial\n" + "    3: generique";
    public static final String MSG_3_TEL = "*Un contact commercial possède 3 numeros de telephone.";
    public static final String MSG_SOL_TEL = "Veuillez entrer le numero de telephone : ";
    public static final String MSG_SOL_TEL_BUREAU = "Veuillez entrer le numero de telephone du bureau: ";
    public static final String MSG_SOL_TEL_CELL = "Veuillez entrer le numero de telephone du cellulaire: ";
    public static final String MSG_SOL_TEL_MAISON = "Veuillez entrer le numero de telephone de la maison: ";
    public static final String MSG_SOL_TYPETEL = "Veuillez indiquer le type du telephone\n" +
            "    1: Cellulaire\n" + "    2: Maison";
    public static final String MSG_SOL_DATE_NAISSANCE = "Veuillez entrer une date de naissance (AAAA/MM/JJ): ";
    public static final String MSG_SOL_MOTSCLE = "Veuillez entrer un mots-cle (Appuyer sur ENTREE pour finir) : ";
    public static final String MSG_SOL_ENTREPRISE = "Veuillez entrer le nom de votre entreprise : ";
    public static final String MSG_NBR_CONTACTS = "\nNombre total de contacts : ";
    public static final String MSG_NBR_PERSO = "Nombre de contacts personnels : ";
    public static final String MSG_NBR_COMM = "Nombre de contacts commerciaux : ";
    public static final String MSG_NBR_GENERIQUES = "Nombre de contacts generiques : ";
    public static final String MSG_ENTREE = "\nAppuyer sur ENTREE pour revenir au menu : ";
    public static final String MSG_NEW_CONTACT = "\nNouveau contact insere";

    // MESSAGES ERREURS
    public static final String MSG_NO_CONTACT = "\nAucun contact trouve.";
    public static final String MSG_ERR_CHOIX_INVALIDE = "Choix invalide. Veuillez recommencer.";
    public static final String MSG_ERR_FNFE = "Erreur d'entree/sortie.";
    public static final String MSG_ERR_POS_INVALIDE = "\nLa position est invalide.";

    public static final String MSG_FIN = "\nFIN NORMALE DU PROGRAMME";
}
