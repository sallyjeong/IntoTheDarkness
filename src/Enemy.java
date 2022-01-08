/* * * * * Imports * * * * */
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import javax.imageio.ImageIO;
/**
 * [Enemy.java]
 * This class creates a single enemy, and extends Character class
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class Enemy extends Character {
    private BufferedImage sprite[];
    private boolean angry;
    private Rectangle angryBox;
    public static int pathToPlayerMap[][];
    static int[] directions = {0, 1, 0, -1, -1, 0, 1, 0}; //down, up, left, right
    long lastTimeCheck; //store the time of the last time the time was recorded
    long deltaTime; //to keep the elapsed time between current time and last time
    
    /**
     * Constructs a new enemy character
     * @param x An integer holding the x coordinate of the enemy
     * @param y An integer holding the y coordinate of the enemy
     * @param hp An integer holding the health points of the enemy
     * @param curSprite An integer holding the index of the current sprite animation
     */
    public Enemy(int x, int y, int hp, int curSprite) {
        super(x, y, hp, curSprite);
        this.setHitbox(x + 21, y + 21, 49, 64);
        this.angryBox = new Rectangle(x - 170, y - 170, 425, 425);
        loadSprite();
        this.angry = false;
        pathToPlayerMap = new int[101][80];
    }
    
    /**
     * draw
     * draws the current sprite of the enemy
     * @param g Graphics for drawing
     */
    @Override
    public void draw(Graphics g) {
        if ((super.getX() < 1020) && (super.getX() >= 0) && (super.getY() < 765) && (super.getY() >= 0)) {
            try {
                g.drawImage(sprite[this.getCurSpr()], super.getX(), super.getY(), null);
            } catch (Exception e) {
            }
        }

    }
    
    /**
     * loadSprite
     * loads the sprites for the enemy
     */
    @Override
    public void loadSprite() {
        sprite = new BufferedImage[8];
        try {
            sprite[0] = ImageIO.read(new File("graphics\\charactersprites03.png"));
            sprite[1] = ImageIO.read(new File("graphics\\charactersprites04.png"));
            sprite[2] = ImageIO.read(new File("graphics\\charactersprites05.png"));
            sprite[3] = ImageIO.read(new File("graphics\\charactersprites06.png"));
            sprite[4] = ImageIO.read(new File("graphics\\charactersprites07.png"));
        } catch (Exception e) {
            System.out.println("error loading sprite");
        }
    }
    
    /**
     * update
     * updates the location of the current enemy
     * @param movex The x value that the enemy moves immediatly
     * @param movey The y value that the enemy moves immediatly
     * @param moveDirection The direction that the enemy needs to move next based on the player's location
     */
    public void update(int movex, int movey, int moveDirection) {
        this.setX(this.getX() - movex);  
        this.setY(this.getY() - movey); //occurs anytime the map is moved
        long currentTime = System.currentTimeMillis();  //get the current time
        deltaTime += currentTime - lastTimeCheck; //add to the elapsed time
        lastTimeCheck = currentTime; //update the last time var
        int index = moveDirection * 2 - 2; 
        if (deltaTime >= 150) { //occurs every 150 milliseconds
            if ((angry) && (moveDirection > 0)) { //only do if moveDirection returns a value that is not -1 or 0
                if (this.getCurSpr() >= 4) {
                    this.setCurSpr(-1);
                }
                this.setX(this.getX() + 17 * directions[index]); 
                this.setY(this.getY() + 17 * directions[index + 1]); //move the enemy towards the player
                this.setCurSpr(this.getCurSpr() + 1);
            }
            deltaTime = 0;
        }
        this.getHitbox().x = this.getX();
        this.getHitbox().y = this.getY(); 
        this.angryBox.x = this.getX() - 170;
        this.angryBox.y = this.getY() - 170;  //update the hitbox and the box that triggers the enemy
    }

    /**
     * nextDirection
     * runs a BFS to find the shortest possible path between the enemy and the player
     * @return int, the direction that the enemy needs to take next
     * @param map The map array
     * @param playerX The current x value of the player
     * @param playerY The current y value of the player
     * @param startX The current x value of the enemy
     * @param startY The current y value of the enemy
     */
    public int nextDirection(int map[][], int playerX, int playerY, int startX, int startY) {
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        int cntarr[][] = new int[101][80];
        int prevDirection[][] = new int[101][80];
        q.add(startX);
        q2.add(startY);
        while (!q.isEmpty()) {
            int x = q.poll(), y = q2.poll();
            if ((x == playerX) && (y == playerY)) { //once found shortest path, backtrack back the current location to find the next direction
                int direction = 0;
                while (true) {
                    if ((x == startX) && (y == startY)) {
                        return direction; //will return 0 if enemy is already on top of player
                    }
                    if (prevDirection[y][x] == 1) {
                        y--;
                        direction = 1; //going down
                    } else if (prevDirection[y][x] == 2) {
                        y++;
                        direction = 2; //going up
                    } else if (prevDirection[y][x] == 3) {
                        x++;
                        direction = 3; //going left
                    } else if (prevDirection[y][x] == 4) {
                        x--;
                        direction = 4; //going right
                    }
                }
            }
            try {
                for (int i = 0; i < 8; i += 2) {
                    int newX = x + directions[i];
                    int newY = y + directions[i + 1];
                    if ((map[newY][newX] != 1) && (cntarr[newY][newX] == 0)) {
                        q.add(newX);
                        q2.add(newY);
                        cntarr[newY][newX] = cntarr[y][x] + 1;
                        if (i == 0) {
                            prevDirection[newY][newX] = 1; //down
                        } else if (i == 2) {
                            prevDirection[newY][newX] = 2; //up
                        } else if (i == 4) {
                            prevDirection[newY][newX] = 3; //left
                        } else if (i == 6) {
                            prevDirection[newY][newX] = 4; //right
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        return -1; //return -1 if it is impossible for the enemy to reach the player
    }

    /**
     * getAngry
     * changes the enemies current angry state to true
     */
    public void getAngry() {
        this.angry = true;
    }

    /**
     * isAngry
     * @return boolean, return if the enemy is angry
     */
    public boolean isAngry() {
        return this.angry;
    }
    
    /**
     * getAngryBox
     * @return Rectangle, returns the box that triggers the enemy to move if the player collides with it
     */
    public Rectangle getAngryBox() {
        return this.angryBox;
    }
    
    /**
     * playHitSound
     * plays the sound of the enemy getting hit
     */
    @Override
    public void playHitSound(){
        Sound.playEnemyHit();
    }
    
    /**
     * playDeadSound
     * plays the sound when the enemy dies
     */
    @Override
    public void playDeadSound(){
        Sound.playEnemyDead();
    }
}