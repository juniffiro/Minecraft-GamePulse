package ua.juniffiro.ms.gamepulse.util;

import org.bukkit.scheduler.BukkitRunnable;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/03/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class Timer extends BukkitRunnable {

    /*
        Utility for creating a countdown timer.
     */

    private int countdownTime;
    private final Tasks tasks;

    public Timer(Tasks tasks) {
        this.tasks = tasks;
        this.countdownTime = tasks.taskTime();
    }

    @Override
    public void run() {
        if (countdownTime == 0) {
            tasks.onTimerFinish();
            this.cancel();
            return;
        }
        if (tasks.conditionCountdownFalse()) {
            countdownTime = tasks.taskTime();
            tasks.onConditionCountdownFalse(countdownTime);
        } else {
            tasks.onConditionSuccessRunning(countdownTime);
            --countdownTime;
        }
    }
}
