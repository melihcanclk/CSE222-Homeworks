import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static FileHandler fileHandler;
    private static Logger logger =
            Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws IOException, CloneNotSupportedException {

        fileHandler = new
                FileHandler(Main.class.getName() + ".log");
        logger.setLevel(Level.ALL);
        logger.addHandler(fileHandler);
        logger.info("Log message redirected to a file");
        logger.info("The name of the logger is " +
                logger.getName() +
                " \nwhich is same as class name: "
                + Main.class.getName());

        File file_with_iterator = new File("txtWithIterator.txt");
        File file_without_iterator = new File("txtWithoutIterator.txt");
        long startTime;
        long stopTime;

        SimpleTextEditor simpleTextEditor_with_iterator = new SimpleTextEditorArrayList(file_with_iterator);

        startTime = System.nanoTime();
        simpleTextEditor_with_iterator.read_with_iterator(file_with_iterator.getPath());
        stopTime = System.nanoTime();
        double time = (double)(stopTime - startTime);
        logger.info("Execution time of read method with iterator is " + ((time) / 1_000_000_000) + " seconds.\n");

        SimpleTextEditor simpleTextEditor_without_iterator = new SimpleTextEditorLinkedList(file_without_iterator);

        startTime = System.nanoTime();
        simpleTextEditor_without_iterator.read_without_iterator(file_without_iterator.getPath());
        stopTime = System.nanoTime();
        time = (double)(stopTime - startTime);
        logger.info("Execution time of read method without iterator is " + ((time) / 1_000_000_000) + " seconds.\n");

        startTime = System.nanoTime();
        simpleTextEditor_with_iterator.add_with_iterator(65, " THIS STRING IS FROM ADD METHOD OF WITHOUT ITERATOR ");
        stopTime = System.nanoTime();
        time = (double) (stopTime - startTime);
        logger.info("Execution time of add method with iterator is " + ((time) / 1_000_000_000) + " seconds.\n");

        startTime = System.nanoTime();
        simpleTextEditor_without_iterator.add_without_iterator(65, " THIS STRING IS FROM ADD METHOD OF WITHOUT ITERATOR ");
        stopTime = System.nanoTime();
        time = (double) (stopTime - startTime);
        logger.info("Execution time of add method without iterator is " + ((time) / 1_000_000_000) + " seconds.\n");


        String value_string = "reprehenderit";
        char[] values = value_string.toCharArray();

        logger.info(value_string + " is the string for find method.");

        startTime = System.nanoTime();
        logger.info("Starting index of character array " + Arrays.toString(values) + " is " + simpleTextEditor_with_iterator.find_with_iterator(values));
        stopTime = System.nanoTime();
        time = (double) (stopTime - startTime);
        logger.info("Execution time of find method with iterator is " + ((time) / 1_000_000_000) + " seconds.\n");

        startTime = System.nanoTime();
        logger.info("Starting index of character array " + Arrays.toString(values) + " is " + simpleTextEditor_without_iterator.find_without_iterator(values));
        stopTime = System.nanoTime();
        time = (double) (stopTime - startTime);
        logger.info("Execution time of find method without iterator is " + ((time) / 1_000_000_000) + " seconds.\n");

        logger.info("Text before replacing is \n" + simpleTextEditor_with_iterator);
        startTime = System.nanoTime();
        simpleTextEditor_with_iterator.replace_with_iterator('.', 'a');
        stopTime = System.nanoTime();
        time = (double) (stopTime - startTime);
        logger.info("Execution time of replace method with iterator is " + ((time) / 1_000_000_000) + " seconds.\n");
        logger.info("Text after replacing is \n" + simpleTextEditor_with_iterator);

        logger.info("Text before replacing is \n" + simpleTextEditor_without_iterator);
        startTime = System.nanoTime();
        simpleTextEditor_without_iterator.replace_without_iterator('.', 'a');
        stopTime = System.nanoTime();
        time = (double) (stopTime - startTime);
        logger.info("Execution time of replace method without iterator is " + ((time) / 1_000_000_000) + " seconds.\n");
        logger.info("Text after replacing is \n" + simpleTextEditor_without_iterator);
    }
}
