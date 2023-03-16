package ua.juniffiro.ms.gamepulse.util;

import org.bukkit.ChatColor;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 12/03/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class TimeUtil {

    /**
     * Handler for timer.
     * Returns 'true' every
     * 20, 10, 5, 4, 3, 2, 1 seconds.
     * @param i
     *        Countdown time
     */
    public static boolean shouldAnnounceTime(int i) {
        return (i <= 20 && i % 5 == 0 && i != 15) || i <= 5;
    }

    /**
     * Handler for the timer.
     * Returns a specific color depending
     * on the countdown time.
     *
     * @param i
     *        Countdown time
     */
    public static ChatColor getColor(int i) {
        ChatColor color;
        switch (i) {
            case 5:
            case 4:
                color = ChatColor.DARK_RED;
                break;
            case 3:
                color = ChatColor.RED;
                break;
            case 2:
                color = ChatColor.YELLOW;
                break;
            case 1:
                color = ChatColor.GREEN;
                break;
            default:
                color = ChatColor.AQUA;
                break;
        }
        return color;
    }
}
