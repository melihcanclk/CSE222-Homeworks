import java.util.Scanner;

public class Admin extends People{
    private final String password;

    /**
     * Constructor of Admin Class
     * @param username Username of Admin
     * @param password Password of Admin
     */
    Admin(String username, String password){
        super(username);
        this.password = password;
    }

    /**
     * Adding book to Map
     * @param map Map that keeps all information about books
     */
    public void addBook(NestedMap map){
        System.out.println(map);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of the author : ");
        String nameOfAuthor = scanner.nextLine();
        System.out.print("Enter title of the book : ");
        String title = scanner.nextLine();
        System.out.print("Enter shelf, corridor and queue of the book that you will put respectively : ");
        int shelf = scanner.nextInt();
        int corridor = scanner.nextInt();
        int queue = scanner.nextInt();
        map.put(new Book(nameOfAuthor,title,new Location(shelf,corridor,queue)));
    }

    /**
     *  Remove book from Map
     * @param map Map that keeps all information about books
     */
    public void removeBook(NestedMap map){
        System.out.println(map);
        System.out.print("Enter shelf, corridor and queue of the book that you will put respectively : ");
        Scanner scanner = new Scanner(System.in);
        int shelf = scanner.nextInt();
        int corridor = scanner.nextInt();
        int queue = scanner.nextInt();
        map.removeBook(new Location(shelf,corridor,queue));
    }

    /**
     * Update locations of the books
     * @param map Map that keeps all information about books
     */
    public void updateLocation(NestedMap map){
        System.out.println(map);
        System.out.print("Enter shelf, corridor and queue of the book that you will change position respectively : ");
        Scanner scanner = new Scanner(System.in);
        int shelf1 = scanner.nextInt();
        int corridor1 = scanner.nextInt();
        int queue1 = scanner.nextInt();
        System.out.print("Enter shelf, corridor and queue of the book that you will put new position respectively : ");
        int shelf2 = scanner.nextInt();
        int corridor2 = scanner.nextInt();
        int queue2 = scanner.nextInt();
        Location location1 = new Location(shelf1,corridor1,queue1);
        Location location2 = new Location(shelf2,corridor2,queue2);
        if(!location1.equals(location2)){
            map.updateLocations(location1,location2);
        }else {
            System.out.println("Entered Same Location!");
        }
    }

    /**
     * Printing All books
     * @param map Map that keeps all information about books
     */
    public void printAllBooks(NestedMap map){
        System.out.println(map);
    }

    /**
     * Getting password of the Admin
     * @return password
     */
    public String getPassword() {
        return password;
    }
}
