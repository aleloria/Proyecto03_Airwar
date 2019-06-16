package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

import com.logic.Location;
import com.logic.Plane;
import com.logic.SpotPos;



public class MovementGUI extends JFrame implements KeyListener, ActionListener, Runnable{


	private Image Map = new ImageIcon("Images/Map01.jpeg").getImage();
	int x= 10, y=400 , velX=0 , velYFire=0;
	protected static Graphics2D dbg;
	protected static Image dbImage, load;
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();

	AntiAircraft AA = new AntiAircraft();
	Bullet bullet = new Bullet();

	Boolean attacking = false;
	//generator 
	public SpotPos S_Pos[] = new SpotPos[19];
	public int SpotType;
	public Plane planes[];
	
	//plane animation
	Timer tm = new Timer(10,this);

	Boolean reachDestination = true;


	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == e.VK_LEFT) {

		}
		if (keyCode == e.VK_RIGHT) {



		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == e.VK_LEFT) {

		}
		if (keyCode == e.VK_RIGHT) {


		}

		if (keyCode == e.VK_SPACE ) {

			attacking = true;
			bullet.setPosX(AA.getPosX());
			if(reachDestination) {
				attacking = true;
				bullet.setPosX(AA.getPosX());
				Bullet bullets = new Bullet();
				bulletList.add(bullets);
			}
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
	
		if(AA.getPosX()==4) {
			setVelX(4);


		}

		if (AA.getPosX()==1104) {

			setVelX(-4);

		}

		AA.setPosX(AA.getPosX()+velX);

	}
	private void movingBullet() throws InterruptedException {
		if(attacking) {
		
			if (bullet.getPosY() > 5){

				reachDestination = false;
				velYFire -= 4;
				bullet.setPosY(AA.getPosY()+velYFire);

			}
			else {

				bullet.setPosY(AA.getPosY());
				velYFire = 0;
				attacking = false;
				reachDestination = true;


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
		for(Plane x: planes){
			int[] posFinal = {S_Pos[x.getFinalVertex()].getposX(),S_Pos[x.getFinalVertex()].getposy()};
			int posX = x.getPosX();
			int posY = x.getPosY();
			if(posX>posFinal[0]) {
				x.setPosX(posX - x.getVelX());
			}if(posX<posFinal[0]) {
				x.setPosX(posX + x.getVelX());
			}if(posY>posFinal[1]) {
				x.setPosY(posY - x.getVelY());
			}if(posY<posFinal[1]) {
				x.setPosY(posY + x.getVelY());
			}
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
		// TODO Auto-generated method stub

		g.drawImage(Map,0, 0, null);
		g.drawImage(AA.getImageData(),AA.getPosX(), AA.getPosY(), null);

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


		if(attacking) {
			for(int i =0;i<2;i++) {
				g.drawImage(bullet.getBulletImg(),bullet.getPosX()+(i*100), AA.getPosY()+velYFire, null);
				g.setColor(Color.WHITE);
				g.drawRect(bullet.getPosX()+(i*100)+18 , bullet.getPosY()+10, 21, 20);
			}
		}
		repaint();
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