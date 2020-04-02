import java.io.File;
import java.util.LinkedList;
/**
 * Class for create LinkedList
 */
public class SimpleTextEditorLinkedList extends SimpleTextEditor{
    /**
     * Constructor for LinkedList creator Class
     * @param file File that is going to be read
     */
    SimpleTextEditorLinkedList(File file){
        super(file);
        list = new LinkedList<>();
    }
}
