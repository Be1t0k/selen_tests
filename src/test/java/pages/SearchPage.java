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

public class SearchPage extends BaseSeleniumPage {
    public SearchPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "Asset1286623")
    private WebElement goodIcon;
    @FindBy(xpath = "//*[@id=\"Asset1286623\"]/div[1]/div[2]/a")
    private WebElement linkToDetails;
    @FindBy(xpath = "//ul[@id=\"searchSummaryContainer\"]/li/div/h1/span[2]")
    private WebElement search_res;

    public boolean CheckElement(By element){
        try {
            driver.findElement(element);
        }
        catch (NotFoundException e){
            return false;
        }
        return true;
    }
    public DetailsPage OpenDetails(){
        Actions actions = new Actions(driver);
        actions.moveToElement(goodIcon);
        goodIcon.click();
        linkToDetails.click();
        Assert.assertTrue(search_res.getText().toLowerCase().contains(ConfigProvider.SEARCH_DATA.toLowerCase()));
        Assert.assertTrue(CheckElement(By.xpath("//*[@id=\"price\"]/a")));
        return new DetailsPage();
    }
}
