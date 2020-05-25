import java.util.ArrayList;

public class User extends People{
    ArrayList<Book> bookList;
    User(String username){
        super(username);
        bookList = new ArrayList<>();
    }
}
