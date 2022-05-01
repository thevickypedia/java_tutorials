import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

class SampleLogger {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void SampleLogMessages() {
        LOGGER.log(Level.INFO, "Sample log for INFO level");
        LOGGER.log(Level.WARNING, "Sample log for WARNING level");
        LOGGER.log(Level.SEVERE, "Sample log for SEVERE level");
    }
}

public class custom_logger {
    public static void main(String[] args) {
        SampleLogger sample_object = new SampleLogger();
        sample_object.SampleLogMessages();
        LogManager log_manager = LogManager.getLogManager();
        Logger log = log_manager.getLogger(Logger.GLOBAL_LOGGER_NAME);
        log.log(Level.INFO, "Sample log for INFO level");
        log.log(Level.WARNING, "Sample log for WARNING level");
        log.log(Level.SEVERE, "Sample log for SEVERE level");
    }
}
