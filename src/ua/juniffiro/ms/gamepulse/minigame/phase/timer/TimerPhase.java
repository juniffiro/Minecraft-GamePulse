package ua.juniffiro.ms.gamepulse.minigame.phase.timer;

import org.bukkit.scheduler.BukkitRunnable;
import ua.juniffiro.ms.gamepulse.minigame.arena.MiniGameArena;
import ua.juniffiro.ms.gamepulse.minigame.phase.GamePhase;
import ua.juniffiro.ms.gamepulse.util.Tasks;
import ua.juniffiro.ms.gamepulse.util.Timer;

public abstract class TimerPhase extends GamePhase {

	private final int seconds;

	public TimerPhase(MiniGameArena arena, int seconds) {
		super(arena);
		this.seconds = seconds;
	}

	@Override
	public void start() {
		MiniGameArena arena = getArena();
		BukkitRunnable runnable = new Timer(new Tasks() {
			@Override
			public int taskTime() {
				return seconds;
			}

			@Override
			public boolean conditionCountdownFalse() {
				return arena.getGamers().size() < arena.getMinPlayers();
			}

			@Override
			public void onTimerFinish() {
				cleanup();
				onGamePhaseStart();
			}

			@Override
			public void onConditionCountdownFalse(int resetCountdownTime) {
				onNotEnoughPlayers();
			}

			@Override
			public void onConditionSuccessRunning(int countdownTime) {
				onAnnounceTime(countdownTime);
			}
		});
		runnable.runTaskTimer(arena.getPlugin(), 20L, 20L);
	}

	/**
	 * Started when the countdown has finished.
	 */
	public abstract void onGamePhaseStart();

	/**
	 * In case of a shortage of players
	 * to start the phase.
	 * The method is executed every second.
	 */
	public abstract void onNotEnoughPlayers();

	/**
	 * Used to count down the timer.
	 * The method is executed every second.
	 */
	public abstract void onAnnounceTime(int countdownTime);
}

