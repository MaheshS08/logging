package com.github.mahesh.loggingframework.core.logger;

import com.github.mahesh.loggingframework.api.Logger;
import com.github.mahesh.loggingframework.core.dispatch.LogDispatcher;
import com.github.mahesh.loggingframework.domain.LogEvent;
import com.github.mahesh.loggingframework.domain.LogLevel;

import java.time.Instant;
import java.util.Map;

/**
 * A simple synchronous logger that logs messages to standard output.
 *
 * <p>It checks the current log level, enriches the message with MDC data,
 * and delegates log output to the LogDispatcher.</p>
 */
public class SimpleLogger implements Logger {

    private final String loggerName;
    private final LogLevel configuredLevel;
    private LogDispatcher dispatcher;

    public SimpleLogger(String name) {
        this.loggerName = name;
        this.configuredLevel = LogLevel.INFO; // default log level
    }


    @Override
    public void info(String message) {

    }

    private void log(LogLevel level, String message, Throwable t) {
        if (!isLogLevelEnabled(level)) {
        }
        Map<String, String> contextMap = MDC.getContextMap();
        LogEvent logEvent = new LogEvent(
                Instant.now(),
                level,
                message,
                loggerName,
                t.getClass().getName(),
                contextMap,
                t);
        LogDispatcher.dispatch(logEvent);
    }

    private boolean isLogLevelEnabled(LogLevel level) {
        return level.ordinal() >= configuredLevel.ordinal();
    }

}
