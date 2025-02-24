/*
 * CMSC 204
 * 
 * Montana Bazarragchaa
 * 
 */


import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {
	
	private ArrayList<T> queue;
	private int size;
	
	public MyQueue(int size) {
		this.size = size;
		this.queue = new ArrayList<>(size);
	}
	
	public MyQueue() {
		this(30);
	}
	
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	/**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {
		return queue.size() == size;
	}
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	@Override
	public T dequeue() throws QueueUnderflowException{
		if (isEmpty()== true) { 
			
			throw new QueueUnderflowException();
		}
		return queue.remove(0);
	}

	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return queue.size();
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException{
		
		if(isFull() == true) {
			throw new QueueOverflowException();		
		}
		queue.add(e);
		return true;
	}
	
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString() {
		
		String s = "";
		
		for (int i = 0; i < size(); i++) {
		
			s += queue.get(i).toString();
		}
		
		return s;
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		
		String s = "";
		
		for (int i = 0; i < size(); i++) {
			
			if(i == size() - 1) {
			
				s += queue.get(i).toString();
			
			}else {
				
				s += queue.get(i).toString() + delimiter;
			}
		}
		
		return s;
	}
	
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	 
	  */
	public void fill(ArrayList<T> list)  {
        queue.clear();
        queue.addAll(list);
	}
	
 

}
