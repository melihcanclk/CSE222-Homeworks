public class NameOfSoftware {
    private String name;
    private Double version;

    public NameOfSoftware(String name, Double v) {
        this.name = name;
        this.version = v;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return name + '\'' +
                ", version=" + version +
                '}';
    }
}
