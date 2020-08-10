package auth.exception;

/**
 * @author fdse
 */
public class UserOperationException extends RuntimeException {
    private static final long serialVersionUID = 8468616518092020748L;

    public UserOperationException(String msg) {
        super(msg);
    }
}
