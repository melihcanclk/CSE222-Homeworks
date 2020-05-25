public class Admin extends People{
    private final String password;
    Admin(String username, String password){
        super(username);
        this.password = password;
    }
    public void addBook(NestedMap map,Book book){
        map.put(book);
    }
    public void removeBook(NestedMap map, Book book){
        map.removeBook(book.getLocation());
    }
    public void updateLocation(NestedMap map, Location oldLocation, Location newLocation){
        map.updateLocations(oldLocation,newLocation);
    }
    public String getPassword() {
        return password;
    }
}
