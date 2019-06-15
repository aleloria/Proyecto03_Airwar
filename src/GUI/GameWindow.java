package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.logic.Location;
import com.sun.org.apache.xerces.internal.impl.xs.XMLSchemaLoader.LocationArray;

public class GameWindow extends JFrame {

	private static JPanel contentPane;
	//places in the map, airports or aircraft carrier 
	static int[]  locationsArray;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow frame = new GameWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameWindow() {
		setTitle("Proyecto 3 AIRWAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1290, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Image backgroundImg = new ImageIcon("Images\\Map01.jpeg").getImage();
		contentPane.setLayout(null);
		JLabel background =new JLabel("");
		background.setBounds(2, 2, 1280, 720);
		background.setIcon(new ImageIcon(backgroundImg));		
		contentPane.add(background);	
		background.addMouseListener(new MapRanger(background));

		setContentPane(contentPane);
	}	
}

//--------------------------------------******************************-----------------------------------------------
class MapRanger extends MouseAdapter{

	JLabel label;
	Rectangle[] rects;

	public MapRanger(JLabel label){

		this.label = label;
	}

	/**
	 *               earth | water | earth 
	 *  Places:        0   |   1   |   2
	 *                     |       |
	 */
	private void initRects(){

		Rectangle r = label.getBounds();
		Icon icon = label.getIcon();
		int iconWidth = icon.getIconWidth();
		int iconHeight = icon.getIconHeight();
		int x = (r.width - iconWidth);
		int y = (r.height - iconHeight);
		int w = iconWidth/3;
		int h = iconHeight;
		rects = new Rectangle[3];
		rects[0] = new Rectangle(x, y, w, h);
		rects[1] = new Rectangle(x + w, y, w, h);
		rects[2] = new Rectangle(x + (2*w), y, w, h);

	}

	public void mousePressed(MouseEvent e){

		// wait until component is realized to ensure
		// we get valid bounds information for 'rects'
		if(rects == null)
			initRects();
		java.awt.Point p = e.getPoint();
		System.out.println("point = " + p);
		for(int j = 0; j < rects.length; j++)
			if(rects[j].contains(p)){
				System.out.println("quadrant = " + j);
				break;
			}
	}



}
