import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Repository {
    // Generate random titles from these word pools
    private static final String[] ADJECTIVES = {
            "Ancient", "Brave", "Curious", "Distant", "Elegant", "Fierce", "Golden", "Hidden",
            "Infinite", "Jubilant", "Luminous", "Mysterious", "Noble", "Opulent", "Pristine",
            "Quiet", "Radiant", "Silent", "Timeless", "Vivid", "Wandering", "Youthful", "Zealous"
    };
    private static final String[] NOUNS = {
            "Horizons", "Echoes", "Legends", "Meadows", "Riddles", "Journeys", "Chronicles",
            "Constellations", "Whispers", "Odyssey", "Mirage", "Symphony", "Fragments", "Archives",
            "Labyrinth", "Reflections", "Paradox", "Expedition", "Manuscripts", "Foundations"
    };
    private static final Random RNG = new Random();

    /**
     * Generates a list of 50 Document instances with random titles.
     */
    public static List<Document> getDocuments() {
        List<Document> docs = new ArrayList<>(50);
        for (int i = 1; i <= 50; i++) {
            String title = randomTitle();
            int year = 2000 + (i % 26);
            Document d = new Document(i, title, year);
            docs.add(d);
        }
        return docs;
    }

    /**
     * Generates a list of 50 books instances with random titles.
     */
    public static List<Livre> getLivres() {
        List<Livre> livres = new ArrayList<>(50);
        for (int i = 1; i <= 50; i++) {
            String title = randomTitle();
            int year = 2000 + (i % 26);
            Livre l = new Livre(i, title, year);
            livres.add(l);
        }
        return livres;
    }


    /**
     * Generates a list of 50 Dvds with random titles.
     */
    public static List<Dvd> getDvds() {
        List<Dvd> dvds = new ArrayList<>(50);
        for (int i = 1; i <= 50; i++) {
            String title = randomTitle();
            int year = 2000 + (i % 26);
            Dvd dvd = new Dvd(i, title, year);
            dvds.add(dvd);
        }
        return dvds;
    }

    private static String randomTitle() {
        String adj = ADJECTIVES[RNG.nextInt(ADJECTIVES.length)];
        String noun = NOUNS[RNG.nextInt(NOUNS.length)];
        // Optionally add a small random suffix to reduce duplicates
        int variant = RNG.nextInt(100);
        return adj + " " + noun + " " + variant;
    }
}
