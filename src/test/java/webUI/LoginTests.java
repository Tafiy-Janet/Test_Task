package webUI;

import helpers.WebUITestValues;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("UI")
public class LoginTests extends BaseTest {

    private LoginPage loginForm = new LoginPage();

    @Test
    public void successfulUserAuthorization() {
        loginForm.enterUsername(WebUITestValues.actualUsername)
                .enterPassword(WebUITestValues.actualPassword)
                .clickLogin();
        Assertions.assertTrue(loginForm.isShoppingCartDisplayed());
    }

    @Test
    public void unsuccessfulUserAuthorization1() {
        loginForm.enterUsername(WebUITestValues.emptyUsername)
                .enterPassword(WebUITestValues.emptyPassword)
                .clickLogin();
        Assertions.assertTrue(loginForm.isErrorAppears());
        Assertions.assertTrue(loginForm.isErrorWithExpectedMessage(WebUITestValues.expectedErrorForEmptyField));
    }

    @Test
    public void unsuccessfulUserAuthorization2() {
        loginForm.enterUsername(WebUITestValues.nonExistentUsername)
                .enterPassword(WebUITestValues.nonExistentPassword)
                .clickLogin();
        Assertions.assertTrue(loginForm.isErrorAppears());
        Assertions.assertTrue(loginForm.isErrorWithExpectedMessage(WebUITestValues.expectedErrorForUnregisteredUser));
    }


}
