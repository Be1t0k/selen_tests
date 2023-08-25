package selenide.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseSelenideTest {
     public void setUp(){
         WebDriverManager.chromedriver().setup();
         Configuration.browser = "chrome";
         Configuration.headless = false;
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
