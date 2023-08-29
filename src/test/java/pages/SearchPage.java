package pages;

import helpers.ConfigProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseSeleniumPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage extends BaseSeleniumPage {
    public SearchPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "Asset1286623")
    private WebElement goodIcon;
/*    private ElementsCollection add_to_cart_buttons = $$x("//*[contains(@id,\"Asset\")]/div[1]/div[3]/div[@class=\"asset_action_container\"]");*/
    @FindBy(xpath = "//*[contains(@id, \"Asset\") and contains(@class, \"search-lab\")]")
    private List<WebElement> linkToDetails;
    @FindBy(xpath = "//ul[@id=\"searchSummaryContainer\"]/li/div/h1/span[2]")
    private WebElement search_res;
    @FindBy(xpath = "//*[@id=\"price\"]/a")
    private By price_toggle;

    public boolean CheckElement(By element){
        try {
            driver.findElement(element);
        }
        catch (NotFoundException e){
            return false;
        }
        return true;
    }
    public DetailsPage OpenDetails(int number){
        Actions actions = new Actions(driver);
        actions.moveToElement(goodIcon);
        goodIcon.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(linkToDetails.get(number)));
        linkToDetails.get(number).click();
        Assert.assertTrue(search_res.getText().toLowerCase().contains(ConfigProvider.SEARCH_DATA.toLowerCase()));
        Assert.assertTrue(CheckElement(By.xpath("//*[@id=\"price\"]/a")));
        return new DetailsPage();
    }
    public String getSearchResult(){
        return search_res.getText().toLowerCase();
    }
    public Boolean getPriceElement(){
        return CheckElement(By.xpath("//*[@id=\"price\"]/a"));
    }
}
