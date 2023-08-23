import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class Registration {
    private By signup_button = By.id("nav-LoginJoin");
    private By email_input = By.name("user[email]");
    private By pass_input = By.name("user[password]");
    private By passconf_input = By.name("user[password_confirmation]");
    @Test
    public void registration() throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        Data data = new Data();
        driver.manage().window().maximize();
        driver.get(data.baseUrl);
        driver.findElement(signup_button).click();
        driver.findElement(email_input).sendKeys(data.email);
        driver.findElement(pass_input).sendKeys(data.password);
        driver.findElement(passconf_input).sendKeys(data.password);
        driver.findElement(By.name("commit")).click();
        sleep(300);
        Assert.assertEquals(data.baseUrl, driver.getCurrentUrl());
        driver.quit();
    }
}
