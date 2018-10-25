package SeleniumTrainings;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Size {

    static WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        DriverConfig driverConfig = new DriverConfig();
        driverConfig.chrome();
        driver = new ChromeDriver();
    }

    @Test
    public void getSize() {

        driver.get("https://www.google.com/");
        WebElement button = driver.findElement(By.name("btnK"));
        System.out.println(button.getSize());
        System.out.println(button.getSize().height + " " + button.getSize().width);
        System.out.println(button.getSize().getHeight() + " " + button.getSize().getWidth());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
