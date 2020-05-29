public class Main{
    public static void main(String [] args){
        AVLTree<Integer> x = new AVLTree<>();    
        int []array = {20, 30, 8,47, 39, 18, 20, 92 };
        for (int i = 0; i < array.length; i++) {
            x.add(array[i]);
            System.out.println(x);
        }
        x.remove(20);
        System.out.println(x);

    }
}