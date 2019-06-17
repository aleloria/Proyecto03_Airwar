
package data.structures;

import java.util.Arrays;

public class Main {

	static Graph graph = new Graph(19);
	static Dijkstra path;
	public static void main(String[] args) {


		graph.randomPathGenerator();
		//		for(int index=0;index<graph.getVertexAmount();index++) {
		//			System.out.println("FOR VERTEX "+ index);
		//			graph.getVertexList()[index].traverseList();
		//		}
		path = new Dijkstra(graph, 0,1);
		System.out.println("=============================================================================================================================");
		System.out.println(">>>"+Arrays.deepToString(path.path)); 



	}
}

