/**
 * [FloorTile.java]
 * This class creates a single walkable floor tile and extends tile class
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class FloorTile extends Tile {
	/**
     * Constructs a new floor tile
     * @param id An integer holding the id of the tile
     */
    public FloorTile(int id) {
        super(TileAssets.floor, id);
    }
    /**
     * walkable
     * This method returns if the tile is walkable
     * @return boolean, true
     */
    @Override 
    public boolean walkable() {
        return true;
    }

}