import java.util.Scanner;

public abstract class People {
    /**
     * Username
     */
    private String username;

    /**
     * Constructor of People Abstract class
     * @param username username
     */
    public People(String username) {
        this.username = username;
    }

    /**
     * Getting username of People
     * @return Username of People
     */
   public String getUsername() {
        return username;
    }

    /**
     * Search Book By Author Name
     * @param outermap Outer Map
     */
    public void searchSoftwareByName(SearchTree<Software> tree){
        
        System.out.print("Please enter name of the author : ");
        Scanner scanner = new Scanner(System.in);
        String nameOfSoftware = scanner.nextLine();
        //Print all books named nameofsoftware
    }

    /**
     * Search Author and Location(s) of a book
     * @param outermap Outer Map
     */
    public void searchSoftwareByQuantity(SearchTree<Software> tree){
        
        System.out.print("Please enter title of the book : ");
        Scanner scanner = new Scanner(System.in);
        String nameOfTitle = scanner.nextLine();
        //Print all softwares with same quantity
    }

    /**
     * Search Author and Location(s) of a book
     * @param outermap Outer Map
     */
    public void searchSoftwareByPrice(SearchTree<Software> tree){
        System.out.print("Please enter title of the book : ");
        Scanner scanner = new Scanner(System.in);
        String nameOfTitle = scanner.nextLine();
        //print all softwares with same price
    }

    /**
     * Equals method that controls if two people has same name or not
     * @param obj Other People object
     * @return if two people has same name or not
     */
    @Override
    public boolean equals(Object obj) {
        return this.getUsername().equals(((People)obj).getUsername());
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "People [username=" + username + "]";
    }
    
}
