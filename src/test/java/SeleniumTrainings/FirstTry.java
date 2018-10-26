package SeleniumTrainings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTry {

    static WebDriver driver;

    @Before
    public void setDriver() {
        DriverConfigs driverConfigs = new DriverConfigs();
        driverConfigs.chrome();
        driver = new ChromeDriver();
    }

    @Test
    public void first() {
        driver.get("https://www.google.com");
        System.out.println("Successfully opened the website https://www.google.com/");
    }

    @After
    public void quit() {
        driver.quit();
    }

}
