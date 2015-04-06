package LinkedList.LinkedList;
/**
 * A Node that contains a generic object and can be linked to two other Nodes. For
 * use with a linked data type implementation.
 */
public class Node<T> {
    private Node<T> previous;
    private Node<T> next;
    private T contents;

    /**
     * Creates an empty Node.
     */
    public Node(){
        previous = null;
        next = null;
        contents = null;
    }

    /**
     * Creates a Node that links to the next Node in a set or list.
     * @param next - The next Node contained in a data type
     * @param contents - An object to be represented by the Node.
     */
    public Node(Node<T> next, T contents){
        previous = null;
        this.next = next;
        this.contents = contents;
    }

    /**
     * Creates a Node that links to the next and previous Nodes in a set or list.
     * @param previous - The previous Node contained in a data type.
     * @param next - The next Node contained in a data type
     * @param contents - An object to be represented by the Node.
     */
    public Node(Node<T> previous, Node<T> next, T contents){
        this.previous = previous;
        this.next = next;
        this.contents = contents;
    }

    /**
     * Retrieves the content contained in the Node.
     * @return - the contents of the Node.
     */
    public T getContents() {
        return contents;
    }

    /**
     * Gets the previous Node in a list.
     * @return - a linked Node object.
     */
    public Node<T> getPreviousNode(){
        return previous;
    }

    /**
     * Gets the next Node in a set.
     * @return - a linked Node object.
     */
    public Node<T> getNextNode(){
        return next;
    }

    /**
     * Sets the object represented by the Node.
     * @param contents An object to store in this node.
     */
    public void setContents(T contents){
        this.contents = contents;
    }
    /**
     * Sets the next Node to link to.
     * @param next - The Node to link to.
     */
    public void setNextNode(Node<T> next){
        this.next = next;
    }
    /**
     * Sets the previous Node to link to.
     * @param previous - the Node to link to .
     */
    public void setPreviousNode(Node<T> previous){
        this.previous = previous;
    }

}
