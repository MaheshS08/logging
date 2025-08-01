package com.github.mahesh.loggingframework.api;

import java.util.Map;

/**
 * Mapped Diagnostic Context (MDC) allows applications to associate contextual
 * information with the current thread, enhancing the relevance and traceability
 * of log messages.
 *
 * <p>This class uses a thread-local map internally to store and retrieve
 * diagnostic information, such as user IDs, request IDs, or tenant keys.</p>
 */

public class MDC {

    private static final ThreadLocal<Map<String, String>> contextMap = new ThreadLocal<>();

    /**
     * This method adds a new key-value pair to the MDC context.
     *
     * @param key   The key for the diagnostic information.
     * @param value The value for the diagnostic information.
     */
    public static void put(String key, String value) {
        contextMap.get().put(key, value);
    }

    /**
     * This method retrieves the value associated with the given key from the MDC context.
     *
     * @param key The key for the diagnostic information.
     */
    public static String get(String key) {
        return contextMap.get().get(key);
    }


}
