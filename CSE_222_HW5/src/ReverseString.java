import java.util.Arrays;

public class ReverseString {
    /**
     * Reversing given string
     * @param input String will be reverse printed
     */
    public static String reverseString(String input,StringBuilder stringBuilder){
        String [] array = input.split("/");
        stringBuilder.append((array[array.length - 1])).append("/");
        array = Arrays.copyOf(array, array.length - 1);
        if(array.length == 0){
            return stringBuilder.toString();
        }
        input = String.join("/", array);
        reverseString(input,stringBuilder);
        return stringBuilder.toString();
    }
}
