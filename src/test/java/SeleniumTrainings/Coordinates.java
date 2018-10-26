package SeleniumTrainings;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;


public class Coordinates {

    @Test
    public void getCoordinates() {
        DriverConfigs driverConfigs = new DriverConfigs();
        driverConfigs.chrome();

        driverConfigs.driver.get("https://www.google.com/");

        WebElement button = driverConfigs.driver.findElement(By.name("btnK"));
        Point location = button.getLocation();
        System.out.println(location.x + " " + location.y);
        System.out.println(location.getX() + " " + location.getY());

        driverConfigs.driver.quit();
    }
}
