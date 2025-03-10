/*
 * Montana Bazarrgchaa
 * 
 * CMSC 204
 * 
 */

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Comparator;


public class BasicDoubleLinkedList<T> implements Iterable<T> {
	
	
    @Override
    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }
    
    
	protected class Node{
		protected T data;
		protected Node prev;
		protected Node next;
		
		public Node(T data){
			this.data = data;
			
		}
	}
	
	protected Node head;
	protected Node tail;
	protected int size;
    
    public BasicDoubleLinkedList() {
    	
    	head = null;
    	tail = null;
    	size = 0;
    }
    
    public int getSize() {
    	return size;
    }
    
    public T getFirst() {
    	if(head == null) return null;
    	
    	return head.data;
    	
    }

    public T getLast() {
    	if(tail == null) return null;
    	
    	return tail.data;
    	
    }
    
    public void addToEnd(T data){
    	Node temp = new Node(data);
    	
    	if(size == 0) {
    		head = temp;
    		tail = temp;
    		
    	}else {
    		tail.next = temp;
    		temp.prev = tail;
    		tail = temp;
    	}
    	size++;
    }
    
    public void addToFront(T data) {
    	Node temp = new Node(data);
    	
    	if(size == 0) {
    		head = temp;
    		tail = temp;
    	}else {
    		temp.next = head;
    		head.prev = temp;
    		head = temp;
    	}
    	size++;
    }
    

    public Node remove(T targetData, Comparator<T> comparator) {
   		
    	Node current = head;
    	
    	if(head == null) {
    		return null;
    	}
    	
    	
        while (current != null && comparator.compare(targetData, current.data) != 0) {
            current = current.next;
        }

        // If not found, return null
        if (current == null) {
            return null;
        }

        // Remove the node
        if (current == head) { // Removing head
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (current == tail) { // Removing tail
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else { // Removing from the middle
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--; // Reduce size
        return current;
    }
	
		
    
    public T retrieveFirstElement() {
    	
    	if(head == null)return null;
    	
    	Node temp = head;
    	
    	if(size == 1) {
    		
    		head = null;
    		tail = null;
    	
    	}else {
    	
    		head = head.next;
    		head.prev = null;
    		temp.next = null;
    	
    	}
    	
    	size --;
    	return temp.data;
    	
    }
    
    public T retrieveLastElement() {
    	
    	if (head == null)return null;
    	
    	Node temp = tail;
    	
    	if(size == 1) {
    	
    		head = null;
    		tail = null;
    	
    	}else {
    	
    		tail = tail.prev;
    		tail.next = null;
    	
    	}
    	
    	size --;
    	return temp.data;
    	
    }

    public ArrayList<T> toArrayList(){
		
    	ArrayList<T> ArrayList = new ArrayList<T>();
    	
    	
    	Node current = head;
    	
    	
    	for (int i = 0; i < size; i++) {
    		
    		ArrayList.add(current.data);
    		current = current.next;
    		    	
    	}
    	
    	return ArrayList;
    	
    }


    
    protected class DoubleLinkedListIterator implements ListIterator<T>{

    	private Node current;
		
    	public DoubleLinkedListIterator() {
    		this.current = head;
    	}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			 
			return current != null;
			
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if (!hasNext()) {
			       throw new NoSuchElementException();
			}
				
			T data = current.data;
			current = current.next;
			return data;

		}

		@Override
		public boolean hasPrevious()  {
			// TODO Auto-generated method stub
			 if(current == head) {
				 return false;
			 }else {
				 return true;
			 }
			
		}

		@Override
		public T previous() {
			// TODO Auto-generated method stub
		    if (hasPrevious()== false) {
		        throw new NoSuchElementException();
		    }
		    if(current == null) {
		    	
		    	current = tail;
		   
		    }else {
		    	current = current.prev; 
		    }
		    
		    return current.data;

		}

		@Override
		public int nextIndex() throws UnsupportedOperationException {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException ();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException ();
		}

		@Override
		public void remove() throws UnsupportedOperationException {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException ();

		}

		@Override
		public void set(T e) throws UnsupportedOperationException {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException ();

		}

		@Override
		public void add(T e) throws UnsupportedOperationException {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException ();

		}
    	
    	
    	
    	
    	
    }
	
	
	
	
	
}
