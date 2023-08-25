package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.base.BaseSeleniumPage;

import java.time.Duration;

public class DetailsPage extends BaseSeleniumPage {
    @FindBy(className = "add-to-cart-sidebar-button")
    private WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"cart-button\"]/div/div[1]/button/span/div")
    private WebElement cartCount;
    @FindBy(xpath = "//*[@id=\"quickPurchaseModalLabel\"]")
    private WebElement modalTitle;
    public DetailsPage() {
        PageFactory.initElements(driver, this);
    }

    public DetailsPage AddToCart(String cart_count) {
        addToCartButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(modalTitle));
        Assert.assertEquals(cart_count, cartCount.getText());
        return this;
    }
}
