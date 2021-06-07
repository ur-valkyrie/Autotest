import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmokeTest {

    public static WebDriver driver;

@Test
    public void login() throws InterruptedException {
       System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");

       //Test for login
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://users.bugred.ru/user/login/index.html");
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("levi@gmail.com");
        driver.findElement(By.xpath("//div[@class='row']//div[1]//form[1]//table[1]//tbody[1]//tr[2]//td[2]//input[1]")).sendKeys("levi4");
        driver.findElement(By.xpath("//div[@class='row']//div[1]//form[1]//table[1]//tbody[1]//tr[3]//td[2]//input[1]")).click();

        //check that 'Add User' button is displayed
        WebElement addUserButton = driver.findElement(By.xpath("//a[contains(text(), 'Добавить пользователя')]"));
        Assert.assertEquals(true, addUserButton.isDisplayed());


        //Test for search
        driver.findElement(By.xpath("//input[@placeholder='Введите email или имя']")).sendKeys("levi@gmail.com");
        driver.findElement(By.xpath("//button[contains(text(),'Найти')]")).click();

        driver.quit();



    }
}
