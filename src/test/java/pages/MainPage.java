package pages;

import helpers.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseSeleniumPage;
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
    @FindBy(id = "home-media-type-1")
    private WebElement list_item;

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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"mediaTypeSelect\"]/div/div[2]/li[4]")));
        list_item.click();
        return new MainPage();
    }
    public SearchPage Search(String query){
        search_input.sendKeys(query, Keys.ENTER);
        return new SearchPage();
    }
}
