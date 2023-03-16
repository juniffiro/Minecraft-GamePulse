package ua.juniffiro.ms.gungame;

import org.bukkit.plugin.Plugin;
import ua.juniffiro.ms.gamepulse.minigame.MiniGameInfo;
import ua.juniffiro.ms.gamepulse.minigame.MiniGame;
import ua.juniffiro.ms.gamepulse.minigame.MiniGameCategory;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
@MiniGameInfo(name = "GunGame",
        version = "1.0-beta",
        description = "Funny pvp game",
        category = MiniGameCategory.PVP,
        authors = "Beeroking")
public class GunGame extends MiniGame {

    /*
    Example of a GunGame minigame base.

    This project does not contain a complete minigame
    implementation and serves as an example.
     */

    public GunGame(Plugin plugin) {
        super(plugin, new GunGameServer());
    }
}
