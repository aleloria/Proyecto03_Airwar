package com.logic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Location extends JPanel {
	public Image Image01 = new ImageIcon("Images\\airport.png").getImage();
	public Image Image02 = new ImageIcon("Images\\carrier.png").getImage();
	public Image img;

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public Location (int x, int y, int spot) {
		setBounds(x, y, 32, 32);
		setLayout(new BorderLayout(0, 0));
		setBackground(Color.gray);
		JLabel l = new JLabel();
		if(spot == 0) {
			l.setIcon(new ImageIcon(Image01));
			setImg(Image01);
		}
		if(spot == 1) {
			l.setIcon(new ImageIcon(Image02));
			setImg(Image02);
		}
		
		add(l, BorderLayout.CENTER);
	}
}
