package selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;

public class DetailsPage {
    private final SelenideElement addToCartButton = $x("//*[@id=\"FPAddToCart\"]/button");
    private final SelenideElement cartCount = $x("//*[@id=\"cart-button\"]/div/div[1]/button/span/div");
    public DetailsPage AddToCart() {
        addToCartButton.click();
        return this;
    }
    public int GetCartCount(){
        int count = Integer.parseInt(cartCount.getText());
        return count;
    }
}
