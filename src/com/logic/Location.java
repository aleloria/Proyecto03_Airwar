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
	public Image Image = new ImageIcon("Images\\airport.png").getImage();
	

	public Location (int x, int y) {
		setBounds(x, y, 32, 32);
		setLayout(new BorderLayout(0, 0));
		setBackground(Color.gray);
		JLabel l = new JLabel();
		l.setIcon(new ImageIcon(Image));
		add(l, BorderLayout.CENTER);
	}
}
