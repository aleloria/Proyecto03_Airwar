package data.structures;

// TODO: Auto-generated Javadoc
/**
 * The Class VertexList.
 */
public class VertexList {
	
	/** The vertex. */
	private Integer vertex=0;
	
	/** The head. */
	private Node head;
	
	/** The last. */
	private Node last;
	
	/** The length. */
	private Integer length=0;
	
	
	
	
	
	
	/**
	 * Gets the vertex.
	 *
	 * @return the vertex
	 */
	public Integer getVertex() {
		return vertex;
	}


	/**
	 * Sets the vertex.
	 *
	 * @param vertex the new vertex
	 */
	public void setVertex(Integer vertex) {
		this.vertex = vertex;
	}


	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	public Integer getLength() {
		return length;
	}


	/**
	 * Sets the length.
	 *
	 * @param length the new length
	 */
	public void setLength(Integer length) {
		this.length = length;
	}


	/**
	 * Gets the head.
	 *
	 * @return the head
	 */
	public Node getHead() {
		return head;
	}


	/**
	 * Sets the head.
	 *
	 * @param head the new head
	 */
	public void setHead(Node head) {
		this.head = head;
	}



	/**
	 * Gets the last.
	 *
	 * @return the last
	 */
	public Node getLast() {
		return last;
	}



	/**
	 * Sets the last.
	 *
	 * @param last the new last
	 */
	public void setLast(Node last) {
		this.last = last;
	}



	/**
	 * Append.
	 *
	 * @param vertex the vertex
	 * @param weight the weight
	 */
	public void append(Integer vertex, Integer weight) {

		if(this.head==null) {
			Node newNode= new Node(vertex, weight);
			this.setHead(newNode);
			this.setLast(newNode);
			this.length++;
			return;
		}else{
			Node newNode= new Node(vertex,weight);
			this.last.setNext(newNode);
			this.last=this.last.getNext();
			this.length++;
			return;
		}
		

	}
	
	/**
	 * Erase data.
	 *
	 * @param value the value
	 */
	public void eraseData(Integer value) {
		if (head.getData()[0].equals(value)) {
			this.head=this.head.getNext();
			this.length=this.length-1;
		}else{
			Node current = head;
			while (current!= null) {
				if(current.getData()[0].equals(value)) {
					current.setNext(current.getNext());
					this.length=this.length-1;
					if(this.last==null) {
						this.last=current;
					}
					return;
				}
				current = current.getNext();

			}
		}


	}
	
	/**
	 * Search.
	 *
	 * @param criteria the criteria
	 * @return true, if successful
	 */
	public boolean search(int criteria) { 
		boolean result=false;
		Node current = this.head;
		while (current != null) { 
			if (current.getData()[0].compareTo(criteria)==0) {
				System.out.println("FOUND");
				result=true;
				break;
			}
			current=current.getNext();
		}

		if(result==false) {
			System.out.println("NOT FOUND");
		}

		return result;     
	}
	
	/**
	 * Traverse list.
	 */
	public void traverseList() {
		String data="";
		for(Node current=this.head;current!=null;current=current.getNext()) {
			data=data+" ="+current.getData()[1]+"=>  |" +current.getData()[0]+"|";

		}
		System.out.println("\n"+data+"\n");

	}

}
