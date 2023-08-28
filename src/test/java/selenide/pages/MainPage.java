package selenide.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.typesafe.config.Config;
import org.openqa.selenium.Keys;
import selenide.helpers.ConfigProvider;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage {
    private final SelenideElement login_header_button = $x("//a[@class='L']");
    private final SelenideElement dropdown_button = $x("//button[@id='home-media-type-select-button']");
    private final ElementsCollection list_items = $$x("//*[@id='mediaTypeSelect']/div/div[2]/li[not(@*)]");
    private final SelenideElement search_input = $x("//*[@id='NavTextField']");
    public MainPage(){
        Selenide.open(ConfigProvider.URL);
        getWebDriver().manage().window().maximize();
    }
    public LoginPage MoveToLogin(){
        login_header_button.click();
        return new LoginPage();
    }
    public MainPage ChangeTypeSearch(){
        dropdown_button.click();
        list_items.first().click();
        return this;
    }
    public SearchPage Search(String query){
        search_input.sendKeys(query, Keys.ENTER);
        return new SearchPage();

    }
}

