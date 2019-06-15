package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;



public class MovementGUI extends JFrame implements ActionListener, KeyListener, Runnable{

	

	int x= 0, y=400 , velX =0;
	 protected static Graphics2D dbg;
	    protected static Image dbImage, load;

	public int getVelX() {
		return velX;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}

	AntiAircraft AA = new AntiAircraft();

	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == e.VK_LEFT) {

			setVelX(-4);

		}
		if (keyCode == e.VK_RIGHT) {

			setVelX(+4);

		}
		if (keyCode == e.VK_UP) {

			setVelX(-4);

		}
		if (keyCode == e.VK_DOWN) {

			setVelX(+4);

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == e.VK_LEFT) {

			setVelX(0);
		}
		if (keyCode == e.VK_RIGHT) {

			setVelX(0);
		}

		if (keyCode == e.VK_SPACE ) {


		}

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(true){
				
				moving();
				Thread.sleep(10);
			}
		}catch(Exception e){
			System.out.println("!Uh-oh, something went wrong!.");
			System.out.println(e);
		}

	}
	private void moving() {
		AA.setPosX(AA.getPosX()+velX);
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	public MovementGUI() {
		// TODO Auto-generated constructor stub

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 700);
	
	
	}
	 public void paint(Graphics g){
	        dbImage = createImage(1324,775);
	        dbg = (Graphics2D) dbImage.getGraphics();
	        dbg.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	        paintComponent(dbg);
	        g.drawImage(dbImage, 0, 0,null);
	    }
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		

		g.drawRect(AA.getPosX()-1, AA.getPosY()-4, 167, 197);

		g.drawImage(AA.getImageData(),AA.getPosX(), AA.getPosY(), null);
		repaint();
	}


	


}