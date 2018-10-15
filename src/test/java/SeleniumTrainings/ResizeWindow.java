package SeleniumTrainings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ResizeWindow {

    static WebDriver driver;

    @Before
    public void setUp() {
        DriverConfig driverConfig = new DriverConfig();
        driverConfig.firefox();
        driver = new FirefoxDriver();
    }

    @Test
    public void resize() throws InterruptedException {
        System.out.println(driver.manage().window().getSize());
        driver.manage().window().setSize(new Dimension(500,600));

        Thread.sleep(2000);

        System.out.println(driver.manage().window().getSize());

        System.out.println(driver.manage().window().getPosition());
        driver.manage().window().setPosition(new Point(200,150));

        Thread.sleep(2000);

        System.out.println(driver.manage().window().getPosition());

        driver.manage().window().maximize();

        Thread.sleep(2000);

        System.out.println(driver.manage().window().getSize());

        driver.manage().window().setPosition(new Point(0,0));

        Thread.sleep(2000);

        driver.manage().window().setSize(new Dimension(500,600));

        Thread.sleep(2000);
    }

    @After
    public void quit() {
        driver.quit();
    }
}
