package ma.projet.arrosageintellegentv2.beans;

import java.io.Serializable;
import java.util.List;

public class Parcelle implements Serializable {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", superficie=" + superficie +
                ", image='" + image + '\'' +
                ", type=" + type +
                ", plantages=" + plantages +
                '}';
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public SolType getType() {
        return type;
    }

    public void setType(SolType type) {
        this.type = type;
    }

    public List<Plantage> getPlantages() {
        return plantages;
    }

    public void setPlantages(List<Plantage> plantages) {
        this.plantages = plantages;
    }





    public Parcelle(long id, String libelle, float superficie, String image, SolType type, List<Plantage> plantages) {
        this.id = id;
        this.libelle = libelle;
        this.superficie = superficie;
        this.image = image;
        this.type = type;
        this.plantages = plantages;
    }

    private String libelle;
    private float superficie;
    private String image;
    private SolType type;
    private List<Plantage> plantages;

}
