package GUI;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

import com.logic.Location;
import com.logic.Plane;
import com.logic.SpotPos;

import data.structures.Dijkstra;
import data.structures.Graph;



public class MovementGUI extends JFrame implements KeyListener, ActionListener, Runnable{


	public Image backgroundImg = new ImageIcon("Images\\Map01.jpeg").getImage();
	int x= 10, y=400 , velX=0 , actualVel=0, newVel = 0;
	protected static Graphics2D dbg;
	protected static Image dbImage, load;
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();

	AntiAircraft AA = new AntiAircraft();
	Bullet bullet = new Bullet();

	Boolean attacking = false;
	Boolean reachDestination = true;
	long keyPressLength;
	//generator 
	public SpotPos S_Pos[] = new SpotPos[19];
	public int SpotType;
	public Plane planes[];

	//keypress
	private long keyPressedMillis;
	private boolean alreadyPassed=false;

	//plane animation
	Timer tm = new Timer(10,this);

	//graph
	public Graph graph;

	//points 
	int points=0;


	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();


		if (keyCode == e.VK_SPACE ) {
			if(alreadyPassed==false) {
				keyPressedMillis = System.currentTimeMillis();
				alreadyPassed=true;
			}
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == e.VK_SPACE ) {
			keyPressLength = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - keyPressedMillis)+1;
			attacking = true;
			Bullet bullets = new Bullet();
			bullets.setPosX(AA.getPosX());


			bullets.setKeyPressLength(keyPressLength);
			bulletList.add(bullets);
			alreadyPassed=false;
			//System.out.println("Key Pressed "+keyPressLength+" s");
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

		if (AA.getPosX()==1124) {

			setVelX(-4);

		}

		AA.setPosX(AA.getPosX()+velX);

	}
	private void movingBullet(){

		for(int i=0; i<bulletList.size();i++) {

			if (bulletList.get(i).getPosY() > 5){

				actualVel = bulletList.get(i).getVelyFire();
				bulletList.get(i).setVelyFire((int) (3* -bulletList.get(i).getKeyPressLength()));
				bulletList.get(i).setPosY(bulletList.get(i).getPosY()+bulletList.get(i).getVelyFire());


			}
			else {
				if(!bulletList.isEmpty()) {
					bulletList.remove(i);

				}

			}
		}



	}



	protected int getVelX() {
		return velX;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		for(Plane x: planes){
			if(!x.isKill()) {
				int[] posFinal = {S_Pos[x.getActualVertex()].getposX(),S_Pos[x.getFinalVertex()].getposy()};
				int posX = x.getPosX();
				int posY = x.getPosY();

				double deltaX = posFinal[0] - posX;
				double deltaY = posFinal[1] - posY;
				double angle = Math.atan2( deltaY, deltaX );	

				posX +=  Math.round(Math.cos( angle ));
				posY +=  Math.round(Math.sin( angle ));			
				x.setPosX(posX);
				x.setPosY(posY);
				int[] actualPos = {x.getPosX(),x.getPosY()};
				if(posFinal[0]==actualPos[0] && posFinal[1]==actualPos[1] ) {
					int max = x.path.length-1;
					if(x.index < max) {
						x.setNextActualVertex();
					}
					
				}
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
		this.graph = new Graph(19);
		locationGenerator(20);
		graph.randomPathGenerator(this.S_Pos);
		//lbl
		planesGenerator(20);
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
		g.setFont(new Font("Impact", Font.BOLD,24));
		g.drawString(Integer.toString(points), 1200, 50);
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
			if(!x.isKill()) {
				g.drawImage(x.getImageData(),x.getPosX(),x.getPosY(), null);
				x.setReac(new Rectangle(x.getPosX(),x.getPosY(),32,32));
			}
		}
		//Canon
		//g.drawRect(AA.getPosX()-1, AA.getPosY()-4, 167, 197);
		g.drawImage(AA.getImageData(),AA.getPosX(), AA.getPosY(), null);

		for(int i=0; i<bulletList.size();i++) {
			if(bulletList.get(i).getVelyFire()<-5) {
				g.drawImage(bulletList.get(i).getBullet2(),bulletList.get(i).getPosX(), bulletList.get(i).getPosY(), null);
				//g.setColor(Color.WHITE);
				//g.drawRect(bulletList.get(i).getPosX()+28 , bulletList.get(i).getPosY()+10, 43, 50);
				bulletList.get(i).setRect(new Rectangle(bulletList.get(i).getPosX()+28,bulletList.get(i).getPosY()+10,43, 50));
			}
			else {
				g.drawImage(bulletList.get(i).getBulletImg(),bulletList.get(i).getPosX(), bulletList.get(i).getPosY(), null);
				//g.setColor(Color.WHITE);
				//g.drawRect(bulletList.get(i).getPosX()+18 , bulletList.get(i).getPosY()+10, 21, 20);
				bulletList.get(i).setRect(new Rectangle(bulletList.get(i).getPosX()+18,bulletList.get(i).getPosY()+10,21,20));
			}
		}


		collision();
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
		for(int i=0;i<max;i++) {
			Plane p = new Plane();
			p.setPosX(S_Pos[p.getStratVertex()].getposX()); 
			p.setPosY(S_Pos[p.getStratVertex()].getposy());
			this.planes[i] = p;
			Dijkstra d = new Dijkstra(this.graph,p.getStratVertex(),p.getFinalVertex());
			p.path = d.path;
		}
	}

	public void collision() {
		for(Plane x: planes){
			for(int i=0; i<bulletList.size();i++) {
				if(x.getReac().intersects(bulletList.get(i).getRect())) {
					x.setKill(true);
					this.points += 1;
					System.out.println(points);
				}
			}
		}
	}
}






