package GUI;

import javax.swing.*;
import java.awt.*;

public class AntiAircraft {

    int posX ;
    private int posY;
    private int Lives = 3;
    private Image Image = new ImageIcon("Images/naveChechis.png").getImage().getScaledInstance(119,119,1);

    private Image bullet = new ImageIcon("Images/laser.gif").getImage().getScaledInstance(40,70,1);

    public AntiAircraft(){
        posX=4;
        posY=550;
    }

    public int getPosX(){
        return posX;
    }

    public void setPosX(int x){
        posX=x;
    }

    public int getPosY(){
        return posY;
    }

    public void setPosY(int y){
        posY=y;
    }

    public int getLives(){
        return Lives;
    }

    public void setLives(int life){
        Lives=life;
    }

    public  Image getImageData(){
        return Image;
    }


}
