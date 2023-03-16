package ua.juniffiro.ms.gamepulse.minigame;

import ua.juniffiro.ms.gamepulse.minigame.server.MiniGameServer;
import ua.juniffiro.ms.gamepulse.util.Annotated;
import org.bukkit.plugin.Plugin;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 08/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public abstract class MiniGame extends Annotated<MiniGameInfo> {

    /*
    An abstract minigame class.
    Describes the minigame and takes
    a concrete implementation of the game server.
     */

    private final Plugin plugin;
    private final MiniGameServer server;

    public MiniGame(Plugin plugin, MiniGameServer server) {
        super(MiniGameInfo.class);

        this.plugin = plugin;
        this.server = server;

        server.initialize();
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public MiniGameServer miniGameServer() {
        return server;
    }
}
