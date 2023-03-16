package ua.juniffiro.ms.gungame;

import org.bukkit.entity.Player;
import ua.juniffiro.ms.gamepulse.minigame.Gamer;

import java.util.UUID;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 15/03/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class GunGamePlayer extends Gamer {

    /*
    Coins
    ...
     */

    public GunGamePlayer(Player player) {
        super(player);
    }

    public GunGamePlayer(String name, UUID uniqueId) {
        super(name, uniqueId);
    }
}
