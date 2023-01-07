package ma.projet.arrosageintellegentv2.beans;

public class Plante {
    private long id;
    private String libelle;
    private String image;
    private String racine;
    private TypePlante type;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Plante{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", image='" + image + '\'' +
                ", racine='" + racine + '\'' +
                ", type=" + type +
                '}';
    }

    public void setId(long id) {
        this.id = id;
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

    public String getRacine() {
        return racine;
    }

    public void setRacine(String racine) {
        this.racine = racine;
    }

    public TypePlante getType() {
        return type;
    }

    public void setType(TypePlante type) {
        this.type = type;
    }

    public Plante(long id, String libelle, String image, String racine, TypePlante type) {
        this.id = id;
        this.libelle = libelle;
        this.image = image;
        this.racine = racine;
        this.type = type;
    }
}
