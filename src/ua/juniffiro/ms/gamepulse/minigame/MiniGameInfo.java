package ua.juniffiro.ms.gamepulse.minigame;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 11/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MiniGameInfo {

    String name();

    /**
     * The version of the minigame.
     * Used to determine the version
     * of the plugin and other things.
     */
    String version() default "1.0.0";

    String[] authors() default {};

    String description();

    /**
     * Mini-game category.
     */
    MiniGameCategory category() default MiniGameCategory.OTHER;
}
