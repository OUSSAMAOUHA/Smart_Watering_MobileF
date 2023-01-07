package ma.projet.arrosageintellegentv2.beans;

public class TypePlante {
    private int id;
    private String name;
    private float humiditeMax;
    private float humiditeMin;
    private float temperature;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TypePlante{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", humiditeMax=" + humiditeMax +
                ", humiditeMin=" + humiditeMin +
                ", temperature=" + temperature +
                ", luminosite=" + luminosite +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHumiditeMax() {
        return humiditeMax;
    }

    public void setHumiditeMax(float humiditeMax) {
        this.humiditeMax = humiditeMax;
    }

    public float getHumiditeMin() {
        return humiditeMin;
    }

    public void setHumiditeMin(float humiditeMin) {
        this.humiditeMin = humiditeMin;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getLuminosite() {
        return luminosite;
    }

    public void setLuminosite(float luminosite) {
        this.luminosite = luminosite;
    }

    public TypePlante(int id, String name, float humiditeMax, float humiditeMin, float temperature, float luminosite) {
        this.id = id;
        this.name = name;
        this.humiditeMax = humiditeMax;
        this.humiditeMin = humiditeMin;
        this.temperature = temperature;
        this.luminosite = luminosite;
    }

    private float luminosite;
}
