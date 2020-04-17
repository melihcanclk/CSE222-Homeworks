import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Melihcan Çilek
 */
public class Main {
    /**
     * Employee ArrayList for hold employees
     */
    public static ArrayList<Employee> employeeArray;
    /**
     * Cargo ArrayList for hold cargo's
     */
    public static ArrayList<Cargo> cargoArray;
    /**
     *Branch ArrayList for hold branches
     */
    public static ArrayList<Branch> branchArray;
    /**
     * Customer ArrayList for hold customers
     */
    public static ArrayList<Customer> customerArray;

    /**
     * main method
     * @param args Standart main method argumants
     */
    public static void main(String[] args) {

        initArrays();

        int selection = Menus.mainMenu();
        while(selection != 0){
            switch (selection) {
                case 1:
                    /*Upcasting by using Dynamic cast from employee array to HumanTypes Array*/
                    Object temp = (Object) employeeArray;
                    @SuppressWarnings("unchecked")
                    ArrayList<HumanTypes> castArray = (ArrayList<HumanTypes>) temp;
                    int index = checkAdmin( castArray);
                    if(index >= 0){
                        Menus.adminDecissionMenu(branchArray, employeeArray);
                    }
                    break;
                case 2:
                    Menus.branchEmployeeDecisionMenu(cargoArray,customerArray,branchArray);
                    break;
                case 3:
                    BranchEmployee.changeStatusOfCargo(cargoArray);
                    break;
                case 4:
                    Menus.customerMenu(cargoArray);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + selection);
            }
            selection = Menus.mainMenu();
        }
    }

    /**
     * static function for check administration of person
     * @param array Any Humantypes type array
     * @return returns whether name and surname given person is type of people or not
     */
    private static int checkAdmin(ArrayList<HumanTypes> array){
        int flag = 0, i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name");
        String name = sc.nextLine();
        System.out.println("Enter Surname");
        String surname = sc.nextLine();
        for(i = 0; i< array.size();++i){
            if(array.get(i).getName().equals(name) && array.get(i).getSurname().equals(surname) && array.get(i).getPeopleType().equals(TypeOfPeople.Admin)){
                System.out.println("Logged in!!");
                flag = 1;
            }
        }
        if(flag == 1){
            return i -1;
        }
        System.out.println("Not Logged in!!");
        return -1;
    }

    /**
     * Initialize default branches, branch employees, customers, transportation
     * personnel's,cargo's
     */
    public static void initArrays(){
        branchArray = new ArrayList<>();
        employeeArray = new ArrayList<>();
        customerArray = new ArrayList<>();
        cargoArray = new ArrayList<>();

        branchArray.add(new Branch(("Kocaeli")));
        branchArray.add(new Branch("İstanbul"));
        branchArray.add(new Branch("Karabük"));
        branchArray.add(new Branch("Antalya"));
        branchArray.add(new Branch("Malatya"));

        employeeArray.add(new Admin("Melihcan", "Çilek", TypeOfPeople.Admin));
        employeeArray.add(new BranchEmployee("Batuhan", "Sami", TypeOfPeople.BranchEmployee,branchArray.get(0)));
        employeeArray.add(new BranchEmployee("Mert", "Çilek", TypeOfPeople.BranchEmployee,branchArray.get(0)));
        employeeArray.add(new BranchEmployee("Abdullah", "Küsgülü", TypeOfPeople.BranchEmployee,branchArray.get(1)));
        employeeArray.add(new BranchEmployee("Buğra Eren", "Yılmaz", TypeOfPeople.BranchEmployee,branchArray.get(1)));

        employeeArray.add(new TransportationPersonnel("Hasan", "Bıyık", TypeOfPeople.TransportationPersonnel));
        employeeArray.add(new TransportationPersonnel("Mustafa", "Kayan", TypeOfPeople.TransportationPersonnel));
        employeeArray.add(new TransportationPersonnel("Berkay", "Ayan", TypeOfPeople.TransportationPersonnel));
        employeeArray.add(new TransportationPersonnel("Hasan Ali", "Kaldırım", TypeOfPeople.TransportationPersonnel));


        customerArray.add(new Customer("Pelin","Kuserli", TypeOfPeople.Customer,CustomerType.Sender));
        customerArray.add(new Customer("Zelal","Akdağ", TypeOfPeople.Customer,CustomerType.Receiver));
        customerArray.add(new Customer("Mahmut","Bahar", TypeOfPeople.Customer,CustomerType.Sender));
        customerArray.add(new Customer("Gülşen","Kaderoğlu", TypeOfPeople.Customer,CustomerType.Receiver));
        customerArray.add(new Customer("Gamze","Boran", TypeOfPeople.Customer,CustomerType.Sender));
        customerArray.add(new Customer("Yelda","Yaprak", TypeOfPeople.Customer,CustomerType.Receiver));
        customerArray.add(new Customer("Serdar","Kızılca", TypeOfPeople.Customer,CustomerType.Sender));
        customerArray.add(new Customer("Utku","Sezer", TypeOfPeople.Customer,CustomerType.Receiver));

        cargoArray.add(new Cargo(customerArray.get(0),customerArray.get(1),
                10001,StatusOfCargo.NotArrived,branchArray.get(4),branchArray.get(3)));
        cargoArray.add(new Cargo(customerArray.get(2),customerArray.get(3),
                10002,StatusOfCargo.NotArrived,branchArray.get(2),branchArray.get(3)));
        cargoArray.add(new Cargo(customerArray.get(4),customerArray.get(5),
                10003,StatusOfCargo.NotArrived,branchArray.get(1),branchArray.get(4)));
        cargoArray.add(new Cargo(customerArray.get(6),customerArray.get(7),
                10004,StatusOfCargo.NotArrived,branchArray.get(1),branchArray.get(4)));

    }

}
