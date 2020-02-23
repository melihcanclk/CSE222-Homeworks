public class Customer extends HumanTypes{

    private CustomerType type;

    @Override
    public String toString() {
        return "Customer{" +
                "name" + getName()+
                "surname" + getSurname()+
                "type=" + getType() +
                ", persontype=" + getPeopleType() +
                '}';
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
