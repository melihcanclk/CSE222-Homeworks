public class DetermineElfishWord {
    /**
     * Determine if given string Elfish or not
     * @param input string will be determined
     * @return if given element is elfish or not
     */
    public static boolean determineElfishWord(String input){
        return countNumbers(input, 'e') > 0 && countNumbers(input, 'l') > 0 && countNumbers(input, 'f') > 0;
    }

    /**
     * Counting how many given character are there in string
     * @param input string will be counted
     * @param character character will be searched
     * @return number count
     */
    private static int countNumbers(String input, char character){
        if (input.length() == 0)
            return 0;
        else if (input.charAt(0) == character)
            return 1 + countNumbers(input.substring(1),character);
        else
            return countNumbers(input.substring(1),character);
    }
}
