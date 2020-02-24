/**
 * Branch Class for hold information about branches
 */
public class Branch {
    /**
     * Name of Branch
     */
    private String name;

    /**
     * Branch Constructor
     * @param name Name of Branch
     */
    public Branch(String name) {
        this.name = name;
    }

    /**
     * Getting name of Branch
     * @return Name of Branch
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Setting name of Branch
     * @param name Name of Branch
     */
    public void setName(String name) {
        this.name = name;
    }
}
