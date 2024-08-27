import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCart {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set up the ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");

        // Initialize WebDriver with ChromeDriver and the specified options
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Navigate to the URL
        driver.get("http://www.automationpractice.pl/index.php");
    }

    @Test
    public void addFirstItem() {
        WebElement search = driver.findElement(By.xpath("//input[@id='search_query_top']"));
        search.sendKeys("Printed Summer Dress");
        WebElement searchButton = driver.findElement(By.xpath("//button[@name='submit_search']"));
        searchButton.click();
        WebElement dress = driver.findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-line last-item-of-tablet-line last-mobile-line']//div[@class='product-container']"));
        dress.click();

            WebElement size = driver.findElement(By.xpath("(//select[@id='group_1'])[1]"));
            Select obj = new Select(size);
            obj.selectByVisibleText("M");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quantity_wanted")));
        quantityInput.clear();
        quantityInput.sendKeys("4");
        WebElement addToCart = driver.findElement(By.xpath("//button[@name='Submit']"));
        addToCart.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement proceedButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Proceed to checkout']")));
        proceedButton.click();


    }
}