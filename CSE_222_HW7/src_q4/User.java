import java.util.ArrayList;

public class User extends People{
    /**
     * Booklist of user that have (Canceled)
     */
    ArrayList<Software> sofwareList;

    /**
     * User Constructor
     * @param username Name of the user
     */
    User(String username){
        super(username);
        sofwareList = new ArrayList<>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "User [sofwareList=" + sofwareList + "]";
    }
    
}
