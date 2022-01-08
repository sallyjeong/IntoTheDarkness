/* * * * * Imports * * * * */
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * [Bullet.java]
 * This class creates a single bullet
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class Bullet implements Drawable {
    private int x;
    private int y;
    private boolean visible;
    private int direction;
    private BufferedImage sprite;
    private Rectangle hitbox;

    /**
     * Constructs a new bullet
     * @param x An integer holding the x coordinate of the bullet
     * @param y An integer holding the y coordinate of the bullet
     * @param direction An integer holding the direction the bullet is going
     */
    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.hitbox = new Rectangle(x, y, 50, 50);
        visible = true;
        loadSprite();
    }
    
    /**
     * loadSprite
     * This method loads the corresponding sprite for each bullet and its direction
     */
    public void loadSprite() {
        try {
            if (direction == 1) { //up
                sprite = ImageIO.read(new File("graphics\\fireballup.png"));
            } else if (direction == 2) { //left
                sprite = ImageIO.read(new File("graphics\\fireballleft.png"));
            } else if (direction == 3) { //down
                sprite = ImageIO.read(new File("graphics\\fireballdown.png"));
            } else if (direction == 4) { //right
                sprite = ImageIO.read(new File("graphics\\fireballright.png"));
            }
        } catch (Exception e) {
            System.out.println("error loading sprite");
        }
    }

    /**
     * getHitbox
     * @return Rectangle, returns the hitbox of the bullet
     */
    public Rectangle getHitbox() {
        return this.hitbox;
    }
    
    /**
     * update
     * This method updates the location of the bullet and its hitbox
     */
    public void update() {
        if (visible) {
            if (direction == 1) {
                y -= 10;
                if (y <= 0) {
                    visible = false;
                }
            } else if (direction == 2) {
                x -= 10;
                if (x <= 0) {
                    visible = false;
                }
            } else if (direction == 3) {
                y += 10;
                if (y >= 768) {
                    visible = false;
                }
            } else if (direction == 4) {
                x += 10;
                if (x >= 1024) {
                    visible = false;
                }
            }
            this.getHitbox().x = this.x;
            this.getHitbox().y = this.y;
        }

    }

    /**
     * isVisible
     * @return boolean, returns if the bullet is visible or not
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * draw
     * This method draws the bullet
     * @param g Graphics for drawing
     */
    public void draw(Graphics g) {
        if (visible) {
            g.drawImage(sprite, x, y, null);
        }
    }

}