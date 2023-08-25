package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.base.BaseSeleniumPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    @FindBy(xpath = "//*[@id=\"keymaster-login-button\"]")
    private By by_log_button;
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
        pass_input.sendKeys(password);
        log_button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"user_password\"]")));
        return new MainPage();
    }
    public LoginPage WrongInputLoginData(String email, String password){
        email_input.sendKeys(email);
        continue_log_button.click();
        pass_input.sendKeys(password);
        log_button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"user_password\"]")));
        return this;
    }
    public String getErrorMessage(){
        return error_empy_email.getText().toLowerCase();
    }
}
