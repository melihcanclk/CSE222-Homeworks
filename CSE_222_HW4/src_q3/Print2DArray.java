import java.util.Arrays;

public class Print2DArray {

    public static void initArray(int [][] array, int row, int col,int number) {
        if (row < array.length) {
            if (col < array[row].length) {
                array[row][col] = number;
                initArray(array, row, col + 1,number + 1);
            } else {
                initArray(array, row + 1, 0,number);
            }
        }
    }
    public static void printArray(int [][] array,int x,int y,int i,final int BORDERX,final int BORDERY){
        initArray(array,0,0,1);
        System.out.print(" " + array[y][x]);
        if(x == 0 && y == 0){
            printArray(array,x+1,y,i,BORDERX,BORDERY);
        }else if(x == i && y == i + 1){
            if(i + 1 >= BORDERX / 2 || i + 1 >= BORDERY / 2){
                return;
            }else{
                printArray(array,x +1,y,i + 1,BORDERX,BORDERY);
            }
        }else if(x < BORDERX - i-1 && y == i){
            printArray(array,x+1,y,i,BORDERX,BORDERY);
        }else if(x == BORDERX - i -1 && y < BORDERY - i - 1){
            printArray(array,x,y+1,i,BORDERX,BORDERY);
        }else if(x == i && y < BORDERY - i && y > i + 1){
            printArray(array,x,y- 1,i,BORDERX,BORDERY);
        }else if(x > 0 && y == BORDERY - i - 1){
            printArray(array,x-1,y,i,BORDERX,BORDERY);
        }

    }
}
