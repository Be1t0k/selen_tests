import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class Login {
    private By signup_button = By.id("nav-LoginJoin");
    private By signin_button = By.id("nav-Login");
    private By email_input = By.name("authentication_method[email]");
    private By pass_input = By.xpath("//*[@id=\"user_password\"]");
    private By error_empy_email = By.xpath("//*[@id=\"keymaster-login-errors\"]");
    private By log_button = By.xpath("//*[@id=\"keymaster-login-button\"]");

    @Test
    public void Login() throws InterruptedException{
        WebDriver driver = new ChromeDriver();

        Data data = new Data();
        driver.manage().window().maximize();
        driver.get(data.baseUrl);
        driver.findElement(signin_button).click();
        driver.findElement(email_input).sendKeys(data.email);
        driver.findElement(By.name("commit")).click();
        sleep(300);
        driver.findElement(pass_input).sendKeys(data.password);
        driver.findElement(log_button).click();
        sleep(300);
        Assert.assertEquals(data.baseUrl, driver.getCurrentUrl());
        driver.quit();
    }

    @Test
    public void EmptyLogin() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        Data data = new Data();
        driver.manage().window().maximize();
        driver.get(data.baseUrl);
        driver.findElement(signin_button).click();
        driver.findElement(By.name("commit")).click();
        sleep(300);
        Assert.assertEquals(data.logUrl, driver.getCurrentUrl());
        //Assert.assertEquals("Please enter a valid email address.", driver.findElement(error_empy_email).getText());
        driver.quit();
    }

    @Test
    public void UpperCaseLogin() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        Data data = new Data();
        driver.manage().window().maximize();
        driver.get(data.baseUrl);
        driver.findElement(signin_button).click();
        driver.findElement(email_input).sendKeys(data.email.toUpperCase());
        driver.findElement(By.name("commit")).click();
        sleep(300);
        driver.findElement(pass_input).sendKeys(data.password);
        driver.findElement(log_button).click();
        Assert.assertEquals("Invalid email or password.", driver.findElement(By.xpath("//*[@id=\"keymaster-login-errors\"]")).getText());
        driver.quit();
    }

    @Test
    public void FaultLogin() throws  InterruptedException{
        WebDriver driver = new ChromeDriver();
        Data data = new Data();
        driver.manage().window().maximize();
        driver.get(data.baseUrl);
        driver.findElement(signin_button).click();
        Assert.assertEquals(data.logUrl, driver.getCurrentUrl());
        driver.findElement(email_input).sendKeys("random_email@mail.ru");
        driver.findElement(By.name("commit")).click();
        sleep(600);
        driver.findElement(pass_input).sendKeys(data.password);
        driver.findElement(log_button).click();
        sleep(300);
        Assert.assertEquals("Invalid email or password.", driver.findElement(By.xpath("//*[@id=\"keymaster-login-errors\"]")).getText());
        driver.quit();
    }
}
