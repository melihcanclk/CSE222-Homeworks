import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Halit Ziya", "Çalıkuşu", new Location(5, 4, 1));
        Book book2 = new Book("Halit Ziya", "Çalıkuşu", new Location(5, 4, 2));
        Book book3 = new Book("Halit Ziya", "Mai ve Siyah", new Location(5, 4, 3));
        Book book4 = new Book("Halit Ziya", "Kapıcılar Kralı", new Location(5, 4, 4));
        Book book5 = new Book("Hasan Ali Kaldırım","Nasıl Kaldırdım?",new Location(5,8,9));
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.map.put(book1);
        librarySystem.map.put(book2);
        librarySystem.map.put(book3);
        librarySystem.map.put(book4);
        librarySystem.map.put(book5);

        librarySystem.login();
    }
}
