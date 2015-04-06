package LinkedList.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Used to create an iterable representation of a linked list.
 * @author Ben Aherne
 */
@SuppressWarnings("unchecked")
public class ListIterator<T> implements Iterator<T> {
    private int capacity = 100;
    private T[] contents;
    private int size;
    private int nextItemPosition;

    /**
     * Creates a new ListIterator object.
     */
    public ListIterator() {
        contents = (T[]) (new Object[capacity]);
        size = 0;
        nextItemPosition = 0;
    }

    /**
     * Determines whether the iterator has another element.
     * @return boolean - true if another element exists, otherwise false.
     */
    @Override
    public boolean hasNext() {
        return nextItemPosition < size;
    }

    /**
     * Returns the next object in the iterator and moves the cursor forward.
     * @return the next object in the iterator.
     */
    @Override
    public T next() {
        T item = contents[nextItemPosition];
        nextItemPosition++;
        return item;
    }

    /**
     * Adds an object to the iterator.
     * @param item the object to add.
     */
    public void add(T item) {
        if(size == capacity){
            expand();
        }
        contents[size] = item;
        size++;
    }

    /**
     * Removes the object at the cursors current position from the iterator.
     */
    @Override
    public void remove() {
        ArrayList<T> temp = new ArrayList<>(Arrays.asList(contents));
        temp.remove(contents[nextItemPosition]);
        contents = temp.toArray(contents);
    }

    private void expand() {
        T[] temp = (T[]) new Object[capacity * 2];
        System.arraycopy(contents, 0, temp, 0, capacity);
        contents = temp;
        capacity = capacity * 2;
    }
}
