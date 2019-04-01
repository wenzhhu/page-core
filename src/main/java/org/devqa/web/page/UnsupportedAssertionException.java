package org.devqa.web.page;

/**
 * Thrown to indicate that the requested action is not supported on the
 * {@link org.devqa.web.page.Page}.
 */
public class UnsupportedAssertionException extends RuntimeException {
    public UnsupportedAssertionException() {
    }

    public UnsupportedAssertionException(String message) {
        super(message);
    }

    public UnsupportedAssertionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedAssertionException(Throwable cause) {
        super(cause);
    }

    private static final long serialVersionUID = 1L;

}
