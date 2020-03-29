import java.io.File;
import java.util.ArrayList;

public class SimpleTextEditorArrayList extends SimpleTextEditor{

    SimpleTextEditorArrayList(File file){
        super(file);
        list = new ArrayList<>();
    }

}
