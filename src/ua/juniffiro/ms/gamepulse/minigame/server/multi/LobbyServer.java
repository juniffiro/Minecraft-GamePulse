package ua.juniffiro.ms.gamepulse.minigame.server.multi;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.RegisteredListener;
import ua.juniffiro.ms.gamepulse.Main;
import ua.juniffiro.ms.gamepulse.minigame.arena.multi.Arena;
import ua.juniffiro.ms.gamepulse.minigame.arena.multi.ArenaManager;
import ua.juniffiro.ms.gamepulse.minigame.map.GameMap;
import ua.juniffiro.ms.gamepulse.minigame.server.MiniGameServer;
import ua.juniffiro.ms.gamepulse.util.ListenerHandler;

import java.util.Optional;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public abstract class LobbyServer implements MiniGameServer, Listener {

    /*
    Server implementation for the multi-arena.
    The server works on the principle of the lobby,
    where players can choose the game arena.
     */

    private final ArenaManager arenaManager;

    public LobbyServer() {
        this.arenaManager = new ArenaManager();

        ListenerHandler.register(this);

        RegisteredListener registeredListener = new RegisteredListener(this,
                (listener, event) -> onHandleEvent(event), EventPriority.NORMAL,
                Main.getInstance(), false);

        for (HandlerList handlerList : HandlerList.getHandlerLists()) {
            handlerList.register(registeredListener);
        }
    }

    /**
     * Universal method for handling all events.
     */
    protected void onHandleEvent(Event event) {}

    protected void onHandleArenaEvents(Player player,
                                 ArenaHandler arenaHandler) {
        Optional<Arena> arenaOpt = arenaManager.getCurrentPlayerArena(player);
        if (arenaOpt.isPresent()) {
            Arena arena = arenaOpt.get();
            Optional<GameMap> mapOpt = arena.getMaps().getPlayerGameMap(player);
            if (mapOpt.isPresent()) {
                GameMap map = mapOpt.get();
                arenaHandler.handleArena(arena, map);
            }
        }
    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        handlePlayerJoin(event.getPlayer());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        handlePlayerQuit(event.getPlayer());
    }

    public abstract void handlePlayerJoin(Player player);

    public abstract void handlePlayerQuit(Player player);

    @EventHandler
    public void onServerJoins(PlayerLoginEvent event) {
        if (!canJoin()) {
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "Сервер заполнен. Мест нет.");
        }
    }

    @Override
    public int maxSlots() {
        return Bukkit.getServer().getMaxPlayers();
    }

    @Override
    public boolean canJoin() {
        return !isFull();
    }

    @Override
    public boolean isFull() {
        return Bukkit.getOnlinePlayers().size() == maxSlots();
    }

}
