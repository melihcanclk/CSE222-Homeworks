/**
 * Branch Employee class that holds information about Branch Employee
 * which extends from Employee abstract class
 */
public class BranchEmployee extends Employee{
    /**
     * Branch that branch employee is working
     */
    private Branch branchWorked;

    public BranchEmployee(String name, String surname, TypeOfPeople peopleType, Branch branchWorked) {
        super(name, surname, peopleType);
        this.branchWorked = branchWorked;
    }


    /**
     * Constructor for Branch Employee
     * @param surname Surname Of The Branch Employee
     */


    /**
     * Adding Cargo info to the system
     * @param cargoArray Adding cargo to cargoArray
     * @param customerArray Adding sender and receiver to customer array
     * @param branchArray For deciding to send Cargo from which branch to which branch
     */
    public static void addInfoToSystem(DynamicArray<Cargo> cargoArray, DynamicArray<Customer> customerArray, DynamicArray<Branch> branchArray) {
        Cargo cargo = new Cargo();
        String senderName = getInput("Sender Name");
        String senderSurname = getInput("Sender Surname");
        String receiverName = getInput("Receiver Name");
        String receiverSurname = getInput("Receiver Surname");
        Customer sender = new Customer(senderName,senderSurname,TypeOfPeople.Customer, CustomerType.Sender);
        Customer receiver = new Customer(receiverName,receiverSurname,TypeOfPeople.Customer,CustomerType.Receiver);
<<<<<<< HEAD

=======
>>>>>>> 0b6c4ef0af0f1256785a0a5c1b2b30261b0faeee
        cargo.setReceiver(receiver);
        cargo.setSender(sender);
        if(branchArray.size() >0){
            branchArray.printElements();
            int i = Integer.parseInt(getInput("Number of Start Branch"));
            cargo.setStartBranch(branchArray.getElement(i-1));
            branchArray.printElements();
            int j = Integer.parseInt(getInput("Number of End Branch"));
            while(j == i){
                System.out.println("Entered Same Branch");
                j = Integer.parseInt(getInput("Number of End Branch"));
            }
            cargo.setEndBranch(branchArray.getElement(j-1));
        }
<<<<<<< HEAD
        cargo.setCargoNo(cargoArray.getElement(cargoArray.size() -1).getCargoNo() + 1);
        cargo.setStatusOfCargo(StatusOfCargo.Not_Arrived);
        cargoArray.addElement(cargo);
        boolean includesender = true;
        boolean includereceiver = true;
        /*Upcasting by using Dynamic cast from employee array to HumanTypes Array*/
        Object temp = (Object) customerArray;
        @SuppressWarnings("unchecked")
        DynamicArray<HumanTypes> castArray = (DynamicArray<HumanTypes>) temp;
        if(sender.isInclude(sender,castArray)){
            includesender = false;
        }if(receiver.isInclude(receiver,castArray)){
            includereceiver = false;
        }
        if(includereceiver){
            customerArray.addElement(receiver);
        }if(includesender){
            customerArray.addElement(sender);
        }
=======
        int max = cargoArray.getElement(0).getCargoNo();
        for(int i = 1; i< cargoArray.size();++i){
            if(cargoArray.getElement(i).getCargoNo() > max){
                max = cargoArray.getElement(i).getCargoNo();
            }
        }
        cargo.setCargoNo(max+1);
        cargo.setStatusOfCargo(StatusOfCargo.NotArrived);
        cargoArray.addElement(cargo);
        customerArray.addElement(sender);
        customerArray.addElement(receiver);
>>>>>>> 0b6c4ef0af0f1256785a0a5c1b2b30261b0faeee
    }

    /**
     * Remove cargo from system
     * @param cargoArray Removing Cargo From cargoArray
     * @param customerArray Removing cargo that provides
     */
    public static void removeInfoFromSystem(DynamicArray<Cargo> cargoArray, DynamicArray<Customer> customerArray) {
        if(cargoArray.size()>0){
            cargoArray.printElements();
<<<<<<< HEAD
            int i = Integer.parseInt(getInput("Cargo Number That Will Be Deleted(0 for exit):")) - 1;
            if(i != -1 ){
                if(cargoArray.getElement(i).getStatusOfCargo() != StatusOfCargo.Not_Arrived){
                    System.out.println("Cargo with tracking number " +
                            cargoArray.getElement(i).getCargoNo() +" has removed\n");
                    cargoArray.remove(i);
                    customerArray.remove((i * 2));
                    customerArray.remove((i * 2));
                }else
                    System.out.println("Cargo hasn't arrived yet. Cargo can not be deleted");
=======
            int i = Integer.parseInt(getInput("Cargo Number That Will Be Deleted")) - 1;
            if(cargoArray.getElement(i).getStatusOfCargo() != StatusOfCargo.NotArrived){
                System.out.println("Cargo No " + cargoArray.getElement(i).getCargoNo() + " is deleted\n");
                cargoArray.remove(i);
                customerArray.remove((i * 2) -1);
                customerArray.remove((i * 2));
            }else{
                System.out.println("Cargo No " + cargoArray.getElement(i).getCargoNo() + " is " +
                        cargoArray.getElement(i).getStatusOfCargo() + " so cargo couldn't be delete\n");
>>>>>>> 0b6c4ef0af0f1256785a0a5c1b2b30261b0faeee
            }
        }
    }

    /**
     * Change Status of Cargo from not arrived to arrived
     * @param cargoArray change status of cargo at cargoArray
     */
    public static void changeStatusOfCargo(DynamicArray<Cargo> cargoArray) {
        cargoArray.printElements();
<<<<<<< HEAD
        if(cargoArray.size() != 0){
            int i = Integer.parseInt(getInput("Cargo Number That Will Be Done Status Change(0 for exit):"));
            --i;
            if(i != -1) {
                if (cargoArray.getElement(i).getStatusOfCargo() == StatusOfCargo.Not_Arrived) {
                    cargoArray.getElement(i).setStatusOfCargo(StatusOfCargo.Arrived);
                    System.out.println("Cargo with tracking number " +
                            cargoArray.getElement(i).getCargoNo() +" has reached the "+ cargoArray.getElement(i).getEndBranch() + "\n");
                } else {
                    System.out.println("Cargo Already Arrived!!");
                }
=======
        int i = Integer.parseInt(getInput("Cargo Number That Will Be Done Status Change(0 for exit):"));
        --i;
        if(i != -1){
            if(cargoArray.getElement(i).getStatusOfCargo() == StatusOfCargo.NotArrived){
                cargoArray.getElement(i).setStatusOfCargo(StatusOfCargo.Arrived);
                System.out.println();
            }else{
                System.out.println("Cargo Already Arrived!!");
>>>>>>> 0b6c4ef0af0f1256785a0a5c1b2b30261b0faeee
            }
        }
    }

    /**
     * Getting branch that branchEmployee worked
     * @return
     */
    public Branch getBranchWorked() {
        return branchWorked;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\nWorking Branch:" + branchWorked;
    }

    @Override
<<<<<<< HEAD
    public TypeOfPeople getPeopleType() {
        return null;
    }

    @Override
    public void setPeopleType(TypeOfPeople peopleType) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

=======
    public String toString() {
        return super.toString() +
                " Branch that working at:" + branchWorked;
>>>>>>> 0b6c4ef0af0f1256785a0a5c1b2b30261b0faeee
    }
}
