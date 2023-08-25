package selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement email_input = $x("//*[@id=\"authentication_method_email\"]");
    private final SelenideElement email_enter_button = $x("//*[@id=\"keymaster-sso-search-button\"]");
    private final SelenideElement password_input = $x("//*[@id=\"user_password\"]");

    public MainPage InputLoginData(String email, String password) {
        email_input.sendKeys(email);
        email_enter_button.click();
        password_input.sendKeys(password, Keys.ENTER);
        return new MainPage();
    }
}
