package pages;

import helpers.ConfigProvider;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.BaseSeleniumPage;

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
    private WebElement dropdowm_button;
    @FindBy(xpath = "//*[@id=\"home-media-type-1\"]")
    private WebElement list_item;

    public MainPage(){
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }
    public LoginPage MoveToLogin(){
        login_header_button.click();
        return new LoginPage();
    }
    public SearchPage Search(){
        dropdowm_button.click();
        list_item.click();
        search_input.sendKeys("metal", Keys.ENTER);
        return new SearchPage();
    }
}
