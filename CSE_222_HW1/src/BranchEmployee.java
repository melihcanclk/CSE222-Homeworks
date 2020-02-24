import java.awt.datatransfer.SystemFlavorMap;

public class BranchEmployee extends Employee{

    private Branch branchWorked;

    public BranchEmployee(String name, String surname, TypeOfPeople peopleType, Branch branch) {
        super(name, surname, peopleType);
        this.branchWorked = branch;
    }

    public static void addInfoToSystem(DynamicArray<Cargo> cargoArray, DynamicArray<Customer> customerArray, DynamicArray<Branch> branchArray) {
        Cargo cargo = new Cargo();
        String senderName = getInput("Sender Name");
        String senderSurname = getInput("Sender Surname");
        String receiverName = getInput("Receiver Name");
        String receiverSurname = getInput("Receiver Surname");
        Customer sender = new Customer(senderName,senderSurname,TypeOfPeople.Customer, CustomerType.sender);
        Customer receiver = new Customer(receiverName,receiverSurname,TypeOfPeople.Customer,CustomerType.receiver);
        cargo.setReceiver(receiver);
        cargo.setSender(sender);
        if(branchArray.size() >0){
            branchArray.printElements();
            int i = Integer.parseInt(getInput("Number of Start Branch"));
            cargo.setStartBranch(branchArray.getElement(i-1));
            int j = Integer.parseInt(getInput("Number of End Branch"));
            while(j == i){
                System.out.println("Entered Same Branch");
                j = Integer.parseInt(getInput("Number of End Branch"));
            }
            cargo.setEndBranch(branchArray.getElement(j-1));
        }
        cargo.setCargoNo(cargoArray.size());
        cargo.setStatusOfCargo(StatusOfCargo.notArrived);
        cargoArray.addElement(cargo);
        customerArray.addElement(sender);
        customerArray.addElement(receiver);

    }

    public static void removeInfoFromSystem(DynamicArray<Cargo> cargoArray, DynamicArray<Customer> customerArray) {
        if(cargoArray.size()>0){
            cargoArray.printElements();
            int i = Integer.parseInt(getInput("Cargo Number That Will Be Deleted")) - 1;
            cargoArray.remove(i);
            customerArray.remove((i * 2) -1);
            customerArray.remove((i * 2));
        }
    }

    public static void changeStatusOfCargo(DynamicArray<Cargo> cargoArray) {
        cargoArray.printElements();
        int i = Integer.parseInt(getInput("Cargo Number That Will Be Done Status Change:"));
        --i;
        if(cargoArray.getElement(i).getStatusOfCargo() == StatusOfCargo.notArrived){
            cargoArray.getElement(i).setStatusOfCargo(StatusOfCargo.arrived);
        }else{
            System.out.println("Cargo Already Arrived!!");
        }

    }

    public Branch getBranchWorked() {
        return branchWorked;
    }

    public void setBranchWorked(Branch branchWorked) {
        this.branchWorked = branchWorked;
    }

    @Override
    public String toString() {
        return "BranchEmployee{" +
                " name=" + getName() +
                " surname=" + getSurname()+
                " branchWorked=" + branchWorked +
                ", persontype=" + persontype +
                '}';
    }
}
