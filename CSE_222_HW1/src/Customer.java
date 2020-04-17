/**
 * Class for Customers
 */
public class Customer extends HumanTypes{
    /**
     * CustomerType type type field
     */
    private CustomerType type;

    @Override
    public String toString() {
        return  super.toString() +
                "Type: " + getType();
    }

    /**
     * getter for type
     * @return CustomerType type type
     */
    public CustomerType getType() {
        return type;
    }

    /**
     * Setting CustomerType type
     * @param type CustomerType type type
     */
    public void setType(CustomerType type) {
        this.type = type;
    }

    /**
     * Constructor of Customer class
     * @param name Name of Customer
     * @param surname Surname of Customer
     * @param peopleType TypeOfpeople type peopletype
     * @param type CustomerType type type
     */
    public Customer(String name, String surname, TypeOfPeople peopleType, CustomerType type) {
        super(name, surname, peopleType);
        this.type = type;
    }


}
