/* * * * * Imports * * * * */
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.util.Scanner;

/**
 * [Map.java]
 * This class loads in a text file and holds the values for a tile map
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class Map implements Drawable {
    private int boxWidth, boxHeight;
    private int visibleWidth, visibleHeight;
    private int playerX, playerY;
    private int map[][];

    /**
     * Constructs a moveable map
     * @param xResolution the total horizontal size of the map
     * @param yResolution the total vertical size of the map
     */
    public Map(int xResolution, int yResolution) {
        visibleWidth = 12; //The size of the visible portion of the map
        visibleHeight = 9; 
        boxWidth = 85; //The size of each tile
        boxHeight = 85;
        playerX = 39; //The starting location of the player, in terms of an array index, not pixels
        playerY = 39;
        try {
            map = loadMapData("graphics\\map.txt");
        } catch (Exception e) {
            System.out.println("error loading map");
        }
    }

    /**
     * getPlayerX
     * @return int, returns the current x value of the player, in terms of an array index
     */
    public int getPlayerX() {
        return this.playerX;
    }

    /**
     * getPlayerY
     * @return int, returns the current y value of the player, in terms of an array index
     */
    public int getPlayerY() {
        return this.playerY;
    }

    /**
     * setPlayerX
     * sets the player x value on the array
     */
    public void setPlayerX(int val) {
        this.playerX = val;
    }

    /**
     * setPlayerY
     * sets the player y value on the array
     */
    public void setPlayerY(int val) {
        this.playerY = val;
    }

    /**
     * getMap
     * @return int[][], returns the 2d array of the map
     */
    public int[][] getMap() {
        return this.map;
    }

    /**
     * loadMapData
     * @return int[][], returns the 2d array of integers loaded in from a text file
     */
    public int[][] loadMapData(String filename) {
        int data[][] = null;
        try {
            File f = new File(filename);
            Scanner input = new Scanner(f);
            data = new int[input.nextInt()][input.nextInt()]; // first two lines are map size
            for (int j = 0; j < 101; j++) {
                for (int i = 0; i < 80; i++) {
                    data[j][i] = input.nextInt();
                }
            }
            input.close();
        } catch (Exception E) {
            System.out.println("Error loading map file");
        }
        return data;
    }
    
    /**
     * getTile
     * @return Tile, returns the tile at the given x and y value
     * @param x The x value for the tile
     * @param y The y value for the tile
     */
    public Tile getTile(int x, int y) {
        Tile t = Tile.tiles[map[x][y]];
        return t;
    }
    
    /**
     * draw
     * draws the visible portion of the map based on the player's location
     * @param g Graphics for drawing
     */
    public void draw(Graphics g) {
        for (int j = visibleHeight-1; j>=0; j--) {
            for (int i = visibleWidth-1; i >=0; i--) {
                try {
                    getTile(playerY - visibleHeight / 2 + j, playerX - visibleWidth / 2 + i).draw(g, i * boxWidth, j * boxHeight);
                } catch (ArrayIndexOutOfBoundsException e) {
                 Color color = new Color(62, 54, 68);
                 g.setColor(color);
                 g.fillRect(i * boxWidth, j * boxHeight, 85, 85); 
                }
            }
        }
    }
    
}