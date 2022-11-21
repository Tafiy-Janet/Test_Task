package webUI;


import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

public class LoginPage extends BasePage {

    private By usernameInput = By.xpath("//input[@id='user-name']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//input[@id='login-button']");
    private By shoppingCartButton = By.xpath("//div[@id='shopping_cart_container']");
    private By errorMessage = By.xpath("//div[@class='error-message-container error']");


    public LoginPage enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public LoginPage clickLogin() {
        driver.findElement(loginButton).click();
        return this;
    }

    public boolean isAlertNotPresent() {
        try {
            driver.switchTo().alert();
        } catch (NoAlertPresentException e) {
            return true;
        }
        return false;
    }

    public boolean isShoppingCartDisplayed() {
        if (!isAlertNotPresent()) {
            driver.switchTo().alert().accept();
        }
        return driver.findElement(shoppingCartButton).isDisplayed();
    }

    public boolean isErrorAppears() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isErrorWithExpectedMessage(String expectedError) {
        String actualError = driver.findElement(errorMessage).getText();
        return actualError.contains(expectedError);
    }

}
