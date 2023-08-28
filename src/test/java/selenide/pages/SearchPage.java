package selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;



import java.time.Duration;
import java.util.Collection;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {
    private final SelenideElement search_res = $x("//ul[@id=\"searchSummaryContainer\"]/li/div/h1/span[2]");
    private final ElementsCollection link_to_details = $$x("//*[contains(@id,\"Asset\")]/div[1]/div[3]/div[2]/a[2]/div[@class='txtExpand']");
    private final ElementsCollection add_to_cart_buttons = $$x("//*[contains(@id,\"Asset\")]/div[1]/div[3]/div[@class=\"asset_action_container\"]");
    private final ElementsCollection hover_asset_items = $$x("//*[contains(@id,\"Asset\")]/table/tbody/tr/td/a/picture/img");

    public boolean getPriceElement() {
        return $x("//*[@id=\"price\"]/a").is(Condition.visible);
    }

    public String getSearchResult() {
        return search_res.getText().toLowerCase();
    }

    public DetailsPage OpenDetails() {
        hover_asset_items.first().scrollIntoView(true).hover();
        link_to_details.first().click();
        return new DetailsPage();
    }

    public SearchPage FromSearchAddToCart() {
        hover_asset_items.first().scrollIntoView(true).hover();
        link_to_details.first().click();
        $x("//*[@id=\"FPAddToCart\"]/button/span").click();
        $x("//*[@id=\"quickPurchaseModal\"]/div[2]/div[1]").should(appear, Duration.ofSeconds(15));
        return this;
    }
}
