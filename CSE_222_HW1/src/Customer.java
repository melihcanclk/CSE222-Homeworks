public class Customer extends HumanTypes{

    public Customer(String name, String surname, TypeOfPeople peopleType, CustomerType type) {
        super(name, surname, peopleType);
        this.type = type;
    }

    /**
     * Type of Customer which type of CustomerType
     */
    private CustomerType type;

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\nType:" + getType();
    }

    public static void lookCargo(int trackingNumber, DynamicArray<Cargo> cargoArray){
        for (int i = 0; i<cargoArray.size();++i){
            if(cargoArray.getElement(i).getCargoNo() == trackingNumber){
                System.out.println("Cargo Code:" +
                        cargoArray.getElement(i).getCargoNo() + "\n" +
                        cargoArray.getElement(i).getSender() + "\n" +
                        cargoArray.getElement(i).getReceiver() + "\n\n" +
                        "Cargo is " + cargoArray.getElement(i).getStatusOfCargo() + "\n"
                );
            }
        }
    }

}
