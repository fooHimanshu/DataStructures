/**
 * This Java class is a part of com.ds, a package
 * containing the basic data structure code.
 *  
 */

package com.ds.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.ds.linkedlist.SinglyLinkedList;

/**
 *
 * Part of the package com.ds, a personal package with a number of DS implementation, 
 * GraphUsingLinkedList class uses the previously implemented SinglyLinkedList class. 
 * A similar approach could be taken by using the Java native lined list DS.
 *
 * @author Himanshu Bisht
 *
 */
public class GraphUsingLinkedList implements GraphInterface {
	
	private GraphType graphType = GraphType.DIRECTED;
	private List<SinglyLinkedList<Integer>> graphList;
	private int size;
	
	/**
	 * Defines the properties of a Graph DS, which include:
	 * <ol> 
	 * 	<li>Size</li>
	 * 	<li>Nodes</li>
	 * 	<li>Graph Type (DIRECTED or UNDIRECTED)</li>
	 * </ol>
	 * @param size The total number of edges
	 * @param graphType Enum GraphType.DIRECTED or GraphType.UNDIRECTED
	 */
	public GraphUsingLinkedList(int size, GraphType graphType) {
		this.graphList = new ArrayList<>();
		this.size = size;
		this.graphType = graphType;
		
		for(int i = 0; i < size; i++) {
			SinglyLinkedList<Integer> vertex = new SinglyLinkedList<>();
			vertex.append(i);
			this.graphList.add(vertex);
		}
	}
	
	/**
	 * Adds edges incident to two nodes v1 and v2.
	 * 
	 * @param v1 The node from where the edge originates.
	 * @param v2 The node where the edge falls to.
	 */
	@Override
	public void addEdge(int v1, int v2) {
		
		// check if the node number is valid
		if (v1 < 0 || v2 < 0 || v1 > size - 1 || v1 > size - 1) {
			throw new IllegalArgumentException("One/Both of the vertices number is/are not valid.");
		} 
		
		if(graphList.get(v1) == null) {
			SinglyLinkedList<Integer> subGraph = new SinglyLinkedList<>();
			subGraph.append(v1);
			graphList.set(v1, subGraph);
		}
		
		if(graphList.get(v2) == null) {
			SinglyLinkedList<Integer> subGraph = new SinglyLinkedList<>();
			subGraph.append(v2);
			graphList.set(v2, subGraph);
		}
		
		graphList.get(v1).append(v2);
		
		if(graphType ==  GraphType.UNDIRECTED) {
			graphList.get(v2).append(v1);
		}
		
	}

	/**
	 * Returns all the adjacent nodes to vertex v.
	 * 
	 * @param v Integer node number whose adjacent nodes are required to be found.
	 */
	@Override
	public List<Integer> getAdjacentVertices(int v) {
		// TODO Auto-generated method stub
		if (v < 0  || v > size - 1) {
			throw new IllegalArgumentException("The vertex number is not valid.");
		}
		
		List<Integer> neighbours = this.graphList.get(v).getAllData().subList(1, v); // sublist because the first one is the current v node 
		if (neighbours != null) {
			Collections.sort(neighbours);
		}

		return neighbours;
	}
}
