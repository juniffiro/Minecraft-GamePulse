package ua.juniffiro.ms.gamepulse.minigame.map;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 11/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class GameMapManager {

    private final Map<String, GameMap> gameMaps = new HashMap<>();

    /**
     * Add new game map.
     */
    public void addGameMap(GameMap map) {
        if (map.getAnnotation() == null) {
            System.out.println("Не аннотирован класс.");
            return;
        }
        this.gameMaps.put(map.getAnnotation().mapName(), map);
    }

    /**
     * Check if a certain world
     * is in the list of game maps.
     */
    public boolean containsMap(World world) {
        return gameMaps.values()
                .stream()
                .anyMatch(w -> world.getName()
                        .equals(w.getWorld().getName()));
    }

    /**
     * Get the world the player is currently in.
     */
    public Optional<GameMap> getPlayerGameMap(Player player) {
        return gameMaps.values()
                .stream()
                .filter(map -> map.getWorld().getName()
                        .equals(player.getWorld().getName()))
                .findFirst();
    }

    public Map<String, GameMap> getGameMaps() {
        return gameMaps;
    }

    public void removeGameMap(String key) {
        this.gameMaps.remove(key);
    }

    /**
     * Check if the cards are
     * loaded and everything is OK.
     */
    public boolean isValid() {
        return !gameMaps.isEmpty();
    }

    /**
     * Unload the map by key.
     */
    public void unloadMap(String key) {
        GameMap map = gameMaps.get(key);
        unloadWorld(map.getWorld().getName());
        map.setLoaded(false);
    }

    public void unloadWorld(String world) {
        Bukkit.getServer().unloadWorld(world, true);
    }

    public int size() {
        return gameMaps.size();
    }

    /**
     * Unload all loaded maps.
     */
    public void finish() {
        gameMaps.values().forEach(map -> {
            if (map.isLoaded()) {
                unloadMap(map.getWorld().getName());
            }
        });
        gameMaps.clear();
    }
}
