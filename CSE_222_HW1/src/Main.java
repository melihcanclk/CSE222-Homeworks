import java.awt.*;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {


        DynamicArray<Employee> employeeArray = new DynamicArray<>(Employee.class);
        DynamicArray<Cargo> cargoArray = new DynamicArray<>(Cargo.class);
        DynamicArray<Branch> branchArray = new DynamicArray<>(Branch.class);
        DynamicArray<Customer> customerArray = new DynamicArray<>(Customer.class);
<<<<<<< HEAD
        /*
         * Adding Branches To branchArray
         */
        branchArray.addElement(new Branch("Gebze"));
        branchArray.addElement(new Branch("İstanbul"));
        branchArray.addElement(new Branch("Karabük"));
        branchArray.addElement(new Branch("Ankara"));
        branchArray.addElement(new Branch("İzmir"));
        System.out.println();
        /*
         * Adding Employees To employeeArray
         */
=======

        branchArray.addElement(new Branch("Gebze"));
        branchArray.addElement(new Branch("İstanbul"));
        branchArray.addElement(new Branch("Karabük"));
        branchArray.addElement(new Branch("Antalya"));
        branchArray.addElement(new Branch("Malatya"));
        System.out.println();

>>>>>>> 0b6c4ef0af0f1256785a0a5c1b2b30261b0faeee
        employeeArray.addElement(new Admin("Melihcan", "Çilek", TypeOfPeople.Admin));
        employeeArray.addElement(new BranchEmployee("Batuhan", "Sami", TypeOfPeople.BranchEmployee,branchArray.getElement(0)));
        employeeArray.addElement(new BranchEmployee("Mert", "Çilek", TypeOfPeople.BranchEmployee,branchArray.getElement(0)));
        employeeArray.addElement(new BranchEmployee("Abdullah", "Küsgülü", TypeOfPeople.BranchEmployee,branchArray.getElement(1)));
        employeeArray.addElement(new BranchEmployee("Buğra Eren", "Yılmaz", TypeOfPeople.BranchEmployee,branchArray.getElement(1)));
<<<<<<< HEAD
        employeeArray.addElement(new TransportationPersonnel("Emre", "Özbay", TypeOfPeople.TransportationPersonnel));
        employeeArray.addElement(new TransportationPersonnel("Ali", "Bakan", TypeOfPeople.TransportationPersonnel));
        employeeArray.addElement(new TransportationPersonnel("Veli", "Bakan", TypeOfPeople.TransportationPersonnel));
        System.out.println();
        /*
         * Adding Customers To customerArray
         */
        customerArray.addElement(new Customer("Abdurrahman", "Yenidoğan",TypeOfPeople.Customer,CustomerType.Sender));
        customerArray.addElement(new Customer("Sevinç", "Varaürer", TypeOfPeople.Customer, CustomerType.Receiver));
        customerArray.addElement(new Customer("Rümeysa", "Dayı",TypeOfPeople.Customer,CustomerType.Sender));
        customerArray.addElement(new Customer("Sultan", "Usul", TypeOfPeople.Customer, CustomerType.Receiver));
        customerArray.addElement(new Customer("Timuçin", "Koptur",TypeOfPeople.Customer,CustomerType.Sender));
        customerArray.addElement(new Customer("Gülistan", "Özülkü", TypeOfPeople.Customer, CustomerType.Receiver));
        customerArray.addElement(new Customer("Sedef", "Kendirli", TypeOfPeople.Customer, CustomerType.Sender));
        customerArray.addElement(new Customer("Hakak", "Işılak", TypeOfPeople.Customer, CustomerType.Receiver));
        System.out.println();
        /*
         * Adding Cargo's to cargoArray that customer's have
         */
        cargoArray.addElement(new Cargo(customerArray.getElement(0),customerArray.getElement(1),10001,StatusOfCargo.Not_Arrived,
                branchArray.getElement(0),branchArray.getElement(1)));

        cargoArray.addElement(new Cargo(customerArray.getElement(2), customerArray.getElement(3),10002,StatusOfCargo.Not_Arrived,
                branchArray.getElement(1),branchArray.getElement(3)));

        cargoArray.addElement(new Cargo(customerArray.getElement(4), customerArray.getElement(5),10003,StatusOfCargo.Not_Arrived,
                branchArray.getElement(1),branchArray.getElement(3)));

        cargoArray.addElement(new Cargo(customerArray.getElement(6),customerArray.getElement(7),10004,StatusOfCargo.Not_Arrived,
                branchArray.getElement(4),branchArray.getElement(2)));
        System.out.println();

=======
        System.out.println();

        employeeArray.addElement(new TransportationPersonnel("Hasan", "Bıyık", TypeOfPeople.TransportationPersonnel));
        employeeArray.addElement(new TransportationPersonnel("Mustafa", "Kayan", TypeOfPeople.TransportationPersonnel));
        employeeArray.addElement(new TransportationPersonnel("Berkay", "Ayan", TypeOfPeople.TransportationPersonnel));
        employeeArray.addElement(new TransportationPersonnel("Hasan Ali", "Kaldırım", TypeOfPeople.TransportationPersonnel));
        System.out.println();

        customerArray.addElement(new Customer("Pelin","Kuserli", TypeOfPeople.Customer,CustomerType.Sender));
        customerArray.addElement(new Customer("Zelal","Akdağ", TypeOfPeople.Customer,CustomerType.Receiver));
        customerArray.addElement(new Customer("Mahmut","Bahar", TypeOfPeople.Customer,CustomerType.Sender));
        customerArray.addElement(new Customer("Gülşen","Kaderoğlu", TypeOfPeople.Customer,CustomerType.Receiver));
        customerArray.addElement(new Customer("Gamze","Boran", TypeOfPeople.Customer,CustomerType.Sender));
        customerArray.addElement(new Customer("Yelda","Yaprak", TypeOfPeople.Customer,CustomerType.Receiver));
        customerArray.addElement(new Customer("Serdar","Kızılca", TypeOfPeople.Customer,CustomerType.Sender));
        customerArray.addElement(new Customer("Utku","Sezer", TypeOfPeople.Customer,CustomerType.Receiver));
        System.out.println();

        cargoArray.addElement(new Cargo(customerArray.getElement(0),customerArray.getElement(1),
                10001,StatusOfCargo.NotArrived,branchArray.getElement(4),branchArray.getElement(3)));
        cargoArray.addElement(new Cargo(customerArray.getElement(2),customerArray.getElement(3),
                10002,StatusOfCargo.NotArrived,branchArray.getElement(2),branchArray.getElement(3)));
        cargoArray.addElement(new Cargo(customerArray.getElement(4),customerArray.getElement(5),
                10003,StatusOfCargo.NotArrived,branchArray.getElement(1),branchArray.getElement(4)));
        cargoArray.addElement(new Cargo(customerArray.getElement(6),customerArray.getElement(7),
                10004,StatusOfCargo.NotArrived,branchArray.getElement(1),branchArray.getElement(4)));
        System.out.println();
>>>>>>> 0b6c4ef0af0f1256785a0a5c1b2b30261b0faeee

        int selection = Menus.mainMenu();
        while(selection != 0){
            switch (selection) {
                case 1:
                    /*Upcasting by using Dynamic cast from employee array to HumanTypes Array*/
                    Object temp = (Object) employeeArray;
                    @SuppressWarnings("unchecked")
                    DynamicArray<HumanTypes> castArray = (DynamicArray<HumanTypes>) temp;
                    int index = checkPerson( castArray,TypeOfPeople.Admin);
                    if(index >= 0){
                        Menus.adminDecissionMenu(branchArray,employeeArray);
                    }
                    break;
                case 2:
                    Menus.branchEmployeeDecisionMenu(cargoArray,customerArray,branchArray);
                    break;
                case 3:
<<<<<<< HEAD
                    Menus.transportationMenu();
                    BranchEmployee.changeStatusOfCargo(cargoArray);
                    break;
                case 4:
                    Menus.CustomerDecisionMenu(cargoArray);
=======
                    BranchEmployee.changeStatusOfCargo(cargoArray);
                    break;
                case 4:
                    Menus.customerMenu(cargoArray,customerArray,branchArray);
>>>>>>> 0b6c4ef0af0f1256785a0a5c1b2b30261b0faeee
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
        System.out.println("Not Logged in!!");
        return -1;
    }
}
