package ma.projet.arrosageintellegentv2.beans;

import java.util.List;

public class EspaceVert {
    private long id;
    private String libelle;
    private String image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EspaceVert{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", image='" + image + '\'' +
                ", zones=" + parcelles +
                '}';
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Parcelle> getZones() {
        return parcelles;
    }

    public void setZones(List<Parcelle> parcelles) {
        this.parcelles = parcelles;
    }

    public EspaceVert(long id, String libelle, String image, List<Parcelle> parcelles) {
        this.id = id;
        this.libelle = libelle;
        this.image = image;
        this.parcelles = parcelles;
    }

    private List<Parcelle> parcelles;
}
