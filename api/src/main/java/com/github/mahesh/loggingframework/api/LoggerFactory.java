package com.github.mahesh.loggingframework.api;

public interface LoggerFactory  {
    Logger getLogger(Class<?> clazz);
    Logger getLogger(String name);
}
