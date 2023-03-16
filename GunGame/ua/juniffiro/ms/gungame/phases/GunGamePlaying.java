package ua.juniffiro.ms.gungame.phases;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ua.juniffiro.ms.gamepulse.minigame.arena.MiniGameArena;
import ua.juniffiro.ms.gamepulse.minigame.phase.GamePhase;
import ua.juniffiro.ms.gamepulse.minigame.phase.GamePhaseInfo;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/03/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
@GamePhaseInfo(phaseName = "", prefix = "", priority = 1)
public class GunGamePlaying extends GamePhase {

    public GunGamePlaying(MiniGameArena arena) {
        super(arena);
    }

    @Override
    public void start() {
        getArena().changeGameMode(GameMode.SURVIVAL);

        getArena().getGamers().forEach(gamer -> {
            Player player = gamer.getPlayer();
            player.sendTitle("GunGame - Game started", "Go!");

            player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
        });

        // If Game ends, go to EndPhase...
    }

    @Override
    public void cleanup() {}
}
