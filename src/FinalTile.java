/**
 * [FinalTile.java]
 * This class creates a single goal tile and extends tile class
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class FinalTile extends Tile {
	/**
     * Constructs a new goal tile
     * @param id An integer holding the id of the tile
     */
    public FinalTile(int id) {
        super(TileAssets.finaltile, id);
    }
    
    /**
     * walkable
     * This method returns if the tile is walkable
     * @return boolean, true
     */
    public boolean walkable() {
        return true;
    }

}
