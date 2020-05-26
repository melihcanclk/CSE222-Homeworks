import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        /*
        Book book1 = new Book("Halit Ziya", "Çalıkuşu", new Location(5, 4, 1));
        Book book2 = new Book("Halit Ziya", "Çalıkuşu", new Location(5, 4, 3));
        Book book3 = new Book("Halit Ziya", "Mai ve siyah", new Location(5, 4, 1));
        Book book4 = new Book("Halit Ziya", "Kapıcılar Kralı", new Location(5, 4, 2));
        Book book5 = new Book("Hasan Ali Topaloğlu", "Kapıcılar Kralı", new Location(5, 4, 2));
        NestedMap nestedMap = new NestedMap(book1);
        nestedMap.put(book2);
        nestedMap.put(book3);
        nestedMap.put(book4);
        nestedMap.put(book5);
        System.out.println(nestedMap);

        System.out.println(nestedMap.getBooks("Halit Ziya"));

        nestedMap.updateLocations(book1,new Location(5, 4,3));
        nestedMap.updateLocations(book1,new Location(5, 4,9));
        System.out.println(nestedMap);
        */
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.login();
    }
}
