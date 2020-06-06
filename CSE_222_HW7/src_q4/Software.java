public class Software implements Comparable<Software> {
    private NameOfSoftware nameOfSoftware;
    private Integer quantity;
    private Double price;
    //control compareTo method
    private Controller controller;

    public Software(NameOfSoftware nameOfSoftware, Integer quantity, Double price, Controller controller) {
        this.nameOfSoftware = nameOfSoftware;
        this.quantity = quantity;
        this.price = price;
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public NameOfSoftware getNameOfSoftware() {
        return nameOfSoftware;
    }

    public void setNameOfSoftware(NameOfSoftware nameOfSoftware) {
        this.nameOfSoftware = nameOfSoftware;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

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

    @Override
    public String toString() {
        return "Software{" +
                "name='" + nameOfSoftware +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
