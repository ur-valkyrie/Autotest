import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Autotest {

    public static WebDriver driver;

    @Test
    public void login() throws InterruptedException {
        long random = randomizer();
        System.setProperty("webdriver.chrome.driver", "/Users/user/IdeaProjects/Valkyrie/src/main/resources/chromedriver");

        //Test for login
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://users.bugred.ru/user/login/index.html");
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("levi@gmail.com");
        driver.findElement(By.xpath("//div[@class='row']//div[1]//form[1]//table[1]//tbody[1]//tr[2]//td[2]//input[1]")).sendKeys("levi4");
        driver.findElement(By.xpath("//div[@class='row']//div[1]//form[1]//table[1]//tbody[1]//tr[3]//td[2]//input[1]")).click();


        driver.get("http://users.bugred.ru");
        driver.findElement(By.className("dropdown-toggle")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Личный кабинет')]")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Long.toString(random));

        driver.findElement(By.name("gender")).click();
        Select gender = new Select(driver.findElement(By.name("gender")));
        gender.selectByVisibleText("Женский");
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("04.12.2013");
        driver.findElement(By.xpath("//input[@name='date_start']")).sendKeys("08.06.2021");
        driver.findElement(By.xpath("//textarea[@name='hobby']")).clear();
        driver.findElement(By.xpath("//textarea[@name='hobby']")).sendKeys("Books");
        driver.findElement(By.xpath("//input[@name='inn']")).clear();
        driver.findElement(By.xpath("//input[@name='inn']")).sendKeys(random+ "24");
        driver.findElement(By.xpath("//input[@name='act_profile_now']")).click();

    }

        private long randomizer() {
            long random = (long) ( 1_000_000_000 + Math.random() * 1_000_000_000);
            return random;
        }
}
