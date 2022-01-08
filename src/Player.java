/* * * * * Imports * * * * */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/**
 * [Player.java]
 * This class represents the player
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class Player extends Character {
    private BufferedImage heart;
    private BufferedImage chest;
    private Font font = new Font("Monospaced", Font.BOLD, 27);
    private Color DARK_GRAY = new Color(56, 62, 66, 235);
    private int chestCount;
    private BufferedImage sprite[];
    /**
     * Constructs the player
     * @param x An integer holding the x coordinate of the player
     * @param y An integer holding the y coordinate of the player
     * @param hp An integer holding the health points of the player
     * @param curSprite An integer holding the index of the current sprite animation
     * @param chestCount An integer holding the amount of chests the player has opened
     */
    public Player(int x, int y, int hp, int curSprite, int chestCount) {
        super(x, y, hp, curSprite);
        this.chestCount = chestCount;
        loadSprite();
    }

    /**
     * loadSprite
     * loads the sprites for the player
     */
    @Override
    public void loadSprite() {
        sprite = new BufferedImage[7];
        try {
            sprite[0] = ImageIO.read(new File("graphics\\charactersprites08.png"));
            sprite[1] = ImageIO.read(new File("graphics\\charactersprites09.png"));
            sprite[2] = ImageIO.read(new File("graphics\\charactersprites10.png"));
            sprite[3] = ImageIO.read(new File("graphics\\charactersprites11.png"));
            sprite[4] = ImageIO.read(new File("graphics\\charactersprites12.png"));
            sprite[5] = ImageIO.read(new File("graphics\\charactersprites13.png"));
            sprite[6] = ImageIO.read(new File("graphics\\charactersprites14.png"));
        } catch (Exception e) {
            System.out.println("error loading sprite");
        }
    }

    /**
     * draw
     * draws the current sprite of the player
     * @param g Graphics for drawing
     */
    @Override
    public void draw(Graphics g) {
        try {
          g.drawImage(sprite[this.getCurSpr()], super.getX(), super.getY(), null);
        } catch (Exception e) {
          System.out.println("error drawing spritessssssssss");
          System.out.println(e);
        }
    }

    /**
     * getChestCount
     * @return int, returns the number of chests the player has obtained
     */
    public int getChestCount(){
        if(this.chestCount==4){
            Sound.playDoorOpen();
        }
        return this.chestCount;
    }

    /**
     * addChest
     * adds to the chestCount by 1
     */
    public void addChest() {
        Sound.playOpenChest();
        this.chestCount++;
    }

    /**
     * loadStatusBar
     * loads the images used by the status bar
     */
    public void loadStatusBar() {
        try {
            heart = ImageIO.read(new File("graphics\\tilesprites1.png"));
            chest = ImageIO.read(new File("graphics\\tilesprites3.png"));
        } catch (Exception e) {
            System.out.println("error loading status bar");
        }
    }

    /**
     * drawStatusBar
     * draws the status bar
     * @param g Graphics for drawing
     */
    public void drawStatusBar(Graphics g) {
        loadStatusBar();
        g.setColor(DARK_GRAY);
        g.setFont(font);
        g.fillRect(255, 680, 510, 85);
        g.setColor(Color.WHITE);
        g.drawImage(heart, 310, 680, null);
        g.drawString((" x " + getHp()), 410, 730);
        g.drawImage(chest, 550, 672, null);
        g.drawString((" x " + this.chestCount), 650, 730);
    }
    
    /**
     * playHitSound
     * plays the sound of the player getting hit
     */
    @Override
    public void playHitSound(){
        Sound.playPlayerHit();
    }
    
    /**
     * playDeadSound
     * plays the sound when the player dies
     */
    @Override
    public void playDeadSound(){
        Sound.playPlayerDead();
    }

}