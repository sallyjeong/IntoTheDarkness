/* * * * * Imports * * * * */
import java.awt.Graphics;
import java.util.ArrayList;
/**
 * [EnemyManager.java]
 * This class manages the current enemies on the map
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class EnemyManager implements Drawable {
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private Enemy curEnemy;

    /**
     * updateAll
     * updates all the locations of the enemy
     * @param x The x value that the enemies move
     * @param y The y value that the enemies move
     */
    public void updateAll(int x, int y) {
        for (int i = 0; i < enemies.size(); i++) {
            curEnemy = enemies.get(i);
            curEnemy.update(x, y, 0);
        }
    }

    /**
     * draw
     * draws all the enemies
     * @param g Graphics for drawing
     */
    public void draw(Graphics g) {
        for (int i = 0; i < enemies.size(); i++) {
            curEnemy = enemies.get(i);
            curEnemy.draw(g);
        }
    }

    /**
     * addEnemy
     * adds an enemy to the arraylist of enemies
     * @param e The newly created enemy
     */
    public void addEnemy(Enemy e) {
        enemies.add(e);
    }

    /**
     * removeEnemy
     * removes an enemy from the arraylist of enemies
     * @param e The enemy that needs to be removed
     */
    public void removeEnemy(Enemy e) {
        enemies.remove(e);
    }

    /**
     * getEnemyArr
     * @return ArrayList<Enemy> The arraylist of enemies
     */
    public ArrayList<Enemy> getEnemyArr() {
        return enemies;
    }


}