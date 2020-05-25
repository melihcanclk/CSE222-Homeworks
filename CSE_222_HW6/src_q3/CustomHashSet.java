import java.util.HashSet;

public class CustomHashSet extends HashSet<People> {
    //I have to compare usernames of peoples because I dont want to usernames with he same name so
    // I had to implement custom hash set
    @Override
    public boolean add(People people) {
        for (People people1 : this) {
            if(people1.equals(people))
                return false;
        }
        return super.add(people);
    }
}
