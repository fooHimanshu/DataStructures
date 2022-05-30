/**
 * This Java class is a part of com.ds, a package
 * containing the basic data structure code.
 * 
 */
package com.ds.runner;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ds.exceptions.DSUnderFlowException;
import com.ds.graphs.GraphInterface.GraphType;
import com.ds.graphs.GraphUsingLinkedList;
import com.ds.linkedlist.*;
/**
 * This class should only be used as a runner class
 * for the implemented Data Structure. 
 * 
 * @author Himanshu Bisht
 *
 */
public class RunTheDataStructures {
	
	private static Logger informer = Logger.getLogger("RunnerClassLogs"); // TODO: Research later about this
	
	
	/**
	 * Static method to perform test on SinglyLinkedList
	 * 
	 */
	private static void testSinglyLinkedList() throws DSUnderFlowException {
		informer.info("Creating an instance of Singly Linked List");
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		informer.info("Singly linked list has been created");
        int data; 
        informer.info("Adding 1-10 Integers to the Singly Linked List.");
        for (data=1; data<=10; data++) {
        	list.append(data);	
        }
        try {
        	list.removeData(1);
        	informer.info("Removed data 1");
        } catch (Exception e) {
        	informer.log(Level.SEVERE, "Exception :: ", e);
        };
        informer.info("Printing the list before reversal.");
        SinglyLinkedList.printAllData(list);
        try {
        	informer.info("Reversing the Singly List");
        	list.reverseListRecursively(list.getHead());
        	SinglyLinkedList.printAllData(list);
        } catch (Exception e) {
        	informer.log(Level.SEVERE, "Exception :: ", e);
        }
	}
	
	/**
	 * Static method to perform test on GraphUsingLinkedList
	 * 
	 */
	private static void testGraphsUsingLinkedList() {
		informer.info("Creating an instance of Graph using Linked List");
		GraphUsingLinkedList graph = new GraphUsingLinkedList(4, GraphType.DIRECTED);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 1);
		informer.info("Getting vertices adjacent to 2");
		List<Integer> neighbours = graph.getAdjacentVertices(2);
		if(neighbours != null) {
			for(int i: neighbours) {
				System.out.print(i + " ");
			}
		}
	}
	
	
	/**
	 * Static method with not so good logging. 
	 * 
	 * @param args this param was not used.
	 * @throws DSUnderFlowException 
	 */
	public static void main(String[] args) throws DSUnderFlowException {
		RunTheDataStructures.testSinglyLinkedList();   
		RunTheDataStructures.testGraphsUsingLinkedList();
    }
}
