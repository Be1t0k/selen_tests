import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration extends Data {

    private By signup_button = By.xpath("//*[@id=\"app\"]/div/header/nav/div[2]/div[3]/a");
    private By create_acc = By.xpath("/html/body/div[2]/div/div/div/div/div[4]/a");
    private By input_fir_name = By.name("user[first_name]");
    private By input_sec_name = By.name("user[last_name]");
    private By email_input = By.name("user[email]");
    private By pass_input = By.name("user[password]");
    private By agree_check = By.className("form-check");
    @Test
    public void registration(){

        WebDriver driver = new ChromeDriver();
        Data data = new Data();
        driver.get(data.baseUrl);
        driver.findElement(signup_button).click();
        driver.findElement(create_acc).click();
        driver.findElement(input_fir_name).sendKeys(data.fistname);
        driver.findElement(input_sec_name).sendKeys(data.lastname);
        driver.findElement(email_input).sendKeys(data.email);
        driver.findElement(pass_input).sendKeys(data.password);
        driver.findElement(By.name("commit")).click();
        driver.quit();
    }
}
