import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class signin {
    WebDriver driver;

    @BeforeTest
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");

        // Initialize WebDriver with ChromeDriver and the specified options
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Navigate to the URL
        driver.get("http://www.automationpractice.pl/index.php");
    }
@Test
    public void SignIn(){
        driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abigail.arko@amalitech.com");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("abigail");
        driver.findElement(By.xpath("//span[normalize-space()='Sign in']")).click();
    }
}
