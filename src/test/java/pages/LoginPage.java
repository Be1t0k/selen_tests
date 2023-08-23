package pages;

import org.openqa.selenium.By;

public class LoginPage {

    private By join_link = By.className("keymaster-link");
    private By signup_button = By.id("nav-LoginJoin");
    private By signin_button = By.id("nav-Login");
    private By email_input = By.name("authentication_method[email]");
    private By pass_input = By.xpath("//*[@id=\"user_password\"]");
    private By error_empy_email = By.xpath("//*[@id=\"keymaster-login-errors\"]");
    private By log_button = By.xpath("//*[@id=\"keymaster-login-button\"]");

    public void ClickToJoin(){
        
    }
}
