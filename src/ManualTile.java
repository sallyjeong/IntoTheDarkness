/**
 * [ManualTile.java]
 * This class creates a single tile showing the manual and extends tile class
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class ManualTile extends Tile {
	/**
     * Constructs a new manual tile
     * @param id An integer holding the id of the tile
     */
    public ManualTile(int id) {
        super(TileAssets.manual, id);
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