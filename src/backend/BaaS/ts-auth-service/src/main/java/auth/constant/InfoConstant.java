package auth.constant;

/**
 * @author fdse
 */
public class InfoConstant {

    private InfoConstant() {
        throw new IllegalStateException("Utility class");
    }

    // User service information. If require params, the suffix number is the number of params

    public static final String DUPLICATE = "Duplicate";
    public static final String USER_HAS_ALREADY_EXIST = "User has already exist.";
    public static final String PROPERTIES_CANNOT_BE_EMPTY_1 = "{0} cannot be empty.";
    public static final String USER_IS_NOT_EXIST_2 = "User is not exist, {0}: {1}.";
    public static final String PASSWORD_LEAST_CHAR_1 = "Passwords must contain at least {0} characters."; //NOSONAR
    public static final String USER_NAME_NOT_FOUND_1 = "Username not found: {0}.";

    // User properties

    public static final String ID = "id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password"; //NOSONAR
    public static final String ROLES = "roles";

}
