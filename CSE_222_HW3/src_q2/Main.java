import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        File file_with_iterator = new File("txtWithIterator.txt");
        File file_without_iterator = new File("txtWithoutIterator.txt");
        long startTime;
        long stopTime;

        SimpleTextEditor simpleTextEditor_with_iterator = new SimpleTextEditorArrayList(file_with_iterator);

        startTime = System.nanoTime();
        simpleTextEditor_with_iterator.read_with_iterator(file_with_iterator.getPath());
        stopTime = System.nanoTime();
        double time = (double) (stopTime - startTime);
        System.out.println("Execution time of read method with iterator is " + ((time) / 1_000_000_000) + " seconds.\n");

        SimpleTextEditor simpleTextEditor_without_iterator = new SimpleTextEditorArrayList(file_without_iterator);

        startTime = System.nanoTime();
        simpleTextEditor_without_iterator.read_without_iterator(file_without_iterator.getPath());
        stopTime = System.nanoTime();
        time = (double) (stopTime - startTime);
        System.out.println("Execution time of read method without iterator is " + ((time) / 1_000_000_000) + " seconds.\n");

        startTime = System.nanoTime();
        simpleTextEditor_with_iterator.add_with_iterator(65, " THIS STRING IS FROM ADD METHOD OF WITHOUT ITERATOR ");
        stopTime = System.nanoTime();
        time = (double) (stopTime - startTime);
        System.out.println("Execution time of add method with iterator is " + ((time) / 1_000_000_000) + " seconds.\n");

        startTime = System.nanoTime();
        simpleTextEditor_without_iterator.add_without_iterator(65, " THIS STRING IS FROM ADD METHOD OF WITHOUT ITERATOR ");
        stopTime = System.nanoTime();
        time = (double) (stopTime - startTime);
        System.out.println("Execution time of add method without iterator is " + ((time) / 1_000_000_000) + " seconds.\n");


        String value_string = "reprehenderit";
        char[] values = value_string.toCharArray();

        startTime = System.nanoTime();
        System.out.println("Starting index of character array " + Arrays.toString(values) + " is " + simpleTextEditor_with_iterator.find_with_iterator(values));
        stopTime = System.nanoTime();
        double time1 = (double) (stopTime - startTime);
        System.out.println("Execution time of find method with iterator is " + ((time1) / 1_000_000_000) + " seconds.\n");

        startTime = System.nanoTime();
        System.out.println("Starting index of character array " + Arrays.toString(values) + " is " + simpleTextEditor_without_iterator.find_without_iterator(values));
        stopTime = System.nanoTime();
        double time2 = (double) (stopTime - startTime);
        System.out.println("Execution time of find method without iterator is " + ((time2) / 1_000_000_000) + " seconds.\n");

        System.out.println("Text before replacing is \n" + simpleTextEditor_with_iterator);
        System.out.println();
        startTime = System.nanoTime();
        simpleTextEditor_with_iterator.replace_with_iterator('.', 'a');
        stopTime = System.nanoTime();
        time1 = (double) (stopTime - startTime);
        System.out.println("Execution time of replace method with iterator is " + ((time1) / 1_000_000_000) + " seconds.\n");
        System.out.println("Text after replacing is \n" + simpleTextEditor_with_iterator);
        System.out.println();

        System.out.println("Text before replacing is \n" + simpleTextEditor_without_iterator);
        System.out.println();
        startTime = System.nanoTime();
        simpleTextEditor_without_iterator.replace_without_iterator('.', 'a');
        stopTime = System.nanoTime();
        time1 = (double) (stopTime - startTime);
        System.out.println("Execution time of replace method without iterator is " + ((time1) / 1_000_000_000) + " seconds.\n");
        System.out.println("Text after replacing is \n" + simpleTextEditor_without_iterator);
        System.out.println();

    }
}
