import java.util.Scanner;

public class Admin extends Employee{

    public Admin(String name, String surname, TypeOfPeople peopleType) {
        super(name, surname, peopleType);
    }

    public static void addBranch(DynamicArray<Branch> branchArray){
        String name = getInput("Name");
        branchArray.addElement(new Branch(name));
    }

    public static void removeBranch(DynamicArray<Branch> branchArray, DynamicArray<Employee> employeeArray){
        if(branchArray.size()== 0){
            System.out.println( "No element to remove!!");
            return;
        }
        branchArray.printElements();
        int i = Integer.parseInt(getInput("Branch That Will Be Deleted"));
        int flag = 0;

        for(int j = 0; j< employeeArray.size();++j){
            if(employeeArray.getElement(j).getPeopleType().equals(TypeOfPeople.BranchEmployee)){
                BranchEmployee branchEmployee = (BranchEmployee) employeeArray.getElement(j);
                if(branchEmployee.getBranchWorked().equals(branchArray.getElement(i - 1))){
                    System.out.println( employeeArray.getElement(j).getName() + " deleted.Because "+
                            employeeArray.getElement(j).getName() + " was working at " + branchArray.getElement(i-1));
                    employeeArray.remove(j);
                    --j;
                }
            }
        }
        System.out.println( branchArray.getElement(i-1).getName() + " deleted.");
        branchArray.remove(i-1);

    }

    public static void addEmployee(DynamicArray<Employee> employeeArray,  TypeOfPeople typeOfPerson, Branch branch) {
        String name = getInput("Name");
        String surname = getInput("Surname");

        if(typeOfPerson.name().equals(BranchEmployee.class.getName())){
            employeeArray.addElement(new BranchEmployee(name,surname,typeOfPerson, branch));
        }else if(typeOfPerson.name().equals(TransportationPersonnel.class.getName())){
            employeeArray.addElement(new TransportationPersonnel(name,surname,typeOfPerson));
        }

    }

    public static void removeEmployee( DynamicArray<Employee> employeeArray, TypeOfPeople typeOfPeople){
        if(employeeArray.size()== 0){
            System.out.println( "No element to remove!!");
            return;
        }
        employeeArray.printElements(TypeOfPeople.BranchEmployee);
        String name = getInput("Name");
        String surname = getInput("Surname");
        int flag = 0;

        for(int i = 0; i< employeeArray.size(); ++i){
            if(employeeArray.getElement(i).getName().equals(name) && employeeArray.getElement(i).getSurname().equals(surname) && employeeArray.getElement(i).getPeopleType().equals(typeOfPeople)){
                System.out.println( employeeArray.getElement(i).getName() + " " + employeeArray.getElement(i).getSurname() + " deleted.");
                employeeArray.remove(i);
                flag = 1;
            }
        }
        if(flag == 0){
            System.out.println( "There is no element named " + name);
        }

    }

    @Override
    public String toString() {
        return "Admin" + super.toString();
    }
}
