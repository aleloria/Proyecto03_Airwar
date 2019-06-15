package com.logic;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Plane {
	private int posX;
    private int posY;
    private Image Image = new ImageIcon("Images/plane.png").getImage();

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

}
