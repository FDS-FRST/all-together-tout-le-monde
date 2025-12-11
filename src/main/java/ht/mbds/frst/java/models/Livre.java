package ht.mbds.frst.java.models;

import ht.mbds.frst.java.Empruntable;


public class Livre extends Document implements Empruntable {
    private boolean estDisponible = true;

    public Livre(int id, String titre, int anneePublication) {
        super(id, titre, anneePublication);
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + getId() +
                ", titre='" + getTitre() + '\'' +
                ", anneePublication=" + getAnneePublication() +
                ", disponible=" + estDisponible +
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
