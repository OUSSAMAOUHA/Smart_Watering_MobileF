package ma.projet.arrosageintellegentv2.beans;

public class PlanteServicePK {
    private String date;

    private int parcelle;

    private int plante;

    private int nombre;

    public PlanteServicePK(String date, int parcelle, int plante, int nombre) {
        this.date = date;
        this.parcelle = parcelle;
        this.plante = plante;
        this.nombre = nombre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getParcelle() {
        return parcelle;
    }

    public void setParcelle(int parcelle) {
        this.parcelle = parcelle;
    }

    public int getPlante() {
        return plante;
    }

    public void setPlante(int plante) {
        this.plante = plante;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
}
