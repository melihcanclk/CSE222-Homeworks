import java.util.Stack;

public class ExpressionRecursive {
    /**
     *
     * @param stack
     * @param input
     * @param starting_point
     * @param evaluation_mode 1 for postfix evaluation and -1 for prefix evaluation
     */
    public static void evaluation(Stack<String> stack, String input, int starting_point,int evaluation_mode){
        if(input.isEmpty()){
            return;
        }
        String string = String.valueOf(input.charAt(starting_point));
        double total = 0.0;

        if(Character.isDigit(input.charAt(starting_point))){
            if(Character.isDigit(input.charAt(starting_point+evaluation_mode))){
                string = string + input.charAt(starting_point + evaluation_mode);
                starting_point = starting_point + evaluation_mode;
            }
            stack.push(string);
        }else if(string.charAt(0) == ' '){
            evaluation(stack,input,starting_point+evaluation_mode,evaluation_mode);
            return;
        }
        else{
            String result1 = stack.pop();
            String result2 = stack.pop();
            double item1;
            double item2;
            if(evaluation_mode == 1){
                item1 = Double.parseDouble(result1);
                item2 = Double.parseDouble(result2);
            }else {
                item1 = Double.parseDouble(result2);
                item2 = Double.parseDouble(result1);
            }
            if (string.charAt(0)=='+'){
                total=item1+item2;
            }else if(string.charAt(0) == '-'){
                total=item2-item1;
            }else if(string.charAt(0) == '*'){
                total=item1*item2;
            }else if(string.charAt(0) == '/'){
                total= item2 / item1;
            }
            stack.push(String.valueOf(total));
            System.out.println(total);
        }
        if(evaluation_mode == 1){
            if(starting_point < input.length() - 1){
                evaluation(stack,input,starting_point + evaluation_mode,evaluation_mode);
            }
        }else {
            if (starting_point > 0) {
                evaluation(stack, input, starting_point + evaluation_mode, evaluation_mode);
            }
        }
    }
}
