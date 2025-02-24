/*
 * CMSC 204
 * 
 * Montana Bazarragchaa
 * 
 */

import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {
	/**
	 * Provide two constructors
	 * 1. takes in an int as the size of the stack
	 * 2. default constructor - uses default as the size of the stack
	 */
	
	private ArrayList<T> stack;
	private int size;
	private int index;
	
	public MyStack(int size) {
		this.stack = new ArrayList<>(size);
		this.size = size;
		this.index = 0;
	}
	
	public MyStack () {
		this(30);
	}
	
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return index == 0 ;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		if (stack.size()== size) {
			return true;
		}
		return false;
	}
	

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException{
		if ( isEmpty() == true) throw new StackUnderflowException();
		
		T removed = stack.remove(index - 1);
		index --;
		return removed;
		
	}
	
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException{
		if ( isEmpty() == true) throw new StackUnderflowException();
		return stack.get(index - 1);
		
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		return stack.size();
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	@Override
	public boolean push(T e) throws StackOverflowException{
		if(isFull() == true) throw new StackOverflowException();
		stack.add(e);
		index++;
		return true;
	}
	
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < index; i++) {
			s += stack.get(i).toString();
		}
		return s;
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		
		String s = "";
		for (int i = 0; i < index; i++) {
			if(i == index - 1) {
				return s += stack.get(i).toString();
			}
			s += stack.get(i).toString() + delimiter;
		}
		return s;
	}
	
	 /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	public void fill(ArrayList<T> list) {
        ArrayList<T> copy = new ArrayList<>(list); 
        stack.addAll(copy); 
        index += list.size(); 
	}
}
