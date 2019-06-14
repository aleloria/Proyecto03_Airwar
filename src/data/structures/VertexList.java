package data.structures;


public class VertexList {
	
	private Node head;
	private Node last;


	public Node getHead() {
		return head;
	}


	public void setHead(Node head) {
		this.head = head;
	}



	public Node getLast() {
		return last;
	}



	public void setLast(Node last) {
		this.last = last;
	}



	public void append(Integer vertex, Integer weight) {

		if(this.head==null) {
			Node newNode= new Node(vertex, weight);
			this.setHead(newNode);
			this.setLast(newNode);
			return;
		}else{
			Node newNode= new Node(vertex,weight);
			this.last.setNext(newNode);
			this.last=this.last.getNext();
			return;
		}
		

	}
	
	public void traverseList() {
		String data="";
		for(Node current=this.head;current!=null;current=current.getNext()) {
			data=data+" ==> "+current.getData()[0];

		}
		System.out.println("Current state of list:\n"+data+" ==> ");

	}

}
