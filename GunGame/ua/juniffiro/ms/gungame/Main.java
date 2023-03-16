package ua.juniffiro.ms.gungame;

import ua.juniffiro.ms.gamepulse.minigame.MiniGame;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class Main extends JavaPlugin {

    private static Main instance;
    private MiniGame gg;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        gg = new GunGame(this);
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onDisable() {
        gg.miniGameServer().onDisable();
    }
}
