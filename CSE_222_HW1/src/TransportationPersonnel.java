/**
 * Class for holding Transportation Personnel's
 */
public class TransportationPersonnel extends Employee{
    /**
     * Constructor for Transportation Personnel
     * @param name Name of Transportation Personnel
     * @param surname Surname of Transportation Personnel
     * @param peopleType PeopleType type of Transportation Personnel
     */
    public TransportationPersonnel(String name, String surname, TypeOfPeople peopleType) {
        super(name, surname, peopleType);
    }

    @Override
    /**
     * getting people type
     */
    public TypeOfPeople getPeopleType() {
        return super.getPeopleType();
    }

    /**
     * no-parameter constructor of Transportation Personnel
     */
    public TransportationPersonnel() {
        super();
    }

    @Override
    /**
     * Setting TypeOfPeople type peopletype
     */
    public void setPeopleType(TypeOfPeople peopleType) {
        super.setPeopleType(peopleType);
    }

    @Override
    /**
     * Getting name of Transportation Personnel
     */
    public String getName() {
        return super.getName();
    }

    @Override
    /**
     * Setting name of Transportation Personnel
     */
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    /**
     * Setting surname of Transportation Personnel
     */
    public void setSurname(String surname) {
        super.setSurname(surname);
    }

    @Override
    /**
     * Getting surname of Transportation Personnel
     */
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
