package ua.juniffiro.ms.gamepulse.minigame.server;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 08/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public enum ServerState {

    /**
     * Installed at server startup.
     */
    LOAD,

    RUNNING,

    DISABLE,

    RELOAD,

    /**
     * Set if something is not
     * loaded during initialization.
     */
    NOT_INITIALIZE;
}
