import java.util.Scanner;

public abstract class People {
    private String username;

    public People(String username) {
        this.username = username;
    }

   public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void searchBookByAuthorName(NestedMap outermap){
        System.out.print("Please enter name of the author : ");
        Scanner scanner = new Scanner(System.in);
        String nameOfTheAuthor = scanner.nextLine();
        outermap.getBooks(nameOfTheAuthor);
    }
    public void searchBookByTitle(NestedMap outermap){
        System.out.print("Please enter title of the book : ");
        Scanner scanner = new Scanner(System.in);
        String nameOfTitle = scanner.nextLine();
        outermap.getTitle(nameOfTitle);
    }

    @Override
    public boolean equals(Object obj) {
        return this.getUsername().equals(((People)obj).getUsername());
    }
}
