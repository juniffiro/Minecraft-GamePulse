package ua.juniffiro.ms.buildbattle;

import org.bukkit.entity.Player;
import ua.juniffiro.ms.gamepulse.minigame.Gamer;

import java.util.UUID;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 15/03/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class BuildBattlePlayer extends Gamer {

    /*
    Coins
    ...
     */

    public BuildBattlePlayer(Player player) {
        super(player);
    }

    public BuildBattlePlayer(String name, UUID uniqueId) {
        super(name, uniqueId);
    }
}
