package selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;



import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {
    private final SelenideElement search_res = $x("//ul[@id=\"searchSummaryContainer\"]/li/div/h1/span[2]");
    private final ElementsCollection details_window_link = $$x("//*[contains(@id,\"Asset\")]/div[1]/div[3]/div[2]/a[2]/div[@class='txtExpand']");
    private final ElementsCollection add_to_cart_buttons = $$x("//*[contains(@id,\"Asset\")]/div[1]/div[3]/div[@class=\"asset_action_container\"]");
    private final ElementsCollection link_to_detail_page = $$x("//*[contains(@id,\"Asset\")]/table/tbody/tr/td/a");
    private final ElementsCollection hover_asset_items = $$x("//*[contains(@id,\"Asset\")]/table/tbody/tr/td/a/picture/img");
    private final SelenideElement add_to_cart_button = $x("//*[@id=\"FPAddToCart\"]/button");
    private final SelenideElement count_cart = $x("//*[@id=\"btnNavCart\"]/span[2]");
    private final SelenideElement modal_title = $x("//*[@id=\"quickPurchaseModal\"]/div[2]/div[1]");

    public boolean getPriceElement() {
        return $x("//*[@id=\"price\"]/a").is(Condition.visible);
    }

    public String getSearchResult() {
        return search_res.getText().toLowerCase();
    }

    public SearchPage OpenDetails() {
        hover_asset_items.first().scrollIntoView(true).hover();
        details_window_link.first().click();
        return new SearchPage();
    }
    public SearchPage AddToCart(String number) {
        Integer num = Integer.parseInt(number)+1;
        System.out.println(num);
        add_to_cart_button.scrollIntoView(true).click();
        modal_title.should(appear, Duration.ofSeconds(5));
        count_cart.should(Condition.text(num.toString()));
        return this;
    }
    public DetailsPage OpenDetailsPage() {
        link_to_detail_page.first().scrollIntoView(true).hover().click();
        return new DetailsPage();
    }

    public SearchPage FromSearchAddToCart() {
        hover_asset_items.first().scrollIntoView(true).hover();
        details_window_link.first().click();
        /*$x("//*[@id=\"FPAddToCart\"]/button/span").click();
        modal_title.should(appear, Duration.ofSeconds(5));*/
        return this;
    }
}
