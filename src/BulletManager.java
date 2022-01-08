/* * * * * Imports * * * * */
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * [BulletManager.java]
 * This class manages the current bullets
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class BulletManager implements Drawable {
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    Bullet curBullet;

    /**
     * update
     * This method loops through the arraylist of bullets, and updates each one
     */
    public void update() {
        for (int i = 0; i < bullets.size(); i++) {
            curBullet = bullets.get(i);
            curBullet.update();
        }
    }
    
    /**
     * draw
     * This method loops through the arraylist of bullets, and draws each one
     * @param g Graphics for drawing
     */
    public void draw(Graphics g) {
        for (int i = 0; i < bullets.size(); i++) {
            curBullet = bullets.get(i);
            if(curBullet.isVisible()) {
             curBullet.draw(g);
            }else {
             this.removeBullet(curBullet);
            }
        }
    }

    /**
     * addBullet
     * adds a new bullet to the arraylist of bullets
     * @param b The newly created Bullet
     */
    public void addBullet(Bullet b) {
        bullets.add(b);
    }

    /**
     * removeBullet
     * removes a bullet from the arraylist of bullets
     * @param b The bullet that needs to be removed
     */
    public void removeBullet(Bullet b) {
        bullets.remove(b);
    }

    /**
     * getBulletArr
     * @return ArrayList<Bullet>, returns the arraylist of bullets
     */
    public ArrayList<Bullet> getBulletArr() {
        return bullets;
    }
    
}