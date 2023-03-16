package ua.juniffiro.ms.buildbattle.maps;

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
@GameMapInfo(mapName = "Sky", version = "1.0.0", mapType = GameMapType.LOBBY, description = "Test desc")
public class TestMap extends GameMap {

    public TestMap() {
        super(Bukkit.getWorld("world"));
    }



}
