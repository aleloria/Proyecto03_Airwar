package data.structures;

import java.util.Arrays;

import navigation.Dijkstra;

public class Main {

	public static void main(String[] args) {

		Graph graph = new Graph(5);
		graph.randomPathGenerator();
		for(int index=0;index<graph.getVertexAmount();index++) {
			System.out.println("FOR VERTEX "+ index);
			graph.getVertexList()[index].traverseList();
		}
		Dijkstra path = new Dijkstra(graph, 2);
		
		

		
			
		
	}
}
