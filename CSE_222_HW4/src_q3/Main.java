public class Main{
    final static int BORDERX = 4;
    final static int BORDERY = 5;
    public static void main(String[] args) {
       /* ReverseString.reverseString("his function writes the sentence in reverse");
        System.out.println( DetermineElfishWord.determineElfishWord("waffles"));
        int [] input = {4,5,62,4,6,78,2,121,43};
        RecursiveSelectionSort.recurSelectionSort(input,input.length,0);
        System.out.println(Arrays.toString(input));
        Stack<String> stack = new Stack<>();
        ExpressionRecursive.evaluation(stack,"1 2 3 4 * - 5 / 6 + + 7 8 / -",0,1);
        stack = new Stack<>();
        String string = "-+ + 1 / - 2 * 3 4 5 6 / 7 8";
        ExpressionRecursive.evaluation(stack,string, string.length() - 1,-1);*/

        int [][] array = new int[BORDERY][BORDERX];
        Print2DArray.printArray(array,0,0,0,BORDERX,BORDERY);



    }



}