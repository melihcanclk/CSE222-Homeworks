

public abstract class HumanTypes implements UserInterface{

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
<<<<<<< HEAD
        return  "\nName: " + name +
                "\nSurname: " + surname;
    }
    public static boolean isInclude(HumanTypes humanTypes, DynamicArray<HumanTypes> array){
        boolean flag = false;
        for (int i = 0; i< array.size();++i){
            if(humanTypes.getName().equals(array.getElement(i).getName()) && humanTypes.getSurname().equals(array.getElement(i).getSurname())
                    && humanTypes.getPeopleType().equals(array.getElement(i).getPeopleType())){
                flag = true;
            }
        }
        if(flag){
            System.out.println("\n" + humanTypes.getName() + " is already in  "+ humanTypes.getPeopleType() +" List so not add to system.");
        }else
            return flag;

        return true;
=======
        return  "Name:'" + name + '\'' +
                " Surname: '" + surname + '\'';
>>>>>>> 0b6c4ef0af0f1256785a0a5c1b2b30261b0faeee
    }
}
