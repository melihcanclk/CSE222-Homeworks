import java.util.Scanner;

public class Menus {
    private static int selection;
    static int mainMenu(){
        selection = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("-------Main Menu------");
        System.out.println("1->Administrator Login");
        System.out.println("2->Branch Employee Login");
        System.out.println("3->Transportation Personnel Login");
        System.out.println("4->Customer Login");
        System.out.println("0->Exit From System");
        selection = sc.nextInt();
        return selection;
    }

    private static int amdinMenu(){
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

    static void adminDecissionMenu(DynamicArray<Branch> branchArray, DynamicArray<Employee> employeeArray){
        while(selection != 0) {
            Scanner sc = new Scanner(System.in);
            selection = amdinMenu();
            if (selection == 1) {
                Admin.addBranch(branchArray);
            } else if (selection == 2) {
                Admin.removeBranch(branchArray, employeeArray);
            } else if(selection == 3){
                branchArray.printElements();
            }else if(selection == 4){
                branchArray.printElements();
                int input = sc.nextInt();
                while (input <= 0 || input > branchArray.size()){
                    branchArray.printElements();
                    input = sc.nextInt();
                }
                Branch branch = branchArray.getElement( input- 1);
                Admin.addEmployee(employeeArray,TypeOfPeople.BranchEmployee,branch);

            }else if(selection == 5){
                Admin.removeEmployee(employeeArray,TypeOfPeople.BranchEmployee);
            }else if(selection == 6){
                employeeArray.printElements(TypeOfPeople.BranchEmployee);
            }else if(selection == 7){
                Admin.addEmployee(employeeArray,TypeOfPeople.TransportationPersonnel, null);
            }else if(selection == 8){
                Admin.removeEmployee(employeeArray,TypeOfPeople.TransportationPersonnel);
            }else if(selection == 9){
                employeeArray.printElements(TypeOfPeople.TransportationPersonnel);
            }
        }
    }

    private static int branchEmployeeMenu(){
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

    static void branchEmployeeDecisionMenu(DynamicArray<Cargo> cargoArray, DynamicArray<Customer> customerArray, DynamicArray<Branch> branchArray){
        while(selection != 0) {
            selection = Menus.branchEmployeeMenu();
            if (selection == 1) {
                BranchEmployee.addInfoToSystem(cargoArray, customerArray, branchArray);
            } else if (selection == 2) {
                BranchEmployee.removeInfoFromSystem(cargoArray,customerArray);
            } else if (selection == 3) {
                BranchEmployee.changeStatusOfCargo(cargoArray);
            } else if (selection == 4) {
                cargoArray.printElements();
            }
        }
    }

    static void transportationMenu(){
        System.out.println("---------Transportation Personnel Menu--------");
    }
    static void CustomerDecisionMenu(DynamicArray<Cargo> cargoArray){

        System.out.println("---------Customer Menu--------");
        selection = Integer.parseInt(Employee.getInput("Tracking Number of Cargo"));
        Customer.lookCargo(selection, cargoArray);

    }
}
