package data.structures;

import java.util.concurrent.ThreadLocalRandom;

public class Graph {
	
	private Integer vertexAmount;
	private VertexList vertexList[];
	
	
	
	public Integer getVertexAmount() {
		return vertexAmount;
	}



	public void setVertexAmount(Integer vertexAmount) {
		this.vertexAmount = vertexAmount;
	}



	public VertexList[] getVertexList() {
		return vertexList;
	}



	public void setVertexList(VertexList[] vertexList) {
		this.vertexList = vertexList;
	}



	Graph(Integer amount){
		
		this.vertexAmount = amount;
		this.vertexList = new VertexList[this.vertexAmount];
		
		for(int index=0; index< this.vertexAmount; index++) {
			this.vertexList[index] = new VertexList();
		}
	}
	
	
	 public void addEdge(int weight, int source, int destination) { 

	        this.vertexList[source].append(destination, weight);
	        this.vertexList[destination].append(source, weight);
	    } 
	 
	 public void randomPathGenerator() {
		 int swaps=0;
		 int[] picker = new int[this.vertexAmount];
		 for(int index=0;index<this.vertexAmount;index++) {
			 picker[index]=index;
		 }
		 for(int vertex = 0; vertex<this.vertexAmount;vertex++) {
			 if(swaps==picker.length) {
				 break;
			 }else{
				 boolean success=false;
				 int counter=0;
				 while(success==false) {
					 if(counter==1000) {
						 break;
					 }
					 int randomIndex = ThreadLocalRandom.current().nextInt(0, this.vertexAmount);
					 System.out.println("Trying to add index " + randomIndex+ " which contains the value: "+picker[randomIndex] +" to vertex number "+ vertex);
					 if(picker[randomIndex]==-1 || picker[randomIndex]==vertex) {
						 success=false;
						 counter++;
						 
						 }else if(this.vertexList[vertex].search(picker[randomIndex])) {
							 success=false;
							 counter++;
							 
						 }else{
							 System.out.println("success");
							 int destination=picker[randomIndex];
							 this.addEdge(10, vertex, destination);
							 picker[randomIndex]=-1;
							 swaps++;
							 success=true;
						 }
						
					 }
				 }
			 }
		 }
		 
		 
		 
	 }
