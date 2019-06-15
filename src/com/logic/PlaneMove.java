package com.logic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PlaneMove extends JPanel implements ActionListener {
	Timer tm = new Timer(10,this);
	Plane p = new Plane();
	int x = 0; 
	int velX =  1;
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawRect(x, 100, 36, 36);
		g.drawImage(p.getImageData(),p.getPosX(), 100, null);
//		g.setColor(Color.red);
//		g.fillRect(x, 30, 50, 30);
		
		tm.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		x = x + velX;
		p.setPosX(x + velX);
		repaint();

	}

}
