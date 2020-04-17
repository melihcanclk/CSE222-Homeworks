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
    /**
     * Method for Reading files with iterator
     * @param pathName Pathname
     */
    public void read_with_iterator(String pathName) throws IOException {
        TextFileReader fileIteratorCharByChar = new TextFileReader(pathName);
        for (Character character : fileIteratorCharByChar) {
            list.add(character);
        }
    }

    /**
     *
     * Method for Adding a string to a specific position without iterator
     * @param position Position that will string be added
     * @param nameWillBeAdded String will be added
     * @throws IOException IO Exception
     */
    public void add_without_iterator(int position,String nameWillBeAdded) throws IOException {

        char [] charArray = convertStringToCharArray(nameWillBeAdded);
        for(int i = 0; i< nameWillBeAdded.length(); i++){
            list.add(position - 1, charArray[i]);
            position++;
        }
        writeToFile();
    }
    /**
     *
     * Method for Adding a string to a specific position with iterator
     * @param position Position that will string be added
     * @param nameWillBeAdded String will be added
     * @throws IOException IO Exception
     */
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

    /**
     * Method for finding group of characters with iterator
     * @param groupOfCharacters char array for group of characters
     * @return starting position of character array
     */
    public int find_without_iterator(char [] groupOfCharacters){
        String stringOfList = this.toString();
        String groupOfChar = String.valueOf(groupOfCharacters);
        int position = stringOfList.indexOf(groupOfChar);
        return position; //true
    }

    /**
     * Method for finding group of characters without iterator
     * @param groupOfCharacters char array for group of characters
     * @return starting position of character array
     */
    public int find_with_iterator(char [] groupOfCharacters) {
        ListIterator<Character> listIterator = list.listIterator();
        char value = ' ';
        int index = 0;
        while(listIterator.hasNext()){
            int counter = 0;
            value = listIterator.next();
            if(value == groupOfCharacters[0]){
                while(listIterator.hasNext()){
                    value =  listIterator.next();
                    if(value == groupOfCharacters[counter + 1]){
                        counter++;
                        if(counter == groupOfCharacters.length - 1){
                            return index ;
                        }
                    }else {
                        break;
                    }
                }

            }
            ++index;
            listIterator = list.listIterator(index);
        }
        return -1;

    }

    /**
     * Method for replacing all one character inside text to another character without iterator
     * @param before character that will be changed from
     * @param after character that will be changed to
     * @throws IOException input output exception
     */
    public void replace_without_iterator(char before, char after) throws IOException {
        for (int i = 0; i< list.size(); ++i){
            if(before == list.get(i))
                list.set(i,after);
        }
        writeToFile();
    }
    /**
     * Method for replacing all one character inside text to another character with iterator
     * @param before character that will be changed from
     * @param after character that will be changed to
     * @throws IOException input output exception
     */
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
    /**
     * toString method override for print list
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : list) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

    /**
     * Converting String to char array
     * @param nameWillBeAdded String that will be converted
     * @return Char array that is converted
     */
    private char [] convertStringToCharArray(String nameWillBeAdded){
        char c = nameWillBeAdded.charAt(0);  // returns 'l'
        return nameWillBeAdded.toCharArray();
    }

    /**
     * Writing to file
     * @throws IOException input output exception
     */
    public void writeToFile() throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(this.toString());
        writer.close();
    }

}
