package selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.Collection;

import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {
    private final SelenideElement search_res = $x("//ul[@id=\"searchSummaryContainer\"]/li/div/h1/span[2]");
    public boolean getPriceElement() {
        return $x("//*[@id=\"price\"]/a").is(Condition.visible);
    }

    public String getSearchResult() {
        return search_res.getText().toLowerCase();
    }
}
