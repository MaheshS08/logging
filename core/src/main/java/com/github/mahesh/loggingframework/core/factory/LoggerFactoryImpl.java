package com.github.mahesh.loggingframework.core.factory;

import com.github.mahesh.loggingframework.api.Logger;
import com.github.mahesh.loggingframework.api.LoggerFactory;
import com.github.mahesh.loggingframework.core.logger.SimpleLogger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 *
 * @author Mahesh
 *
 * Implementation of LoggerFactory that returns logger instances.
 *
 * <p>Caches loggers by name or class and delegates creation to the logger backend.
 * For now, only SimpleLogger is supported, but the design is extensible for future
 * logger types (e.g., AsyncLogger, FilteredLogger).</p>
 */
public class LoggerFactoryImpl implements LoggerFactory {

    // Cache to store and reuse logger instances
    private static final Map<String, Logger> loggerCache = new ConcurrentHashMap<>();

    /**
     * Returns a logger instance for the given class.
     *
     * @param clazz the class for which a logger is desired
     * @return a logger instance
     */
    @Override
    public Logger getLogger(Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Class cannot be null");
        }
        return getLogger(clazz.getName());
    }

    /**
     * Returns a logger instance for the given name.
     *
     * @param name the name of the logger
     * @return a logger instance
     */
    @Override
    public Logger getLogger(String name){
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Logger name cannot be null or empty");
        }
        return loggerCache.computeIfAbsent(name, SimpleLogger::new);
    }

}
