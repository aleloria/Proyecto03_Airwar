package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

import com.logic.Location;
import com.logic.Plane;
import com.logic.SpotPos;



public class MovementGUI extends JFrame implements KeyListener, ActionListener, Runnable{


	public Image backgroundImg = new ImageIcon("Images\\Map01.jpeg").getImage();
	int x= 10, y=400 , velX=0 , velYFire=0;
	protected static Graphics2D dbg;
	protected static Image dbImage, load;

	AntiAircraft AA = new AntiAircraft();
	Bullet bullet = new Bullet(0);

	Boolean attacking = false;
	//generator 
	public SpotPos S_Pos[] = new SpotPos[19];
	public int SpotType;
	public Plane planes[];
	
	//plane animation
	Timer tm = new Timer(10,this);



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
			bullet.setPosX(AA.getPosX());
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
				velYFire = 0;
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
//		x = x + velX;
//		p.setPosX(x + velX);
		for(Plane x: planes){
			x.setPosX(x.getPosX()+x.getVelX());
		}
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
		locationGenerator(20);
		planesGenerator(5);
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
		//Background
		g.drawImage(backgroundImg,2, 2, null);
		//Locations
		for(SpotPos i:S_Pos) {
			while(i!=null) {
				Location loc = new Location(i.getposX(),i.getposy(),i.getspot());
				g.drawImage(loc.getImg(),i.getposX(), i.getposy(), null);
				break;
			}
		}
		//Planes
		for(Plane x: planes){
			g.drawImage(x.getImageData(),x.getPosX(),x.getPosY(), null);
		}
		//Canon
		g.drawRect(AA.getPosX()-1, AA.getPosY()-4, 167, 197);
		g.drawImage(AA.getImageData(),AA.getPosX(), AA.getPosY(), null);
		if(attacking) {
			g.drawImage(bullet.getBulletImg(),bullet.getPosX(), AA.getPosY()+velYFire, null);
			g.drawRect(bullet.getPosX()+18 , bullet.getPosY()+10, 21, 20);

		}
		tm.start();
		repaint();
	}

	public void locationGenerator(int max) {
		for(int i=1;i<max;i++) {
			int x = this.x/2;
			int y = (int)(Math.random() * 500 + 32);
			if(x<460 || x>900) {
				SpotType=0;
			}else {
				if(x>511 && x<880) {
					SpotType=1;
				}
			}
			S_Pos[i-1] = new SpotPos(x,y,SpotType,i);
			S_Pos[i-1].showPos();
			//			Location location = new Location(x,y, SpotType);
			//			contentpaint.add(location);
			this.x +=128;
		}


	}
	public void planesGenerator(int max) {
		this.planes = new Plane[max];
		for(int i =0;i<max;i++) {
			Plane p = new Plane();
			p.setPosX(S_Pos[p.getStratVertex()].getposX()); 
			p.setPosY(S_Pos[p.getStratVertex()].getposy());
			this.planes[i] = p;
		}
	}






}