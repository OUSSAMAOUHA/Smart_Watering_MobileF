package ma.projet.arrosageintellegentv2.beans;

import java.time.LocalDateTime;

public class Grandeur {
    private int id;
    private float valeur;
    private String type;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Grandeur{" +
                "id=" + id +
                ", valeur=" + valeur +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Grandeur(int id, float valeur, String type, String date) {
        this.id = id;
        this.valeur = valeur;
        this.type = type;
        this.date = date;
    }

    private String date;
}
