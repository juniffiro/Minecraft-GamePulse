package ua.juniffiro.ms.gamepulse.util;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/03/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public interface Tasks {

    /**
     * Countdown time.
     */
    int taskTime();

    /**
     * Conditions when the game does not start.
     */
    boolean conditionCountdownFalse();

    /**
     * When the countdown finished.
     */
    void onTimerFinish();

    /**
     * If the condition is false.
     * The method is executed every second.
     */
    void onConditionCountdownFalse(int countdownTime);

    /**
     * If the condition is true.
     * The method is executed every second.
     */
    void onConditionSuccessRunning(int countdownTime);
}
