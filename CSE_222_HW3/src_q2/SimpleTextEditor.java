import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

public abstract class SimpleTextEditor {
    protected List<Character> list;
    File file;

    SimpleTextEditor(File file){
        this.file = new File(file.getPath());
    }
    /**
     * Method for Reading files without iterator
     * @param pathName Pathname
     */
    public void read_without_iterator(String pathName) {

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
        for (Character character : fileIteratorCharByChar) {
            list.add(character);
        }
    }
    public void add_without_iterator(int position,String nameWillBeAdded) throws IOException {

        char [] charArray = convertStringToCharArray(nameWillBeAdded);
        for(int i = 0; i< nameWillBeAdded.length(); i++){
            list.add(position - 1, charArray[i]);
            position++;
        }
        writeToFile();
    }
    public void add_with_iterator(int position,String nameWillBeAdded) throws IOException {

        char [] charArray = convertStringToCharArray(nameWillBeAdded);
        ListIterator<Character> listIterator = list.listIterator();
        for(int i = 0; i< position - 1; i++){
            listIterator.next();
        }
        for (char c : charArray) {
            listIterator.add(c);
        }
        writeToFile();
    }
    public int find_without_iterator(char [] groupOfCharacters){
        String stringOfList = this.toString();
        String groupOfChar = String.valueOf(groupOfCharacters);
        int position = stringOfList.indexOf(groupOfChar);
        return position; //true
    }

    public int find_with_iterator(char [] groupOfCharacters) {
        ListIterator<Character> listIterator = list.listIterator();
        char value = ' ';
        int index = 0;
        while(listIterator.hasNext()){
            int counter = 0;
            value = listIterator.next();
            if(value == groupOfCharacters[0]){
                for(int i = 1; i < groupOfCharacters.length;++i){
                    if(listIterator.hasNext()){
                        value =  listIterator.next();
                        if(value == groupOfCharacters[i]){
                            counter++;
                        }else {
                            break;
                        }
                    }

                }
                if(counter == groupOfCharacters.length - 1){
                    return index ;
                }
            }
            ++index;
            listIterator = list.listIterator(index);
        }
        return -1;

    }

    public void replace_without_iterator(char before, char after) throws IOException {
        for (int i = 0; i< list.size(); ++i){
            if(before == list.get(i))
                list.set(i,after);
        }
        writeToFile();
    }
    public void replace_with_iterator(char before, char after) throws IOException {
        ListIterator<Character> listIterator = list.listIterator();
        while (listIterator.hasNext()){
            char value = listIterator.next();
            if(value == before)
                listIterator.set(after);
        }
        writeToFile();
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

    public void writeToFile() throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(this.toString());
        writer.close();
    }

}
