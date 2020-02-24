public class TransportationPersonnel extends Employee{

    public TransportationPersonnel(String name, String surname, TypeOfPeople peopleType) {
        super(name, surname, peopleType);
    }

    @Override
    public String toString() {
        return  super.toString();
    }

    @Override
    public TypeOfPeople getPeopleType() {
        return null;
    }

    @Override
    public void setPeopleType(TypeOfPeople peopleType) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }
}
