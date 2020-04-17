import java.util.Scanner;

/***
 * Abstract class for holding Employees
 */
public abstract class Employee extends HumanTypes {
    /**
     * Employee abstract class constructot
     * @param name Name of Employee
     * @param surname Surname of Employee
     * @param peopleType PeopleType type people type
     */
    public Employee(String name, String surname, TypeOfPeople peopleType) {
        super(name, surname, peopleType);
    }

    @Override
    /**
     * Getting TypeOfPeople type people type
     */
    public TypeOfPeople getPeopleType() {
        return super.getPeopleType();
    }

    /***
     * No-parameter constructor
     */
    public Employee() {
        super();
    }

    @Override
    /**
     * Setting TypeOfPeople type people type
     */
    public void setPeopleType(TypeOfPeople peopleType) {
        super.setPeopleType(peopleType);
    }

    @Override
    /**
     * Getting name of Employee
     */
    public String getName() {
        return super.getName();
    }

    @Override
    /**
     * Setting name of Employee
     */
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    /**
     * Setting surname of Employee
     */
    public void setSurname(String surname) {
        super.setSurname(surname);
    }

    @Override
    /**
     * Getting surname of Employee
     */
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * getting input from user
     * @param var String that wanted to be add to printed string
     * @return String that is taken from user
     */
    public static String getInput(String var){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter "+ var);
        return sc.nextLine();
    }

}
