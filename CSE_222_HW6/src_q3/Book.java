public class Book {
    /**
     * Name of the author
     */
    private String nameOfAuthor;
    /**
     * Title of the book
     */
    private String title;
    /**
     * Location of the book that is located
     */
    private Location location;

    /**
     * Constructor of Book class
     * @param nameOfAuthor Name of the author
     * @param title Title of the book
     * @param location Location of the book that is located
     */
    Book(String nameOfAuthor, String title, Location location){
        this.nameOfAuthor = nameOfAuthor.trim();
        this.title = title.trim();
        this.location = location;
    }
    /**
     * Get Name of the Author
     * @return Name of the Author
     */
    public String getNameOfAuthor() {
        return nameOfAuthor;
    }

    /**
     * Get Title of the book
     * @return Title of the book
     */
    public String getTitle() {
        return title;
    }
    /**
     * Get Location of the book that is located
     * @return Location of the book that is located
     */
    public Location getLocation() {
        return location;
    }

}
