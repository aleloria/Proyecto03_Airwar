package data.structures;

import java.util.HashMap;
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
		
		for(Integer index=0; index< this.vertexAmount; index++) {
			this.vertexList[index] = new VertexList();
			this.vertexList[index].setVertex(index);
		}
	}
	
	
	 public void addEdge(int weight, int source, int destination) { 

	        this.vertexList[source].append(destination, weight);
	        this.vertexList[destination].append(source, weight);
	    } 
	 
	 public void randomPathGenerator() {
		 int swaps=0;
		 for(int vertex = 0; vertex<this.vertexAmount;vertex++) {
			 if(swaps==this.vertexAmount*2) {
				 break;
			 }else{
				 boolean success=false;
				 int counter=0;
				 while(success==false) {
					 if(counter==10000) {
						 break;
					 }
					 int randomIndex = ThreadLocalRandom.current().nextInt(0, this.vertexAmount);
					 int randomWeigth = ThreadLocalRandom.current().nextInt(0, 21);
					 System.out.println("Trying to connect  " + randomIndex+ " to vertex number "+ vertex);
					 if(randomIndex==vertex) {
						 success=false;
						 counter++;
						 
						 
						 }else if(this.vertexList[vertex].search(randomIndex)) {
							 success=false;
							 counter++;
							 
						 }else{
							 System.out.println("success");
							 int destination=randomIndex;
							 this.addEdge(randomWeigth, vertex, destination);
							 swaps++;
							 success=true;
						 }
						
					 }
				 }
			 }
		 }
	 
	 	 
}
