import java.util.Arrays;

public class ReverseString {
    public static void reverseString(String input){
        String [] array = input.split(" ");
        int length = array[array.length - 1].length();
        System.out.println((array[array.length - 1]));
        if(length == input.length())
            return;
        array = Arrays.copyOf(array, array.length - 1);
        input = String.join(" ", array);
        reverseString(input);
    }
}
