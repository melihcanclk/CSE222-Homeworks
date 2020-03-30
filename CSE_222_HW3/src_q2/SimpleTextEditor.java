import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class SimpleTextEditor {
    protected List<Character> list;
    File file;

    SimpleTextEditor(File file){
        this.file = new File(file.getPath());
    }
    /**
     * Method for Reading files
     * @param pathName Pathname
     * @throws IOException input output exception
     */
    public void read_without_iterator(String pathName) throws IOException {

        try (FileReader fr = new FileReader(pathName)) {
            int content;
            while ((content = fr.read()) != -1) {
                list.add((char)content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void read_with_iterator(String pathName) throws IOException {
        TextFileReader fileIteratorCharByChar = new TextFileReader(pathName);
        TextFileReader.ListIterator listIterator = fileIteratorCharByChar.listIterator();
        while (listIterator.hasNext()){
            list.add(listIterator.next());
        }
    }
    public void add_without_iterator(int position,String nameWillBeAdded) throws IOException {

        char [] charArray = convertStringToCharArray(nameWillBeAdded);
        for(int i = 0; i< nameWillBeAdded.length(); i++){
            list.add(position - 1, charArray[i]);
            position++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : list) {
            stringBuilder.append(character);
        }
        writeToFile(stringBuilder.toString());

    }
    public void add_with_iterator(int position,String nameWillBeAdded) throws IOException {

        char [] charArray = convertStringToCharArray(nameWillBeAdded);
        TextFileReader textFileReader = new TextFileReader(file.getPath());
        ListIterator<Character> iterator = textFileReader.listIterator();
        for(int i = 0; i< position; i++){
            iterator.next();
        }
        for (char c : charArray) {
            iterator.add(c);
        }
        scanFile(file.getPath());
    }
    public int find_without_iterator(char [] groupOfCharacters){
        String stringOfList = this.toString();
        String groupOfChar = String.valueOf(groupOfCharacters);
        int position = stringOfList.indexOf(groupOfChar);
        return position; //true
    }

    public int find_with_iterator(char [] groupOfCharacters) throws IOException, CloneNotSupportedException {
        String groupOfChar = String.valueOf(groupOfCharacters);
        TextFileReader textFileReader = new TextFileReader(file.getPath());
        ListIterator<Character> iterator = textFileReader.listIterator();
        char value;
        while(iterator.hasNext()){
            int counter = 0;
            value = iterator.next();
            ListIterator<Character> temp =  ((TextFileReader.ListIterator) iterator).clone();
            if(value == groupOfChar.charAt(0)){
                for(int i = 1; i < groupOfChar.length() ;++i){
                    if(iterator.hasNext()){
                        value =  iterator.next();
                        if(value == groupOfChar.charAt(i)){
                            counter++;
                        }else {
                            break;
                        }
                    }

                }
                if(counter == groupOfChar.length() - 1){
                    return ((TextFileReader.ListIterator) iterator).index - (groupOfChar.length() - 1) ;
                }
            }
            iterator = temp;
        }
        return -1;
    }

    public void replace_without_iterator(char before, char after) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i< list.size(); ++i){
            if(before == list.get(i))
                list.set(i,after);
            stringBuilder.append(list.get(i));
        }
        writeToFile(stringBuilder.toString());
    }
    public void replace_with_iterator(char before, char after) throws IOException {
        TextFileReader textFileReader = new TextFileReader(file.getPath());
        ListIterator<Character> iterator = textFileReader.listIterator();
        StringBuilder stringBuilder = new StringBuilder();
        while(iterator.hasNext()){
            ListIterator<Character> temp = iterator;
            char value = iterator.next();
            if(before == value){
                iterator.set(after);
            }
            stringBuilder.append(temp.next());
        }
        writeToFile(stringBuilder.toString());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : list) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
    private char [] convertStringToCharArray(String nameWillBeAdded){
        char c = nameWillBeAdded.charAt(0);  // returns 'l'
        return nameWillBeAdded.toCharArray();
    }

    private void scanFile(String pathName){
        list.clear();
        try (FileReader fr = new FileReader(pathName)) {
            int content;
            while ((content = fr.read()) != -1) {
                list.add((char)content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void writeToFile(String newLine) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(newLine);
        writer.close();
    }


}
