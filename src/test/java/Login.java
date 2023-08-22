import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class Login extends Data{

    private By signup_button = By.id("nav-LoginJoin");
    private By signin_button = By.id("nav-Login");
    private By email_input = By.name("authentication_method[email]");
    private By pass_input = By.name("user[password]");
    private By agree_check = By.name("user[newsletter_subscriber]");

    @Test
    public void Login()  throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        Data data = new Data();
        driver.manage().window().maximize();
        driver.get(data.baseUrl);
        driver.findElement(signin_button).click();
        driver.findElement(email_input).sendKeys(data.email);
        driver.findElement(By.name("commit")).click();
        driver.findElement(pass_input).sendKeys(data.password);
        driver.findElement(By.name("commit")).click();
        sleep(300);
        Assert.assertEquals(data.baseUrl, driver.getCurrentUrl());
        driver.quit();
    }

    @Test
    public void EmptyLogin(){
        WebDriver driver = new ChromeDriver();
        Data data = new Data();
        driver.manage().window().maximize();
        driver.get(data.baseUrl);
        driver.findElement(signup_button).click();
        Assert.assertEquals(data.logUrl, driver.getCurrentUrl());
        driver.findElement(pass_input).sendKeys(data.password);
        driver.findElement(By.name("commit")).click();
        Assert.assertEquals("You need to sign in or sign up before continuing.", driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]")).getText());
        driver.quit();
    }

    @Test
    public void UpperCaseLogin(){
        WebDriver driver = new ChromeDriver();
        Data data = new Data();
        driver.manage().window().maximize();
        driver.get(data.baseUrl);
        driver.findElement(signup_button).click();
        Assert.assertEquals(data.logUrl, driver.getCurrentUrl());
        driver.findElement(email_input).sendKeys(data.email.toUpperCase());
        driver.findElement(pass_input).sendKeys(data.password);
        driver.findElement(By.name("commit")).click();
        Assert.assertEquals("Invalid email or password.", driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]")).getText());
        driver.quit();
    }

    @Test
    public void FaultLogin(){
        WebDriver driver = new ChromeDriver();
        Data data = new Data();
        driver.manage().window().maximize();
        driver.get(data.baseUrl);
        driver.findElement(signup_button).click();
        Assert.assertEquals(data.logUrl, driver.getCurrentUrl());
        driver.findElement(email_input).sendKeys("random_email@mail.ru");
        driver.findElement(pass_input).sendKeys(data.password);
        driver.findElement(By.name("commit")).click();
        Assert.assertEquals("Invalid email or password.", driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]")).getText());
        driver.quit();
    }

    @Test
    public void ByCookie(){
        WebDriver driver = new ChromeDriver();
        Data data = new Data();
        By img = By.xpath("//*[@id=\"popover-avatar-loggedin-menu\"]/button/div/div/img");

        Cookie cookie = new Cookie("un_sesh", "TTRjSjNqNndxeDU4ZzBzMjBKTllTOE9uMmloQ01BMUpmbkNuRTZ1WUR2Ri9jemV5T2RjS2NoK1Q4aFNQTkk2RXQ1NzVxK2IvWGxFa052cStxcU9PN3hZQWY0am5wMXFSVk81MmorRllaT1dENnhTem5YMjZTYWIyK0c1dytqVHd1Z1FEMU45SFo3Q1lnb1ZtSkRDajRSZjVSbEJYR2tuNCtkVlZPSjNNZE5iTDk0ZGFmV3hOYTg2amlJZU1UNERrS3pRTkVhR1FKdm4rS1JPWXc1OTBDbXFkME9salJYUnN0SEpGa09DY1R0R3dnM3FSaFRYK2pFUDNPQTU0anZXTENvVlR6Q0FiaCtiNVRnSFhvamdxRlkxbFg1djYzbjBNTHI5TW9oSjc1bHhqV2h6WVJUeEhBQzFtNXNETXE0ZU83WFhKb0tOQm05MXExYkpGNXFaSk8wZlAvWlhuQ05wK0xYc3prTW05RlNKVEZEVmtzMThvZkg5amZNVHdTY3hJekVCNWlYdWJOWmx6RDVLUEtUYisvNnFIdnZQSGRjT0xZT3B1a3VPTXRVZzl1WUMra2piSUc4SjMxOW1qcFF0d3ZmZEswTnZCNUY5eFJyVmlRVzIvRnZVZ3JQMVlVRjR2SHIyVG5ZR3VxTFE9LS1HUHRSYzZmZFp4akI0ZWdvdVhEV0RRPT0%3D--85f3fdcc2ad3a94dbde8cd0339faf32e0b8ad98e");
        driver.manage().window().maximize();
        driver.get(data.baseUrl);
        driver.manage().addCookie(cookie);
        driver.manage().addCookie(new Cookie("auth_user_id", "13926150"));
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(img).getTagName(), "img");
        driver.quit();
    }
}
