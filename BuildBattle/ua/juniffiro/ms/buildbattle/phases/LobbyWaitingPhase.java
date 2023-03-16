package ua.juniffiro.ms.buildbattle.phases;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import ua.juniffiro.ms.gamepulse.minigame.Gamer;
import ua.juniffiro.ms.gamepulse.minigame.arena.MiniGameArena;
import ua.juniffiro.ms.gamepulse.minigame.phase.GamePhaseInfo;
import ua.juniffiro.ms.gamepulse.minigame.phase.timer.TimerPhase;
import ua.juniffiro.ms.gamepulse.util.ListenerHandler;
import ua.juniffiro.ms.gamepulse.util.TimeUtil;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/03/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
@GamePhaseInfo(phaseName = "Waiting", prefix = "[Lobby]", priority = 0)
public class LobbyWaitingPhase extends TimerPhase implements Listener {

    public LobbyWaitingPhase(MiniGameArena arena) {
        super(arena, 30);

        ListenerHandler.register(this);
    }

    @EventHandler
    public void onLobbyBlockBreak(BlockBreakEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerFood(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            event.setCancelled(true);
        }
    }

    @Override
    public void onGamePhaseStart() {
        getArena().startNextPhase();
    }

    @Override
    public void onNotEnoughPlayers() {
        for (Gamer gamer : getArena().getGamers()) {
            //countdownTime = resetCountdownTime;
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
                player.sendTitle("" + TimeUtil.getColor(countdownTime) + countdownTime, "");
            }
            announceTime(countdownTime);
        }
    }

    @Override
    public void cleanup() {
        HandlerList.unregisterAll(this);

        getArena().getGamers().forEach(gamer -> {
            gamer.getPlayer().getInventory().clear();
        });
    }

    protected String format(int countdownTime) {
        String s;
        if (countdownTime == 1) {
            s = " second";
//        } else if (countdownTime < 5) {
//            s = " seconds";
        } else {
            s = " seconds";
        }
        return s;
    }

    protected void announceTime(int countdownTime) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1, 1);
        });
        Bukkit.broadcastMessage(ChatColor.YELLOW + "Game will start in " + countdownTime + format(countdownTime));
    }
}
