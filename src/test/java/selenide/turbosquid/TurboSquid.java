package selenide.turbosquid;

import helpers.ConfigProvider;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import selenide.base.BaseSelenideTest;
import selenide.pages.DetailsPage;
import selenide.pages.MainPage;
import selenide.pages.SearchPage;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TurboSquid extends BaseSelenideTest {
    @Test
    @Order(1)
    public void Login(){
        MainPage mainPage = new MainPage()
                .MoveToLogin()
                .InputLoginData(ConfigProvider.EMAIL, ConfigProvider.PASSWORD);
        /*Assert.assertTrue(driver.getCurrentUrl().contains(ConfigProvider.URL));
        Assert.assertTrue(driver.findElement(By.className("icon-user")).isDisplayed());*/
    }
    /*@Test
    @Order(2)
    public void IncorrectLogin(){
        LoginPage loginPage = new MainPage().MoveToLogin().WrongInputLoginData(ConfigProvider.INCORRECT_EMAIL, ConfigProvider.PASSWORD);
        //Assert.assertTrue(driver.getCurrentUrl().contains(ConfigProvider.LOGIN_URL));
        Assert.assertEquals(loginPage.getErrorMessage(), "invalid email or password.");
    }
    @Order(4)
    @Test
    public void Search(){
        DetailsPage detailsPage = new MainPage().Search(ConfigProvider.SEARCH_DATA)
                .OpenDetails()
                .AddToCart("1");
    }
    */
    @Order(5)
    @Test
    public void SearchWithChangeType(){
        SearchPage searchPage = new MainPage().ChangeTypeSearch().Search(ConfigProvider.SEARCH_DATA);
        //Assert.assertTrue(searchPage.getPriceElement());
        //Assert.assertTrue(searchPage.getSearchResult().contains(ConfigProvider.SEARCH_DATA));
    }

    @Order(3)
    @Test
    public void AddToCartUser(){
        DetailsPage detailsPage = new DetailsPage();
        MainPage mainPage = new MainPage();
        mainPage.MoveToLogin()
                .InputLoginData(ConfigProvider.EMAIL, ConfigProvider.PASSWORD)
                .ChangeTypeSearch()
                .Search(ConfigProvider.SEARCH_DATA)
                .OpenDetails()
                .AddToCart();
    }
}
