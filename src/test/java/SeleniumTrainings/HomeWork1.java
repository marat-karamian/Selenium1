package SeleniumTrainings;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HomeWork1 {

    static WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        DriverConfig driverConfig = new DriverConfig();
        driverConfig.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
    }

    @Test
    public void hw1() {
        driver.manage().window().maximize();
        driver.get("https://facebook.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("mkaramyan.dp3@gmail.com");

        WebElement pass = driver.findElement(By.id("pass"));
        pass.clear();
        pass.sendKeys("TestPassword");

        driver.findElement(By.id("loginbutton")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Checks if user is logged in

        boolean isLogged = driver.findElement(By.xpath("//*[@id=\"navItem_4748854339\"]/a/div")).isDisplayed();

        if (isLogged) {
            System.out.println("The user is logged in");
        } else {
            System.out.println("The user is not logged in");
        }
    }

    @AfterClass
    public static void quit() {
        driver.quit();
    }
}