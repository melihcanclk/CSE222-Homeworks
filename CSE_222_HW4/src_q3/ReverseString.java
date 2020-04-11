public class ReverseString {
    public static void reverseString(String input){
        String [] array = input.split(" ");
        int length = array[array.length - 1].length();
        System.out.println((array[array.length - 1]));
        if(length == input.length())
            return;
        input = input.substring(0,input.length() - length - 1);
        reverseString(input);
    }
}
