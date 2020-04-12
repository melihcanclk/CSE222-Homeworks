public class DetermineElfishWord {
    public static boolean determineElfishWord(String input){
        return countNumbers(input, 'e') > 0 && countNumbers(input, 'l') > 0 && countNumbers(input, 'f') > 0;
    }
    private static int countNumbers(String input, char character){
        if (input.length() == 0)
            return 0;
        else if (input.charAt(0) == character)
            return 1 + countNumbers(input.substring(1),character);
        else
            return countNumbers(input.substring(1),character);
    }
}
