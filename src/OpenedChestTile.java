/**
 * [OpenedChestTile.java]
 * This class creates a single opened chest tile and extends tile class
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class OpenedChestTile extends Tile {
	/**
     * Constructs a new opened chest tile
     * @param id An integer holding the id of the tile
     */
    public OpenedChestTile(int id) {
        super(TileAssets.openedchest, id);
    }

}