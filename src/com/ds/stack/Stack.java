/**
 * This Java class is a part of com.ds, a package
 * containing the basic data structure code.
 */
package com.ds.stack;

import com.ds.exceptions.DSOverFlowException;
import com.ds.exceptions.DSUnderFlowException;

/**
 * Part of the package com.ds, a personal package with a 
 * number of DS implementation, Stack class containing a 
 * Element class data structure. The Stack class could be
 * thought of as a manager of the Element class; The Stack
 * class provides a number of operations on the Element class.
 * 
 * @author Himanshu Bisht
 *
 * @param <T> for keeping the class as type independent.
 * 
 */
public class Stack<T> {
	/**
	 * This class could be thought of an individual cell or 
	 * "stack". A collection of instance of this class would
	 * make up a Stack data structure.
	 * 
	 * @author Himanshu Bisht
	 *
	 * @param <T> a promise to keep the class data type independent.
	 */
	@SuppressWarnings("hiding")
	private class Element<T> {
		private T data; // The data to be stored
		private Element<T> prevCellPointer; // The pointer to the second-last Element 
		
		/**
		 * The Element class has two parts: 
		 * <ol>
		 * 	<li>The data itself. And,</li>
		 *  <li>The pointer to the last Element.</li>
		 * </ol>
		 * 
		 * @param data the data of any data type.
		 * @param nextCell the pointer to the last "cell" or "Element"
		 * 
		 */
		public Element(T data, Element<T> nextCell) {
			this.data = data;
			this.prevCellPointer = nextCell;
		}
		
		/**
		 * To retrieve the data from a cell.
		 * 
		 * @return data of the stored data type.
		 */
		public T getData() {
			return data;
		}
		
		/**
		 * To set data in a Stack cell.
		 * 
		 * @param data accepts data of any type.
		 */
		@SuppressWarnings("unused")
		public void setData(T data) {
			this.data = data;
		}

		/**
		 * To retrieve the cell just before the current cell.
		 * 
		 * @return an instance of Element class.
		 */
		public Element<T> getPrevCellPointer() {
			return prevCellPointer;
		}

		/**
		 * Sets the pointer of a current Stack cell to the given
		 * Stack cell. NB! only use this to connect the current
		 * Stack cell to the previous Stack cell.
		 * 
		 * @param nextCellPointer an instance of Element class.
		 */
		@SuppressWarnings("unused")
		public void setPrevCellPointer(Element<T> nextCellPointer) {
			this.prevCellPointer = nextCellPointer;
		}		
	}
	
	private int maxSize; // The maximum size of the Stack.
	private int size; // Tracks the number of elements in the Stack at any point. 
	private Element<T> top; // Keeps track of the latest element in the Stack.
	
	/**
	 * Initialises the Stack with user defined size.
	 * 
	 * @param stack_size the size of the stack
	 */
	public Stack(int stack_size) {
		this.maxSize = size; // the size of an array
		this.size = 0; // just to make things clear
		this.top = null; // just to make things clear
	}
	
	/**
	 * Tells the maximum size of the Stack.
	 * 
	 * @return a positive integer. 
	 */
	public int getMaxSize() {
		return maxSize;
	}

	/**
	 * Tells the number of elements present in the Stack.
	 * 
	 * @return a positive integer.
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Adds elements to the top of the Stack.
	 * 
	 * @param data the data to be added.
	 * @throws DSOverFlowException if the Stack is already full.
	 */
	public void push(T data) throws DSOverFlowException {
		// checks if the Stack is already full
		if (this.size == this.maxSize) {
			throw new DSOverFlowException("The stack has run out of memory.");
		} 
		Element<T> element = new Element<T>(data, this.top);
		this.top = element;
		this.size++;
	}
	
	/**
	 * Removes elements to the top of the Stack.
	 * 
	 * @throws DSUnderFlowException if the Stack is has no item/data.
	 * @return data the removed data
	 */
	public T pop() throws DSUnderFlowException {
		if (this.size == 0) {
			throw new DSUnderFlowException("The stack has no data.");
		}
		T data = this.top.getData();
		this.top = this.top.getPrevCellPointer();
		this.size--;
		return data;
	}
	
	/**
	 * Use this to know the data at the top of the Stack without popping.
	 * 
	 * @return data the data at the top of the Stack.
	 * @throws DSUnderFlowException if the stack has no item/data.
	 */
	public T peek() throws DSUnderFlowException {
		if (this.size == 0) {
			throw new DSUnderFlowException("The stack has no data.");
		}
		return this.top.getData();
	}
}
