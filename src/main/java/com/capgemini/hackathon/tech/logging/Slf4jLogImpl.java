package com.capgemini.hackathon.tech.logging;

import org.slf4j.Logger;

/**
 * Slf4jLogImpl which simply delegates the Log methods to the underlying SLF4J interface.
 */
class Slf4jLogImpl implements Log {
    @SuppressWarnings("squid:S1312")
    // this is our own implementation and used for different loggers, thus we have to suppress sonar warning
    final Logger slf4jLogger;

    Slf4jLogImpl(final Logger logger) {
        slf4jLogger = logger;
    }

    public void error(final String message, final Throwable t) {
        slf4jLogger.error(message, t);
    }

    public void error(final String message, final Object... params) {
        slf4jLogger.error(message, params);
    }

    public void warn(final String message, final Object... params) {
        slf4jLogger.warn(message, params);
    }

    public void info(final String message, final Object... params) {
        slf4jLogger.info(message, params);
    }

    public void debug(final String message, final Object... params) {
        slf4jLogger.debug(message, params);
    }
}
