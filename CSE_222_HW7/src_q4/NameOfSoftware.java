public class NameOfSoftware {
    /**
     * Name of Software
     */
    private String name;
    /**
     * Version of Software
     */
    private Double version;

    /**
     * Name of software class constructor
     * @param name Only Name of software
     * @param v version of software
     */
    public NameOfSoftware(String name, Double v) {
        this.name = name;
        this.version = v;
    }

    /**
     * Getter for Name of software
     * @return Name of Software
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for Version of Software
     * @return Version of Software
     */
    public Double getVersion() {
        return version;
    }


    /**
     * toString method
     * @return String name + version
     */
    @Override
    public String toString() {
        return name + '\'' +
                ", version=" + version +
                '}';
    }
}
