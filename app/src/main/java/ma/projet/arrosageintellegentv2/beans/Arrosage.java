package ma.projet.arrosageintellegentv2.beans;

import java.util.Date;

public class Arrosage {
    private int id;
    private String date;
    private float litresEau;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Arrosage{" +
                "id=" + id +
                ", date=" + date +
                ", litresEau=" + litresEau +
                '}';
    }

    public Arrosage(int id, String date, float litresEau) {
        this.id = id;
        this.date = date;
        this.litresEau = litresEau;
    }

    public float getLitresEau() {
        return litresEau;
    }

    public void setLitresEau(float litresEau) {
        this.litresEau = litresEau;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
