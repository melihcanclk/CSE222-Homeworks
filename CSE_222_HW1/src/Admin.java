import java.util.Scanner;

public class Admin extends Employee{

    public Admin(String name, String surname, TypeOfPeople peopleType) {
        super(name, surname, peopleType);
    }

    public static void addBranch(DynamicArray<Branch> branchArray){
        String name = getInput("Name");
        boolean flag = false;
        for (int i = 0; i< branchArray.size();i++){
            if(branchArray.getElement(i).getName().equals(name)){
                flag = true;
            }
        }
        if(!flag){
            branchArray.addElement(new Branch(name));
        }else System.out.println(name + " already inside of branches.\n");
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
            BranchEmployee branchEmployee = new BranchEmployee(name,surname,typeOfPerson, branch);
            Object temp = (Object) employeeArray;
            @SuppressWarnings("unchecked")
            DynamicArray<HumanTypes> castArray = (DynamicArray<HumanTypes>) temp;

                employeeArray.addElement(branchEmployee);


        }else if(typeOfPerson.name().equals(TransportationPersonnel.class.getName())){
            TransportationPersonnel transportationPersonnel = new TransportationPersonnel(name,surname,typeOfPerson);
            Object temp = (Object) employeeArray;
            @SuppressWarnings("unchecked")
            DynamicArray<HumanTypes> castArray = (DynamicArray<HumanTypes>) temp;

                employeeArray.addElement(transportationPersonnel);

        }

    }

    public static void removeEmployee( DynamicArray<Employee> employeeArray, TypeOfPeople typeOfPeople){

        employeeArray.printElements(typeOfPeople);
        int i = Integer.parseInt(getInput("employee will be deleted(0 for exit):"));
        int  k=0;
        boolean flag = false;
        if(i == 0)
            flag = true;
        for (int j = 0; j< employeeArray.size();++j ){
            if(employeeArray.getElement(j).getPeopleType() == typeOfPeople){
                if(k==i-1 ) {
                    System.out.println(employeeArray.getElement(j).getName() + " " + employeeArray.getElement(j).getSurname() + " deleted.");
                    employeeArray.remove(j);
                    flag = true;
                }
                ++k;
            }
        }
        if(!flag){
            System.out.println("Out Of Bound!!!\n");
        }

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
