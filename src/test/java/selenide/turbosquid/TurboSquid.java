package selenide.turbosquid;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import helpers.ConfigProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import selenide.base.BaseSelenideTest;
import selenide.pages.LoginPage;
import selenide.pages.MainPage;
import selenide.pages.SearchPage;
import selenium.pages.DetailsPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;


public class TurboSquid extends BaseSelenideTest {
    @Test
    public void Login(){
        MainPage mainPage = new MainPage()
                .MoveToLogin()
                .InputLoginData(ConfigProvider.EMAIL, ConfigProvider.PASSWORD);
        System.out.println(webdriver().driver().getCurrentFrameUrl());
        Assert.assertTrue(webdriver().driver().getCurrentFrameUrl().contains(ConfigProvider.URL));
    }
    @Test
    public void IncorrectLogin(){
        LoginPage loginPage = new MainPage().MoveToLogin().InputWrongLoginData(ConfigProvider.INCORRECT_EMAIL, ConfigProvider.PASSWORD);
        Assert.assertTrue(webdriver().object().getCurrentUrl().contains(ConfigProvider.LOGIN_URL));
        Assert.assertEquals(loginPage.getErrorMessage(), "invalid email or password.");
    }
    @Test
    public void SearchAddToCart(){
        SearchPage searchPage = new MainPage().Search(ConfigProvider.SEARCH_DATA)
                .FromSearchAddToCart();
        Assert.assertEquals("1", $x("//*[@id=\"btnNavCart\"]/span[2]").getText());
    }

    @Test
    public void SearchWithChangeType(){
        SearchPage searchPage = new MainPage()
                .ChangeTypeSearch()
                .Search(ConfigProvider.SEARCH_DATA);
        Assert.assertTrue(webdriver().driver().getCurrentFrameUrl().contains(ConfigProvider.URL));
        Assert.assertTrue(searchPage.getSearchResult().contains(ConfigProvider.SEARCH_DATA.toLowerCase()));
    }
    /*
    @Test
    public void AddToCartUser(){
        MainPage mainPage = new MainPage();
        mainPage.MoveToLogin()
                .InputLoginData(ConfigProvider.EMAIL, ConfigProvider.PASSWORD)
                .Search(ConfigProvider.SEARCH_DATA)
                .OpenDetails()
                .AddToCart("4");
    }*/
}
