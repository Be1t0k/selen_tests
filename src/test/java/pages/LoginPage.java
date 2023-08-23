package pages;

import helpers.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.BaseSeleniumPage;

public class LoginPage extends BaseSeleniumPage {
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"keymaster-content\"]/div/div[1]/a")
    private WebElement join_link;
    @FindBy(name = "authentication_method[email]")
    private WebElement email_input;
    @FindBy(xpath = "//*[@id=\"keymaster-sso-search-button\"]")
    private WebElement continue_log_button;
    @FindBy(xpath = "//*[@id=\"keymaster-login-button\"]")
    private WebElement log_button;
    @FindBy(id = "keymaster-header-image")
    private WebElement header_image;
    @FindBy(xpath = "//*[@id=\"user_password\"]")
    private WebElement pass_input;
    @FindBy(id = "keymaster-forgot-password")
    private WebElement forgot_pass;
    @FindBy(xpath = "//*[@id=\"keymaster-login-errors\"]")
    private WebElement error_empy_email;
    @FindBy(xpath = "//*[@id=\"keymaster-contact-support\"]/a")
    private WebElement trouble_enter;
    public void ClickToJoin(){
        join_link.click();
    }
    public MainPage InputLoginData(String email, String password){
        email_input.sendKeys(email);
        continue_log_button.click();
        pass_input.sendKeys(password, Keys.ENTER);
        return new MainPage();
    }
}
