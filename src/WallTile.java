/**
 * [WallTile.java]
 * This class creates a single wall tile and extends tile class
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class WallTile extends Tile {
	/**
     * Constructs a new wall tile
     * @param id An integer holding the id of the tile
     */
    public WallTile(int id) {
        super(TileAssets.wall, id);
    }

}