import java.awt.*;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        DynamicArray<Employee> employeeArray = new DynamicArray<>(Employee.class);
        DynamicArray<Cargo> cargoArray = new DynamicArray<>(Cargo.class);
        DynamicArray<Branch> branchArray = new DynamicArray<>(Branch.class);
        DynamicArray<Customer> customerArray = new DynamicArray<>(Customer.class);

        employeeArray.addElement(new Admin("Melihcan", "Çilek", TypeOfPeople.Admin));
        int selection = Menus.mainMenu();
        while(selection != 0){
            switch (selection) {
                case 1:
                    /*Upcasting by using Dynamic cast from employee array to HumanTypes Array*/
                    /*Object temp = (Object) employeeArray;
                    @SuppressWarnings("unchecked")
                    DynamicArray<HumanTypes> castArray = (DynamicArray<HumanTypes>) temp;
                    int index = checkPerson( castArray,TypeOfPeople.Admin);*/
                    int index = 1;
                    if(index >= 0){
                        Menus.amdinDecissionMenu(branchArray,employeeArray);
                    }
                    break;
                case 2:
                    Menus.branchEmployeeDecisionMenu(cargoArray,customerArray,branchArray);
                    break;
                case 3:
                    System.out.println("1->Transportation Menu");
                    break;
                case 4:
                    System.out.println("1->Customer Menu");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + selection);
            }
            selection = Menus.mainMenu();
        }
    }

    public static int checkPerson(DynamicArray<HumanTypes> array, TypeOfPeople typeOfPeople){
        int flag = 0, i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name");
        String name = sc.nextLine();
        System.out.println("Enter Surname");
        String surname = sc.nextLine();
        for(i = 0; i< array.size();++i){
            if(array.getElement(i).getName().equals(name) && array.getElement(i).getSurname().equals(surname) && array.getElement(i).getPeopleType().equals(typeOfPeople)){
                System.out.println("Logged in!!");
                flag = 1;
            }
        }
        if(flag == 1){
            return i -1;
        }
        //TODO : check names, surnames and type
        System.out.println("Not Logged in!!");
        return -1;
    }
}
