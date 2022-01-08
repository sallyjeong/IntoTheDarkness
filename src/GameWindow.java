/* * * * * Imports * * * * */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * [GameWindow.java]
 * This class is used to start the program and manage the windows
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
class GameWindow extends JFrame {

    /**
     * Constructs a game window
     */
    public GameWindow() {
        setTitle("Into the Darkness");
        setSize(1024, 765);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new GamePanel());
        pack();
        setVisible(true);
    }

    /**
     * [GamePanel.java]
     * This inner class represents the panel on which the game takes place
     * @author Peter Gao, Sally Jeong
     * @version 1.0
     * @since June 2021
     */
    static class GamePanel extends JPanel implements KeyListener {
        Map map;
        Player player = new Player(510, 340, 10, 0, 0);
        int direction = 1; //direction player is facing
        BulletManager bm;
        boolean won;
        boolean dead;
        EnemyManager em;
        FrameRate frameRate;
        Screen screen = new Screen();

        /**
         * Constructs a game panel and initializes variables
         */
        public GamePanel() {
            setPreferredSize(new Dimension(1024, 768));
            addKeyListener(this);
            setFocusable(true);
            requestFocusInWindow();
            map = new Map(1024, 768);
            bm = new BulletManager();
            em = new EnemyManager();
            won = false;
            //adding all the enemies with all their coordinates, each with 5 hp
            em.addEnemy(new Enemy(-680, 255, 5, 0));
            em.addEnemy(new Enemy(-1870, -680, 5, 0));
            em.addEnemy(new Enemy(-1020, -255, 5, 0));
            em.addEnemy(new Enemy(-2720, 0, 5, 0));
            em.addEnemy(new Enemy(-1615, 85, 5, 0));
            em.addEnemy(new Enemy(-2720, 595, 5, 0));
            em.addEnemy(new Enemy(-2550, 1530, 5, 0));
            em.addEnemy(new Enemy(-1190, 1530, 5, 0));
            em.addEnemy(new Enemy(-2635, 2210, 5, 0));
            em.addEnemy(new Enemy(-1105, 2295, 5, 0));
            em.addEnemy(new Enemy(-1700, 2465, 5, 0));
            em.addEnemy(new Enemy(-2550, 2635, 5, 0));
            em.addEnemy(new Enemy(-2125, 2805, 5, 0));
            em.addEnemy(new Enemy(-2635, 3060, 5, 0));
            em.addEnemy(new Enemy(-1870, 3060, 5, 0));
            em.addEnemy(new Enemy(-595, 3230, 5, 0));
            em.addEnemy(new Enemy(-2635, 3485, 5, 0));
            em.addEnemy(new Enemy(-1955, 3740, 5, 0));
            em.addEnemy(new Enemy(-2720, 4080, 5, 0));
            em.addEnemy(new Enemy(-2550, 4675, 5, 0));
            em.addEnemy(new Enemy(-1615, 4845, 5, 0));
            em.addEnemy(new Enemy(-2295, 4930, 5, 0));
            em.addEnemy(new Enemy(-1275, 5355, 5, 0));
            em.addEnemy(new Enemy(-2040, 5440, 5, 0));
            em.addEnemy(new Enemy(-1105, -2890, 5, 0));
            em.addEnemy(new Enemy(850, -2805, 5, 0));
            em.addEnemy(new Enemy(2125, -2805, 5, 0));
            em.addEnemy(new Enemy(3230, -2635, 5, 0));
            em.addEnemy(new Enemy(255, -2550, 5, 0));
            em.addEnemy(new Enemy(2550, -2210, 5, 0));
            em.addEnemy(new Enemy(-1275, -2040, 5, 0));
            em.addEnemy(new Enemy(-425, -2040, 5, 0));
            em.addEnemy(new Enemy(-1190, -1955, 5, 0));
            em.addEnemy(new Enemy(-1275, -1870, 5, 0));
            em.addEnemy(new Enemy(2465, -1700, 5, 0));
            em.addEnemy(new Enemy(1190, -1445, 5, 0));
            em.addEnemy(new Enemy(1700, -1445, 5, 0));
            em.addEnemy(new Enemy(3740, -1360, 5, 0));
            em.addEnemy(new Enemy(-850, -1275, 5, 0));
            em.addEnemy(new Enemy(425, -1190, 5, 0));
            em.addEnemy(new Enemy(3315, -1105, 5, 0));
            em.addEnemy(new Enemy(1615, -680, 5, 0));
            em.addEnemy(new Enemy(2125, -595, 5, 0));
            em.addEnemy(new Enemy(3060, -340, 5, 0));
            em.addEnemy(new Enemy(2465, -255, 5, 0));
            em.addEnemy(new Enemy(3485, 85, 5, 0));
            em.addEnemy(new Enemy(2295, 425, 5, 0));
            em.addEnemy(new Enemy(1615, 935, 5, 0));
            em.addEnemy(new Enemy(1785, 1190, 5, 0));
            em.addEnemy(new Enemy(3570, 1190, 5, 0));
            em.addEnemy(new Enemy(425, 1955, 5, 0));
            em.addEnemy(new Enemy(3740, 2210, 5, 0));
            em.addEnemy(new Enemy(1530, 2465, 5, 0));
            em.addEnemy(new Enemy(3230, 2720, 5, 0));
            em.addEnemy(new Enemy(1870, 2890, 5, 0));
            em.addEnemy(new Enemy(2380, 2975, 5, 0));
            em.addEnemy(new Enemy(425, 3060, 5, 0));
            em.addEnemy(new Enemy(3570, 3060, 5, 0));
            em.addEnemy(new Enemy(2040, 3400, 5, 0));
            em.addEnemy(new Enemy(3740, 3485, 5, 0));
            em.addEnemy(new Enemy(3060, 3570, 5, 0));
            em.addEnemy(new Enemy(85, 3825, 5, 0));
            em.addEnemy(new Enemy(765, 3825, 5, 0));
            em.addEnemy(new Enemy(2550, 4335, 5, 0));
            em.addEnemy(new Enemy(-85, 4420, 5, 0));
            em.addEnemy(new Enemy(1700, 4590, 5, 0));
            em.addEnemy(new Enemy(1190, 4675, 5, 0));
            em.addEnemy(new Enemy(255, 5185, 5, 0));
            em.addEnemy(new Enemy(1190, 5355, 5, 0));
            em.addEnemy(new Enemy(3740, 5355, 5, 0));
            em.addEnemy(new Enemy(-595, 5440, 5, 0));
            frameRate = new FrameRate();
            TileAssets.init();
            Sound.playGame();
        }

        /**
         * paintComponent
         * This method that updates the variables and draws to the screen
         * @param g, Graphics for drawing
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g); //required to ensure the panel is correctly redrawn
            if(won) {
                screen.drawWin(g); //draw win screen
            }else if ((!player.getDeath()) && (!won)) { //if alive and in-game
                map.draw(g);
                player.drawStatusBar(g);
                bm.update();
                bm.draw(g);
                Tile curTile = map.getTile(map.getPlayerY(), map.getPlayerX());
                if (player.getCurSpr() == 3) {
                    player.setCurSpr(0);
                } else if (player.getCurSpr() == 7) {
                    player.setCurSpr(4);
                }
                player.draw(g);
                if (curTile.getID() == 4) { //if player is standing on a spike
                    player.loseHp(1000);
                    if (player.getDeath()){
                        dead=true;
                    }
                }
                if(curTile.getID()==15) { //if player is standing on the final tile
                    won = true;
                    Sound.playWinScreen();
                }
                for (int e = 0; e < em.getEnemyArr().size(); e++) {
                    Enemy curEnemy = em.getEnemyArr().get(e);
                    if(curEnemy.getDeath()) {
                        em.removeEnemy(curEnemy); //removing current enemy from the arraylist if it's dead
                        continue;
                    }
                    if (player.getHitbox().intersects(curEnemy.getHitbox())) { //if player touches enemy
                        player.loseHp(1000);
                        if (player.getDeath()){
                            dead=true;
                        }
                    } else if (player.getHitbox().intersects(curEnemy.getAngryBox())) { //if player triggers the enemy
                        curEnemy.getAngry();
                    }
                    if(curEnemy.isAngry()) {
                        //enDirection and enDirection2 are used to determine the direction the current enemy needs to go
                        //The reason there are 2 different variables is because the enemy may not be centered on an exact tile,
                        //and therefore it makes the numbers wrong by a bit when doing integer division by 85;
                        int enDirection = curEnemy.nextDirection(map.getMap(), map.getPlayerX(), map.getPlayerY(), curEnemy.getX() / 85 + map.getPlayerX() - 6, curEnemy.getY() / 85 + map.getPlayerY() - 4);
                        int enDirection2 = curEnemy.nextDirection(map.getMap(), map.getPlayerX(), map.getPlayerY(), (int) Math.ceil((double) curEnemy.getX() / 85) + map.getPlayerX() - 6, (int) Math.ceil((double) curEnemy.getY() / 85) + map.getPlayerY() - 4);
                        if (enDirection2 != 0) {
                            curEnemy.update(0, 0, enDirection2);
                        } else {
                            curEnemy.update(0, 0, enDirection);
                        }
                    }
                    curEnemy.draw(g);
                    for (int i = 0; i < bm.getBulletArr().size(); i++) {
                        Bullet curBullet = bm.getBulletArr().get(i);
                        if (curBullet.isVisible()) {
                            if (curBullet.getHitbox().intersects(curEnemy.getHitbox())) { //if a bullet hits an enemy
                                curEnemy.loseHp(170);
                                curEnemy.getAngry();
                            }
                        }else {
                            bm.removeBullet(curBullet); //remove the bullet if its no longer visible
                        }
                    }
                }
                if (dead){
                    Sound.playLose();
                }
                frameRate.update();
                frameRate.draw(g);
            }else if (dead){
                screen.drawDead(g); //draw death screen
            }
            //request a repaint
            repaint();
            try {
                Thread.sleep(5);
            } catch (Exception e) {
            }
        }

        /**
         * keyTyped
         * This method is invoked when a key has been typed
         * @param e KeyEvent indicates that a keystroke occurred in a component
         */
        public void keyTyped(KeyEvent e) {
        }

        /**
         * keyPressed
         * This method is invoked when a key has been pressed
         * @param e KeyEvent indicates that a keystroke occurred in a component
         */
        public void keyPressed(KeyEvent e) {
        }

        /**
         * keyReleased
         * This method is invoked when a key has been released
         * @param e KeyEvent indicates that a keystroke occurred in a component
         */
        public void keyReleased(KeyEvent e) {

            if (e.getKeyChar() == 'a') { //move left
                if (direction == 2) {
                    player.setCurSpr(player.getCurSpr() + 1);
                } else {
                    player.setCurSpr(4);
                }
                direction = 2;
                if (map.getTile(map.getPlayerY(), map.getPlayerX() - 1).walkable()) { //update values if tile is walkable
                    map.setPlayerX(map.getPlayerX() - 1);
                    em.updateAll(-85, 0);
                } else if (map.getMap()[map.getPlayerY()][map.getPlayerX() - 1] == 3) { //if player walks into a chest
                    map.getMap()[map.getPlayerY()][map.getPlayerX() - 1] = 14;
                    player.addChest();
                } else if((map.getMap()[map.getPlayerY()][map.getPlayerX() - 1] == 9) || (map.getMap()[map.getPlayerY()][map.getPlayerX() - 1] == 2)) { //if player walks into the door
                    if (player.getChestCount()==4){
                        map.getMap()[12][17] = 0;
                        map.getMap()[13][17] = 0;
                        System.out.println("Door opened.");
                    }else{
                        System.out.println("Door closed. Collect 4 chests to open the door.");
                    }
                }

            } else if (e.getKeyChar() == 's') { //move down
                direction = 3;
                if (map.getTile(map.getPlayerY() + 1, map.getPlayerX()).walkable()) { //update values if tile is walkable
                    map.setPlayerY(map.getPlayerY() + 1);
                    em.updateAll(0, 85);
                } else if (map.getMap()[map.getPlayerY() + 1][map.getPlayerX()] == 3) { //if player walks into a chest
                    map.getMap()[map.getPlayerY() + 1][map.getPlayerX()] = 14;
                    player.addChest();
                } else if((map.getMap()[map.getPlayerY()+1][map.getPlayerX()] == 9) || (map.getMap()[map.getPlayerY()+1][map.getPlayerX() - 1] == 2)) { //if player walks into the door
                    if (player.getChestCount()==4){
                        map.getMap()[12][17] = 0;
                        map.getMap()[13][17] = 0;
                        System.out.println("Door opened.");
                    }else{
                        System.out.println("Door closed. Collect 4 chests to open the door.");
                    }
                }
                player.setCurSpr(player.getCurSpr() + 1);

            } else if (e.getKeyChar() == 'd') { //move right
                if (direction == 4) {
                    player.setCurSpr(player.getCurSpr() + 1);
                } else {
                    player.setCurSpr(0);
                }
                direction = 4;
                if (map.getTile(map.getPlayerY(), map.getPlayerX() + 1).walkable()) { //update values if tile is walkable
                    map.setPlayerX(map.getPlayerX() + 1);
                    em.updateAll(85, 0);
                } else if (map.getMap()[map.getPlayerY()][map.getPlayerX() + 1] == 3) { //if player walks into a chest
                    map.getMap()[map.getPlayerY()][map.getPlayerX() + 1] = 14;
                    player.addChest();
                } else if((map.getMap()[map.getPlayerY()][map.getPlayerX()+1] == 9) || (map.getMap()[map.getPlayerY()][map.getPlayerX() + 1] == 2)) { //if player walks into the door
                    if (player.getChestCount()==4){
                        map.getMap()[12][17] = 0;
                        map.getMap()[13][17] = 0;
                        System.out.println("Door opened.");
                    }else{
                        System.out.println("Door closed. Collect 4 chests to open the door.");
                    }
                }

            } else if (e.getKeyChar() == 'w') { //move up
                direction = 1;
                if (map.getTile(map.getPlayerY() - 1, map.getPlayerX()).walkable()) { //update values if tile is walkable
                    map.setPlayerY(map.getPlayerY() - 1);
                    em.updateAll(0, -85);
                } else if (map.getMap()[map.getPlayerY() - 1][map.getPlayerX()] == 3) { //if player walks into a chest
                    map.getMap()[map.getPlayerY() - 1][map.getPlayerX()] = 14;
                    player.addChest();
                } else if((map.getMap()[map.getPlayerY()-1][map.getPlayerX()] == 9) || (map.getMap()[map.getPlayerY()-1][map.getPlayerX()] == 2)) { //if player walks into the door
                    if (player.getChestCount()==4){
                        map.getMap()[12][17] = 0;
                        map.getMap()[13][17] = 0;
                        System.out.println("Door opened.");
                    }else{
                        System.out.println("Door closed. Collect 4 chests to open the door.");
                    }
                }
                player.setCurSpr(player.getCurSpr() + 1);
            } else if (e.getKeyChar() == ' ') { //shoot a bullet
                bm.addBullet(new Bullet(525, 355, direction));

            } else if (e.getKeyChar() == 'x') { //exit the window when on the win or death screen
                if ((player.getDeath()) || (won)) {
                    System.out.println("game exited");
                    System.exit(0);
                }
            }
        }
    }
}
