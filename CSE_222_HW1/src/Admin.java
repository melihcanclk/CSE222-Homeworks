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
<<<<<<< HEAD
        Branch branch = new Branch(name);
        branchArray.addElement(new Branch(name));
=======
        boolean flag = false;
        for (int i = 0; i< branchArray.size();i++){
            if(branchArray.getElement(i).getName().equals(name)){
                flag = true;
            }
        }
        if(!flag){
            branchArray.addElement(new Branch(name));
        }else System.out.println(name + " already inside of branches.\n");
>>>>>>> 0b6c4ef0af0f1256785a0a5c1b2b30261b0faeee
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
<<<<<<< HEAD
            BranchEmployee branchEmployee = new BranchEmployee(name,surname,typeOfPerson,branch);
            Object temp = (Object) employeeArray;
            @SuppressWarnings("unchecked")
            DynamicArray<HumanTypes> castArray = (DynamicArray<HumanTypes>) temp;
            if(!HumanTypes.isInclude(branchEmployee,castArray)){
                employeeArray.addElement(branchEmployee);
            }
=======
            BranchEmployee branchEmployee = new BranchEmployee(name,surname,typeOfPerson, branch);
            Object temp = (Object) employeeArray;
            @SuppressWarnings("unchecked")
            DynamicArray<HumanTypes> castArray = (DynamicArray<HumanTypes>) temp;

                employeeArray.addElement(branchEmployee);

>>>>>>> 0b6c4ef0af0f1256785a0a5c1b2b30261b0faeee

        }else if(typeOfPerson.name().equals(TransportationPersonnel.class.getName())){
            TransportationPersonnel transportationPersonnel = new TransportationPersonnel(name,surname,typeOfPerson);
            Object temp = (Object) employeeArray;
            @SuppressWarnings("unchecked")
            DynamicArray<HumanTypes> castArray = (DynamicArray<HumanTypes>) temp;

                employeeArray.addElement(transportationPersonnel);

        }

    }

    /**
     * Remove employee from employeeArray
     * @param employeeArray Dynamic Java class array that contains employees
     * @param typeOfPeople type of person to check whether person is Branch Employee or Transportation Personnel
     */
    public static void removeEmployee( DynamicArray<Employee> employeeArray, TypeOfPeople typeOfPeople){
<<<<<<< HEAD
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
=======

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

>>>>>>> 0b6c4ef0af0f1256785a0a5c1b2b30261b0faeee
    }

    /**
     * ToString Method for Admin class
     * @return Admin String that includes information for administrator
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
