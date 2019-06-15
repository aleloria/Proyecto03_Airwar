package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;



public class MovementGUI extends JPanel implements ActionListener, KeyListener{
	
	javax.swing.Timer t = new javax.swing.Timer(5, this);
	
	double x= 0, y=400 , velX =0;
	AntiAircraft AA = new AntiAircraft();
	public MovementGUI() {
		// TODO Auto-generated constructor stub
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//g2.draw( (Shape) new Rectangle(x, y, 40, 40));
		g2.drawRect((int)x-1, (int)y-4, 167, 197);
		
		g.drawImage(AA.getImageData(),AA.getPosX(), AA.getPosY(), null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		x += velX;

		AA.setPosX((int)x);
		AA.setPosY((int)y);
		
		
	}
	public void left() {
		velX = -1.5;
		
		
	}
	public void right() {
		velX = 1.5;
	
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_LEFT) {
			left();
		}
		else if(code == KeyEvent.VK_RIGHT) {
			right();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		velX=0;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
