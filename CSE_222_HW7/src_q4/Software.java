public class Software implements Comparable<Software> {
    private String name;
    private Double version;
    private Integer quantity;
    private Double price;

    public Software(String name, Double version, Integer quantity, Double price) {
        this.name = name;
        this.version = version;
        this.quantity = quantity;
        this.price = price;
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
        int returnval = this.name.compareTo(o.name);
        if(returnval == 0){
            returnval = this.version.compareTo(o.version);
        }
        return returnval;
    }

    @Override
    public String toString() {
        return "Software{" +
                "name='" + name +" " + version +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
