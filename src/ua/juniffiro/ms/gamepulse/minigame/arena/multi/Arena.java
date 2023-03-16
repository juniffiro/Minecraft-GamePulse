package ua.juniffiro.ms.gamepulse.minigame.arena.multi;

import org.bukkit.plugin.Plugin;
import ua.juniffiro.ms.gamepulse.minigame.arena.MiniGameArena;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public abstract class Arena extends MiniGameArena {

    private final String arenaName;

    public Arena(Plugin plugin, int minPlayers, int slots, String arenaName) {
        super(plugin, minPlayers, slots);
        this.arenaName = arenaName;
    }

    public Arena(Plugin plugin, int slots, String arenaName) {
        super(plugin, slots);
        this.arenaName = arenaName;
    }

    public String getArenaName() {
        return arenaName;
    }

}
