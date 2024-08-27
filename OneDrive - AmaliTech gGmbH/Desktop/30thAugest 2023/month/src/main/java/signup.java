
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class signup {

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
    public void CreateAnAccount() {
        // Click the "Sign in" link
        driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();

        // Generate a unique email address
        int length = 12;
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String temp = RandomStringUtils.random(length, allowedChars);
        String uniqueEmail = temp + "@gmail.com"; // Removed substring method to keep full length

        // Enter the unique email address into the input field
        WebElement emailField = driver.findElement(By.xpath("//input[@id='email_create']"));
        emailField.sendKeys(uniqueEmail);
        System.out.println("Generated email: " + uniqueEmail);

        // Click the "Create an account" button
        WebElement button = driver.findElement(By.xpath("//span[normalize-space()='Create an account']"));
        button.click();
    }
    @Test
    public void contineRegistering() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Abigail");
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Arko");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("arkoingeabigail");
        driver.findElement(By.xpath("//span[normalize-space()='Register']")).click();
        Thread.sleep(500);

        String successMessage = driver.findElement(By.xpath("//p[@class='alert alert-success']")).getText();
        String actualMessage = "Your account has been created.";
        assertEquals(actualMessage, successMessage);
        System.out.println(successMessage);
    }


    @AfterTest
    public void tearDown() {
        // Close the browser and end the session
        if (driver != null) {
            driver.quit();
        }
    }
}
