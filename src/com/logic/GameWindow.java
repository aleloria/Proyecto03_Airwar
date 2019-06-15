package com.logic;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import com.logic.SpotPos;

public class GameWindow {

	private JFrame frame;
	public JPanel contentpaint;
	public SpotPos S_Pos[] = new SpotPos[20];
    public int SpotType;
	
	private int x=128; int y=720;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow window = new GameWindow();
					window.locationGenerator(20);
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
		for(int i=1;i<max;i++) {
			int x = this.x/2;
			int y = (int)(Math.random() * 500 + 1);
			if(x<460 || x>900) {
				SpotType=0;
			}else {
				if(x>520 && x<880) {
					SpotType=1;
				}
			}
			S_Pos[i-1] = new SpotPos(x,y,SpotType);
			S_Pos[i-1].showPos();
			Location location = new Location(x,y, SpotType);
			contentpaint.add(location);
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
		JPanel p = new JPanel();
		p.setBounds(2, 2, 1280, 720);
		JLabel background =new JLabel();
		background.setBounds(2, 2, 1280, 720);
		background.setIcon(new ImageIcon(backgroundImg));		
		p.add(background);
		p.setLayout(null);
		frame.getContentPane().add(p);
		contentpaint = p;
		frame.setVisible(true);
		
	}

}
