package GUI;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import com.logic.Location;
import com.logic.Plane;
import com.logic.SpotPos;

import data.structures.Dijkstra;
import data.structures.Graph;
import data.structures.Node;
import data.structures.VertexList;




// TODO: Auto-generated Javadoc
/**
 * The Class MovementGUI.
 */
public class MovementGUI extends JFrame implements KeyListener, ActionListener, Runnable{


	/** The background img. */
	public Image backgroundImg = new ImageIcon("Images\\Map01.jpeg").getImage();
	
	/** The new vel. */
	int x= 10, y=400 , velX=0 , actualVel=0, newVel = 0;
	
	/** The dbg. */
	protected static Graphics2D dbg;
	
	/** The load. */
	protected static Image dbImage, load;
	
	/** The bullet list. */
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	
	/** The edges list. */
	ArrayList<Integer> edgesList = new ArrayList<Integer>();
	
	/** The edges list 2. */
	ArrayList<Integer> edgesList2 = new ArrayList<Integer>();
	
	/** The weight list. */
	ArrayList<Integer> weightList = new ArrayList<Integer>();
	
	/** The stats list. */
	ArrayList<String> statsList = new ArrayList<String>();
	
	/** The aa. */
	AntiAircraft AA = new AntiAircraft();
	
	/** The bullet. */
	Bullet bullet = new Bullet();

	/** The attacking. */
	Boolean attacking = false;
	
	/** The refresh. */
	Boolean refresh = true;
	
	/** The reach destination. */
	Boolean reachDestination = true;
	
	/** The key press length. */
	long keyPressLength;
	
	/** The S pos. */
	//generator 
	public SpotPos S_Pos[] = new SpotPos[19];
	
	/** The Spot type. */
	public int SpotType;
	
	/** The planes. */
	public Plane planes[];

	/** The key pressed millis. */
	//keypress
	private long keyPressedMillis;
	
	/** The already passed. */
	private boolean alreadyPassed=false;
	
	/** The pause. */
	boolean pause = false;
	
	/** The tm. */
	//plane animation
	Timer tm = new Timer(10,this);

	/** The graph. */
	//graph
	public Graph graph;

	/** The points. */
	//points 
	int points=0;
	
	/** The index. */
	int index =0;


	/**
	 * Key pressed.
	 *
	 * @param e the e
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();


		if (keyCode == e.VK_SPACE ) {
			if(alreadyPassed==false) {
				keyPressedMillis = System.currentTimeMillis();
				alreadyPassed=true;
			}
		}
		if(keyCode == e.VK_P) {
			pause = true;
		}
	}


	/**
	 * Key released.
	 *
	 * @param e the e
	 */
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
	
	/**
	 * Key typed.
	 *
	 * @param arg0 the arg 0
	 */
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Run.
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(true){
				if(pause == false) {
					moving();
					movingBullet();
					Thread.sleep(10);
				}
			}
		}catch(Exception e){
			System.out.println("!Uh-oh, something went wrong!.");
			System.out.println(e);
		}

	}
	
	/**
	 * Moving.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	private void moving() throws InterruptedException {

		if(AA.getPosX()==4) {
			setVelX(4);


		}

		if (AA.getPosX()==1124) {

			setVelX(-4);

		}

		AA.setPosX(AA.getPosX()+velX);

	}
	
	/**
	 * Moving bullet.
	 */
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



	/**
	 * Gets the vel X.
	 *
	 * @return the vel X
	 */
	protected int getVelX() {
		return velX;
	}
	
	/**
	 * Sets the vel X.
	 *
	 * @param velX the new vel X
	 */
	public void setVelX(int velX) {
		this.velX = velX;
	}

	
	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int i =0;
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
			}else {
				Plane p = new Plane();
				p.setPosX(S_Pos[p.getStratVertex()].getposX()); 
				p.setPosY(S_Pos[p.getStratVertex()].getposy());
				this.planes[i] = p;
				Dijkstra d = new Dijkstra(this.graph,p.getStratVertex(),p.getFinalVertex());
				p.path = d.path;
			}i++;
		}
	}
	
	/**
	 * Instantiates a new movement GUI.
	 */
	public MovementGUI() {
		// TODO Auto-generated constructor stub

		addKeyListener(this);
		getContentPane().setLayout(null);





		setTitle("Airwar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1400,800);
		setResizable(true);
		setVisible(true);
		this.graph = new Graph(19);
		locationGenerator(20);
		graph.randomPathGenerator(this.S_Pos);

		//lbl
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
	
	/**
	 * Paint.
	 *
	 * @param g the g
	 */
	public void paint(Graphics g){
		dbImage = createImage(1350,775);
		dbg = (Graphics2D) dbImage.getGraphics();
		dbg.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0,null);
	}
	
	/**
	 * Paint component.
	 *
	 * @param g the g
	 */
	public void paintComponent(Graphics2D g) {

		//Background
		g.drawImage(backgroundImg,2, 2, null);
		g.setFont(new Font("Impact", Font.BOLD,24));
		g.drawString(Integer.toString(points), 19, 50);
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

		for(int n = 0; n< graph.getVertexList().length; n++) {
			int intialX= S_Pos[n].getposX();
			int initialY=S_Pos[n].getposy();
			for(Node j = this.graph.getVertexList()[n].getHead(); j != null;j = j.getNext()) {
				edgesList.add(j.getData()[0]);

			}
			int counter = 0;
						int r = ThreadLocalRandom.current().nextInt(0, 256);
						int g1 = ThreadLocalRandom.current().nextInt(0, 256);
						int b = ThreadLocalRandom.current().nextInt(0, 256);
			for(int index =0; index <edgesList.size(); index++ ) {
				int indicator = edgesList.get(index);
				int destinationX = S_Pos[indicator].getposX();
				int destinationY = S_Pos[indicator].getposy();


				g.setColor(new Color(r, g1, b));
				//g.setColor(Color.WHITE);
				 //creates a copy of the Graphics instance
		        Graphics2D g2d = (Graphics2D) g.create();

		        //set the stroke of the copy, not the original 
		        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
		        g2d.setStroke(dashed);
		        g2d.drawLine(intialX+30, initialY+15+counter, destinationX+30, destinationY+15+counter);

		        //gets rid of the copy
		        g2d.dispose();
				//g.setStroke(new BasicStroke(3));
				//g.drawLine(intialX+30, initialY+15+counter, destinationX+30, destinationY+15+counter);
				counter+=10;
			}
			edgesList.clear();


		}

		g.setColor(Color.WHITE);
		g.fillRect(1205, 0, 500, 800);
		g.setColor(Color.BLACK);

		for(Integer c=0; c <19;c++) {
			for(Node j = this.graph.getVertexList()[c].getHead(); j != null;j = j.getNext()) {
				edgesList2.add(j.getData()[0]);
				weightList.add(j.getData()[1]);

			}
		
			statsList.add("Vertex: "+c.toString());
			statsList.add("E: "+edgesList2.toString());
			statsList.add("W: "+weightList.toString());
			edgesList2.clear();
			weightList.clear();
		}
		
		for(int l = 0; l<statsList.size();l++) {

			Font f = new Font("serif", Font.PLAIN,13 );
			g.setFont(f);
			g.drawString(statsList.get(l), 1207, (l*13)+42);
			repaint();
		}
		
		statsList.clear();
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

	/**
	 * Location generator.
	 *
	 * @param max the max
	 */
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
	
	/**
	 * Planes generator.
	 *
	 * @param max the max
	 */
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

	/**
	 * Collision.
	 */
	public void collision() {
		for(Plane x: planes){
			for(int i=0; i<bulletList.size();i++) {
				if(x.getReac().intersects(bulletList.get(i).getRect())) {
					x.setKill(true);
					this.points += 1;
					VertexList vertexList=this.graph.getVertexList()[x.getActualVertex()];
					for(Node vertex = vertexList.getHead(); vertex!=null;vertex=vertex.getNext() ) {
						if(vertex.getData()[0]==x.getFinalVertex()) {
							System.out.println("PESO ORIGINAL: "+vertex.getData()[1]);
							
							vertex.getData()[1]+=100;
							System.out.println("PESO NUEVOOOOO: "+vertex.getData()[1]);
							
						}
					}
				}
			}
		}
	}
}






