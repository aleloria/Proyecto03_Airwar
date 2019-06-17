package GUI;

import javax.swing.*;
import java.awt.*;

// TODO: Auto-generated Javadoc
/**
 * The Class AntiAircraft.
 */
public class AntiAircraft {

    /** The pos X. */
    int posX ;
    
    /** The pos Y. */
    private int posY;
    
    /** The Lives. */
    private int Lives = 3;
    
    /** The Image. */
    private Image Image = new ImageIcon("Images/naveChechis.png").getImage().getScaledInstance(119,119,1);

    /** The bullet. */
    private Image bullet = new ImageIcon("Images/laser.gif").getImage().getScaledInstance(40,70,1);

    /**
     * Instantiates a new anti aircraft.
     */
    public AntiAircraft(){
        posX=4;
        posY=550;
    }

    /**
     * Gets the pos X.
     *
     * @return the pos X
     */
    public int getPosX(){
        return posX;
    }

    /**
     * Sets the pos X.
     *
     * @param x the new pos X
     */
    public void setPosX(int x){
        posX=x;
    }

    /**
     * Gets the pos Y.
     *
     * @return the pos Y
     */
    public int getPosY(){
        return posY;
    }

    /**
     * Sets the pos Y.
     *
     * @param y the new pos Y
     */
    public void setPosY(int y){
        posY=y;
    }

    /**
     * Gets the lives.
     *
     * @return the lives
     */
    public int getLives(){
        return Lives;
    }

    /**
     * Sets the lives.
     *
     * @param life the new lives
     */
    public void setLives(int life){
        Lives=life;
    }

    /**
     * Gets the image data.
     *
     * @return the image data
     */
    public  Image getImageData(){
        return Image;
    }


}
