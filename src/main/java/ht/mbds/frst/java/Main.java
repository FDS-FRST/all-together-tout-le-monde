package ht.mbds.frst.java;

import ht.mbds.frst.java.data.Repository;
import ht.mbds.frst.java.models.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    }
}