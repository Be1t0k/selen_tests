package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseSeleniumPage;

public class SearchPage extends BaseSeleniumPage {
    public SearchPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"Asset1637359\"]/div[1]/div[2]/div[2]/a[2]")
    private WebElement addToCartIcon;
    @FindBy(xpath = "//*[@id=\"Asset1501756\"]/div[1]/div[2]/div[2]/a[1]")
    private WebElement linkToGood;

    public void AddToCart(){
        //linkToGood.click();
        addToCartIcon.click();
    }
}
