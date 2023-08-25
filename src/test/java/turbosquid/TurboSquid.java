package turbosquid;

import helpers.ConfigProvider;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.DetailsPage;
import pages.LoginPage;
import pages.MainPage;
import base.BaseSeleniumTest;
import pages.SearchPage;

public class TurboSquid extends BaseSeleniumTest {
    @Test
    public void Login(){
        MainPage mainPage = new MainPage();
        mainPage.MoveToLogin()
                .InputLoginData(ConfigProvider.EMAIL, ConfigProvider.PASSWORD);
        Assert.assertTrue(driver.getCurrentUrl().contains(ConfigProvider.LOGIN_URL));
        Assert.assertTrue(driver.findElement(By.className("icon-user")).isDisplayed());
    }
    @Test
    public void IncorrectLogin(){
        LoginPage loginPage = new MainPage().MoveToLogin().WrongInputLoginData(ConfigProvider.INCORRECT_EMAIL, ConfigProvider.PASSWORD);
        Assert.assertTrue(driver.getCurrentUrl().contains(ConfigProvider.LOGIN_URL));
        Assert.assertEquals(loginPage.getErrorMessage(), "invalid email or password.");
    }
    @Test
    public void Search(){
        DetailsPage detailsPage = new MainPage().Search(ConfigProvider.SEARCH_DATA)
                .OpenDetails()
                .AddToCart("1");
    }
    @Test
    public void SearchWithChangeType(){
        SearchPage searchPage = new MainPage().ChangeTypeSearch().Search(ConfigProvider.SEARCH_DATA);
        Assert.assertTrue(searchPage.getPriceElement());
        Assert.assertTrue(searchPage.getSearchResult().contains(ConfigProvider.SEARCH_DATA));
    }
    @Test
    public void AddToCartUser(){
        MainPage mainPage = new MainPage();
        mainPage.MoveToLogin()
                .InputLoginData(ConfigProvider.EMAIL, ConfigProvider.PASSWORD)
                .Search(ConfigProvider.SEARCH_DATA)
                .OpenDetails()
                .AddToCart("4");
    }
}
