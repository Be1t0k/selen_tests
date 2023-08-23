package turbosquid;

import helpers.ConfigProvider;
import org.junit.Test;
import pages.LoginPage;
import test.BaseSeleniumTest;

public class TurboSquid extends BaseSeleniumTest {
    @Test
    public void Login(){
        LoginPage loginPage = new LoginPage();
        loginPage.InputLoginData(ConfigProvider.EMAIL, ConfigProvider.PASSWORD);
    }
}
