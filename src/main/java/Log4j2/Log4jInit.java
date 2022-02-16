package Log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jInit {
    private static final Logger logger = LogManager.getLogger(Log4jInit.class);

    public static void main(String[] args) {
        logger.debug("Log4j is working" );

    }

}