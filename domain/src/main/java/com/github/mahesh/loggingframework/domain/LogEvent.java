package com.github.mahesh.loggingframework.domain;

import java.time.Instant;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

/**
 * Immutable representation of a log entry.
 */
public final class LogEvent {
    private final Instant timestamp;
    private final LogLevel level;
    private final String message;
    private final String loggerName;
    private final String threadName;
    private final Map<String,String> contextMap;
    private final Throwable throwable;

    public LogEvent(
            Instant timestamp,
            LogLevel level,
            String message,
            String loggerName,
            String threadName,
            Map<String, String> contextMap,
            Throwable throwable
    ) {
        this.timestamp = timestamp;
        this.level = level;
        this.message = message;
        this.loggerName = loggerName;
        this.threadName = threadName;
        this.contextMap = contextMap != null ? Collections.unmodifiableMap(contextMap) : Collections.emptyMap();
        this.throwable = throwable;
    }

    public Instant getTimestamp() { return timestamp; }
    public LogLevel getLevel() { return level; }
    public String getMessage() { return message; }
    public String getLoggerName() { return loggerName; }
    public String getThreadName() { return threadName; }
    public Map<String, String> getContextMap() { return contextMap; }

    public Optional<Throwable> getThrowable() {
        return Optional.ofNullable(throwable);
    }
}
