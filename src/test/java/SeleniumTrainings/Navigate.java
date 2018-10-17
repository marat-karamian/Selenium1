package SeleniumTrainings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate {

    static WebDriver driver;

    @Before
    public void setDriver() {
        DriverConfig driverConfig = new DriverConfig();
        driverConfig.chrome();
        driver = new ChromeDriver();
    }

    @Test
    public void nav() throws InterruptedException {
        String url = "https://en.wikipedia.org";
        driver.navigate().to(url);
        driver.manage().window().maximize();

        Thread.sleep(2000);

        driver.findElement(By.linkText("Help")).click();
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().to(url);
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);
    }

    @After
    public void quit() {
        driver.quit();
    }
}
