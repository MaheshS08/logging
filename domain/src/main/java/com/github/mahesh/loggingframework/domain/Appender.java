package com.github.mahesh.loggingframework.domain;

public interface Appender {
    void append(LogEvent logEvent);
}
