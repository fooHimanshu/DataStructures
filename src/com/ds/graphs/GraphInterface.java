/**
 * This Java Interface is a part of com.ds, a package
 * containing the basic data structure code.
 *  
 */
package com.ds.graphs;

import java.util.List;

/**
 * An interface to all Graphs implementation which is required to
 * be implemented by all the Graph DS classes this package has. This 
 * is required so that the implementation specification remains the
 * same for all Graphs.
 * 
 * @author Himanshu Bisht
 *
 */
public interface GraphInterface {
	enum GraphType {
		DIRECTED,
		UNDIRECTED
	}
	
	/**
	 * Adds edges incident to two nodes v1 and v2.
	 * 
	 * @param v1 The node from where the edge originates.
	 * @param v2 The node where the edge falls to.
	 */
	void addEdge(int v1, int v2);
	
	/**
	 * Returns all the adjacent nodes to vertex v. 
	 * 
	 * @param v Integer node number whose adjacent nodes are required to be found.
	 * @return
	 */
	List<Integer> getAdjacentVertices(int v);
}
