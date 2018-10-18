package SeleniumTrainings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Alerts {

    static WebDriver driver;

    @Before
    public void setDriver() {
        DriverConfig driverConfig = new DriverConfig();
        driverConfig.firefox();
        driver = new FirefoxDriver();
    }

    @Test
    public void alerts() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://toolsqa.com/automation-practice-switch-windows");

        driver.findElement(By.id("alert")).click();

        Alert myAlert = driver.switchTo().alert();

        Thread.sleep(3000);

        myAlert.accept();
    }

    @After
    public void quit() {
        driver.quit();
    }
}
