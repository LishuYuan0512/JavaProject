
package logger;
/**
 * This is a enumerated class, containing 5 levels of information.
 * @author yye00
 */
public enum LogLevel {
    TRACE(1),
    DEBUG(2),
    INFO(3),
    WARN(4),
    ERROR(5);

    final int level;

    /**
     * Constructor.
     * @param level
     */
    LogLevel(int level) {
        this.level = level;
    }
}

