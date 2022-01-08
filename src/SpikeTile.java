/**
 * [SpikeTile.java]
 * This class creates a single spike tile and extends tile class
 * @author Peter Gao, Sally Jeong
 * @version 1.0
 * @since June 2021
 */
public class SpikeTile extends Tile {
	/**
     * Constructs a new spike tile
     * @param id An integer holding the id of the tile
     */
    public SpikeTile(int id) {
        super(TileAssets.spike, id);
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