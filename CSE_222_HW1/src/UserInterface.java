/**
 * Interface of users
 */
public interface UserInterface {
    /**
     * Getting PeopleType type people type
     * @return PeopleType type people type
     */
    TypeOfPeople getPeopleType();

    /**
     * Setting People type people type
     * @param peopleType PeopleType type people type
     */
    void setPeopleType(TypeOfPeople peopleType);

    /**
     * Getting name
     * @return String type name
     */
    String getName();

    /**
     * Setting name
     * @param name String type name
     */
    void setName(String name);

    /**
     * Setting Surname
     * @param surname String type surname
     */
    void setSurname(String surname);

    /**
     * Getting surname
     * @return String type surname
     */
    String getSurname();
}