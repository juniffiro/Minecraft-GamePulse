package ua.juniffiro.ms.gungame;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import ua.juniffiro.ms.gamepulse.minigame.arena.multi.Arena;
import ua.juniffiro.ms.gamepulse.minigame.map.GameMap;
import ua.juniffiro.ms.gamepulse.minigame.server.multi.ArenaHandler;
import ua.juniffiro.ms.gamepulse.minigame.server.multi.LobbyServer;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class GunGameServer extends LobbyServer {

    private final ItemStack SELECT_ARENAS = new ItemStack(Material.FEATHER);

    public GunGameServer() {}

    @Override
    public void initialize() {
        // Create a new arena for 24 players
        getArenaManager().addGameArena(
                new GunGameArena(2, 24, "Town"));
    }

    // Universal event handler
    public void onHandleEvent(Event event) {
        if (event instanceof BlockBreakEvent) {
            BlockBreakEvent blockBreakEvent = (BlockBreakEvent) event;
            Player player = blockBreakEvent.getPlayer();

            onHandleArenaEvents(player, (arena, map) -> {
                switch (map.getAnnotation().mapType()) {
                    case LOBBY:
                        player.sendMessage("Cancelled block break event");
                        blockBreakEvent.setCancelled(true);
                        break;
                    case PLAY:
                    case OTHER:
                        player.sendMessage(String.format("Block destroyed %d",
                                blockBreakEvent.getBlock().getTypeId()));
                        break;
                }
            });
        }
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        // Check player's world and handle logic
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        if (!event.getHand().equals(EquipmentSlot.HAND)) {
            return;
        }
        if (!action.equals(Action.RIGHT_CLICK_AIR) && !action.equals(Action.RIGHT_CLICK_BLOCK)) {
            return;
        }
        if (event.getItem() == null) {
            return;
        }

        // Checks...
        joinArena("Town", player);

        /*
        Interact block or click sign
         */

    }

    private void joinArena(String arenaName, Player player) {
        // Handle lobby actions

        // Ex. clear join item or teleport to arena

       // player.getInventory().clear();

        getArenaManager().joinArena(arenaName, player);
    }

    @Override
    public void onDisable() {
        // Kick all players and finish arena
        getArenaManager().finish();
    }

    @Override
    public void handlePlayerJoin(Player player) {
        player.getInventory().clear();

        player.sendMessage("Welcome to the GunGame");
        player.sendMessage("Select arena");

        player.getInventory().addItem(SELECT_ARENAS);
    }

    @Override
    public void handlePlayerQuit(Player player) {}
}
