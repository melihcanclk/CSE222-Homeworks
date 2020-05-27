import java.util.ArrayList;

public class User extends People{
    /**
     * Booklist of user that have (Canceled)
     */
    ArrayList<Book> bookList;

    /**
     * User Constructor
     * @param username Name of the user
     */
    User(String username){
        super(username);
        bookList = new ArrayList<>();
    }
}
