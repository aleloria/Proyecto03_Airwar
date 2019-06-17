package data.structures;

/**
 * The Class Node.
 */
public class Node{
	
	private Integer[] data = new Integer[2];
	private Node next;
	
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Integer[] getData() {
		return data;
	}
	public void setData(Integer[] data) {
		this.data = data;
	}
	
	/**
	 * Gets the next.
	 *
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	/**
	 * Instantiates a new node.
	 *
	 * @param vertex the vertex
	 * @param weight the weight
	 */
	public Node(Integer vertex,Integer weight) {
		this.data[0]=vertex;
		this.data[1]=weight;

	}
	
	
	
	
	
}
