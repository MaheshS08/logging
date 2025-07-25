package com.github.mahesh.loggingframework.domain;

public interface Filter {
    boolean shouldLog(LogEvent logEvent);
}
