public class Livre extends Document {
    public Livre(int id, String titre, int anneePublication) {
        super(id, titre, anneePublication);
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", anneePublication=" + anneePublication +
                '}';
    }
}
