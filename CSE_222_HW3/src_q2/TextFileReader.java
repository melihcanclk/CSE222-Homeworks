import java.io.*;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Class for reading text file that implements iterable interface
 */
public class TextFileReader implements Iterable<Character> {
    /**
     * BufferedReader reader for read text
     */
    private BufferedReader reader;
    /**
     * File file that will be read
     */
    File file;

    /**
     * Constructor for create reader
     * @param fileName Filename that will be read
     * @throws IOException Input output exception
     */
    public TextFileReader(String fileName) throws IOException {
        file = new File(fileName);
        reader = new BufferedReader(new FileReader(fileName));
    }

    protected void finalize() throws Throwable {
        reader.close();
    }
    /**
     * iterator method for create iterator
     */
    @Override
    public Iterator<Character> iterator() {
        return new Iterator<Character>() {
            private int value;
            private int index = 0;
            public boolean hasNext() {

                try {
                    value = reader.read();
                    if (value != -1) {
                        return true;
                    } else {
                        reader.close();
                        return false;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public Character next() {
                ++index;
                return (char) value;
            }
        };
    }
}