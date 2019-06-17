package com.logic;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Plane {
	private int posX;
    private int posY;
    private int velX =1;
    private int velY =1;
    private int stratVertex;
    private int finalVertex;
    //vertex
    public Integer[] path;
    public int index = 0;
    
    //Rect
    public Rectangle reac;
    
    private Image Image = new ImageIcon("Images/plane.png").getImage();
    
    
    public boolean kill = false;
    

    public Plane() {
		road();
		this.reac = new Rectangle();
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public Image getImageData() {
		return Image;
	}
	public int getVelX() {
		return velX;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public int getVelY() {
		return velY;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public int getStratVertex() {
		return stratVertex;
	}
	public void setStratVertex(int stratVertex) {
		this.stratVertex = stratVertex;
	}
	public int getFinalVertex() {
		return finalVertex;
	}
	public void setFinalVertex(int finalVertex) {
		this.finalVertex = finalVertex;
	}
	//set road 
	public void road() {
		int start = (int)(Math.random() * 19+ 0);
		setStratVertex(start);
		int finalV = (int)(Math.random() * 19+ 0);
		while(finalV == start) {
			finalV = (int)(Math.random() * 19+ 0);
		}setFinalVertex(finalV);
	}
	public int getActualVertex() {
		return path[this.index];
	}
	public int getNext() {
		return path[this.index+1];
	}
	public void setNextActualVertex() {
		this.index += 1;
	}
	public Rectangle getReac() {
		return reac;
	}
	public void setReac(Rectangle reac) {
		this.reac.setBounds(reac);
	}
	public boolean isKill() {
		return kill;
	}
	public void setKill(boolean kill) {
		this.kill = kill;
	}
	
	

}
