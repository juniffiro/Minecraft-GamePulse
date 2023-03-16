package ua.juniffiro.ms.gamepulse.minigame;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 08/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public enum MiniGameCategory {

    /**
     * A category of minigames with
     * an emphasis on survival.
     * (ex: UHC, SKYWARS)
     */
    SURVIVAL,

    /**
     * Arcade, jogging, platformers.
     * Mostly without battles and PvP.
     * (ex: BuildBattle, SpeedBuilders,
     * BlockParty, Pixel Block, etc.)
     */
    ARCADE,

    /**
     * PvP-based minigames. These can be
     * both 1-on-1 duels and team battles.
     * ex: Duels, KitPvP, GunGame
     */
    PVP,

    /**
     * PvE-based minigames. This is a battle
     * with mobs in single-player and team mode.
     * ex. MobWars, MobArena
     */
    PVE,

    /**
     * Mini-games that don't fall into
     * the standard categories.
     * ex: RPG based
     */
    OTHER
}
