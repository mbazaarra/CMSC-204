/*
 * Montana Bazarrgchaa
 * 
 * CMSC 204
 * 
 */

import java.util.Comparator;
import java.lang.UnsupportedOperationException;
import java.util.ListIterator;


public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	
	private Comparator<T> comparator;
	
    public SortedDoubleLinkedList(Comparator<T> comparator) {
        this.comparator = comparator;
    }
    
 
    public void add(T data) {
        Node temp = new Node(data);

        if (head == null) {
            head = tail = temp;
        } else if (comparator.compare(data, head.data) <= 0) {
            temp.next = head;
            head.prev = temp;
            head = temp;
        } else if (comparator.compare(data, tail.data) >= 0) {
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
        } else {
            Node current = head;

            while (current.next != null && comparator.compare(data, current.next.data) > 0) {
                current = current.next;
            }

            temp.next = current.next;
            temp.prev = current;
            current.next.prev = temp;
            current.next = temp;
        }

        size++;
    }
   
    @Override
    
    public void addToEnd(T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
    
    @Override
    public void addToFront(T data) throws UnsupportedOperationException  {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
    
    @Override
    public ListIterator<T> iterator(){
    	return super.iterator();
    }
    
    public Node remove​(T data, Comparator<T> comparator) {
    	
    	return super.remove(data, comparator);
    	
    }
    
    
	
}
