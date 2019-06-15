package com.logic;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Location extends JPanel {
	public Image Image = new ImageIcon("imagenes\\airport.png").getImage();
	

	public Location (int x, int y) {
		System.out.println("generator");
		setBounds(x, y, 32, 32);
	}
}
