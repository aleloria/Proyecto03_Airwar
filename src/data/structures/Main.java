package data.structures;


public class Main {

	public static void main(String[] args) {

		Graph graph = new Graph(3);
		

		graph.randomPathGenerator();

		for(int index=0;index<graph.getVertexAmount();index++) {
			System.out.println("FOR VERTEX "+ index);
			graph.getVertexList()[index].traverseList();
		}


	}
}
