import java.io.*;
import java.lang.Cloneable;
import java.util.Iterator;
import java.util.Scanner;


class TextFileReader implements Iterable<Character> {
    private class BufferedReader_Extend extends BufferedReader implements Cloneable{

        public BufferedReader_Extend(Reader in, int sz) {
            super(in, sz);
        }

        public BufferedReader_Extend(Reader in) {
            super(in);
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
    private BufferedReader_Extend reader;
    File file;

    public TextFileReader(String fileName) throws IOException {
        file = new File(fileName);
        reader = new BufferedReader_Extend(new FileReader(fileName));
    }

    protected class X implements java.util.ListIterator<Character>{

        int value;
        int index = -1;
        BufferedReader_Extend bufferedReader;

        public boolean hasNext() {
            try {
                value = bufferedReader.read();
                if (value != -1) {
                    return true;
                } else {
                    bufferedReader.close();
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

    }

    public class ListIterator extends X implements Cloneable{
        public ListIterator() {
            bufferedReader = reader;
            value = 0;
            index = -1;
        }

        @Override
        public ListIterator clone() throws CloneNotSupportedException {
            super.clone();
            ListIterator listIterator = new ListIterator();
            listIterator.value = this.value;
            listIterator.index = this.index;
            bufferedReader = (BufferedReader_Extend) reader.clone();
            return listIterator;
        }
    }
    @Override
    public Iterator<Character> iterator() {
        return new Iterator<>() {
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
        };
    }

    public ListIterator listIterator() {
        return new ListIterator();

    }
}