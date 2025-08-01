package com.github.mahesh.loggingframework.core.formatter;

import com.github.mahesh.loggingframework.domain.Formatter;
import com.github.mahesh.loggingframework.domain.LogEvent;

public class PlainTextFormatter implements Formatter {
    @Override
    public String format(LogEvent event) {
        StringBuilder message = new StringBuilder();
        message.append("["+event.getTimestamp()+"] - ["+event.getLevel()+"] - ["+event.getLoggerName()+"] - ["+event.getMessage()+"]");
        return message.toString();
    }
}
