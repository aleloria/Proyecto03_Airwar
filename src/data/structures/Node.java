package data.structures;

public class Node{
	
	private Integer[] data = new Integer[2];
	private Node next;
	
	
	public Integer[] getData() {
		return data;
	}
	public void setData(Integer[] data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node(Integer vertex,Integer weight) {
		this.data[0]=vertex;
		this.data[1]=weight;

	}
	
	
	
	
	
}
