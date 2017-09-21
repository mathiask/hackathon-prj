package com.capgemini.hackathon.common.logging;

/**
 * Simple Logging API for HRL based on the SLF4J interface.
 * The {@link Slf4jLogImpl} implementation simply delegates to the SLF4J API.
 * <p>
 * <b>Log Declaration</b><p>
 * The log should be declared as:
 * <pre>
 *     private static final Log LOG = LogFactory.create();
 * </pre>
 * <p>
 * <b>Parameterized Logging</b><p>
 * Instead of using string concatenation this interface supports parameter placeholder marked with <code>{}</code>
 * and the parameter are passed as object array.
 * <pre>
 *     LOG.info("The vehicle for vin {} was not found in order {}", vin, orderId);
 *     LOG.debug("vin was null");
 * </pre>
 * <p>
 * <b>Logging Exceptions</b><p>
 * To log an exception the exception must be the last paramter in the object array and no marker must be present for
 * this parameter.
 * <pre>
 *     LOG.debug("The vehicle for vin {} could not be found", vin, exception);
 * </pre>
 *
 * @see LogFactory
 */
public interface Log {

    /**
     * Log an exception (throwable) at the ERROR level with an
     * accompanying message.
     *
     * @param message the message accompanying the exception
     * @param t       the exception (throwable) to log
     */
    void error(String message, Throwable t);

    /**
     * Writes an <em>error</em> message to the log.
     *
     * @param message the message to log, param placeholder are marked with <code>{}</code>.
     * @param params  the params for the message;
     *                if the last parameter is an exception and it has no marker then the stack trace will aso be logged
     */
    void error(String message, Object... params);

    /**
     * Writes an <em>warning</em> message to the log.
     *
     * @param message the message to log, param placeholder are marked with <code>{}</code>.
     * @param params  the params for the message;
     *                if the last parameter is an exception and it has no marker then the stack trace will aso be logged
     */
    void warn(String message, Object... params);

    /**
     * Writes an <em>information</em> message to the log.
     *
     * @param message the message to log, param placeholder are marked with <code>{}</code>.
     * @param params  the params for the message;
     *                if the last parameter is an exception and it has no marker then the stack trace will aso be logged
     */
    void info(String message, Object... params);

    /**
     * Writes an <em>debugging</em> message to the log.
     *
     * @param message the message to log, param placeholder are marked with <code>{}</code>.
     * @param params  the params for the message;
     *                if the last parameter is an exception and it has no marker then the stack trace will aso be logged
     */
    void debug(String message, Object... params);
}
