/**
 * This Java class is a part of com.ds, a package
 * containing the basic data structure code.
 *  
 * TODO: Sorting maybe at some point.
 */

package com.ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

import com.ds.exceptions.DSOverFlowException;
import com.ds.exceptions.DSUnderFlowException;

/**
 * Part of the package com.ds, a personal package with a number of DS implementation, 
 * SinglyLinkedList class containing a Node class data structure. 
 * The SinglyLinkedList class could be thought of as a manager of
 * a Node class; The SinglyLinkedList class provides a number of 
 * operations on the Node class.
 * 
 * @author Himanshu Bisht
 *
 * @param <T> for keeping the class as type independent.
 * 
 */

public class SinglyLinkedList<T> {
	
	/**
	 * The Node class containing the data and the reference
	 * to the next node.
	 *
	 * @param <T> a promise to keep the data type independent.
	 * 
	 */
	private static class Node<T> {
		private T data; // The data being stored in an individual node
		private Node<T> pointerToNextNode; // The pointer to next node 
		
		public Node(T data, Node<T> node) {
			this.data = data;
			this.pointerToNextNode = node;
		}
		
		/**
		 * Getter for data
		 * 
		 * @return T the data stored in the node
		 */
		public T getData() {
			return this.data;
		}
		
		/**
		 * Adds/Updates data for a particular node
		 * 
		 * @param data the data to be stored
		 */
		@SuppressWarnings("unused")
		public void setData(T data) {
			this.data = data;
		}
		
		/**
		 * Returns the pointer to the next node of the 
		 * selected node.
		 * 
		 * @return Node<T> pointer to the next node
		 */
		public Node<T> getNextNode() {
			return this.pointerToNextNode;
		}
		
		/**
		 * Sets the pointer of the current node to point to
		 * the next node.
		 * 
		 * @param node the node next to the current node
		 */
		public void setPointerToNextNode(Node<T> node) {
			this.pointerToNextNode = node;
		}
	}
	
	private Node<T> head; // keeps track of the head node
	private Node<T> tail; // keeps track of the next node
	private int size; // keeps track of the size of the linked list at any point 
	
	/**
	 * Initiates the new Singly Linked List. 
	 * Upon Initialisation with:
	 * <ol> 
	 * <li>An empty head pointer</li>
	 * <li>An empty tail pointer</li>
	 * <li>Size of the list of to 0 .</li>
	 * </ol>
	 */
	public SinglyLinkedList() {
		this.head = null; // sets the head to null upon creation of a new SingleLinkedList
		this.tail = null; // sets the tail to null upon creation of a new SingleLinkedList
		this.size = 0;  // sets the size of the list to 0 upon creation of a new SingleLinkedList
	}
	
	/**
	 * Tells the size of the Linked List 
	 * 
	 * @return size positive integer equals to or greater than 0
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Returns the head node of the Linked List
	 * 
	 * @return head a Node object 
	 */
	public Node<T> getHead() {
		return this.head;
	}
	
	/**
	 * Tells if the Linked List is Empty.
	 *  
	 * @return true if list is empty else false
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	/**
	 * Adds a new node at the end of the Linked List.
	 * 
	 * @param data the data to be added to the end of the list
	 */
	public void append(T data) {
		Node<T> newNode = new Node<T>(data, null);
		if (this.size == 0) {
			this.head = newNode;
		} else {
			this.tail.setPointerToNextNode(newNode);
		}
		this.tail = newNode;
		this.size++;
	}
	
	/**
	 * Returns the tail node of the Linked List
	 * 
	 * @return tail a Node object 
	 */
	public Node<T> getTail() {
		return this.tail;
	}
	
	/**
	 * Adds a new node at the <b>beginning</b> of the Linked List.
	 * 
	 * @param data the data to be added to the beginning of the list
	 */
	public void prepend(T data) {
		Node<T> newNode = new Node<T>(data, this.head);
		if (this.size == 0) {
			this.tail = newNode;
		}
		this.head = newNode;
		this.size++;
	}
	
	/**
	 * Removes the first occurrence of the matching data node form an unknown location.
	 * 
	 * @param data the data of to be removed
	 * @throws DSOverFlowException if the Singly Linked List is empty.
	 */
	public void removeData(T data) throws DSUnderFlowException {
		// return if the list is empty
		if(this.isEmpty()) {
			this.throwUnderFlowException(null);
		}

		Node<T> currentNode = this.head;
		Node<T> prevNode = null;
		
		// trace the node with matching data
		while(currentNode != null && currentNode.getData() != data) {
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		if (currentNode == null) {
			System.out.println("The item was not found.");
		} else if (currentNode != null && prevNode == null) {
			this.head = currentNode.getNextNode();
			this.size--;
			System.out.println("The item was removed.");
			return;
		} else {
			prevNode.setPointerToNextNode(currentNode.getNextNode());
			this.size--;
			System.out.println("The item was removed.");
			return;
		}
	}
	
	/**
	 * Recursively reverse the node with this function.
	 * 
	 * @param node pass the head node
	 * @return the head node
	 */
	public Node<T> reverseListRecursively(Node<T> node) {
		
		if (node == null || node.getNextNode() == null) {
			this.head = node;
			return node;
		}
		
		Node <T> currentNode = reverseListRecursively(node.getNextNode());
		currentNode.setPointerToNextNode(node);
		node.setPointerToNextNode(null);
		this.tail = node;
		return node;
	}
	
	/**
	 * Reverses the entire Linked List.
	 * @throws DSOverFlowException if the Singly Linked List is empty.
	 */
	public void reverseList() throws DSUnderFlowException {
		if (this.isEmpty()) {
			this.throwUnderFlowException(null);
		} else {
			Node<T> currentNode = this.head;
			Node<T> prevNode = null;
			Node<T> refNode = null;
			while(currentNode != null) {
				refNode = currentNode.getNextNode();
				currentNode.setPointerToNextNode(prevNode);
				prevNode = currentNode;
				currentNode = refNode;
				if (refNode == null) {
					this.tail = this.head;
				}
				if (currentNode==null) {
					this.head = prevNode;
				}
			}
		}
	}
	
	/**
	 * Helper function to reduce code duplication for
	 * throwing an exception when the singly linked list
	 * is empty.
	 * 
	 * @param msg a custom error could be passed or just pass null
	 * @throws DSUnderFlowException a common exception message when the list is empty.
	 */
	private void throwUnderFlowException(String msg) throws DSUnderFlowException {
		if (msg == null) {
			throw new DSUnderFlowException("The Singly Linked List is empty!");
		} else {
			throw new DSUnderFlowException(msg);
		}
	}

	/**
	 * Prints data in the order head to tail.
	 * 
	 * @param list the linked list which needs to be printed
	 * @throws DSOverFlowException if the Singly Linked List is empty.
	 */
	public static void printAllData(SinglyLinkedList<?> list) throws DSUnderFlowException {
		Node<?> pointer = list.head;
		while(true) {
        	if (list.isEmpty()) {
        		list.throwUnderFlowException("The Singly Linked List is not iterable as it is empty!");
        	}
        	if (pointer.getNextNode() == null) {
        		System.out.println(pointer.getData());
        		break;
        	} else {
        		System.out.print(pointer.getData() + " ");
        		pointer = pointer.getNextNode();
        	}
        } System.out.println(); 
    }
	
	/**
	 * Returns all the nodes in form of a list.
	 * 
	 * @return list of all nodes
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAllData() {
		List<T> allData = new ArrayList<>();
		Node<?> pointer = this.head;
		while(true) {
        	if (this.isEmpty()) {
        		return null;
        	} 
        	
        	allData.add((T) pointer.getData());
        	if (pointer.getNextNode() == null) {
        	   	break;
        	} 
        	pointer = pointer.getNextNode();
        }
																											
		return allData;
	}
}
	


