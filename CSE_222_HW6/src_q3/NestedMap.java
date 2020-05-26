import java.util.*;

public class NestedMap {
    private Map<String, Map<String , Set<Location>>> outerMap;
    NestedMap(){
        outerMap = new HashMap<>();
    }
    NestedMap(Book book){
        this();
        outerMap.put(book.getNameOfAuthor(),constructMapFromBook(book));
    }
    //Constructs inner class
    private Map<String,Set<Location>> constructMapFromBook(Book book){

        Set<Location> setOfLocation = new HashSet<>();
        setOfLocation.add(book.getLocation());

        Map<String,Set<Location>> innerMap = new HashMap<>();
        innerMap.put(book.getTitle(),setOfLocation);

        return innerMap;
    }
    public void put(Book book){

        if(!isLocated(book.getLocation())){
            Map<String,Set<Location>> titles = outerMap.get(book.getNameOfAuthor());
            //If there is author with same name
            if(titles != null){
                Set<Location> locations = titles.get(book.getTitle());
                //If there is title with same name
                if(locations != null){
                    boolean isContains = locations.contains(book.getLocation());{
                        //It there is no book at the same location
                        if(!isContains){
                            outerMap.get(book.getNameOfAuthor()).get(book.getTitle()).add(book.getLocation());

                        }
                        return;
                    }
                }
                Set<Location> setOfLocation = new HashSet<>();
                setOfLocation.add(book.getLocation());

                outerMap.get(book.getNameOfAuthor()).put(book.getTitle(),setOfLocation);
                return;
            }
            Set<Location> setOfLocation = new HashSet<>();
            setOfLocation.add(book.getLocation());

            Map<String,Set<Location>> innermap = new HashMap<>();
            innermap.put(book.getTitle(),setOfLocation);

            outerMap.put(book.getNameOfAuthor(),innermap);
        }

    }
    public void removeBook(Book book){
        outerMap.remove(book.getNameOfAuthor());
    }
    public void removeAuthor(String nameOfAuthor){
        outerMap.remove(nameOfAuthor);
    }
    public Map<String,Set<Location>> getBooks(String authorName){
        return outerMap.get(authorName);
    }
    public void updateLocations(Book book,Location newLocation){
        if(!isLocated(newLocation)){
            outerMap.get(book.getNameOfAuthor()).get(book.getTitle()).remove(book.getLocation());
            outerMap.get(book.getNameOfAuthor()).get(book.getTitle()).add(newLocation);
        }
    }

    public void getTitle(String title){
        Set<String> setOfAuthors = outerMap.keySet();
        Iterator<String> iterator = setOfAuthors.iterator();
        for(Map<String,Set<Location>> temp: outerMap.values()){
            String author = iterator.next();
            for(String titles:temp.keySet()){
                if(titles.equals(title)){
                    System.out.println(author + " " + temp.values());
                }
            }
        }
    }
    private boolean isLocated(Location location){
        for (Map<String, Set<Location>> value : outerMap.values()) {
            for (Set<Location> locationsSet : value.values()) {
                for (Location locations : locationsSet) {
                    if(locations.equals(location)){
                        System.out.println("There is book at " + location);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return outerMap.toString();
    }
}
