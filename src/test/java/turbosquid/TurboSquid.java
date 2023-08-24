package turbosquid;

import helpers.ConfigProvider;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import base.BaseSeleniumTest;

public class TurboSquid extends BaseSeleniumTest {
    @Test
    public void Login(){
        MainPage mainPage = new MainPage();
        mainPage.MoveToLogin()
                .InputLoginData(ConfigProvider.EMAIL, ConfigProvider.PASSWORD);
    }
    @Test
    public void Search(){
        MainPage mainPage = new MainPage();
        mainPage.Search("metal")
                .AddToCart();
    }
}
