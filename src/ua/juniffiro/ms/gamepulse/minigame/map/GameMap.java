package ua.juniffiro.ms.gamepulse.minigame.map;

import ua.juniffiro.ms.gamepulse.util.Annotated;
import org.bukkit.World;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 08/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class GameMap extends Annotated<GameMapInfo> {

    private final World world;
    private boolean loaded;

    public GameMap(World world) {
        super(GameMapInfo.class);

        this.world = world;
    }

    public World getWorld() {
        return world;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    /**
     * Check if the game map is loaded.
     */
    public boolean isLoaded() {
        return loaded;
    }
}
