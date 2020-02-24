public class TransportationPersonnel extends Employee{

    public TransportationPersonnel(String name, String surname, TypeOfPeople peopleType) {
        super(name, surname, peopleType);
    }

    @Override
    public String toString() {
<<<<<<< HEAD
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

=======
        return super.toString();
>>>>>>> 0b6c4ef0af0f1256785a0a5c1b2b30261b0faeee
    }
}
