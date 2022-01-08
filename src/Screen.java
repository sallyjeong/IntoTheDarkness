/* * * * * Imports * * * * */
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * [Screen.java]
 * This class holds the lose screen and win screen
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class Screen {
    private BufferedImage deathScreen;
    private BufferedImage winScreen;

    /**
     * loadScreen
     * This method loads the death and win screens
     */
    public void loadScreen() {
        try {
            deathScreen = ImageIO.read(new File("graphics\\Death Screen.png"));
            winScreen = ImageIO.read(new File("graphics\\Win Screen.png"));
        } catch (Exception e) {
            System.out.println("error loading death screen");
        }
    }

    /**
     * drawDead
     * This method draws the player lose screen
     * @param g Graphics for drawing
     */
    public void drawDead(Graphics g) {
        loadScreen();
        g.drawImage(deathScreen, 0, 0, null);
    }

    /**
     * drawWin
     * This method draws the player win screen
     * @param g Graphics for drawing
     */
    public void drawWin (Graphics g) {
        loadScreen();
        g.drawImage(winScreen, 0, 0, null);
    }
}

