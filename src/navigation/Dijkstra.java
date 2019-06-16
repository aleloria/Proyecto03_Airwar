package navigation;
import java.util.Arrays;

import data.structures.Graph;
import data.structures.Node;
import data.structures.VertexList;

public class Dijkstra {
	
	private VertexList[] vertexList = new VertexList[1];
	private Integer[] unvisited = new Integer[1];
	private Integer vertexAmount = 0;
	private VertexList path = new VertexList();
	private Integer[] distances = new Integer[1];
	private Integer[] previousVertex = new Integer[1];
	private boolean hasElements= true;
	
	
	
	
	public Dijkstra(Graph graph, Integer start) {
		
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
		
		begin();

	}

	private void begin() {
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
			System.out.println();
			
		}
		
		
	}

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
		
	
	
	

	private void checkForElements() {
		for(Integer index=0;index<this.unvisited.length;index++) {
			if(this.unvisited[index]!=-1) {
				this.hasElements=true;
			}
		}
	}

	public Integer[] getUnvisited() {
		return unvisited;
	}
	public Integer getVertexAmount() {
		return vertexAmount;
	}
	public VertexList getPath() {
		return path;
	}
	
	
	
	
	

}
