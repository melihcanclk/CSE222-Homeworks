public class DynamicArray<T> {
    private T array[];
    // holds the current size of array
    private int size;
    // holds the total capacity of array
    private int capacity;
    private Class<T> type;
    // default constructor to initialize the array and values
    public DynamicArray(Class<T> type){
        array = (T[]) new Object [2];
        size=0;
        capacity=2;
        this.setType(type);
    }

    // to add an element at the end
    public void addElement(T element){
        // double the capacity if all the allocated space is utilized
        if (size == capacity){
            ensureCapacity(2);
        }
        array[size] = element;
        System.out.println(element + " added as " + element.getClass().getName() + "\n");
        size++;
    }

    // to get an element at an index
    public T getElement(int index){
        if(index < size())
            return array[index];
        else
            return null;
    }

    // to remove an element at a particular index
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

    /* method to increase the capacity, if necessary, to ensure it can hold at least the
     *  number of elements specified by minimum capacity arguement
     */
    public void ensureCapacity(int minCapacity){
        T temp[] = (T[])new Object[capacity*minCapacity];
        if (capacity >= 0)
            System.arraycopy(array, 0, temp, 0, capacity);
        array = temp;
        capacity = capacity * minCapacity;
    }

    // to get the current size
    public int size(){
        return size;
    }

    // to get the current capacity
    public int capacity(){
        return capacity;
    }

    // method to print whole elements in array
    public void printElements(){
        if(this.size() == 0){
            System.out.println("There's no element!!!");
        }else{
            System.out.println("Elements in " + getType().getName() + ":");
            for(int i = 0; i< size(); ++i){
                System.out.print(i+1 + "->");
                System.out.println(getElement(i));
            }
        }

        System.out.println();
    }

    // method to print elements in array
    public void printElements(Object object){
        boolean flag = false;
        int j = 1;
        for(int i = 0; i< size(); ++i){
            if( getElement(i).getClass().getTypeName().equals(object.toString())){
                System.out.print(j + "->");
                System.out.println(getElement(i));
                ++j;
                flag = true;
            }
        }
        if(!flag){
            System.out.println("No element in " + object.toString());
        }
    }

    public Class<T> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }

}

