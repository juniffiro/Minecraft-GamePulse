package ua.juniffiro.ms.gamepulse.log;

import java.util.logging.Logger;

public class Log {

    public static Logger logger = Logger.getLogger("GameIts...");

    public static void write(Object object) {
        logger.info(object.toString());
    }
}