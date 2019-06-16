
package data.structures;

import java.util.Arrays;

import navigation.Dijkstra;

public class Main {
	
	static Graph graph = new Graph(10);
	
	static Dijkstra path;
	public static void main(String[] args) {
	
		
		graph.randomPathGenerator();
		for(int index=0;index<graph.getVertexAmount();index++) {
			System.out.println("FOR VERTEX "+ index);
			graph.getVertexList()[index].traverseList();
		}
		path = new Dijkstra(graph, 0,1);
		System.out.println("=============================================================================================================================");
		path = new Dijkstra(graph, 0,2);
		System.out.println("=============================================================================================================================");
		path = new Dijkstra(graph, 0,3);
		System.out.println("=============================================================================================================================");
		path = new Dijkstra(graph, 0,4);
		System.out.println("=============================================================================================================================");
		path = new Dijkstra(graph, 0,5);
		System.out.println("=============================================================================================================================");
		path = new Dijkstra(graph, 0,6);
		System.out.println("=============================================================================================================================");
		path = new Dijkstra(graph, 0,7);
		System.out.println("=============================================================================================================================");
		path = new Dijkstra(graph, 0,8);
		System.out.println("=============================================================================================================================");
		path = new Dijkstra(graph, 0,9);
		System.out.println("=============================================================================================================================");

		
		
		


		
		
//		
//		if(path.checkValidity()==false) {
//			path.begin();
//		}


		
			
		
	}
}

