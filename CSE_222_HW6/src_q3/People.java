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
    public void searchBookByAuthorName(NestedMap outermap){
        outermap.printAuthors();
        System.out.print("Please enter name of the author : ");
        Scanner scanner = new Scanner(System.in);
        String nameOfTheAuthor = scanner.nextLine();
        outermap.getBooks(nameOfTheAuthor);
    }

    /**
     * Search Author and Location(s) of a book
     * @param outermap Outer Map
     */
    public void searchBookByTitle(NestedMap outermap){
        outermap.printBookTitles();
        System.out.print("Please enter title of the book : ");
        Scanner scanner = new Scanner(System.in);
        String nameOfTitle = scanner.nextLine();
        outermap.getTitle(nameOfTitle);
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
}
