package data.structures;

public class Main {

	public static void main(String[] args) {
		
		Graph graph = new Graph(6);
		
		graph.randomPathGenerator();
		
		for(int index=0;index<graph.getVertexAmount();index++) {
			graph.getVertexList()[index].traverseList();
		}
	}

}
