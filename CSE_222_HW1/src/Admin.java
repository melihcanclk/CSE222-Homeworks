/**
 * Administrator Class that extends from Employee abstract java class
 *
 */
public class Admin extends Employee{


    /**
     *
     * @param name
     * @param surname
     * @param peopleType
     */
    public Admin(String name, String surname, TypeOfPeople peopleType) {
        super(name, surname, peopleType);
    }

    /**
     * Adding branches to branch array
     * @param branchArray Dynamic Java class array that contains branches
     */
    public static void addBranch(DynamicArray<Branch> branchArray){
        String name = getInput("Name");
        Branch branch = new Branch(name);
        branchArray.addElement(new Branch(name));
    }

    /**
     * Removing branch from branchArray by getting index of the branches
     * @param branchArray Dynamic Java class array that contains branches
     * @param employeeArray Dynamic Java class array that contains employees for removing employees that are working
     *                      on that branch
     */
    public static void removeBranch(DynamicArray<Branch> branchArray, DynamicArray<Employee> employeeArray){
        if(branchArray.size()== 0){
            System.out.println( "No element to remove!!");
            return;
        }
        branchArray.printElements();
        int i = Integer.parseInt(getInput("Branch That Will Be Deleted(0 for exit)"));
        int flag = 0;
        if(i != 0){
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
    }

    /**
     * Adding Employee to employeeArray by getting name and surname of employee addition
     * @param employeeArray Dynamic Java class array that contains employees
     * @param typeOfPerson type of person to check whether person is Branch Employee or Transportation Personnel
     * @param branch branch that will be appointed
     */
    public static void addEmployee(DynamicArray<Employee> employeeArray,  TypeOfPeople typeOfPerson, Branch branch) {
        String name = getInput("Name");
        String surname = getInput("Surname");

        if(typeOfPerson.name().equals(BranchEmployee.class.getName())){
            BranchEmployee branchEmployee = new BranchEmployee(name,surname,typeOfPerson,branch);
            Object temp = (Object) employeeArray;
            @SuppressWarnings("unchecked")
            DynamicArray<HumanTypes> castArray = (DynamicArray<HumanTypes>) temp;
            if(!HumanTypes.isInclude(branchEmployee,castArray)){
                employeeArray.addElement(branchEmployee);
            }

        }else if(typeOfPerson.name().equals(TransportationPersonnel.class.getName())){
            employeeArray.addElement(new TransportationPersonnel(name,surname,typeOfPerson));
        }

    }

    /**
     * Remove employee from employeeArray
     * @param employeeArray Dynamic Java class array that contains employees
     * @param typeOfPeople type of person to check whether person is Branch Employee or Transportation Personnel
     */
    public static void removeEmployee( DynamicArray<Employee> employeeArray, TypeOfPeople typeOfPeople){
        if(employeeArray.size()== 0){
            System.out.println( "No element to remove!!");
            return;
        }
        employeeArray.printElements(typeOfPeople);
        int i = Integer.parseInt(getInput("Number Of " + typeOfPeople + " will be deleted(0 for exit):"));
        int counter = 1;
        if(i != 0){
            for(int j = 0; j< employeeArray.size();j++){
                if((employeeArray.getElement(j).getPeopleType() == typeOfPeople)){
                    if(counter == i){
                        System.out.println( employeeArray.getElement(j).getName() + " " + employeeArray.getElement(j).getSurname() + " deleted.");
                        employeeArray.remove(j);
                    }
                    ++counter;
                }
            }
        }
    }

    /**
     * ToString Method for Admin class
     * @return Admin String that includes information for administrator
     */
    @Override
    public String toString() {
        return "Admin" + super.toString();
    }
}
