import java.io.File;
import java.util.LinkedList;

public class SimpleTextEditorLinkedList extends SimpleTextEditor{

    SimpleTextEditorLinkedList(File file){
        super(file);
        list = new LinkedList<>();
    }
}
