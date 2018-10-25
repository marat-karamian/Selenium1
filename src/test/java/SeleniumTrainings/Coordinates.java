package SeleniumTrainings;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Coordinates {

    static WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        DriverConfig driverConfig = new DriverConfig();
        driverConfig.chrome();
        driver = new ChromeDriver();
    }

    @Test
    public void getCoordinates() {

        driver.get("https://www.google.com/");
        WebElement button = driver.findElement(By.name("btnK"));
        Point location = button.getLocation();
        System.out.println(location.x + " " + location.y);
        System.out.println(location.getX() + " " + location.getY());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
