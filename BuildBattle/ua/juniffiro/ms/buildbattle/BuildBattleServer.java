package ua.juniffiro.ms.buildbattle;

import ua.juniffiro.ms.gamepulse.minigame.server.mono.MonoServer;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class BuildBattleServer extends MonoServer {

    public BuildBattleServer() {
        super(new BuildBattleMonoArena(2,12));
    }

    @Override
    public void initialize() {
        //
    }

    @Override
    public void onDisable() {
        getArena().onEnd();
    }
}
