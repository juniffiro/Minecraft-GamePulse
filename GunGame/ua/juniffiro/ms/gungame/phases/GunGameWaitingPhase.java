package ua.juniffiro.ms.gungame.phases;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import ua.juniffiro.ms.gamepulse.minigame.Gamer;
import ua.juniffiro.ms.gamepulse.minigame.arena.MiniGameArena;
import ua.juniffiro.ms.gamepulse.minigame.phase.GamePhaseInfo;
import ua.juniffiro.ms.gamepulse.minigame.phase.timer.TimerPhase;
import ua.juniffiro.ms.gamepulse.util.TimeUtil;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/03/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
@GamePhaseInfo(phaseName = "Waiting",
        prefix = "[Lobby]",
        priority = 0)
public class GunGameWaitingPhase extends TimerPhase {

    public GunGameWaitingPhase(MiniGameArena arena) {
        super(arena, 30);
    }

    @Override
    public void onGamePhaseStart() {
        getArena().startNextPhase();
    }

    @Override
    public void onNotEnoughPlayers() {
        for (Gamer gamer : getArena().getGamers()) {
            Player player = gamer.getPlayer();
            player.setExp(1.0f);
            player.setLevel(30);
        }
    }

    @Override
    public void onAnnounceTime(int countdownTime) {
        for (Gamer gamer : getArena().getGamers()) {
            Player player = gamer.getPlayer();
            player.setExp(countdownTime / 30.0F);
            player.setLevel(countdownTime);
        }
        if (TimeUtil.shouldAnnounceTime(countdownTime) && countdownTime != 0) {
            for (Gamer gamer : getArena().getGamers()) {
                Player player = gamer.getPlayer();
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1, 1);
                player.sendTitle("" + TimeUtil.getColor(countdownTime) + countdownTime, "");
            }
            Bukkit.broadcastMessage(ChatColor.YELLOW + "Game will start in " + countdownTime + format(countdownTime));
        }
    }

    @Override
    public void cleanup() {
        getArena().getGamers().forEach(gamer -> {
            gamer.getPlayer().getInventory().clear();
        });
    }

    protected String format(int countdownTime) {
        String s;
        if (countdownTime == 1) {
            s = " second";
        } else {
            s = " seconds";
        }
        return s;
    }
}
