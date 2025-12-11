package ht.mbds.frst.java;

import ht.mbds.frst.java.data.Repository;
import ht.mbds.frst.java.models.Document;

import java.util.List;

public class Main {
    public static void afficheDocument(List<Document> documents) {
        System.out.println("Total: " + documents.size());
        for (int i = 0; i < Math.min(5, documents.size()); i++) {
            System.out.println(documents.get(i));
        }
    }

    public static void main(String[] args) {
        var livres = Repository.getLivres();
        afficheDocument(livres);

        var dvds = Repository.getDvds();
        afficheDocument(dvds);
    }
}