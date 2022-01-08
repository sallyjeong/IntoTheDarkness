/* * * * * Imports * * * * */
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * [Tile.java]
 * This class represents a single tile on the map
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */

public class Tile {
    public static Tile[] tiles = new Tile[256];
    public static Tile floortile = new FloorTile(0);
    public static Tile walltile = new WallTile(1);
    public static Tile door0tile = new Door0Tile(2);
    public static Tile door1tile = new Door1Tile(9);
    public static Tile chestTile = new ChestTile(3);
    public static Tile OpenedChestTile = new OpenedChestTile(14);
    public static Tile spiketile = new SpikeTile(4);
    public static Tile torchedwalltile = new TorchedWallTile(5);
    public static Tile barrel0tile = new Barrel0Tile(6);
    public static Tile barrel1tile = new Barrel1Tile(7);
    public static Tile manual = new ManualTile(11);
    public static Tile flag0 = new Flag0Tile(12);
    public static Tile flag1 = new Flag1Tile(13);
    public static Tile skull = new SkullTile(8);
    public static Tile finaltile = new FinalTile(15);
    private int id;
    BufferedImage texture;

    /**
     * Constructs a new tile
     * @param texture A BufferedImage holding the image of the tile
     * @param id An integer holding the id of the tile
     */
    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;
        tiles[id] = this;
    }
    
    /**
     * draw
     * This method draws the tile
     * @param g Graphics for drawing
     * @param x An integer holding the x-coordinate of the tile
     * @param y An integer holding the y-coordinate of the tile
     */
    public void draw(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, null);
    }
    
    /**
     * getID
     * @return int, returns the id of the tile
     */
    public int getID() {
        return this.id;
    }
    
    /**
     * walkable
     * This method returns if the tile is walkable
     * @return boolean, false
     */
    public boolean walkable() {
        return false;
    }
    
}