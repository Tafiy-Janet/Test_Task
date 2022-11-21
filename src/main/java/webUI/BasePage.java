package webUI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;
    protected static final Duration DEFAULT_TIMEOUT_SECONDS = Duration.ofSeconds(15);
    protected static String URL;

    private static WebDriver get() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(DEFAULT_TIMEOUT_SECONDS);
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT_SECONDS);
        driver.get(URL);
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = get();
        }
        return driver;
    }

    public static void disposeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
