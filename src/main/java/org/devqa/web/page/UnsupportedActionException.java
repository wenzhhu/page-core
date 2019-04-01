package org.devqa.web.page;

/**
 * Thrown to indicate that the requested action is not supported on the
 * {@link org.devqa.web.page.Page}.
 */
public class UnsupportedActionException extends RuntimeException {
    public UnsupportedActionException() {
    }

    public UnsupportedActionException(String message) {
        super(message);
    }

    public UnsupportedActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedActionException(Throwable cause) {
        super(cause);
    }

    private static final long serialVersionUID = 1L;

}
