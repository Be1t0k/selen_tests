package selenium.pages;

import helpers.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.base.BaseSeleniumPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BaseSeleniumPage {
    @FindBy(id = "nav-Login")
    private WebElement login_header_button;
    @FindBy(id = "nav-LoginJoin")
    private WebElement join_header_button;
    @FindBy(xpath = "//*[@id=\"btnNavCart\"]")
    private WebElement cart_icon;
    @FindBy(xpath = "//*[@id=\"NavTextField\"]")
    private WebElement search_input;
    @FindBy(xpath = "//*[@id=\"home-media-type-select-button\"]")
    private WebElement dropdown_button;
    @FindBy(xpath = "//*[@id=\"mediaTypeSelect\"]/div/div[2]/li[2]")
    private WebElement list_item;
    @FindBy(id = "home-media-type-texture-maps-option")
    private WebElement list_item_link;
    @FindBy(xpath = "//ul[@id=\"searchSummaryContainer\"]/li/div/h1/span[2]")
    private WebElement search_res;
    public MainPage(){
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }
    public LoginPage MoveToLogin(){
        login_header_button.click();
        return new LoginPage();
    }
    public MainPage ChangeTypeSearch(){
        dropdown_button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("home-media-type-texture-maps-option")));
        list_item.click();
        return this;
    }
    public SearchPage Search(String query){
        search_input.sendKeys(query, Keys.ENTER);
        //Assert.assertTrue(list_item_link.getText().toLowerCase().contains(ConfigProvider.SEARCH_DATA.toLowerCase()));
        return new SearchPage();

    }
}
