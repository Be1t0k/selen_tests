package pages;

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

    public DetailsPage OpenDetails(){
        Actions actions = new Actions(driver);
        actions.moveToElement(goodIcon);
        goodIcon.click();
        linkToDetails.click();
        return new DetailsPage();
    }
}
