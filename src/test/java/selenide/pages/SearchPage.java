package selenide.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {
    private final ElementsCollection link_to_details = $$x("//*[@id]/div[1]/div[2]/a[contains(@href, 'https')]");
    private final SelenideElement search_res_title = $x("//ul[@id=\"searchSummaryContainer\"]/li/div/h1/span[2]");
    private final SelenideElement price_toggle = $x("//*[@id=\"price\"]/a");

    public DetailsPage OpenDetails(){
        link_to_details.first().click();
        return new DetailsPage();
    }
}
