package com.logic;

import javax.swing.JFrame;

import GUI.MovementGUI;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		PlaneMove p = new PlaneMove();
		f.add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 700);

	}

}
