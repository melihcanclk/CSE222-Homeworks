public class Book {
    private String nameOfAuthor;
    private String title;
    private Location location;

    Book(String nameOfAuthor, String title, Location location){
        this.nameOfAuthor = nameOfAuthor.trim();
        this.title = title.trim();
        this.location = location;
    }

    public String getNameOfAuthor() {
        return nameOfAuthor;
    }

    public void setNameOfAuthor(String nameOfAuthor) {
        this.nameOfAuthor = nameOfAuthor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
