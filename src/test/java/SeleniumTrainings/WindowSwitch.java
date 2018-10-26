package SeleniumTrainings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowSwitch {

    static WebDriver driver;

    @Before
    public void setDriver() {
        DriverConfigs driverConfigs = new DriverConfigs();
        driverConfigs.chrome();
        driver = new ChromeDriver();
    }

    @Test
    public void switchWindow() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://toolsqa.com/automation-practice-switch-windows");

        Thread.sleep(1000);

        String handle = driver.getWindowHandle();
        System.out.println(handle);

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@id='content']/p[3]/button")).click();
        Thread.sleep(1000);

        Set handles = driver.getWindowHandles();
        System.out.println(handles);

        for (String handle1 : driver.getWindowHandles()) {
            System.out.println(handle1);
            driver.switchTo().window(handle1);
        }

        Thread.sleep(1000);
    }

    @After
    public void quit() throws InterruptedException {
        driver.close();

        Thread.sleep(1000);
        driver.quit();
    }
}
