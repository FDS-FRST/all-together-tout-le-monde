package ht.mbds.frst.java;

import ht.mbds.frst.java.data.Repository;
import ht.mbds.frst.java.models.Document;

import java.util.*;

public class Main {
    public static void afficheDocument(List<Document> documents) {
        System.out.println("Total: " + documents.size());
        for (int i = 0; i < Math.min(5, documents.size()); i++) {
            System.out.println(documents.get(i));
        }
    }

    public static void afficheCataloge(List<Document> documents) {
        afficheDocument(documents);
    }

    public static Document rechercherParId (Map<Integer, Document> documents, int id) {
        for (Map.Entry<Integer, Document> entry : documents.entrySet()) {
            if (entry.getKey() == id) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        var livres = Repository.getLivres();
        afficheDocument(livres);
        System.out.println();
        var dvds = Repository.getDvds();
        afficheDocument(dvds);

        List<Document> catalogue = new ArrayList<Document>(livres);
        catalogue.addAll(dvds);
        afficheCataloge(catalogue);

        Map<Integer, Document> allDocuments = new HashMap<>();
        for (Document doc : catalogue) {
            allDocuments.put(doc.getId(), doc);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Entrer un ID à rechercher : ");
        int id = sc.nextInt();
        if (rechercherParId(allDocuments, id) != null) {
            System.out.println("Document Trouvé");
            System.out.println(rechercherParId(allDocuments, id));
        }else {
            System.out.println("Document n'existe pas");
        }

    }
}