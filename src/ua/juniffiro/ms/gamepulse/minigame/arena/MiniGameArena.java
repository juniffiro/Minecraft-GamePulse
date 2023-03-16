package ua.juniffiro.ms.gamepulse.minigame.arena;

import ua.juniffiro.ms.gamepulse.log.Log;
import ua.juniffiro.ms.gamepulse.minigame.Gamer;
import ua.juniffiro.ms.gamepulse.minigame.server.ServerState;
import ua.juniffiro.ms.gamepulse.minigame.map.GameMap;
import ua.juniffiro.ms.gamepulse.minigame.map.GameMapManager;
import ua.juniffiro.ms.gamepulse.minigame.phase.GamePhase;
import ua.juniffiro.ms.gamepulse.minigame.phase.GamePhaseManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import ua.juniffiro.ms.gamepulse.util.ListenerHandler;

import java.util.*;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public abstract class MiniGameArena implements Listener {

    private final Plugin plugin;

    private ServerState mgState;
    private final GameMapManager maps;
    private final GamePhaseManager phases;

    private final Set<Gamer> gamers;
    private final Set<Gamer> view;

    // Default Game Mode
    private GameMode gameMode = GameMode.SURVIVAL;

    private final int minPlayers;

    // Server slots
    private int slots;

    /**
     * Minimum of 2 players to play.
     */
    public MiniGameArena(Plugin plugin, int slots) {
        this(plugin, 2, slots);
    }

    public MiniGameArena(Plugin plugin, int minPlayers, int slots) {
        this.plugin = plugin;
        this.mgState = ServerState.LOAD;

        this.maps = new GameMapManager();
        this.phases = new GamePhaseManager();

        this.gamers = new HashSet<>();
        this.view = new HashSet<>();

        this.minPlayers = minPlayers;
        this.slots = slots;

        ListenerHandler.register(this, plugin);

        onFirst();
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    /**
     * Check if new players can join the arena.
     */
    public boolean canJoinArena() {
        return gamers.size() < slots && mgState.equals(ServerState.RUNNING);
    }

    /**
     * Handling player join
     */
    public abstract void handleJoin(Player player);

    /**
     * Handling player quit.
     */
    public abstract void handleQuit(Player player);

    /**
     * Called when player logs on to a server.
     */
    public abstract void handleLogin(Player player);

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public Set<Gamer> getGamers() {
        return gamers;
    }

    public Set<Gamer> getViewers() {
        return view;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    /**
     * Create a new instance of Gamer.
     *
     * @param gamer
     *         Wrapper in the form
     *         of a player entity
     * @return Gamer.
     */
    public Gamer setupGamer(Gamer gamer) {
        gamers.add(gamer);
        return gamer;
    }

    /**
     * Remove player from the list
     * of players in the game.
     *
     * @param player
     *        Bukkit Player to get
     *        the Gamer wrapper
     */
    public void removeGamer(Player player) {
        gamers.removeIf(g -> g.getUniqueId().equals(player.getUniqueId()));
    }

    /**
     * Add player to the game observer list.
     */
    public Gamer addViewer(Gamer gamer) {
        gamers.remove(gamer);
        view.add(gamer);
        return gamer;
    }

    public ServerState getMgState() {
        return mgState;
    }

    /**
     * Set the current server status.
     */
    public void setMgState(ServerState mgState) {
        this.mgState = mgState;
    }

    /**
     * Manager, which is responsible for
     * loading and managing game maps.
     *
     * @return Game map manager.
     */
    public GameMapManager getMaps() {
        return maps;
    }

    /**
     * Manager, which is responsible for
     * loading and managing game phases.
     *
     * @return Game phase manager.
     */
    public GamePhaseManager getPhases() {
        return phases;
    }

    /**
     * Check if the arena is initialized.
     */
    public boolean initialized() {
        return maps.isValid() && phases.isValid();
    }

    public void addGamePhase(GamePhase phase) {
        phases.addPhase(phase);
    }

    public void removeGamePhase(String phaseName) {
        phases.removePhase(phaseName);
    }

    public void addGameMap(GameMap map) {
        maps.addGameMap(map);
    }

    public void removeMap(String map) {
        maps.removeGameMap(map);
    }

    /**
     * Loaded once during the initialization
     * of the game. Here you can load
     * commands, listeners and other data.
     */
    public void onFirst() {
        if (!mgState.equals(ServerState.LOAD)) {
            return;
        }
        if (initialized()) {
            Log.write("The game has already been initialized. " +
                    "It is not possible to run the method.");
            return;
        }
        init();

        if (phases.isValid()) {
            phases.getGamePhases().sort(Comparator.comparingInt(
                    gp -> gp.getAnnotation().priority()));

            phases.startPhase(phases.getFirstPhase()); // Run first phase

            System.out.println("========================");
            System.out.println("Arena: " + getClass().getSimpleName());
            System.out.println("Loaded game maps: " + maps.size());
            System.out.println("Loaded game phases: " + phases.size());
            System.out.println("========================");

            afterInit();
            setMgState(ServerState.RUNNING);
        } else {
            setMgState(ServerState.NOT_INITIALIZE);

            System.out.println("========================");
            System.out.println("Game phases not found.");
            System.out.println("========================");
        }
    }

    /**
     * Called at the end of the minigame.
     */
    public void onEnd() {
        if (mgState.equals(ServerState.DISABLE)) {
            return;
        }
        setMgState(ServerState.DISABLE);
        phases.finish();
        maps.finish();
        finish();
    }

    /**
     * Change the game mode for all players.
     */
    public void changeGameMode(GameMode gameMode) {
        setGameMode(gameMode);

        getGamers().forEach(gamer -> gamer.getPlayer()
                .setGameMode(gameMode));
    }

    /**
     * Go to the next phase of the minigame.
     */
    public void startNextPhase() {
        GamePhase next = phases.nextPhase();
        if (next == null) return;
        phases.startPhase(next);
    }

    /**
     * Get a wrapper for the player entity
     * from the list of active players.
     *
     * @return Optional(Gamer)
     */
    public Optional<Gamer> getGamer(Player player) {
        return gamers.stream()
                .filter(gamer -> gamer.getUniqueId().equals(player.getUniqueId()))
                .findFirst();
    }

    /**
     * Check if the player is playing
     * in a certain arena.
     */
    public boolean isPlaying(Player player) {
        Optional<Gamer> opt = getGamer(player);
        return opt.isPresent();
    }

    /**
     * Initializing maps and other
     * things in this method.
     */
    public abstract void init();

    /**
     * Here we can do something after
     * the initialization of the minigame.
     */
    protected void afterInit() {}

    /**
     * Override if additional processes
     * need to be closed or terminated.
     */
    protected void finish() {}
}
