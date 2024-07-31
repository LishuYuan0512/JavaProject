package logger;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LMSLogger {
    private final String LOG_FILE = "app.log";
    private static PrintWriter writer;
    private static LMSLogger lmsLoggerInstance;

    /**
     * Private constructor.
     * @throws IOException
     */
    private LMSLogger() throws IOException{
        try{
            writer = new PrintWriter(new FileWriter(LOG_FILE, true));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * This method to ensure only one LMSLogger instance is initialized
     * @return lmsLoggerInstance
     * @throws IOException
     */
    public static synchronized LMSLogger getInstance() throws IOException {
        if (lmsLoggerInstance == null) {
            lmsLoggerInstance = new LMSLogger();
        }
        return lmsLoggerInstance;
    }

    /**
     * Method to write logs into the log file
     * @param level
     * @param message
     */
    public void log(LogLevel level, String message) {
        writer.println("[" + level + "] " + message);
        writer.flush();
    }

    /**
     * Method to write exceptions into the log file
     * @param e
     */
    public void logException(Exception e) {
        writer.println("[EXCEPTION] " + e.getMessage());
        e.printStackTrace(writer);
        writer.flush();
    }

    /**
     * This method is to close the log file.
     */
    public void close() {
        writer.close();
    }
}
