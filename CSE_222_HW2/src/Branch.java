import java.util.ArrayList;

/**
 * Class for Branch's
 */
public class Branch {
    /**
     * Name of branch field
     */
    private String name;

    /**
     * Constructor of Branch Class
     * @param name name of branch
     */
    public Branch(String name) {
        this.name = name;
    }

    /**
     * Getting name of branch
     * @return String type name
     */
    public String getName() {
        return name;
    }

    /**
     * Setting name of branch
     * @param name name of branch will be set
     */
    public void setName(String name) {
        this.name = name;
    }


}
