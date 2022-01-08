/**
 * [TorchedWallTile.java]
 * This class creates a single torched wall tile and extends tile class
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class TorchedWallTile extends Tile {
	/**
     * Constructs a new torched wall tile tile
     * @param id An integer holding the id of the tile
     */
    public TorchedWallTile(int id) {
        super(TileAssets.torchedwall, id);
    }

}