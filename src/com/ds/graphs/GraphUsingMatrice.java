/**
 * This Java class is a part of com.ds, a package
 * containing the basic data structure code.
 * 
 */
package com.ds.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Part of the package com.ds, GraphUsingMatrice class uses 
 * two dimensional n x n Matrices for graph representation.
 *
 * @author Himanshu Bisht
 *
 */
public class GraphUsingMatrice implements GraphInterface {
	
	private GraphType graphType = GraphType.DIRECTED;
	private int[][] ajancencyMatrix;
	private int size;

	/**
	 * Defines the properties of a Graph DS, which include:
	 * <ol> 
	 * 	<li>Size</li>
	 * 	<li>Adjacency Matrix with Nodes</li>
	 * 	<li>Graph Type (DIRECTED or UNDIRECTED)</li>
	 * </ol>
	 * @param size The total number of nodes
	 * @param graphType Enum GraphType.DIRECTED or GraphType.UNDIRECTED 
	 */
	public GraphUsingMatrice(int size, GraphType graphType) {
		this.ajancencyMatrix = new int[size][size];
		this.size = size;
		this.graphType = graphType;
		for(int i=0; i < this.size; i++) {
			for(int j=0; j < this.size; j++) {
				this.ajancencyMatrix[i][j] = 0;
			}
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
		
		if (v1 < 0 || v2 < 0 || v1 > size - 1 || v1 > size - 1) {
			throw new IllegalArgumentException("One/Both of the vertices number is/are not valid.");
		}
		this.ajancencyMatrix[v1][v2] = 1;
		if (graphType == GraphType.UNDIRECTED) {
			this.ajancencyMatrix[v2][v1] = 1;
		}
		
	}

	/**
	 * Returns all the adjacent nodes to vertex v.
	 * 
	 * @param v Integer node number whose adjacent nodes are required to be found.
	 */
	@Override
	public List<Integer> getAdjacentVertices(int v) {
		if (v < 0  || v > size - 1 ) {
			throw new IllegalArgumentException("The vertice is not valid.");
		}		List<Integer> neighbours = new ArrayList<Integer>();
		
		for(int i=0; i < v; i++) {
			if (this.ajancencyMatrix[v][i] == 1) {
				neighbours.add(i);
			}
		}
		Collections.sort(neighbours);
		return neighbours;
	}
	
}



