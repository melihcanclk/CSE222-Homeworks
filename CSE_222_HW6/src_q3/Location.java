import java.util.Objects;

public class Location{
    int shelf;
    int corridor;
    int queue;
    Location(int shelf, int corridor, int queue){
        this.shelf = shelf;
        this.corridor = corridor;
        this.queue = queue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return shelf == location.shelf &&
                corridor == location.corridor &&
                queue == location.queue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shelf, corridor, queue);
    }

    @Override
    public String toString(){
        return "s"+ shelf + "c" + corridor + "." + queue;
    }
}