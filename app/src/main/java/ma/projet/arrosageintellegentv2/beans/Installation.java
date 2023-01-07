package ma.projet.arrosageintellegentv2.beans;

import java.util.Date;

public class Installation {
    private long id;
    private String dateDebut;
    private String dateFin;
    private Boitier boitier;

    public void setId(long id) {
        this.id = id;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public Boitier getBoitier() {
        return boitier;
    }

    public void setBoitier(Boitier boitier) {
        this.boitier = boitier;
    }

    public Installation(long id, String dateDebut, String dateFin, Boitier boitier) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.boitier = boitier;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Installation{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", boitier=" + boitier +
                '}';
    }


}
