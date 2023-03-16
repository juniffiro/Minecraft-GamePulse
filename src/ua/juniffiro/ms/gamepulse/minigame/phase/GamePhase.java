package ua.juniffiro.ms.gamepulse.minigame.phase;

import ua.juniffiro.ms.gamepulse.minigame.arena.MiniGameArena;
import ua.juniffiro.ms.gamepulse.util.Annotated;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 11/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public abstract class GamePhase extends Annotated<GamePhaseInfo> {

    private final MiniGameArena arena;
    private String motd;

    public GamePhase(MiniGameArena arena) {
        super(GamePhaseInfo.class);

        this.motd = getAnnotation().phaseName();
        this.arena = arena;
    }

    /**
     * Server motd during the phase.
     */
    public String getMotd() {
        return motd;
    }

    public void setMotd(String motd) {
        this.motd = motd;
    }

    public MiniGameArena getArena() {
        return arena;
    }

    /**
     * Start of phase.
     */
    public abstract void start();

    /**
     * End of phase.
     */
    public void end() {}

    /**
     * Clearing after the game phase actions.
     */
    public abstract void cleanup();
}
