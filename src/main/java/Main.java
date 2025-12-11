public class Main {
    public static void main(String[] args) {
        var docs = Repository.getDocuments();
        System.out.println("Total documents: " + docs.size());
        for (int i = 0; i < Math.min(5, docs.size()); i++) {
            System.out.println(docs.get(i));
        }
    }
}