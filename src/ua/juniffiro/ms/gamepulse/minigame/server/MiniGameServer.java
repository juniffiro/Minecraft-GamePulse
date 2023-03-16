package ua.juniffiro.ms.gamepulse.minigame.server;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public interface MiniGameServer {

    /**
     * Number of slots for players on the server.
     */
    int maxSlots();

    /**
     * Checking the ability to connect
     * to the server.
     */
    boolean canJoin();

    /**
     * Check if the server is full.
     */
    boolean isFull();

    /**
     * Server initialization.
     * Suitable for initializing
     * databases and other things.
     */
    void initialize();

    /**
     * What to do when the server
     * shuts down.
     */
    void onDisable();
}
