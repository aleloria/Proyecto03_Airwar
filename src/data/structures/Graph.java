package data.structures;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import com.logic.SpotPos;

// TODO: Auto-generated Javadoc
/**
 * The Class Graph.
 * The Class Graph implements a Graph data structure using an adjacency list model. The main characteristics of this implementation are:
 * =>Every vertex inside the graph is reachable through any other vertex.
 * =>The graph is weighted.
 * =>The graph is not directed.
 * 
 */
public class Graph {
	
	/** The vertex amount. 
	 * Amount of existing vertices inside the graph*/
	private Integer vertexAmount;
	
	/** The vertex list
	 * An array of custom LinkedList objects that represents the adjacent nodes for each existing vertex. */
	private VertexList vertexList[];
	
	
	
	/**
	 * Gets the vertex amount.
	 *
	 * @return the vertex amount
	 */
	public Integer getVertexAmount() {
		return vertexAmount;
	}



	/**
	 * Sets the vertex amount.
	 *
	 * @param vertexAmount the new vertex amount
	 */
	public void setVertexAmount(Integer vertexAmount) {
		this.vertexAmount = vertexAmount;
	}



	/**
	 * Gets the vertex list.
	 *
	 * @return the vertex list
	 */
	public VertexList[] getVertexList() {
		return vertexList;
	}



	/**
	 * Sets the vertex list.
	 *
	 * @param vertexList the new vertex list
	 */
	public void setVertexList(VertexList[] vertexList) {
		this.vertexList = vertexList;
	}



	/**
	 * Instantiates a new graph.
	 *
	 * @param amount the amount
	 */

	public Graph(Integer amount){
		
		this.vertexAmount = amount;
		this.vertexList = new VertexList[this.vertexAmount];
		
		for(Integer index=0; index< this.vertexAmount; index++) {
			this.vertexList[index] = new VertexList();
			this.vertexList[index].setVertex(index);
		}
	}
	
	
	 /**
 	 * Adds the edge.
 	 *
 	 *adds a connection between two vertices inside the graph, the connection goes both ways,
 	 *this means that a new node is created in the linked list of the index of the adjacency list
 	 *that corresponds to both vertices. 

 	 * @param weight the weight
 	 * @param source the source
 	 * @param destination the destination
 	 */
 	public void addEdge(int weight, int source, int destination) { 

	        this.vertexList[source].append(destination, weight);
	        this.vertexList[destination].append(source, weight);
	    } 
	 
	 /**
 	 * Random path generator.
 	 * This method uses Java.Util ThreadLocalRandom to generate a random index number that represents a vertex inside the adjacency list
 	 * it then creates an edge for each existing vertex, a connection, to the randomly generated index in the adjacency list.
 	 * It creates twice as many edges than there are vertices, ensuring that every node is connected.
	 * @param Positions 
 	 */
 	public void randomPathGenerator(SpotPos[] Positions) {
		 int swaps=0;
		 for(int vertex = 0; vertex<this.vertexAmount;vertex++) {
			 if(swaps==this.vertexAmount*2) {
				 break;
			 }else{
				 boolean success=false;
				 int counter=0;
				 while(success==false) {
					 if(counter==10000) {
						 break;
					 }
					 int randomIndex = ThreadLocalRandom.current().nextInt(0, this.vertexAmount);
					 Integer weight = getWeight(Positions, vertex, randomIndex);
					 System.out.println("Trying to connect  " + randomIndex+ " to vertex number "+ vertex);
					 if(randomIndex==vertex) {
						 success=false;
						 counter++;
						 
						 
						 }else if(this.vertexList[vertex].search(randomIndex)) {
							 success=false;
							 counter++;
							 
						 }else{
							 System.out.println("success");
							 int destination=randomIndex;
							 this.addEdge(weight, vertex, destination);
							 swaps++;
							 success=true;
						 }
						
					 }
				 }
			 }
		 }



 	private Integer getWeight(SpotPos[] positions, int source, int destination) {

 		int xCoordinateSource = positions[source].getposX();
 		int yCoordinateSource = positions[source].getposy();
 		int xCoordinateDestination = positions[destination].getposX();
 		int yCoordinateDestination = positions[destination].getposy();
 		Double xDifference = (double) Math.abs((xCoordinateSource-xCoordinateDestination));
 		Double yDifference = (double) Math.abs((yCoordinateSource-yCoordinateDestination));
 		Integer distanceBetweenVertices = (int) Math.sqrt(Math.pow(xDifference, 2)+Math.pow(yDifference, 2));
 		System.out.println("ORIGINAL DISTANCE: "+distanceBetweenVertices);
 		
 		if (positions[source].getspot()==1 || positions[destination].getspot()==1){
 			distanceBetweenVertices = distanceBetweenVertices*2;
 			System.out.println("WATER MODIFIER: "+distanceBetweenVertices);
 		}
 		Integer weight = distanceBetweenVertices;
 		return weight; 
 	}
	 
	 	 
}
