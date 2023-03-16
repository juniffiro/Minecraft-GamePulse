package ua.juniffiro.ms.buildbattle;

import ua.juniffiro.ms.gamepulse.minigame.MiniGameInfo;
import ua.juniffiro.ms.gamepulse.minigame.MiniGame;
import ua.juniffiro.ms.gamepulse.minigame.MiniGameCategory;
import org.bukkit.plugin.Plugin;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
@MiniGameInfo(name = "BuildBattle Solo",
        version = "1.0-beta",
        description = "Funny Game",
        category = MiniGameCategory.ARCADE,
        authors = "Juniffiro")
public class BuildBattle extends MiniGame {

    /*
    Example of a BuildBattle minigame base.

    This project does not contain a complete minigame
    implementation and serves as an example.
     */

    public BuildBattle(Plugin plugin) {
        super(plugin, new BuildBattleServer());
    }
}
