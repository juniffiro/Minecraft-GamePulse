package ua.juniffiro.ms.buildbattle.phases;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import ua.juniffiro.ms.gamepulse.minigame.arena.MiniGameArena;
import ua.juniffiro.ms.gamepulse.minigame.phase.GamePhase;
import ua.juniffiro.ms.gamepulse.minigame.phase.GamePhaseInfo;
import ua.juniffiro.ms.gamepulse.util.ListenerHandler;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/03/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
@GamePhaseInfo(phaseName = "", prefix = "", priority = 1)
public class MainGamePhase extends GamePhase implements Listener {

    public MainGamePhase(MiniGameArena arena) {
        super(arena);
    }

    @EventHandler
    public void onBlockBreakTest(BlockBreakEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(String.format("Block destroyed %d",
                event.getBlock().getTypeId()));
    }

    @Override
    public void start() {
        ListenerHandler.register(this);

        getArena().changeGameMode(GameMode.CREATIVE);

        getArena().getGamers().forEach(gamer -> {
            Player player = gamer.getPlayer();
            player.sendTitle("BuildBattle - Game started", "Go!");

            player.getInventory().addItem(new ItemStack(Material.GRASS));
        });

        // If Game ends, go to EndPhase...
    }

    @Override
    public void cleanup() {
        ListenerHandler.unregister(this);
    }
}
