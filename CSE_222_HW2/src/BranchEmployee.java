import java.awt.*;
import java.util.ArrayList;

/**
 * Class for BranchEmployees
 */
public class BranchEmployee extends Employee{

    /**
     * Additional field that holds for branch that branchEmployee is working
     */
    private Branch branchWorked;

    /**
     * BranchEmployee Constructor
     * @param name Name of branch employee
     * @param surname Surname of branch employee
     * @param peopleType PeopleType enumeration type of people
     * @param branch Branch that will be set to branch employee
     */
    public BranchEmployee(String name, String surname, TypeOfPeople peopleType, Branch branch) {
        super(name, surname, peopleType);
        this.branchWorked = branch;
    }

    /**
     * Adding cargo info to system
     * @param cargoArray Cargo array that holds cargo's
     * @param customerArray Customer array that holds customers
     * @param branchArray Branch array that holds branches
     */
    public static void addInfoToSystem(ArrayList<Cargo> cargoArray, ArrayList<Customer> customerArray, ArrayList<Branch> branchArray) {
        if(branchArray.size() >0){
            Cargo cargo = new Cargo();
            String senderName = getInput("Sender Name");
            String senderSurname = getInput("Sender Surname");
            String receiverName = getInput("Receiver Name");
            String receiverSurname = getInput("Receiver Surname");
            Customer sender = new Customer(senderName,senderSurname,TypeOfPeople.Customer, CustomerType.Sender);
            Customer receiver = new Customer(receiverName,receiverSurname,TypeOfPeople.Customer,CustomerType.Receiver);
            cargo.setReceiver(receiver);
            cargo.setSender(sender);

            int max = cargoArray.get(0).getCargoNo();
            for(int i = 1; i< cargoArray.size();++i){
                if(cargoArray.get(i).getCargoNo() > max){
                    max = cargoArray.get(i).getCargoNo();
                }
            }
            cargo.setCargoNo(max+1);
            cargo.setStatusOfCargo(StatusOfCargo.NotArrived);
            cargoArray.add(cargo);
            customerArray.add(sender);
            customerArray.add(receiver);
            Menus.print(branchArray);
            int i = Integer.parseInt(getInput("Number of Start Branch"));
            cargo.setStartBranch(branchArray.get(i-1));
            Menus.print(branchArray);
            int j = Integer.parseInt(getInput("Number of End Branch"));
            while(j == i){
                System.out.println("Entered Same Branch");
                j = Integer.parseInt(getInput("Number of End Branch"));
            }
            cargo.setEndBranch(branchArray.get(j-1));
        }else{
            System.out.println("No branch to be Branch Employee Placed.");
        }

    }

    /**
     * Remove Cargo from system. At the same time, Customer that add to is deleting as well
     * @param cargoArray Cargo array that holds cargo's
     * @param customerArray Customer array that holds customers
     */
    public static void removeInfoFromSystem(ArrayList<Cargo> cargoArray, ArrayList<Customer> customerArray) {
        if(cargoArray.size()>0){
            Menus.print(cargoArray);
            int i = Integer.parseInt(getInput("Cargo Number That Will Be Deleted")) - 1;
            if(cargoArray.get(i).getStatusOfCargo() != StatusOfCargo.NotArrived){
                System.out.println("Cargo No " + cargoArray.get(i).getCargoNo() + " is deleted\n");
                cargoArray.remove(i);
                customerArray.remove((i * 2) -1);
                customerArray.remove((i * 2));
            }else{
                System.out.println("Cargo No " + cargoArray.get(i).getCargoNo() + " is " +
                        cargoArray.get(i).getStatusOfCargo() + " so cargo cannot be deleted\n");
            }
        }else{
            System.out.println("There's no cargo to be removed.");
        }
    }

    /**
     * Changing Status of cargo
     * @param cargoArray Cargo array that holds cargo's
     */
    public static void changeStatusOfCargo(ArrayList<Cargo> cargoArray) {
        Menus.print(cargoArray);
        int i = Integer.parseInt(getInput("Cargo Number That Will Be Done Status Change(0 for exit):"));
        --i;
        if(i != -1){
            if(cargoArray.get(i).getStatusOfCargo() == StatusOfCargo.NotArrived){
                cargoArray.get(i).setStatusOfCargo(StatusOfCargo.Arrived);
                System.out.println("Status of cargo no " + cargoArray.get(i).getCargoNo() + " is now " + cargoArray.get(i).getStatusOfCargo() + ".");
            }else{
                System.out.println("Cargo Already Arrived!!");
            }
        }

    }

    /**
     * Getting Branch that BranchEmployee working
     * @return Branch type branch that BranchEmployee working
     */
    public Branch getBranchWorked() {
        return branchWorked;
    }

    /**
     * Setting Branch that BranchEmployee working
     * @param branchWorked Branch type branch that will BranchEmployee work
     */
    public void setBranchWorked(Branch branchWorked) {
        this.branchWorked = branchWorked;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Branch worked:" + branchWorked;
    }
}
