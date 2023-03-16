package ua.juniffiro.ms.gamepulse.minigame.map;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 11/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface GameMapInfo {

    /**
     * Game map name.
     * May be the same as the name of the game world.
     */
    String mapName();

    /**
     * Game map version.
     */
    String version();

    /**
     * Game map type.
     * Used for the event processing system
     * and to indicate the purpose of the map.
     * By default, PLAY.
     */
    GameMapType mapType() default GameMapType.PLAY;

    String[] authors() default {};

    /**
     * Game map description.
     */
    String description();
}

