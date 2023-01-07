package ma.projet.arrosageintellegentv2.beans;

public class Capteur {
    private long id;
    private String type;
    private String image;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Capteur{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Capteur(long id, String type, String image) {
        this.id = id;
        this.type = type;
        this.image = image;
    }
}
