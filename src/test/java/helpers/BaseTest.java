package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Configuration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

abstract public class BaseTest {

    WebDriver driver;
    @Before
    void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @After
    void tearDown() {
        driver.quit();
    }

}
