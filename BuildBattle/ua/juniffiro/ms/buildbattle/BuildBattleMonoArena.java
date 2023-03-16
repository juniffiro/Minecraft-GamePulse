package ua.juniffiro.ms.buildbattle;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.server.ServerListPingEvent;
import ua.juniffiro.ms.buildbattle.maps.TestMap;
import ua.juniffiro.ms.buildbattle.phases.LobbyWaitingPhase;
import ua.juniffiro.ms.buildbattle.phases.MainGamePhase;
import ua.juniffiro.ms.gamepulse.Main;
import ua.juniffiro.ms.gamepulse.minigame.Gamer;
import ua.juniffiro.ms.gamepulse.minigame.arena.mono.MonoArena;
import org.bukkit.entity.Player;
import ua.juniffiro.ms.gamepulse.minigame.phase.GamePhase;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class BuildBattleMonoArena extends MonoArena {

    public BuildBattleMonoArena(int minPlayers, int slots) {
        super(Main.getInstance(), minPlayers, slots);
    }

    @Override
    public void handleJoin(Player player) {
        player.sendMessage("BB Arena Test");
        player.sendTitle(String.format("%sBuildBattle", ChatColor.YELLOW), "Test");

        player.getInventory().clear();

        player.setGameMode(getGameMode());
        player.setExp(0);
        player.setLevel(0);
        player.setFoodLevel(20);
        player.setHealth(player.getMaxHealth());

        setupGamer(new Gamer(player));
    }

    @Override
    public void handleQuit(Player player) {
        removeGamer(player);
    }

    @Override
    public void handleLogin(Player player) {
        System.out.println("The logged-in player with the nickname " + player.getName());
    }

    @Override
    public void init() {

        setGameMode(GameMode.ADVENTURE);

        addGamePhase(new LobbyWaitingPhase(this));
        addGameMap(new TestMap());
        addGamePhase(new MainGamePhase(this));
    }

    @Override
    public void onLogin(PlayerLoginEvent event) {
        switch (getMgState()) {
            case LOAD:
            case RELOAD:
                event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "Server setup");
                break;
            case RUNNING:
                // Checks moders and arena mode
                break;
        }
    }

    @Override
    public void onMotdChange(ServerListPingEvent event) {
        switch (getMgState()) {
            case LOAD:
                event.setMotd("Server loading");
                break;
            case RUNNING:

                GamePhase phase = getPhases().getCurrentPhase();
                if (phase != null) {
                    event.setMotd(phase.getMotd());
                }
                break;
            case RELOAD:
                event.setMotd("Server reload");
                break;
        }
    }
}
