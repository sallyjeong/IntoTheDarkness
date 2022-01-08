/* * * * * Imports * * * * */
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * [TileAssets.java]
 * This class holds the BufferedImages for each tile
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class TileAssets {

    public static BufferedImage floor, wall, door0, door1, torchedwall, spike, closedchest, openedchest, barrel0, barrel1, manual, flag0, flag1, skull, finaltile;

    /**
     * init
     * This method initializes the images for each tile
     */
    public static void init() {
        try {
            floor = ImageIO.read(new File("graphics\\tilesprites_143.png"));
            wall = ImageIO.read(new File("graphics\\tilesprites_038.png"));
            door0 = ImageIO.read(new File("graphics\\tilesprites9.png"));
            door1 = ImageIO.read(new File("graphics\\tilesprites8.png"));
            torchedwall = ImageIO.read(new File("graphics\\tilesprites_076.png"));
            spike = ImageIO.read(new File("graphics\\tilesprites0.png"));
            closedchest = ImageIO.read(new File("graphics\\tilesprites6.png"));
            openedchest = ImageIO.read(new File("graphics\\tilesprites4.png"));
            barrel0 = ImageIO.read(new File("graphics\\barrel0.png"));
            barrel1 = ImageIO.read(new File("graphics\\barrel1.png"));
            manual = ImageIO.read(new File("graphics\\Manual.png"));
            flag0 = ImageIO.read(new File("graphics\\tilesprites12.png"));
            flag1 = ImageIO.read(new File("graphics\\tilesprites13.png"));
            skull = ImageIO.read(new File("graphics\\tilesprites14.png"));
            finaltile = ImageIO.read(new File("graphics\\finaltile.png"));
        } catch (Exception e) {
            System.out.println("error loading tiles");
        }
    }
    
}