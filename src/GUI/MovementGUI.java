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



public class MovementGUI extends JFrame implements KeyListener, ActionListener, Runnable{



	int x= 10, y=400 , velX=0 , velYFire=0;
	protected static Graphics2D dbg;
	protected static Image dbImage, load;
	
	AntiAircraft AA = new AntiAircraft();
	Bullet bullet = new Bullet(0);

	Boolean attacking = false;



	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == e.VK_LEFT) {
			setVelX(-4);

		}
		if (keyCode == e.VK_RIGHT) {

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
			
			attacking = true;
		}

	}
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(true){

				moving();
				movingBullet();
				Thread.sleep(10);
			}
		}catch(Exception e){
			System.out.println("!Uh-oh, something went wrong!.");
			System.out.println(e);
		}

	}
	private void moving() throws InterruptedException {
		if(AA.getPosX()>=0 && AA.getPosX()<=1100) {
			AA.setPosX(AA.getPosX()+velX);

		}
		else{
			if(AA.getPosX()<0) {

				velX = 0;
				AA.setPosX(0);
			}
			else if (AA.getPosX()>1100) {
				velX = 0;
				AA.setPosX(1100);
			}

		}


	}
	private void movingBullet() throws InterruptedException {
		if(attacking) {
			System.out.println(bullet.getPosY());
			if (bullet.getPosY() > 5){
			
				velYFire -= 4;
				bullet.setPosY(AA.getPosY()+velYFire);
			
			}
			else {
			
				bullet.setPosY(AA.getPosY());
				velYFire =0;
				attacking = false;
		
			
			}

		}

	}
	protected int getVelX() {
		return velX;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public int getVelYFire() {
		return velYFire;
	}

	public void setVelYFire(int velYFire) {
		this.velYFire = velYFire;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	public MovementGUI() {
		// TODO Auto-generated constructor stub

		addKeyListener(this);
		setLayout(null);
		setTitle("Airwar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1360,762);
		setResizable(false);
		setVisible(true);
		Thread t=new Thread() {
			public void run() {
				//the following line will keep this app alive for 1000 seconds,
				//waiting for events to occur and responding to them (printing incoming messages to console).
				try {Thread.sleep(15);} catch (InterruptedException ie) {}
			}
		};
		t.start();
		System.out.println("Started");



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
		if(attacking) {
			g.drawImage(bullet.getBulletImg(),AA.getPosX(), AA.getPosY()+velYFire, null);
			g.drawRect(AA.getPosX(), bullet.getPosY(), 20, 20);

		}
		repaint();
	}





}