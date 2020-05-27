import java.util.Objects;

public class Location{
    int shelf;
    int corridor;
    int queue;

    /**
     * Constructor of Locaiton Class
     * @param shelf Shelf
     * @param corridor Corridor
     * @param queue Order of Book
     */
    Location(int shelf, int corridor, int queue){
        this.shelf = shelf;
        this.corridor = corridor;
        this.queue = queue;
    }

    /**
     * Override equals method that detect if two Locations are the same or not
     * @param o Other Location object
     * @return if two locations are the same or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return shelf == location.shelf &&
                corridor == location.corridor &&
                queue == location.queue;
    }

    /**
     * HashCode override
     * @return Hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(shelf, corridor, queue);
    }

    /**
     * Overriden toString method
     * @return Location string
     */
    @Override
    public String toString(){
        return "s"+ shelf + "c" + corridor + "." + queue;
    }
}