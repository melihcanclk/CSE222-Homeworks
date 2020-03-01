import java.util.ArrayList;
/**
 * Class for Administrators
 */
public class Admin extends Employee{

    /**
     * Admin constructor
     * @param name Name of admin
     * @param surname Surname of admin
     * @param peopleType PeopleType enumeration type of people
     */
    public Admin(String name, String surname, TypeOfPeople peopleType) {
        super(name, surname, peopleType);
    }

    /**
     * Adding branch to branchArray
     * @param branchArray branchArray that holds branches
     */
    public static void addBranch(ArrayList<Branch> branchArray){
        String name = getInput("Name of branch will be added:");
        boolean flag = false;
        for (int i = 0; i< branchArray.size();i++){
            if(branchArray.get(i).getName().equals(name)){
                flag = true;
            }
        }
        if(!flag){
            branchArray.add(new Branch(name));
        }else System.out.println(name + " already inside of branches.\n");
    }

    /**
     * Removing branches
     * @param branchArray branchArray that holds branches
     * @param employeeArray employeeArray that holds employees
     */
    public static void removeBranch(ArrayList<Branch> branchArray, ArrayList<Employee> employeeArray){
        if(branchArray.size()== 0){
            System.out.println( "No element to remove!!");
            return;
        }
        Menus.print(branchArray);
        int i = Integer.parseInt(getInput("Branch That Will Be Deleted(0 for exit)"));
        while(i > branchArray.size() || i < 0){
            System.out.println("Wrong number. Please try again.");
            i = Integer.parseInt(getInput("Branch That Will Be Deleted(0 for exit)"));
        }
        if(i == 0){
            return;
        }
        /*Deleting branch employees that will be deleted*/
        for(int j = 0; j< employeeArray.size();++j){
            if(employeeArray.get(j).getPeopleType().equals(TypeOfPeople.BranchEmployee)){
                BranchEmployee branchEmployee = (BranchEmployee) employeeArray.get(j);
                if(branchEmployee.getBranchWorked().equals(branchArray.get(i - 1))){
                    System.out.println( employeeArray.get(j).getName() + " deleted.Because "+
                            employeeArray.get(j).getName() + " was working at " + branchArray.get(i-1));
                    employeeArray.remove(j);
                    --j;
                }
            }
        }
        System.out.println( branchArray.get(i-1).getName() + " deleted.");
        branchArray.remove(i-1);

    }

    /**
     * Adding employees to employeeArray
     * @param employeeArray employeeArray that holds employees
     * @param typeOfPerson PeopleType enumeration type of people
     * @param branch branch that will be set
     */
    public static void addEmployee(ArrayList<Employee> employeeArray,  TypeOfPeople typeOfPerson, Branch branch) {
        String name = getInput("Name");
        String surname = getInput("Surname");

        for (int i = 0; i< employeeArray.size();++i){
            if(name.equals(employeeArray.get(i).getName()) && surname.equals(employeeArray.get(i).getSurname()) && employeeArray.get(i).getPeopleType().equals(typeOfPerson)){
                System.out.println(employeeArray.get(i).getName() +" " +
                                   employeeArray.get(i).getSurname()  + " is already a " + typeOfPerson.name() );
                return;
            }
        }

        if(typeOfPerson.name().equals(BranchEmployee.class.getName())){

            BranchEmployee branchEmployee = new BranchEmployee(name,surname,typeOfPerson, branch);
            Object temp = (Object) employeeArray;
            @SuppressWarnings("unchecked")
            ArrayList<HumanTypes> castArray = (ArrayList<HumanTypes>) temp;

                employeeArray.add(branchEmployee);


        }else if(typeOfPerson.name().equals(TransportationPersonnel.class.getName())){

            TransportationPersonnel transportationPersonnel = new TransportationPersonnel(name,surname,typeOfPerson);
            Object temp = (Object) employeeArray;
            @SuppressWarnings("unchecked")
            ArrayList<HumanTypes> castArray = (ArrayList<HumanTypes>) temp;

                employeeArray.add(transportationPersonnel);

        }

    }

    /**
     * Remove Employees with given type
     * @param employeeArray employeeArray that holds employees
     * @param typeOfPeople PeopleType enumeration type of people
     */
    public static void removeEmployee( ArrayList<Employee> employeeArray, TypeOfPeople typeOfPeople){

        Menus.print(employeeArray,typeOfPeople);
        int i = Integer.parseInt(getInput("employee will be deleted(0 for exit):"));
        int  k=0;
        boolean flag = false;
        if(i == 0)
            flag = true;
        for (int j = 0; j< employeeArray.size();++j ){
            if(employeeArray.get(j).getPeopleType() == typeOfPeople){
                if(k==i-1 ) {
                    System.out.println(employeeArray.get(j).getName() + " " + employeeArray.get(j).getSurname() + " deleted.");
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
