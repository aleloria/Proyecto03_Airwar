package GUI;

import javax.swing.JFrame;

import com.arduino.MovementADU;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		MovementADU p = new MovementADU();
		Thread t1 = new Thread(p);
        t1.start();
		
	}

}
