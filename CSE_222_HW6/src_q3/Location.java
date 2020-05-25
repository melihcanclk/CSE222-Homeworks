import java.util.Objects;

public class Location{
    int shelf;
    int corridor;
    int queue;
    StatusOfBooks status;
    Location(int shelf, int corridor, int queue){
        this.shelf = shelf;
        this.corridor = corridor;
        this.queue = queue;
        this.status = StatusOfBooks.Available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return shelf == location.shelf &&
                corridor == location.corridor &&
                queue == location.queue &&
                status == location.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shelf, corridor, queue, status);
    }

    @Override
    public String toString(){
        return "c"+ corridor + "s" + shelf + "." + queue + " / " + status;
    }
}