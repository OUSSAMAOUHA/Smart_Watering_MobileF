package ma.projet.arrosageintellegentv2.beans;

public class Plantage {
    private int id;
    private String date;
    private int nombre;
    private Plante plante;
    private PlanteServicePK pk;

    public Plantage(int id, String date, int nombre, Plante plante, PlanteServicePK pk) {
        this.id = id;
        this.date = date;
        this.nombre = nombre;
        this.plante = plante;
        this.pk = pk;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Plantage{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", nombre=" + nombre +
                ", plante=" + plante +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public Plante getPlante() {
        return plante;
    }

    public void setPlante(Plante plante) {
        this.plante = plante;
    }

    public PlanteServicePK getPk() {
        return pk;
    }

    public void setPk(PlanteServicePK pk) {
        this.pk = pk;
    }
}
