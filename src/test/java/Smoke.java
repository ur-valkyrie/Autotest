import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Smoke {
    public static WebDriver driver;

    @Test
    public void login() throws InterruptedException {
        int random = randomizer();
        System.setProperty("webdriver.chrome.driver", "/Users/user/IdeaProjects/Valkyrie/src/main/resources/chromedriver");

        //Test for 'Add User'
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://users.bugred.ru/user/login/index.html");
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Integer.toString(random));
        driver.findElement(By.xpath("//div[@class='row']//div[2]//form[1]//table[1]//tbody[1]//tr[2]//td[2]//input[1]")).sendKeys(random+"@ukr.net");
        driver.findElement(By.xpath("//div[@class='row']//div[2]//form[1]//table[1]//tbody[1]//tr[3]//td[2]//input[1]")).sendKeys(Integer.toString(random));
        driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]")).click();


        //Test for search
        driver.findElement(By.xpath("//input[@placeholder='Введите email или имя']")).sendKeys(random+"@ukr.net");
        driver.findElement(By.xpath("//button[contains(text(),'Найти')]")).click();
        WebElement FindEmail = driver.findElement(By.xpath("//a[contains(text(),'Посмотреть')]"));
        Assert.assertEquals(true, FindEmail.isDisplayed());

    }

    private int randomizer() {
        int random = (int) ((int) 1 + Math.random() * 1000000);
        return random;
    }
    }
