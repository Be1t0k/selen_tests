package selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class DetailsPage {
    private final SelenideElement add_to_cart_button = $x("//*[@id=\"FPAddToCart\"]/button");
    private final SelenideElement count_cart = $x("//*[@id=\"btnNavCart\"]/span[2]");
    public void AddToCart(String number) {
        Integer num = Integer.parseInt(number)+1;
        System.out.println(num);
        add_to_cart_button.scrollIntoView(true).click();
        count_cart.should(Condition.text(num.toString()), Duration.ofSeconds(5));
    }
}
