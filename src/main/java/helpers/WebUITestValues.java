package helpers;

public class WebUITestValues {

    public static String actualUsername = "standard_user";
    public static String actualPassword = "secret_sauce";
    public static String nonExistentUsername = "ghost.123";
    public static String nonExistentPassword = "123Password";
    public static String emptyUsername = "";
    public static String emptyPassword = "";
    public static String expectedErrorForEmptyField = "Username is required";
    public static String expectedErrorForUnregisteredUser = "Username and password do not match any user in this service";
}
