package com.capgemini.hackathon.common.logging;

import org.slf4j.Logger;

import javax.annotation.Nonnull;

/**
 * Factory for getting Logs.
 * <p>
 * Each class which wants to log should create the logger as follows:
 * <code>
 * private static final Log LOG = LogFactory.create();
 * </code>
 * If non class level logs are needed #getLog could be used.
 */
public final class LogFactory {

    /**
     * Private constructor since there should be no instances of this class.
     */
    private LogFactory() {
    }

    /**
     * Return the log for the current (calling) class.
     * The current class is determined via stacktrace.
     *
     * @return the log for the calling class
     */
    @Nonnull
    public static Log getLog() {
        final Throwable t = new Throwable();
        final StackTraceElement directCaller = t.getStackTrace()[1];
        return getLog(directCaller.getClassName());
    }

    /**
     * Return the log named logName.
     *
     * @param logName the name of the log to return
     * @return the log named logName
     */
    @Nonnull
    public static Log getLog(@Nonnull String logName) {
        return new Slf4jLogImpl(getSlf4jLogger(logName));
    }

    private static Logger getSlf4jLogger(@Nonnull String aLoggerName) {
        return org.slf4j.LoggerFactory.getLogger(aLoggerName);
    }
}
