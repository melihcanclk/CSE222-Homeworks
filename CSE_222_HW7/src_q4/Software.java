/**
 * Software class that keeps Software utilities
 */
public class Software implements Comparable<Software> {
    /**
     * Name of software (name + version)
     */
    private NameOfSoftware nameOfSoftware;
    /**
     * Quantity of a software
     */
    private Integer quantity;
    /**
     * Price of a software
     */
    private Double price;
    /**
     * Control compareTo method
     */
    private Controller controller;

    /**
     * Software Class constructor
     * @param nameOfSoftware Name of Store class instance name of class
     * @param quantity Quantity of software
     * @param price Price of software
     * @param controller Controller of software that set compareTo method
     */
    public Software(NameOfSoftware nameOfSoftware, Integer quantity, Double price, Controller controller) {
        this.nameOfSoftware = nameOfSoftware;
        this.quantity = quantity;
        this.price = price;
        this.controller = controller;
    }

    /**
     * Setting controller of software
     * @param controller Controller enum class
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Getter for name of software
     * @return NameOfSoftware Type Name of Software
     */
    public NameOfSoftware getNameOfSoftware() {
        return nameOfSoftware;
    }

    /**
     * Setter for Name of Software
     * @param nameOfSoftware NameOfSoftware type name of software
     */
    public void setNameOfSoftware(NameOfSoftware nameOfSoftware) {
        this.nameOfSoftware = nameOfSoftware;
    }

    /**
     * Getter for Quantity
     * @return Integer type Quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Getter for Price
     * @return Double type Price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * compareTo method for software class. This class's behaviour changes according to software variable's controller.
     * If controller is NAME, it uses String compareTo method. If controller is QUANTITY_ADD, it returns 1 if other software
     * object is greater or equal to this software variable. Reason of that greater or equal to is that if two different
     * software has same quantity, it adds to tree anyway. This reason is same for PRICE_ADD controller. For QUANTITY_FIND
     * and PRICE_FIND, It uses Integer and Double compareTo method respectively
     * @param o other software variable
     * @return compareTo method returns
     */
    @Override
    public int compareTo(Software o) {
        int compare = 0;
        if(controller.equals(Controller.NAME)){
            compare = this.nameOfSoftware.getName().compareTo(o.nameOfSoftware.getName());
            if(compare == 0){
                compare = this.nameOfSoftware.getVersion().compareTo(o.nameOfSoftware.getVersion());
            }
            //eşit olduğunda sağa vermemin sebebi aynı olduğunda da bütün ağaçlarda tutmak
        }else if(controller.equals(Controller.QUANTITY_ADD)){
            if(this.quantity.compareTo(o.quantity) >= 0){
                compare = 1;
            }else{
                compare = -1;
            }
        }else if(controller.equals(Controller.QUANTITY_FIND)){
            compare = this.quantity.compareTo(o.quantity);
        }else if(controller.equals(Controller.PRICE_ADD)){
            if(this.price.compareTo(o.price) >= 0){
                compare = 1;
            }else{
                compare = -1;
            }
        }else if(controller.equals(Controller.PRICE_FIND)){
            compare = this.price.compareTo(o.price);
        }
        return compare;
    }

    /**
     * toString method for Software Class
     * @return String name + quantity + price
     */
    @Override
    public String toString() {
        return "Software{" +
                "name='" + nameOfSoftware +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
