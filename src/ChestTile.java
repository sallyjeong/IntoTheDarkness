/**
 * [ChestTile.java]
 * This class creates a single closed chest tile and extends tile class
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class ChestTile extends Tile {
	/**
     * Constructs a new closed chest tile
     * @param id An integer holding the id of the tile
     */
    public ChestTile(int id) {
        super(TileAssets.closedchest, id);
    }

}