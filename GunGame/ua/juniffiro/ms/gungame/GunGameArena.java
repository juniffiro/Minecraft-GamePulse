package ua.juniffiro.ms.gungame;

import ua.juniffiro.ms.gamepulse.Main;
import ua.juniffiro.ms.gamepulse.minigame.Gamer;
import ua.juniffiro.ms.gamepulse.minigame.arena.multi.Arena;
import org.bukkit.entity.Player;
import ua.juniffiro.ms.gungame.maps.GunGameTownMap;
import ua.juniffiro.ms.gungame.phases.GunGamePlaying;
import ua.juniffiro.ms.gungame.phases.GunGameWaitingPhase;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class GunGameArena extends Arena {

    public GunGameArena(int minPlayers, int slots, String arenaName) {
        super(Main.getInstance(), minPlayers, slots, arenaName);
    }

    @Override
    public void handleJoin(Player player) {
        setupGamer(new Gamer(player));
        player.sendMessage("You're connected to arena");
    }

    @Override
    public void handleQuit(Player player) {
        removeGamer(player);
    }

    @Override
    public void handleLogin(Player player) {}

    @Override
    public void init() {
        addGameMap(new GunGameTownMap());
        addGamePhase(new GunGameWaitingPhase(this));
        addGamePhase(new GunGamePlaying(this));
    }
}
