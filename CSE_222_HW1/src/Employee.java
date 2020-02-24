import java.util.Scanner;

public abstract class Employee extends HumanTypes {


    public Employee(String name, String surname, TypeOfPeople peopleType) {
        super(name, surname, peopleType);
    }


    @Override
    public TypeOfPeople getPeopleType() {
        return super.getPeopleType();
    }

    public Employee() {
        super();
    }

    @Override
    public void setPeopleType(TypeOfPeople peopleType) {
        super.setPeopleType(peopleType);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static String getInput(String var){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter "+ var);
        return sc.nextLine();
    }

}
