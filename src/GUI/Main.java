package GUI;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MovementGUI p = new MovementGUI();
		Thread t1 = new Thread(p);
        t1.start();
		
	}

}
