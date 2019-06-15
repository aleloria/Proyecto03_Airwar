package com.logic;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameWindow {

	private JFrame frame;
	public JPanel contentpaint;
	
	private int x=128; int y=720;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow window = new GameWindow();
					window.locationGenerator(18);
//					window.locationGenerator(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameWindow() {
		initialize();
	}

	public void locationGenerator(int max) {
		for(int i=1;i<=max;i++) {
			int x = this.x/2;
			int y = (int)(Math.random() * 500 + 1); 
			Location location = new Location(x,y);
			frame.getContentPane().add(location);
			this.x +=128;
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image backgroundImg = new ImageIcon("Images\\Map01.jpeg").getImage();
		JLabel background = new JLabel();
		background.setBounds(2, 2, 1280, 720);
		background.setIcon(new ImageIcon(backgroundImg));		
		frame.getContentPane().add(background);
		frame.setVisible(true);
		
	}

}
