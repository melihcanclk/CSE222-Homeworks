public class Location{
    int shelf;
    int corridor;
    int queue;
    Status status;
    Location(int shelf, int corridor, int queue){
        this.shelf = shelf;
        this.corridor = corridor;
        this.queue = queue;
        this.status = Status.Available;
    }
    @Override
    public String toString(){
        return "c"+ corridor + "s" + shelf + "." + queue + " / " + status;
    }
}