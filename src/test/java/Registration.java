import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {

    public void registration(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mpo\\IdeaProjects\\selenium_test\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://habr.com/ru/articles/");
        driver.manage().window().maximize();
    }
}
