package ht.mbds.frst.java.models;

import ht.mbds.frst.java.Empruntable;

public class Livre extends Document implements Empruntable {
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

    @Override
    public boolean estDisponible() {
        return false;
    }

    @Override
    public void emprunter() {

    }

    @Override
    public void retourner() {

    }
}
