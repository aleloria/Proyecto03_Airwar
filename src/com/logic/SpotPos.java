package com.logic;

public class SpotPos {
	
	int posX;
	int posY;
	int spot;
	int vertex;
	
	
	public SpotPos(int posX, int posY, int spot,int vertex) {
		this.posX = posX;
		this.posY = posY;
		this.spot = spot;
		this.vertex = vertex;
	}	
	
	
	public int getposX() {
		return posX;		
	}
	
	public int getposy() {
		return posY;		
	}
	
	public int getspot() {
		return spot;		
	}
	
	public void showPos() {
		System.out.print("x="+posX);
		System.out.print(" y="+posY);
		System.out.print(" type="+spot);
		System.out.println(" vertex="+vertex);
		
		
	}
	
}
