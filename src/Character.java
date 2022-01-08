/* * * * * Imports * * * * */
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * [Character.java]
 * This class represents a single character in the game
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public abstract class Character implements Drawable {
    private int x, y;
    private int hp;
    private Rectangle hitbox;
    private int curSprite;
    long lastTimeCheck; //store the time of the last time the time was recorded
    long deltaTime; //to keep the elapsed time between current time and last time

    /**
     * Constructs a new character
     * @param x An integer holding the x coordinate of the character
     * @param y An integer holding the y coordinate of the character
     * @param hp An integer holding the health points of the character
     * @param curSprite An integer holding the index of the current sprite animation
     */
    public Character(int x, int y, int hp, int curSprite) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.hitbox = new Rectangle(x, y, 85, 85);
        this.curSprite = curSprite;
    }

    /**
     * loadSprite
     * loads the sprites for the character
     */
    public abstract void loadSprite();

    /**
     * playHitSound
     * plays the sound of the character getting hit
     */
    public abstract void playHitSound();

    /**
     * playDeadSound
     * plays the sound of the character dying
     */
    public abstract void playDeadSound();

    /**
     * getX
     * @return int, returns the x coordinate of the character
     */
    public int getX() {
        return this.x;
    }

    /**
     * getY
     * @return int, returns the y coordinate of the character
     */
    public int getY() {
        return this.y;
    }

    /**
     * setX
     * sets the x coordinate for the character
     */
    public void setX(int val) {
        this.x = val;
    }

    /**
     * setY
     * sets the y coordinate for the character
     */
    public void setY(int val) {
        this.y = val;
    }

    /**
     * getHitbox
     * @return Rectangle, returns the hitbox of the character
     */
    public Rectangle getHitbox() {
        return this.hitbox;
    }

    /**
     * getHp
     * @return int, returns the health points of the character
     */
    public int getHp() {
        return this.hp;
    }

    /**
     * getCurSpr
     * @return int, returns the index for the current sprite animation of the character
     */
    public int getCurSpr() {
        return this.curSprite;
    }

    /**
     * setCurSpr
     * sets the index for the next animation sprite
     * @param val The animation index that is being set to
     */
    public void setCurSpr(int val) {
        this.curSprite = val;
    }

    /**
     * loseHp
     * This method causes the current character to lose hp every certain amount of milliseconds
     * @param time The integer value representing the number of milliseconds
     */
    public void loseHp(int time) {
        long currentTime = System.currentTimeMillis();  //get the current time
        deltaTime += currentTime - lastTimeCheck; //add to the elapsed time
        lastTimeCheck = currentTime;
        if (deltaTime >= time) {
            this.hp--;
            if (hp>0){
                this.playHitSound();
            }else{
                this.playDeadSound();
            }
            deltaTime = 0;
        }
    }

    /**
     * getDeath
     * @return boolean, returns if the character is dead or not
     */
    public boolean getDeath() {
        if (hp <= 0) {
            return true;
        }
        return false;
    }

    /**
     * setHitbox
     * sets the hitbox to new values
     * @param x The x coordinate of the new hitbox
     * @param y The y coordinate of the new hitbox
     * @param w The width of the new hitbox
     * @param h The height of the new hitbox
     */
    public void setHitbox(int x, int y, int w, int h) {
        this.hitbox= new Rectangle(x,y,w,h);
    }

    
}