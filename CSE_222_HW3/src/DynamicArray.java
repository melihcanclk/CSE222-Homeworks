/**
 * Class for holding array dynamicly
 * @param <T> Any object for holding objects in array as generic
 */

public class DynamicArray<T> implements Cloneable{
    /**
     * Array that holds T type
     */
    private T array[];
    /**
     * holds the current size of array
     */
    private int size;
    /**
     * holds the total capacity of array
     */
    private int capacity;


    /**
     * // default constructor to initialize the array, values and class type
     */
    public DynamicArray(int capacity){
        create(capacity);
    }
    private void create(int capacity){
        array = (T[]) new Object [capacity];
        size=0;
        this.capacity=capacity;

    }

    /**
     *  to add an element at the end
     * @param element element will be add
     */
    public void addElement(T element) throws ArrayIndexOutOfBoundsException{
        try{
            array[size] = element;
            size++;
        }catch (ArrayIndexOutOfBoundsException exception){
            System.out.println(exception);
        }
    }

    public void setIndex(T element, int index){
        array[index] = element;
    }

    /**
     * to get an element at an index
     * @param index index of element that will be taken
     * @return T type
     */
    public T getElement(int index){
        return array[index];
    }

    /**
     * to remove an element at a particular index
     * @param index index of array
     */
    public void remove(int index){
        if(index>=size || index<0){
            System.out.println("No element at this index");
        }else{
            for(int i=index;i<size-1;i++){
                array[i] = array[i+1];
            }
            array[size-1]=null;
            size--;
        }
    }

    /**
     * to get the current size
     * @return size of array
     */
    public int size(){
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     *  to get the current capacity
     * @return capacity of array
     */
    public int capacity(){
        return capacity;
    }

    public void clear(){
        create(this.capacity);
    }

    public Object clone()throws CloneNotSupportedException{  
        return super.clone();  
    }    

    /**
     * method to print whole elements in array
     * @return elements
     */
    @Override
    public String toString() {
        StringBuilder x = new StringBuilder("");
        for(T temp : array){
            if(temp != null)
                x.append(temp.toString());
            x.append(" , ");
        }

        return "DynamicArray{" +
                "array=" + x +
                " size=" + size +
                ", capacity=" + capacity +
                '}' + "\n";
    }

}

