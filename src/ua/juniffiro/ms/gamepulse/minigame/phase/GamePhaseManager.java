package ua.juniffiro.ms.gamepulse.minigame.phase;

import java.util.LinkedList;
import java.util.Optional;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 11/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class GamePhaseManager {

    private final LinkedList<GamePhase> gamePhases;
    private GamePhase currentPhase;

    public GamePhaseManager() {
        this.gamePhases = new LinkedList<>();
    }

    public LinkedList<GamePhase> getGamePhases() {
        return gamePhases;
    }

    public GamePhase getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(GamePhase currentPhase) {
        this.currentPhase = currentPhase;
    }

    /**
     * Get game phase by name.
     *
     * @return Optional(GamePhase).
     */
    public Optional<GamePhase> getGamePhase(String phaseName) {
        return gamePhases.stream()
                .filter(gamePhase -> gamePhase.getAnnotation()
                        .phaseName().equals(phaseName))
                .findFirst();
    }

    /**
     * Add new game phase.
     */
    public void addPhase(GamePhase phase) {
        this.gamePhases.add(phase);
    }

    /**
     * Remove phase from phases list.
     */
    public void removePhase(GamePhase phase) {
        this.gamePhases.remove(phase);
    }

    /**
     * Remove phase from phases list by name.
     */
    public void removePhase(String phaseName) {
        Optional<GamePhase> phase = getGamePhase(phaseName);
        phase.ifPresent(gamePhases::remove);
    }

    public GamePhase getFirstPhase() {
        return gamePhases.getFirst();
    }

    public void startPhase(GamePhase phase) {
        phase.start();
        setCurrentPhase(phase);
    }

    /**
     * The next game phase after current.
     *
     * @return Next game phase.
     */
    public GamePhase nextPhase() {
        return gamePhases.get(gamePhases.indexOf(currentPhase) + 1);
    }

    public boolean isValid() {
        return !gamePhases.isEmpty() && gamePhases.getFirst() != null;
    }

    public void finish() {
        gamePhases.clear();
    }

    public int size() {
        return gamePhases.size();
    }
}
