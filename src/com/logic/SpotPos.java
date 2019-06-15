package com.logic;

public class SpotPos {
	
	int posX;
	int posY;
	int spot;
	
	
	public SpotPos(int posX, int posY, int spot) {
		this.posX = posX;
		this.posY = posY;
		this.spot = spot;
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
		System.out.println(" type="+spot);
		
		
	}
	
}
