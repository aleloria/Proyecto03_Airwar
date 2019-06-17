package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class StartWindow extends JFrame {

	public static void main(String[] args) {
		StartWindow frame = new StartWindow();
	}
	private Image Image = new ImageIcon("Images/Start_Window.jpeg").getImage();
	private Image play = new ImageIcon("Images/play.png").getImage();
	private JPanel contentpane;
	
	
	public StartWindow() {
		setLayout(null);
		setTitle("Airwar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50,50,850,478);
		setUndecorated(true);
		setResizable(true);
		setVisible(true);
		

		
		contentpane = new JPanel();
		contentpane.setBounds(0,0,850,478);
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentpane.setLayout(null);
		
		JLabel background = new JLabel();
		background.setBounds(0, 0, 850, 478);
		background.setIcon(new ImageIcon(Image));
		
		JButton btn = new JButton();
		btn.setBounds(350, 235, 128,128);
		btn.setIcon(new ImageIcon(play));
		btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MovementGUI p = new MovementGUI();
				Thread t1 = new Thread(p);
		        t1.start();
		        StartWindow.this.dispose();
			}
		});
		
		contentpane.add(btn);
		contentpane.add(background);
		this.add(contentpane);
	}
	

}
