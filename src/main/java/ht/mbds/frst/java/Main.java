package ht.mbds.frst.java;

import ht.mbds.frst.java.models.Document;
import ht.mbds.frst.java.models.Dvd;
import ht.mbds.frst.java.models.Livre;

import java.util.*;

class Main {

    private static List<Document> catalogue = new ArrayList<>();
    private static Map<Integer, Document> index = new HashMap<>();

    public static void main(String[] args) {
        // Création de quelques documents
        Livre l1 = new Livre(1, "Le Seigneur des Anneaux", 1954);
        Livre l2 = new Livre(2, "Harry Potter", 1997);
        Dvd d1 = new Dvd(3, "Inception", 2010);
        Dvd d2 = new Dvd(4, "Matrix", 1999);

        // Ajout au catalogue
        ajouterDocument(l1);
        ajouterDocument(l2);
        ajouterDocument(d1);
        ajouterDocument(d2);

        menu();
    }
    //Ajout de la methode Pause, qui permet de faire une pause après chaque operation du menu
    static void pause(Scanner sc) {
        System.out.println("\nAppuyez sur la touche Enter du clavier pour continuer...");
        sc.nextLine();
    }

    static void menuItems() {
        System.out.println("\n--- MENU ---");
        System.out.println("1 - Afficher le catalogue");
        System.out.println("2 - Rechercher un document par id");
        System.out.println("3 - Emprunter un document");
        System.out.println("4 - Retourner un document");
        System.out.println("5 - Statistiques");
        System.out.println("0 - Quitter");
        System.out.print("Votre choix : ");
    }

    static void menu() {
        // Menu
        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            menuItems();
            choix = sc.nextInt();
            sc.nextLine(); //  vider le buffer
            switch (choix) {
                case 1 -> {
                    afficherCatalogue();
                    pause(sc); // mets une pause
                }
                case 2 -> {
                    System.out.print("Entrez l'id : ");
                    int id = sc.nextInt();
                   sc.nextLine(); //  vider le buffer
                    rechercherParId(id);
                    pause(sc);
                }
                case 3 -> {
                    System.out.print("Entrez l'id : ");
                    int id = sc.nextInt();
                    sc.nextLine(); //Vider le buffer
                    emprunterDocument(id);
                    pause(sc);
                }
                case 4 -> {
                    System.out.print("Entrez l'id : ");
                    int id = sc.nextInt();
                    sc.nextLine(); //Vider le buffer
                    retournerDocument(id);
                    pause(sc);
                }
                case 5 -> {
                    statistiques();
                    pause(sc);
                }
                case 0 -> System.out.println("Au revoir !");
                default -> {
                    System.out.println("Choix invalide.");
                    pause(sc);
                }
            }
        } while (choix != 0);
    }

    static void ajouterDocument(Document doc) {
        catalogue.add(doc);
        index.put(doc.getId(), doc);
    }

    static void afficherCatalogue() {
        System.out.println("\nCatalogue :");
        for (Document doc : catalogue) {
            System.out.println(doc);
        }
    }

    static void rechercherParId(int id) {
        Document doc = index.get(id);
        if (doc == null) {
            System.out.println("ht.mbds.frst.java.models.Document introuvable");
        } else {
            System.out.println("Trouvé : " + doc);
        }
    }

    static void emprunterDocument(int id) {
        Document doc = index.get(id);
        if (doc == null) {
            System.out.println("ht.mbds.frst.java.models.Document introuvable");
        } else if (doc instanceof Empruntable e) {
            e.emprunter();
        } else {
            System.out.println("Ce document ne peut pas être emprunté.");
        }
    }

    static void retournerDocument(int id) {
        Document doc = index.get(id);
        if (doc == null) {
            System.out.println("ht.mbds.frst.java.models.Document introuvable");
        } else if (doc instanceof Empruntable e) {
            e.retourner();
        } else {
            System.out.println("Ce document ne peut pas être retourné.");
        }
    }

    static void statistiques() {
        int dispo = 0, empruntes = 0;
        for (Document doc : catalogue) {
            if (doc instanceof Empruntable e) {
                if (e.estDisponible()) dispo++;
                else empruntes++;
            }
        }
        System.out.println("Documents disponibles : " + dispo);
        System.out.println("Documents empruntés : " + empruntes);
    }
}