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
    /***
     * No-parameter constructor
     */
    public Employee() {
        super();
    }


}
