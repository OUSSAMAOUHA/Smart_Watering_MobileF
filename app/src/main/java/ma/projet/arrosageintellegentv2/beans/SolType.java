package ma.projet.arrosageintellegentv2.beans;

public class SolType {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return  name ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SolType(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
