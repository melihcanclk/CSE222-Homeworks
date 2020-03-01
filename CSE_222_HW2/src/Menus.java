import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for holding Menu's
 */
public class Menus {
    private static int selection;

    /**
     * Main menu
     * @return Selection of user
     */
    static int mainMenu(){
        selection = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("---------Main Menu--------");
        System.out.println("1->Administrator Login");
        System.out.println("2->Branch Employee Login");
        System.out.println("3->Transportation Personnel Login");
        System.out.println("4->Customer Login");
        System.out.println("0->Exit From System");
        selection = sc.nextInt();
        return selection;
    }

    /**
     * Administrator menu
     * @return Selection of user
     */
    static int adminMenu(){
        selection = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("---------Admin Menu--------");
        System.out.println("1->Add Branch");
        System.out.println("2->Remove Branch");
        System.out.println("3->Show Branch(s)");
        System.out.println("4->Add Branch Employee");
        System.out.println("5->Remove Branch Employee");
        System.out.println("6->Show Branch Employee");
        System.out.println("7->Add Transportation Personnel");
        System.out.println("8->Remove Transportation Personnel");
        System.out.println("9->Show Transportation Personnel");
        System.out.println("0->Exit from Admin Menu");
        selection = sc.nextInt();
        return selection;
    }

    /**
     * After getting decission, according to the selection, there will be some choice
     * @param branchArray Branch array that holding branches
     * @param employeeArray employeeArray that holding employees
     */
    static void adminDecissionMenu(ArrayList<Branch> branchArray, ArrayList<Employee> employeeArray){
        while(selection != 0) {
            Scanner sc = new Scanner(System.in);
            selection = Menus.adminMenu();
            if (selection == 1) {
                Admin.addBranch(branchArray);
            } else if (selection == 2) {
                Admin.removeBranch(branchArray, employeeArray);
            } else if(selection == 3){
                print(branchArray);
            }else if(selection == 4){
                print(branchArray);
                Branch branch = branchArray.get(sc.nextInt() - 1);
                Admin.addEmployee(employeeArray,TypeOfPeople.BranchEmployee,branch);
            }else if(selection == 5){
                Admin.removeEmployee(employeeArray,TypeOfPeople.BranchEmployee);
            }else if(selection == 6){
                print(employeeArray,TypeOfPeople.BranchEmployee);
            }else if(selection == 7){
                Admin.addEmployee(employeeArray,TypeOfPeople.TransportationPersonnel, null);
            }else if(selection == 8){
                Admin.removeEmployee(employeeArray,TypeOfPeople.TransportationPersonnel);
            }else if(selection == 9){
                print(employeeArray,TypeOfPeople.TransportationPersonnel);
            }
        }
    }

    /**
     * Branch Employee Menu
     * @return Selection of user
     */
    static int branchEmployeeMenu(){
        selection = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("---------Branch Employee Menu--------");
        System.out.println("1->Enter Information About Cargo(Customer Will Be Added To System)");
        System.out.println("2->Remove Information About Cargo(Customer Will Be Deleted From System)");
        System.out.println("3->Change Status of a Cargo");
        System.out.println("4->Show Cargo(s)");
        System.out.println("0->Exit from Branch Employee Menu");
        selection = sc.nextInt();
        return selection;
    }

    /**
     * After getting decission, according to the selection, there will be some choice
     * @param branchArray Branch array that holding branches
     * @param cargoArray cargoArray that holding cargo's
     * @param customerArray  customerArray that holding customers
     */
    static void branchEmployeeDecisionMenu(ArrayList<Cargo> cargoArray, ArrayList<Customer> customerArray, ArrayList<Branch> branchArray){
        while(selection != 0) {
            selection = Menus.branchEmployeeMenu();
            if (selection == 1) {
                BranchEmployee.addInfoToSystem(cargoArray, customerArray, branchArray);
            } else if (selection == 2) {
                BranchEmployee.removeInfoFromSystem(cargoArray,customerArray);
            } else if (selection == 3) {
                BranchEmployee.changeStatusOfCargo(cargoArray);
            }else if (selection == 4) {
                print(cargoArray);
            }
        }
    }

    /**
     * Customer Menu
     * @param cargoArray cargoArray that holding cargo's
     */
    static void customerMenu(ArrayList<Cargo> cargoArray){
        while(selection != 0) {
            boolean flag = false;
            selection = Integer.parseInt(Employee.getInput("Tracking Number of the Cargo:(0 for exit)"));
            for (int i = 0; i< cargoArray.size(); ++i){
                if(cargoArray.get(i).getCargoNo() == selection){
                    Cargo cargo = new Cargo();
                    cargo = cargoArray.get(i);
                    System.out.println("Cargo No:" + cargo.getCargoNo() + "\n" +cargo.getSender() + cargo.getReceiver() + "\n"
                    + "Current Status: " + cargo.getStatusOfCargo());
                    flag = true;
                }
            }
            if(!flag && selection != 0){
                System.out.println("No Cargo with tracking number " + selection);
            }
        }
    }
    public static void print(ArrayList arrayList){
        int counter = 1;
        for(Object instance : arrayList){
            System.out.println(counter + "->" + instance + "\n");
            ++counter;
        }
    }

    public static void print(ArrayList arrayList,TypeOfPeople typeOfPeople){
        int counter = 1;
        for(Object instance : arrayList){
            Employee employee = (Employee)instance;
            if(typeOfPeople.equals(employee.getPeopleType())){
                System.out.println(counter + "->" + employee + "\n");
                ++counter;
            }
        }
    }

}
