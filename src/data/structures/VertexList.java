package data.structures;


public class VertexList {
	
	private Node head;
	private Node last;
	private Integer lenght=0;
	
	
	

	public Integer getLenght() {
		return lenght;
	}


	public void setLenght(Integer lenght) {
		this.lenght = lenght;
	}


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
			this.lenght++;
			return;
		}else{
			Node newNode= new Node(vertex,weight);
			this.last.setNext(newNode);
			this.last=this.last.getNext();
			this.lenght++;
			return;
		}
		

	}
	
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
	
	public void traverseList() {
		String data="";
		for(Node current=this.head;current!=null;current=current.getNext()) {
			data=data+" ==> "+current.getData()[0];

		}
		System.out.println("Current state of list:\n"+data+" ==> ");

	}

}
