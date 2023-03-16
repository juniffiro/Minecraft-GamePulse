package ua.juniffiro.ms.gamepulse;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {}

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onDisable() {}
}
