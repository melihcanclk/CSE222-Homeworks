import java.util.Comparator;

public class Specs implements Comparator {
    /**
     * Version name
     */
    private Double versionName;
    /**
     * Quantity of Software
     */
    private Long quantity;
    /**
     * Price
     */
    private Long price;

    /**
     * @return the quantity
     */
    public Long getQuantity() {
        return quantity;
    }

    /**
     * @return the versionName
     */
    public Double getVersionName() {
        return versionName;
    }

    /**
     * @param versionName the versionName to set
     */
    public void setVersionName(Double versionName) {
        this.versionName = versionName;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public Long getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public int compare(Object arg0, Object arg1) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}