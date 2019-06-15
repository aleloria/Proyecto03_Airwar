package GUI;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyActionDetector extends KeyAdapter{

	AntiAircraft AA = new AntiAircraft();
	public KeyActionDetector(AntiAircraft AA) {
		// TODO Auto-generated constructor stub
		this.AA = AA;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_LEFT) {
			
			AA.setPosX(AA.getPosX()-3);
		}
		else if(code == KeyEvent.VK_RIGHT) {
			AA.setPosX(AA.getPosX()+3);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
