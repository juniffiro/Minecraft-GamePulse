package ua.juniffiro.ms.gamepulse.minigame;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 11/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class Gamer {

    /*
        Bukkit Player wrapper
     */

    private String name;
    private UUID uniqueId;
    private final Player player;
    private boolean isPlaying;

    public Gamer(Player player) {
        this.name = player.getName();
        this.uniqueId = player.getUniqueId();
        this.player = player;
    }

    public Gamer(String name, UUID uniqueId) {
        this.name = name;
        this.uniqueId = uniqueId;
        this.player = Bukkit.getPlayer(uniqueId);
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }
}
