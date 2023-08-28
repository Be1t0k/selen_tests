package selenide.pages;

import com.codeborne.selenide.SelenideElement;
import helpers.ConfigProvider;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement email_input = $x("//*[@id=\"authentication_method_email\"]");
    private final SelenideElement email_enter_button = $x("//*[@id=\"keymaster-sso-search-button\"]");
    private final SelenideElement password_input = $x("//*[@id=\"user_password\"]");
    public void InputSearchData(){
        email_input.sendKeys(ConfigProvider.EMAIL);

    }
}
