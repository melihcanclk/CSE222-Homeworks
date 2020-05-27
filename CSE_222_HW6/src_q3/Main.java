import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Halit Ziya", "Çalıkuşu", new Location(5, 4, 1));
        Book book2 = new Book("İlber Ortaylı", "Bir Ömür Nasıl Yaşanır? ", new Location(5, 4, 2));
        Book book3 = new Book("Jose Mauro De Vasconcelos", "Seker Portakali", new Location(5, 4, 3));
        Book book4 = new Book("Michael Ende", "Momo ", new Location(5, 4, 4));
        Book book6 = new Book("Ray Bradbury","Fahrenheit 451",new Location(5,8,5));
        Book book7 = new Book("George Orwell","Hayvan Çiftliği ",new Location(5,8,6));
        Book book8 = new Book("Victor Hugo","Bir İdam Mahkumunun Son Günü",new Location(5,8,7));
        Book book9 = new Book("Sabahattin Ali","İcimizdeki Seytan",new Location(5,8,8));
        Book book10 = new Book("George Orwell","1984",new Location(5,8,9));
        Book book11 = new Book("Stefan Zweig","Olağanüstü Bir Gece",new Location(4,8,9));
        Book book12 = new Book("Stefan Zweig","Bilinmeyen Bir Kadının Mektubu",new Location(2,6,9));
        Book book13 = new Book("Fyodor Mihayloviç Dostoyevski","Suç ve Ceza",new Location(1,8,9));
        Book book14 = new Book("Antoine De Saint Exupery","Küçük Prens",new Location(8,8,9));

        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.map.put(book1);
        librarySystem.map.put(book2);
        librarySystem.map.put(book3);
        librarySystem.map.put(book4);
        librarySystem.map.put(book6);
        librarySystem.map.put(book7);
        librarySystem.map.put(book8);
        librarySystem.map.put(book9);
        librarySystem.map.put(book10);
        librarySystem.map.put(book11);
        librarySystem.map.put(book12);
        librarySystem.map.put(book13);
        librarySystem.map.put(book14);

        librarySystem.login();
    }
}
