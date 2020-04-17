/**
 * Class for holding array dynamicly
 * @param <T> Any object for holding objects in array as generic
 */

public class DynamicArray<T>{
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
     * holds type of class
     */
    private Class<T> type;

    /**
     * // default constructor to initialize the array, values and class type
     * @param type Class type type
     */
    public DynamicArray(Class<T> type){
        array = (T[]) new Object [2];
        size=0;
        capacity=2;
        this.setType(type);
    }


    /**
     *  to add an element at the end
     * @param element element will be add
     */
    public void addElement(T element){
        // double the capacity if all the allocated space is utilized
        if (size == capacity){
            ensureCapacity(2);
        }
        array[size] = element;
        System.out.println(element + " added to " + element.getClass().getName());
        size++;
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

    /** method to increase the capacity, if necessary, to ensure it can hold at least the
     *  number of elements specified by minimum capacity arguement
     * @param minCapacity minimum capacity of array
     */
    public void ensureCapacity(int minCapacity){
        T temp[] = (T[])new Object[capacity*minCapacity];
        if (capacity >= 0)
            System.arraycopy(array, 0, temp, 0, capacity);
        array = temp;
        capacity = capacity * minCapacity;
    }

    /**
     * to get the current size
     * @return size of array
     */
    public int size(){
        return size;
    }

    /**
     *  to get the current capacity
     * @return capacity of array
     */
    public int capacity(){
        return capacity;
    }

    /**
     * method to print whole elements in array
     */
    public void printElements(){
        if(this.size() == 0){
            System.out.println("There's no element!!!");
        }
        System.out.println("Elements in " + getType().getName() + ":\n");
        for(int i = 0; i< size(); ++i){
            System.out.print(i+1 + "->");
            System.out.println(getElement(i));
        }
        System.out.println();
    }

    /**
     * method to print some elements in array
     * @param object object that restrict printing objects
     */
    public void printElements(Object object){
        boolean flag = false;
        int j = 1;
        for(int i = 0; i< size(); ++i){
            if( getElement(i).getClass().getTypeName().equals(object.toString())){
                System.out.print(j + "->");
                System.out.println(getElement(i));
                flag = true;
                ++j;
            }
        }
        if(!flag){
            System.out.println("No element in " + object.toString());
        }
    }

    /**
     * getting type of class
     * @return Class<T> type
     */
    public Class<T> getType() {
        return type;
    }

    /**
     * Setting Type of Class
     * @param type Class<T> type
     */
    public void setType(Class<T> type) {
        this.type = type;
    }
}

