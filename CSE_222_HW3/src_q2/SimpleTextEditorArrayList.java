import java.io.File;
import java.util.ArrayList;

/**
 * Class for create Arraylist
 */
public class SimpleTextEditorArrayList extends SimpleTextEditor{
    /**
     * Constructor for ArrayList creator Class
     * @param file File that is going to be read
     */
    SimpleTextEditorArrayList(File file){
        super(file);
        list = new ArrayList<>();
    }

}
