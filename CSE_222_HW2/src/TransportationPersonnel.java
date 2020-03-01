/**
 * Class for holding Transportation Personnel's
 */
public class TransportationPersonnel extends Employee {
    /**
     * Constructor for Transportation Personnel
     *
     * @param name       Name of Transportation Personnel
     * @param surname    Surname of Transportation Personnel
     * @param peopleType PeopleType type of Transportation Personnel
     */
    public TransportationPersonnel(String name, String surname, TypeOfPeople peopleType) {
        super(name, surname, peopleType);
    }

    /**
     * no-parameter constructor of Transportation Personnel
     */
    public TransportationPersonnel() {
        super();
    }
}
