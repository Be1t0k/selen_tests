package selenide.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseSelenideTest {
     public void setUp(){
         Configuration.browser = "chrome";
         Configuration.headless = false;
         Configuration.pageLoadStrategy = "normal";
     }
     @Before
    public void init(){
         setUp();
     }
     @After
    public void tearDown(){
         Selenide.closeWebDriver();
     }
}
