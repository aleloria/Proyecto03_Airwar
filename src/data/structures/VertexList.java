package data.structures;

public class VertexList {
	
	private Integer vertex=0;
	private Node head;
	private Node last;
	private Integer length=0;
	
	
	
	
	
	
	public Integer getVertex() {
		return vertex;
	}


	public void setVertex(Integer vertex) {
		this.vertex = vertex;
	}


	public Integer getLength() {
		return length;
	}


	public void setLength(Integer length) {
		this.length = length;
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
			data=data+" ="+current.getData()[1]+"=>  |" +current.getData()[0]+"|";

		}
		System.out.println("\n"+data+"\n");

	}

}
