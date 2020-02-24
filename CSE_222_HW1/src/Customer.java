public class Customer extends HumanTypes{

    private CustomerType type;

    @Override
    public String toString() {
        return  super.toString() +
                "Type: " + getType();
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public Customer(String name, String surname, TypeOfPeople peopleType, CustomerType type) {
        super(name, surname, peopleType);
        this.type = type;
    }


}
