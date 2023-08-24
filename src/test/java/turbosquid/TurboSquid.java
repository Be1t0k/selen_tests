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
    public void IncorrectLogin(){
        MainPage mainPage = new MainPage();
        mainPage.MoveToLogin().InputLoginData(ConfigProvider.INCORRECT_EMAIL, ConfigProvider.PASSWORD);
    }
    @Test
    public void Search(){
        MainPage mainPage = new MainPage();
        mainPage.Search(ConfigProvider.SEARCH_DATA)
                .OpenDetails()
                .AddToCart();
    }
    @Test
    public void SearchWithChangeType(){
        MainPage mainPage = new MainPage();
        mainPage.ChangeTypeSearch().Search(ConfigProvider.SEARCH_DATA);
    }
    @Test
    public void AddToCartUser(){
        MainPage mainPage = new MainPage();
        mainPage.MoveToLogin()
                .InputLoginData(ConfigProvider.EMAIL, ConfigProvider.PASSWORD)
                .Search(ConfigProvider.SEARCH_DATA)
                .OpenDetails()
                .AddToCart();
    }
}
