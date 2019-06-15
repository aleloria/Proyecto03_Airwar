package com.logic;

import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;

public class Location extends JPanel {
	public Image Image01 = new ImageIcon("Images\\airport.png").getImage();
	public Image Image02 = new ImageIcon("Images\\plane.png").getImage();

	public Location (int x, int y, int place) {
		setBounds(x, y, 32, 32);
		setLayout(new BorderLayout(0, 0));
		setBackground(Color.gray);
		JLabel l = new JLabel();
		if(place == 0) {
			l.setIcon(new ImageIcon(Image01));
		}
		if(place == 1) {
			l.setIcon(new ImageIcon(Image02));
		}
		
		add(l, BorderLayout.CENTER);
	}
}
