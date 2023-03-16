package ua.juniffiro.ms.gamepulse.minigame.phase;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 11/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface GamePhaseInfo {

    /**
     * Game phase name.
     */
    String phaseName();

    /**
     * The prefix for the current phase
     * to be used in chat, etc.
     */
    String prefix();

    /**
     * Game phase priority.
     */
    int priority();
}
