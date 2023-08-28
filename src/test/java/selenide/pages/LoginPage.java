package selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement email_input = $x("//*[@id=\"authentication_method_email\"]");
    private final SelenideElement email_enter_button = $x("//*[@id=\"keymaster-sso-search-button\"]");
    private final SelenideElement password_input = $x("//*[@id=\"user_password\"]");
    private final SelenideElement email_pass_error_message = $x("//*[@id=\"keymaster-login-errors\"]");

    public MainPage InputLoginData(String email, String password) {
        email_input.sendKeys(email, Keys.ENTER);
        password_input.sendKeys(password, Keys.ENTER);
        password_input.should(disappear, Duration.ofSeconds(4));
        email_pass_error_message.shouldBe(empty);
        return new MainPage();
    }
}
