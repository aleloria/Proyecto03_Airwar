package GUI;

import javax.swing.*;
import java.awt.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Bullet.
 */
public class Bullet {
	
	/** The bullet. */
	private Image bullet = new ImageIcon("Images/Bullet.gif").getImage().getScaledInstance(60,60,1);
	
	/** The bullet 2. */
	private Image bullet2 = new ImageIcon("Images/Bullet.gif").getImage().getScaledInstance(100,100,1);


	/** The pos Y. */
	public int posX,posY = 550;
    
    /** The vely fire. */
    public int velyFire =0;
    
    /** The rect. */
    public Rectangle rect;

    /** The key press length. */
    public long keyPressLength = 0;

	/**
	 * Gets the key press length.
	 *
	 * @return the key press length
	 */
	public long getKeyPressLength() {
		return keyPressLength;
	}

	/**
	 * Sets the key press length.
	 *
	 * @param keyPressLength the new key press length
	 */
	public void setKeyPressLength(long keyPressLength) {
		this.keyPressLength = keyPressLength;
	}

	/**
	 * Gets the vely fire.
	 *
	 * @return the vely fire
	 */
	public int getVelyFire() {
		return velyFire;
	}

	/**
	 * Sets the vely fire.
	 *
	 * @param velyFire the new vely fire
	 */
	public void setVelyFire(int velyFire) {
		this.velyFire = velyFire;
	}

	/**
	 * Instantiates a new bullet.
	 */
	public Bullet(){
        //this.posX=x;
        //this.posY=y;
		this.rect = new Rectangle();
    

    }

    /**
     * Sets the pos X.
     *
     * @param posX the new pos X
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Sets the pos Y.
     *
     * @param posY the new pos Y
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Gets the pos X.
     *
     * @return the pos X
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Gets the pos Y.
     *
     * @return the pos Y
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Gets the bullet img.
     *
     * @return the bullet img
     */
    public java.awt.Image getBulletImg() {
        return bullet;
    }

	/**
	 * Gets the rect.
	 *
	 * @return the rect
	 */
	public Rectangle getRect() {
		return rect;
	}

	/**
	 * Sets the rect.
	 *
	 * @param rect the new rect
	 */
	public void setRect(Rectangle rect) {
		this.rect.setBounds(rect);
	}
    
    /**
     * Gets the bullet 2.
     *
     * @return the bullet 2
     */
    public Image getBullet2() {
		return bullet2;
	}

	/**
	 * Sets the bullet 2.
	 *
	 * @param bullet2 the new bullet 2
	 */
	public void setBullet2(Image bullet2) {
		this.bullet2 = bullet2;
	}
    
}

