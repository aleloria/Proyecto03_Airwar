package data.structures;
import java.util.Arrays;

import data.structures.Graph;
import data.structures.Node;
import data.structures.VertexList;

// TODO: Auto-generated Javadoc
/**
 * The Class Dijkstra.
 * Dijkstra algorithm implemented on a Class for easy management of data and access. The Dijkstra Class takes a given graph of N vertices and 2N edges
 * and returns the shortest path between all vertices. This modified implementation also takes a source vertex and a destination vertex and returns the
 * shortest path between them.
 */
public class Dijkstra {
	
	/** The vertex list. */
	private VertexList[] vertexList = new VertexList[1];
	
	/** The unvisited. */
	private Integer[] unvisited = new Integer[1];
	
	/** The vertex amount. */
	private Integer vertexAmount = 0;
	
	/** The path. */
	public Integer[] path = new Integer[1];
	
	/** The distances. */
	private Integer[] distances = new Integer[1];
	
	/** The previous vertex. */
	private Integer[] previousVertex = new Integer[1];
	
	/** The has elements. */
	private boolean hasElements= true;
	
	
	
	
	/**
	 * Instantiates a new dijkstra.
	 *
	 *Starts the generation of the shortest path between two given vertices. uses the classic Dijkstra approach, then extrapolates the shortest path
	 *information from an array that contains the shortest routes between the starting vertex and every existing vertex inside the graph.
	 * @param graph the graph
	 * @param start the start
	 * @param finish the finish
	 */
	public Dijkstra(Graph graph, Integer start, Integer finish) {
		
		this.vertexAmount = graph.getVertexAmount();
		this.vertexList = graph.getVertexList();
		this.unvisited = new Integer[this.vertexAmount];
		this.distances = new Integer[this.vertexAmount];
		this.previousVertex = new Integer[this.vertexAmount];
		for(Integer index=0;index<this.vertexAmount;index++) {
			this.distances[index]=Integer.MAX_VALUE;
			this.unvisited[index]=index;
		}
		this.distances[start]=0;
		this.previousVertex[start]=start;
		begin(finish,start);
	}

	/**
	 * Begin.
	 *
	 * @param finish the finish
	 * @param start the start
	 */
	public void begin(Integer finish, Integer start) {
		while(hasElements) {
			Integer currentVertex= getVertex();
			
			if(currentVertex==-1) {
				break;
			}
			System.out.println("VERTICE SELECCIONADO "+currentVertex);
			for(Node currentNode=this.vertexList[currentVertex].getHead();currentNode!=null;currentNode=currentNode.getNext()) {
				if(this.unvisited[currentNode.getData()[0]]>=0) {
					if(this.distances[currentNode.getData()[0]]>distances[currentVertex]+currentNode.getData()[1]) {
						System.out.println("DISTANCIA ACTUAL PARA EL NODO "+ currentNode.getData()[0]+": "+this.distances[currentNode.getData()[0]]);
						System.out.println("SERA REMPLAZADO POR: "+distances[currentVertex]+"+"+currentNode.getData()[1]+"="+(distances[currentVertex]+currentNode.getData()[1]));
						this.distances[currentNode.getData()[0]]=distances[currentVertex]+currentNode.getData()[1];
						this.previousVertex[currentNode.getData()[0]]=currentVertex;
					}
				}
				
			}
			this.unvisited[currentVertex]=-1;
			System.out.println("DISTANCIAS "+Arrays.deepToString(distances));
			System.out.println("PREVIOUS VERTEX "+Arrays.deepToString(previousVertex));
			System.out.println();
			
			
			
			
		}
		getPath(finish,start);
			
	}

	/**
	 * Gets the vertex.
	 *
	 * @return the vertex
	 */
	private Integer getVertex() {
		checkForElements();
		Integer vertex=-1;
		Integer smallestDistance=Integer.MAX_VALUE;
		for(Integer index=0;index<this.unvisited.length;index++) {
			if(this.unvisited[index]>=0) {
				if(this.distances[index]<smallestDistance) {
					System.out.println("Sustituyo "+smallestDistance+" por "+this.distances[index]);
					smallestDistance=this.distances[index];
					vertex=index;
					
				}

			}
		}
		
		return vertex;
	}
		
	
	
	

	/**
	 * Check for elements.
	 */
	private void checkForElements() {
		for(Integer index=0;index<this.unvisited.length;index++) {
			if(this.unvisited[index]!=-1) {
				this.hasElements=true;
			}
		}
	}

	/**
	 * Gets the unvisited.
	 *
	 * @return the unvisited
	 */
	public Integer[] getUnvisited() {
		return unvisited;
	}
	
	/**
	 * Gets the vertex amount.
	 *
	 * @return the vertex amount
	 */
	public Integer getVertexAmount() {
		return vertexAmount;
	}
	
	/**
	 * Check validity.
	 *
	 * @return true, if successful
	 */
	public boolean checkValidity() {
		boolean valid = true;
		for(int index=0;index<this.previousVertex.length;index++) {
			if(this.previousVertex[index]==null) {
				valid = false;
				System.out.println("correction needed");
			}
		}
		return valid;
	}
	
	/**
	 * Gets the path.
	 *
	 * @param finish the finish
	 * @param start the start
	 * @return the path
	 */
	public Integer[] getPath(int finish, int start) {
		Integer[] preliminaryPath = new Integer[this.vertexAmount];
		Integer index=0;
		Integer target=finish;
		while(true) {
			System.out.println("TARGET BEFORE "+target);
			preliminaryPath[index]=target;
			target=this.previousVertex[target];
			System.out.println("TARGET AFTER "+target);
			index++;
			if(target.equals(start)) {
				break;
			}
		}
		
		Integer counter = 0;
		for(int position=0;position<preliminaryPath.length;position++) {
			if(preliminaryPath[position]!=null) {
				counter++;
			}
		}
		this.path = new Integer[counter];
		Integer i=0;
		counter=counter-1;
		while(counter>=0) {
			if(counter<0) {
				break;
			}
			this.path[i]=preliminaryPath[counter];
			i++;
			counter--;
		}
		System.out.println(Arrays.deepToString(path));
		return this.path;
	}

	
	
	
	
	
	

}
