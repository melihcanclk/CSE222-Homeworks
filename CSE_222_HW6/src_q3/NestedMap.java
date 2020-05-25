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

        if(isLocated(book.getLocation()) == null){
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
    public void removeBook(Location location){
        Iterator author_iter = outerMap.keySet().iterator();
        for (Map<String, Set<Location>> value : outerMap.values()) {
            author_iter.next();
            Iterator bookTitle_iter = value.keySet().iterator();
            for (Set<Location> locations : value.values()) {
                bookTitle_iter.next();
                locations.remove(location);
                if(locations.size() == 0){
                    bookTitle_iter.remove();
                }
            }
            if(value.size() == 0){
                author_iter.remove();
            }
        }
    }

    public void getBooks(String authorName){
        StringBuilder sb = new StringBuilder();
        for (String s1 : outerMap.keySet()) {
            if(s1.equals(authorName)){
                sb.append(authorName).append("\n\t");
                Map<String,Set<Location>> set = outerMap.get(s1);
                int i = 1;
                for (String s : set.keySet()) {
                    sb.append(i).append("->").append(s).append("\n\t");
                    ++i;
                }
                System.out.println(sb.toString());
                System.out.print("Select number that you want to see the location : ");
                Scanner scanner = new Scanner(System.in);
                int numberOfTheBook = scanner.nextInt();
                while(numberOfTheBook >= i || numberOfTheBook < 0){
                    numberOfTheBook = scanner.nextInt();
                }
                i = 1;
                for (Set<Location> value : set.values()) {
                    if(i == numberOfTheBook){
                        System.out.println(value);
                        return;
                    }
                    ++i;
                }
            }
            System.out.println("There is no author named " + authorName);
        }
    }
    public void updateLocations(Location oldLocation,Location newLocation){
        boolean isdeleted = false;
        for (Map<String, Set<Location>> value : outerMap.values()) {
            for (Set<Location> locations : value.values()) {
                if(locations.remove(oldLocation)){
                    locations.add(newLocation);
                    isdeleted = true;
                }

            }
        }
        if(!isdeleted){
            System.out.println("No book at " + oldLocation);
        }

    }

    public void getTitle(String title){
        Set<String> setOfAuthors = outerMap.keySet();
        Iterator<String> iterator = setOfAuthors.iterator();
        for(Map<String,Set<Location>> temp: outerMap.values()){
            String author = iterator.next();
            for(String titles:temp.keySet()){
                if(titles.equals(title)){
                    System.out.println(author + " " + temp.get(title));
                }
            }
            return;
        }
    }
    private Iterator isLocated(Location location){
        for (Map<String, Set<Location>> value : outerMap.values()) {
            for (Set<Location> locationsSet : value.values()) {
                Iterator locations = locationsSet.iterator();
                while(locations.hasNext()){
                    if(locations.next().equals(location)){
                        System.out.println("There is book at " + location);
                        return locations;
                    }

                }
            }
        }
        return null;
    }
    @Override
    public String toString() {
        for (Map.Entry entry : outerMap.entrySet())
        {
            System.out.println("key: \n" + entry.getKey() + "\n\t value: \n\t\t" + entry.getValue());
        }
        return null;
    }
}
