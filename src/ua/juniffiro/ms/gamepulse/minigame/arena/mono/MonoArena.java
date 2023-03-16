package ua.juniffiro.ms.gamepulse.minigame.arena.mono;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.Plugin;
import ua.juniffiro.ms.gamepulse.minigame.arena.MiniGameArena;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 11/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public abstract class MonoArena extends MiniGameArena {

    public MonoArena(Plugin plugin, int minPlayers, int slots) {
        super(plugin, minPlayers, slots);
    }

    public MonoArena(Plugin plugin, int slots) {
        super(plugin, slots);
    }

    /** =============================
     * Handling events occurring
     * in the monoarena
     *  ============================== */

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        handleJoin(event.getPlayer());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        handleQuit(event.getPlayer());
    }

    @EventHandler
    public void onServerJoins(PlayerLoginEvent event) {
        onLogin(event);
        handleLogin(event.getPlayer());
    }

    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {
        onMotdChange(event);
    }

    public abstract void onLogin(PlayerLoginEvent event);

    public abstract void onMotdChange(ServerListPingEvent event);
}
