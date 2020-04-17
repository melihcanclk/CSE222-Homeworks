import java.util.ArrayList;
import java.util.Scanner;

/**
 * Abstract Class for holding HumanTypes
 */
public abstract class HumanTypes implements UserInterface{
    /**
     * Name of Human Types
     */
    private String name;
    /**
     * Surname Of HumanTypes
     */
    private String surname;
    /**
     * TypeOfPerson Type personType
     */
    TypeOfPeople persontype;

    /**
     * Constructor for abstract class HumanTypes
     * @param name Name of Humantype
     * @param surname Surname of Humantype
     * @param peopleType PeopleType type peopleType
     */
    public HumanTypes(String name, String surname, TypeOfPeople peopleType) {
        this.name = name;
        this.surname = surname;
        this.persontype = peopleType;
    }

    /**
     * No parameter constructor
     */
    public HumanTypes() { }

    /**
     * Getting people Type
     * @return TypeOfPeople type personType
     */
    public TypeOfPeople getPeopleType() {
        return persontype;
    }

    /**
     * Setting PeopleType
     * @param peopleType TypeOfPeople type personType
     */
    public void setPeopleType(TypeOfPeople peopleType) {
        this.persontype = peopleType;
    }

    /**
     * Getting name of HumanType
     * @return String type name
     */
    public String getName() {
        return name;
    }

    /**
     * Setting name of HumanType
     * @param name name of HumanType
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Settin surname of HumanType
     * @param surname surname of HumanType
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Getting Surname of HumanType
     * @return String type surname
     */
    public String getSurname() {
        return surname;
    }

    public static String getInput(String var){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter "+ var);
        return sc.nextLine();
    }

    @Override
    public String toString() {
        return  "Name:'" + name + '\'' +
                " Surname: '" + surname + '\'';
    }
}
