import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src_q2/doc.txt");
        SimpleTextEditor simpleTextEditor = new SimpleTextEditorArrayList(file);
        simpleTextEditor.read_with_iterator(file.getPath());
        char[] char_arr = {'x','x','x'};
        simpleTextEditor.replace_with_iterator('o','_');
        System.out.println(simpleTextEditor);

    }
}
