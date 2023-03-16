package ua.juniffiro.ms.gamepulse.util;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import ua.juniffiro.ms.gamepulse.Main;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/03/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class ListenerHandler {

    /**
     * Register a new listener.
     */
    public static void register(Listener listener) {
        Bukkit.getServer()
                .getPluginManager()
                .registerEvents(listener, Main.getInstance());
    }

    /**
     * Register a new listener.
     */
    public static void register(Listener listener, Plugin plugin) {
        Bukkit.getServer()
                .getPluginManager()
                .registerEvents(listener, plugin);
    }

    /**
     * Unregister a specific listener.
     */
    public static void unregister(Listener listener) {
        HandlerList.unregisterAll(listener);
    }
}
