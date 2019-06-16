package GUI;

import javax.swing.*;
import java.awt.*;

public class Bullet {
	 private Image bullet = new ImageIcon("Images/Bullet.gif").getImage().getScaledInstance(60,60,1);
    public int posX,posY = 550;;

    public Bullet(){
        //this.posX=x;
        //this.posY=y;
    

    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public java.awt.Image getBulletImg() {
        return bullet;
    }
}
