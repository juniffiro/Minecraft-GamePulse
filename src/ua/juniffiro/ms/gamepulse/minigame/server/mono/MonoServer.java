package ua.juniffiro.ms.gamepulse.minigame.server.mono;

import ua.juniffiro.ms.gamepulse.minigame.arena.mono.MonoArena;
import org.bukkit.Bukkit;
import ua.juniffiro.ms.gamepulse.minigame.server.MiniGameServer;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public abstract class MonoServer implements MiniGameServer {

    /*
    Server implementation for the mono-arena.
    Mono Arena = an arena with a specific game implementation
    that works on the principle of 1 arena = 1 server.
     */

    private final MonoArena arena;

    public MonoServer(MonoArena arena) {
        this.arena = arena;
    }

    public MonoArena getArena() {
        return arena;
    }

    @Override
    public int maxSlots() {
        return this.arena.getSlots();
    }

    @Override
    public boolean canJoin() {
        return this.arena.canJoinArena() && !isFull();
    }

    @Override
    public boolean isFull() {
        return Bukkit.getOnlinePlayers().size() == maxSlots();
    }
}
