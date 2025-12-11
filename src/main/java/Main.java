public class Main {
    public static void main(String[] args) {
        var docs = Repository.getDocuments();
        System.out.println("Total documents: " + docs.size());
        for (int i = 0; i < Math.min(5, docs.size()); i++) {
            System.out.println(docs.get(i));
        }
        System.out.println();
        var livres = Repository.getLivres();
        System.out.println("Total Livres: " + livres.size());
        for (int i = 0; i < Math.min(5, livres.size()); i++) {
            System.out.println(livres.get(i));
        }

        System.out.println();
        var dvds = Repository.getDvds();
        System.out.println("Total DVDs: " + dvds.size());
        for (int i = 0; i < Math.min(5, dvds.size()); i++) {
            System.out.println(dvds.get(i));
        }
    }
}