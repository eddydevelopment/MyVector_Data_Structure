public class MyVector<E> extends MyAbstractList<E>{
@SuppressWarnings("unchecked")
    E[] array;
    int incrementSize;
    public MyVector() {
        array = (E[]) new Object[10]; 
        incrementSize = 5;
        size = 0;
    }
    public MyVector(int capacity){
        array = (E[]) new Object[capacity]; 
        incrementSize = 5; 
        size = 0;
    }
    public MyVector(int capacity, int increment){
        array = (E[]) new Object[capacity]; 
        incrementSize = increment;
        size = 0;
    }
    private void doubleArray(){
        int newCapacity = array.length*incrementSize;
        E[] bigBoy = (E[]) new Object[newCapacity];
        for(int i = 0; i < array.length; i++){
            bigBoy[i] = array[i];
        }
        array = bigBoy;
    }
    public boolean add(E data){
        if(size >= array.length){
            doubleArray();
        }
        array[size] = data;
        size++;
        return true;
    }   
        
    /**
	 * Appends the specified element to the end of this list,
	 * The list capacity should be resized based on a capacity
	 * increment variable once the current capacity is filled (capacity == size).
	 * @param data
	 * @return boolean
	 */
    
    public boolean add(int index, E data) throws IndexOutOfBoundsException{
        if(size >= array.length){
            doubleArray();
        }

        for(int i = index; i < size; i++){
            array[i + 1] = array[i];
        }
        
        array[index] = data;
        size++;
        return true;
    }
    /**
	 * Inserts the specified element at the specified position in this list.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements by adding one to their indices.
	 * The list capacity should be resized based on a capacity
	 * increment variable once the current capacity is filled (capacity == size).
	 * @param index - index at which the specified element is to be inserted
	 * @param data - element to be inserted
	 * @return boolean
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
	 */
    
    public void clear(){
       for (int i = 0; i < size; i++){
          array[i] = null;
       }
       size = 0;
    }
    /**
	 * Removes all of the elements from this list
	 */
    
    public E get(int index){
        return array[index];
    }
    /**
	 * Returns the element at the specified position in this list
	 * @param index
	 * @return E
	 */
    
    public boolean isEmpty(){
        return size == 0;
    }    
   /**
	 * Returns true if this list contains no elements
	 * @return boolean
	 */
    
    public E remove(int index) throws IndexOutOfBoundsException{
        E lol = array[index];
        for(int i = index + 1; i < size; i++){
            array[i - 1] = array[i];
        }
        
  
        size--;
        return lol;
        
    }
	/**
	 * Removes the  element at the specified position in this list.
	 * Shifts any subsequent elements by subtracting one from their indices.
	 * @param index - index of the element to be removed
	 * @return E - the element that was removed from the list
	 * IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
	 */
    
    public void trimToSize(){
        E[] tinyBoy = (E[]) new Object[size];
        for(int i = 0; i < size; i++){
            tinyBoy[i] = array[i];
        }
        array = tinyBoy;
    }
         
    /**
	 * Trims the capacity of this MyVector instance to be the list's current size. An application 
         * can use this operation to minimize the storage of a MyVector instance.
	 */
    
    public int size(){
         return size;
    }     
    /**
	 * Returns the number of elements in this list
	 * @return int
	 */
    public int getCapacity(){
         return array.length;
    }    //which returns the capacity (not the size) of the internal array structure
    public int getIncrement(){
        return incrementSize;
    }    //which returns the capacity increment of the vector
    public String toString(){
         String lolazo = "[";
         for (int i = 0; i < size; i++){
              if( i != size - 1)
                 lolazo += array[i] + "," + " ";
              else
                 lolazo +=array[i] + "]";
         }
         return lolazo;
    }
}