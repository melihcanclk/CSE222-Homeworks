import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static FileHandler fileHandler;
    private static Logger logger =
            Logger.getLogger(Main.class.getName());

    final static String arraylist = "ARRAYLIST";
    final static String linkedlist = "LINKEDLIST";
    public static String value = "";
    static long startTime;
    static long stopTime;
    static double time;

    static SimpleTextEditor simpleTextEditor_with_iterator = null;
    static SimpleTextEditor simpleTextEditor_without_iterator = null;

    static File file_with_iterator = null;
    static File file_without_iterator = null;

    public static void main(String[] args) throws IOException {

        main_menu();
        test1();
        //test2();
        //test3();
        //test4();
    }
    public static void main_menu() throws IOException {

        Scanner scanner = new Scanner(System.in);

        int result;
        int number_of_test = 370;

        System.out.println("1-> 370 Characters");
        System.out.println("2-> 10.000 Characters");
        System.out.println("3-> 100.000 Characters");

        result = scanner.nextInt();
        if(result == 1){
            number_of_test = 370;
        }else if(result == 2){
            number_of_test = 10000;
        }else if(result == 3){
            number_of_test = 100000;
        }
        file_with_iterator = new File("txtWithIterator_" + number_of_test +".txt");
        file_without_iterator = new File("txtWithoutIterator_" + number_of_test +".txt");

        System.out.println("1-> Arraylist implementation test");
        System.out.println("2-> LinkedList implementation test");

        result = scanner.nextInt();

        if(result == 1){
            value = arraylist;
            simpleTextEditor_with_iterator = new SimpleTextEditorArrayList(file_with_iterator);
            simpleTextEditor_without_iterator = new SimpleTextEditorArrayList(file_without_iterator);
        }else if(result == 2){
            value = linkedlist;
            simpleTextEditor_with_iterator = new SimpleTextEditorLinkedList(file_with_iterator);
            simpleTextEditor_without_iterator = new SimpleTextEditorLinkedList(file_without_iterator);
        }
        fileHandler = new
                FileHandler(Main.class.getName() +"_"+  number_of_test +".log");
        logger.setLevel(Level.ALL);
        logger.addHandler(fileHandler);
        logger.info("Log message redirected to a file");
        logger.info("The name of the logger is " +
                logger.getName() +
                " \nwhich is same as class name: "
                + Main.class.getName());
        logger.info(value + " IMPLEMENTATION TEST STARTING \n");
    }

    /**
     * for testing read methods
     * @throws IOException exception for check input output
     */
    public static void test1() throws IOException {

        startTime = System.nanoTime();
        assert simpleTextEditor_with_iterator != null;
        simpleTextEditor_with_iterator.read_with_iterator(file_with_iterator.getPath());
        stopTime = System.nanoTime();
        time = (double)(stopTime - startTime);
        logger.info("Execution time of read method with iterator is " + ((time) / 1_000_000_000) + " seconds.\n");
        logger.info("Text is \n" + simpleTextEditor_with_iterator);


        startTime = System.nanoTime();
        simpleTextEditor_without_iterator.read_without_iterator(file_without_iterator.getPath());
        stopTime = System.nanoTime();
        time = (double)(stopTime - startTime);
        logger.info("Execution time of read method without iterator is " + ((time) / 1_000_000_000) + " seconds.\n");
        logger.info("Text is \n" + simpleTextEditor_without_iterator);
    }

    /**
     * for testing add methods
     * @throws IOException for check input output
     */
    public static void test2() throws IOException {

        test1();

        logger.info("Text before replacing is \n" + simpleTextEditor_with_iterator);
        startTime = System.nanoTime();
        simpleTextEditor_with_iterator.add_with_iterator(80, " THIS STRING IS FROM ADD METHOD OF WIT ITERATOR BY USING " + value);
        stopTime = System.nanoTime();
        time = (double) (stopTime - startTime);
        logger.info("Execution time of add method with iterator is " + ((time) / 1_000_000_000) + " seconds.\n");
        logger.info("Text after replacing is \n" + simpleTextEditor_with_iterator);

        logger.info("Text before replacing is \n" + simpleTextEditor_without_iterator);
        startTime = System.nanoTime();
        simpleTextEditor_without_iterator.add_without_iterator(80, " THIS STRING IS FROM ADD METHOD OF NOT ITERATOR BY USING " + value);
        stopTime = System.nanoTime();
        time = (double) (stopTime - startTime);
        logger.info("Execution time of add method without iterator is " + ((time) / 1_000_000_000) + " seconds.\n");
        logger.info("Text after replacing is \n" + simpleTextEditor_without_iterator);

    }

    /**
     * for testing find methods
     * @throws IOException for check input output
     */
    public static void test3() throws IOException {

        test1();

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
    }

    /**
     * for testing replace methods
     * @throws IOException for check input output
     */
    public static void test4() throws IOException {

        test1();

        logger.info("Text before replacing is \n" + simpleTextEditor_with_iterator);
        startTime = System.nanoTime();
        simpleTextEditor_with_iterator.replace_with_iterator('a', '_');
        stopTime = System.nanoTime();
        time = (double) (stopTime - startTime);
        logger.info("Execution time of replace method with iterator is " + ((time) / 1_000_000_000) + " seconds.\n");
        logger.info("Text after replacing is \n" + simpleTextEditor_with_iterator);

        logger.info("Text before replacing is \n" + simpleTextEditor_without_iterator);
        startTime = System.nanoTime();
        simpleTextEditor_without_iterator.replace_without_iterator('a', '_');
        stopTime = System.nanoTime();
        time = (double) (stopTime - startTime);
        logger.info("Execution time of replace method without iterator is " + ((time) / 1_000_000_000) + " seconds.\n");
        logger.info("Text after replacing is \n" + simpleTextEditor_without_iterator);
    }
}
