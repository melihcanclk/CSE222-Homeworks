

public abstract class HumanTypes{

    private String name;
    private String surname;
    TypeOfPeople persontype;

    public HumanTypes(String name, String surname, TypeOfPeople peopleType) {
        this.name = name;
        this.surname = surname;
        this.persontype = peopleType;
    }

    public HumanTypes() {

    }

    public TypeOfPeople getPeopleType() {
        return persontype;
    }

    public void setPeopleType(TypeOfPeople peopleType) {
        this.persontype = peopleType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return  "Name:'" + name + '\'' +
                " Surname: '" + surname + '\'';
    }
}
