import java.io.*;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;


class TextFileReader implements Iterable<Character> {
    private BufferedReader reader;
    File file;

    public TextFileReader(String fileName) throws IOException {
        file = new File(fileName);
        reader = new BufferedReader(new FileReader(fileName));
    }

    protected void finalize() throws Throwable {
        reader.close();
    }

    public ListIterator<Character> listIterator() {
        return new ListIterator<>() {
            private int value;
            private int index;

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

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Character previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return index+1;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void set(Character s) {
                this.value = s;

            }

            @Override
            public void add(Character s) {
                Scanner scanner = null;
                try {
                    scanner = new Scanner(file).useDelimiter("\0");
                    String line = scanner.next();
                    String newLine = line.substring(0, index) + s + line.substring(index);
                    index++;
                    FileWriter writer = new FileWriter(file);
                    writer.write(newLine);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        };
    }

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