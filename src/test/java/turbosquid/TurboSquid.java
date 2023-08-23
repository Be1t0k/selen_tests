package turbosquid;

import helpers.ConfigProvider;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import base.BaseSeleniumTest;

public class TurboSquid extends BaseSeleniumTest {
    @Test
    public void Login(){
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        mainPage
                .MoveToLogin()
                .InputLoginData(ConfigProvider.EMAIL, ConfigProvider.PASSWORD)
                .Search("metal");
                //.AddToCart();
    }
}
