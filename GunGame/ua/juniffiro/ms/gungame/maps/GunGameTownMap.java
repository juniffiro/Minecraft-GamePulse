package ua.juniffiro.ms.gungame.maps;

import org.bukkit.Bukkit;
import ua.juniffiro.ms.gamepulse.minigame.map.GameMap;
import ua.juniffiro.ms.gamepulse.minigame.map.GameMapInfo;
import ua.juniffiro.ms.gamepulse.minigame.map.GameMapType;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/03/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
@GameMapInfo(mapName = "Town",
        version = "1.0.0",
        mapType = GameMapType.PLAY,
        description = "Small sky town")
public class GunGameTownMap extends GameMap {

    public GunGameTownMap() {
        super(Bukkit.getWorld("world"));
    }
}
