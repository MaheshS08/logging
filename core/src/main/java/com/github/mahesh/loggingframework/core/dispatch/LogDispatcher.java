package com.github.mahesh.loggingframework.core.dispatch;


import com.github.mahesh.loggingframework.core.formatter.PlainTextFormatter;
import com.github.mahesh.loggingframework.domain.Formatter;
import com.github.mahesh.loggingframework.domain.LogEvent;

/**
 * @author Mahesh
 * Dispatches log events to output destinations.
 *
 * <p>Currently, writes to the console using standard output. In future versions,
 * will support file output, JSON formatters, and asynchronous writing.</p>
 */
public class LogDispatcher {
    private static final Formatter formatter = new PlainTextFormatter();

    /**
     * Dispatches the given log event to the output destination.
     *
     * @param event The log event to be dispatched.
     */
    public static void dispatch(LogEvent event) {
        if (event == null) return;
        String message = formatter.format(event);
        switch (event.getLevel()) {
            case ERROR:
            case FATAL:
                System.err.println(message);
                break;
            default:
                System.out.println(message);

        }
    }
}
