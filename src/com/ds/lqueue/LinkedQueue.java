/**
 * This Java class is a part of com.ds, a package
 * containing the basic data structure code.
 *  
 */
package com.ds.lqueue;

import com.ds.exceptions.DSOverFlowException;
import com.ds.exceptions.DSUnderFlowException;


/**
 * Part of the package com.ds, a personal package with a 
 * number of DS implementation, LinkedQueue class containing a 
 * Element class data structure. The LinkedQueue class could be
 * thought of as a manager of the Element class; The LinkedQueue
 * class provides a number of operations on the Element class.
 * 
 * @author bisht
 *
 * @param <T>
 */
public class LinkedQueue <T> {
	
	/**
	 * This class could be thought of an individual cell or 
	 * "stack". A collection of instance of this class would
	 * make up a Stack data structure.
	 * 
	 * @author Himanshu Bisht
	 *
	 * @param <T> a promise to keep the class data type independent.
	 */
	private static class Element<T> {
		private T data;
		private Element<T> nextElement;
		public Element(T data, Element<T> element) {
			this.data = data;
			this.nextElement = element;
		}
		
		public T getData() {
			return this.data;
		}
		
		public Element<T> getNextElement() {
			return this.nextElement;
		}
		
		public void setNextElement(Element<T> element) {
			this.nextElement = element;
		}
		
		@SuppressWarnings("unused")
		public void setData(T data) {
			this.data = data;
		}
	}
	
	private Element<T> first; // the head of the queue
	private Element<T> last; // the tail of the queue
	private int max_size;
	private int size;
	
	/**
	 * Initialises the class with a given size and sets head and last pointer pointing to null.
	 * @param max_size
	 */
	public LinkedQueue(int max_size) {
		this.first = null;
		this.last = null;
		this.size = 0; // don't really have any effect
		this.max_size = max_size;
	}
	
	public void enQueue(T data) throws DSOverFlowException {
		Element<T> newElement = new Element<T>(data, null);
		if (this.size == this.max_size) {
			throw new DSOverFlowException("The Queue is full!");
		} else if (this.size == 0 ) {
			this.first = newElement;
			this.last = this.first;
		} else {
			this.last.setNextElement(newElement);
			this.last = newElement;
		}
		this.size++;
	}
	
	public T deQueue() throws DSUnderFlowException {
		if (this.size == 0) {
			throw new DSUnderFlowException("The Queue is empty!");
		} 
		T data = this.first.getData();
		this.first = this.first.getNextElement();
		if (this.first == null) {
			this.last = null;
		}
		this.size--;
		return data;
	}
	
	public void show() {
		System.out.println("First: " + this.first.getData());
	}
	
	public void showLast() {
		System.out.println("First: " + this.last.getData());
	}
	
	public static void printAllData(LinkedQueue<?> list) throws DSUnderFlowException {
		Element<?> pointer = list.first;
		while(true) {
        	if (list.size == 0) {
        		throw new DSUnderFlowException("The Singly Linked List is not iterable as it is empty!");
        	}
        	if (pointer.getNextElement() == null) {
        		System.out.println(pointer.getData());
        		break;
        	} else {
        		System.out.print(pointer.getData() + " ");
        		pointer = pointer.getNextElement();
        	}
        } System.out.println(); 
    }
}
