package ht.mbds.frst.java.models;

public class Dvd extends Document {

    public Dvd(int id, String titre, int anneePublication) {
        super(id, titre, anneePublication);
    }

    @Override
    public String toString() {
        return "Dvd{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", anneePublication=" + anneePublication +
                '}';
    }
}
