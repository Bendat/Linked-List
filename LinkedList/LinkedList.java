package LinkedList.LinkedList;
import java.util.Iterator;

/**
 * A double Linked List data type.
 * @author Ben Aherne.
 */
@SuppressWarnings("unchecked")
public class LinkedList<T> implements Iterable {
    private int count;
    private Node<T> head;
    private Node<T> tail;

    /**
     * Create an empty List.
     */
    public LinkedList() {
        head = new Node<>(null, tail, null);
        tail = new Node<>(head, null, null);
        count = 0;
    }

    /**
     * Add an object to the list. Does nothing if the list already contains that object.
     *
     * @param content - the object to be added
     */
    public void add(T content) {
        if (contains(content)) {
            return;
        }
        Node<T> cursor = tail.getPreviousNode();
        Node<T> tempElement = new Node<>(cursor, cursor.getNextNode(), content);
        tail.setPreviousNode(tempElement);
        cursor.setNextNode(tempElement);
        count++;
    }
    /**
     * Adds a linked list object to the current object, ignores
     * duplicate entries.
     * @param objectList - the elements to be added
     */
    public void addAll(LinkedList<T> objectList) {
        for(T item : (Iterable<T>) objectList) {
            this.add(item);
        }
    }
    /**
     * Remove the provided object from this set if it exists.
     * @param item -- the element to be removed.
     */
    public void remove(T item) {
        Node<T> cursor = head.getNextNode();
        Node<T> tempHead;
        Node<T> tempTail;
        while(cursor != null) {
            if (cursor.getContents().equals(item)) {
                tempHead = cursor.getPreviousNode();
                tempTail = cursor.getNextNode();
                if (tempTail != null) {
                    tempTail.setPreviousNode(tempHead);
                }
                if (tempHead != null) {
                    tempHead.setNextNode(tempTail);
                }
                count--;
                break;
            }
            cursor = cursor.getNextNode();
        }
    }
    /**
     * Remove the object at the provided position from this set if it exists.
     * @param position -- the position of the element to be removed.
     */
    public void remove(int position) {
        Node<T> cursor = head.getNextNode();
        int currentPosition = 0;
        Node<T> tempHead;
        Node<T> tempTail;
        while(cursor != null) {
            if (currentPosition == position) {
                tempHead = cursor.getPreviousNode();
                tempTail = cursor.getNextNode();
                if (tempTail != null) {
                    tempTail.setPreviousNode(tempHead);
                }
                if (tempHead != null) {
                    tempHead.setNextNode(tempTail);
                }
                count--;
                break;
            }
            currentPosition++;
            cursor = cursor.getNextNode();
        }
    }
    /**
     * Remove from this set all of its elements that are
     * contained in the specified set. This operation
     * effectively modifies this set so that its value is
     * the asymmetric set difference of the two sets.
     *
     * @param remSet-- the elements to be removed
     */
    public void removeAll(LinkedList<T> remSet) {
        Iterator<T> abi;
        Node<T> cursor = head.getNextNode();
        while (cursor != null) {
            abi = remSet.iterator();
            while (abi.hasNext()) {
                if (cursor.getContents().equals(abi.next())) {
                    remove(cursor.getContents());
                }
            }
            cursor = cursor.getNextNode();
        }
    }

    /**
     * Removes all objects that don' exist in the current list object and the provided list.
     * @param retentionList-- the elemnets to be retained
     */
    public void retainAll(LinkedList<T> retentionList) {
        Iterator<T> abi= retentionList.iterator();;
        Node<T> cursor = head.getNextNode();
        while (cursor != null) {
            boolean isShared = false;
            while (abi.hasNext()) {
                if (cursor.getContents().equals(abi.next())) {
                    isShared = true;
                }
            }
            if (!isShared) {
                remove(cursor.getContents());
            }
            abi = retentionList.iterator();
            cursor = cursor.getNextNode();
        }
    }
    /**
     * Return true if this List contains the provided Object
     * @param item -the object to check
     * @return boolean membership indication
     */
    public boolean contains(T item) {
        Node<T> cursor = head.getNextNode();
        while (cursor != null) {
            if (cursor.getContents().equals(item)) {
                return true;
            }
            cursor = cursor.getNextNode();
        }
        return false;
    }
    /**
     * Determines if the provided list is a subset of the current LinkedList object.
     * @param checkSet-- the candidate subset
     * @return boolean subset indication
     */
    public boolean containsAll(LinkedList checkSet) {
        for (T aCheckSet : (Iterable<T>) checkSet) {
            if (!contains(aCheckSet)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Return the number of items in this list.
     * @return size of set
     */
    public int size() {
        return count;
    }
    /**
     * Describes whether or not a List object is empty.
     * @return true if empty, false if Object contains any Nodes.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Return an iterable representation of this list.
     * @return the elements of this set
     */
     public Iterator<T> iterator() {
        ListIterator<T> iter = new ListIterator<T>();
        Node<T> cursor = head.getNextNode();
        while (cursor != null) {
            T elem = cursor.getContents();
            iter.add(elem);
            cursor = cursor.getNextNode();
        }
        return iter;
    }
}
