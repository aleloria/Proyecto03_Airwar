package GUI;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		MovementGUI p = new MovementGUI();
		f.add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 700);
	}

}
