package ua.juniffiro.ms.gamepulse.minigame.arena.multi;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class ArenaManager implements Listener {

    // Arena list
    private final List<Arena> arenas = new ArrayList<>();

    public void addGameArena(Arena arena) {
        arenas.add(arena);
    }

    /**
     * Get the arena by name.
     *
     * @return Optional(Arena)
     */
    public Optional<Arena> getArena(String arenaName) {
       return arenas.stream()
               .filter(arena -> arena.getArenaName().equals(arenaName))
               .findFirst();
    }

    /**
     * Get the arena in which the player
     * is currently playing.
     */
    public Optional<Arena> getCurrentPlayerArena(Player player) {
        return arenas.stream()
                .filter(arena -> arena.isPlaying(player))
                .findFirst();
    }

    /**
     * Join the arena.
     */
    public void joinArena(Arena arena, Player player) {
        arena.handleJoin(player);
    }

    /**
     * Join the arena by name.
     */
    public void joinArena(String arenaName, Player player) {
        Optional<Arena> arenaOpt = getArena(arenaName);
        if (arenaOpt.isPresent()) {
            joinArena(arenaOpt.get(), player);
        } else {
            player.sendMessage(String.format(
                    "%sError connecting to the arena %s. Arena not found.",
                    ChatColor.RED, arenaName));
        }
    }

    public List<Arena> getArenas() {
        return arenas;
    }

    /**
     * Check if all arenas are initialized.
     */
    public boolean isInitialized() {
        return arenas.stream().allMatch(Arena::initialized);
    }

    /**
     * Finish the game in all arenas.
     */
    public void finish() {
        arenas.forEach(Arena::onEnd);
    }
}
