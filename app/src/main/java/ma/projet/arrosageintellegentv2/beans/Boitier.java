package ma.projet.arrosageintellegentv2.beans;

public class Boitier {
    private long id;
    private String ref;
    private String type;
    private String code;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Boitier{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String image;

    public Boitier(long id, String ref, String type, String code, String image) {
        this.id = id;
        this.ref = ref;
        this.type = type;
        this.code = code;
        this.image = image;
    }
}
