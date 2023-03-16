package ua.juniffiro.ms.gamepulse.minigame.server.multi;

import ua.juniffiro.ms.gamepulse.minigame.arena.multi.Arena;
import ua.juniffiro.ms.gamepulse.minigame.map.GameMap;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/03/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public interface ArenaHandler {

    /**
     * The method of processing certain events.
     * This option is intended for servers with
     * multiple arenas, because servers of this
     * type use a single event handler.
     * Using this method, we can handle events
     * such as a player being in the
     * lobby, as well as him being in the game.
     *
     * @param arena
     *        Game arena
     * @param map
     *        The game map on which the
     *        player is now
     */
    void handleArena(Arena arena, GameMap map);
}
