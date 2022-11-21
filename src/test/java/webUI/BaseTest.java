package webUI;


import helpers.PropertyReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;


public class BaseTest {

    protected static WebDriver driver;

    @BeforeEach
    public void setUp(TestInfo info) {
        if (info.getTags().contains("UI")) {
            BasePage.URL = PropertyReader.getWebURL();
            driver = BasePage.getDriver();
        }
    }

    @AfterEach
    public void tearDown() {
        BasePage.disposeDriver();
    }
}
